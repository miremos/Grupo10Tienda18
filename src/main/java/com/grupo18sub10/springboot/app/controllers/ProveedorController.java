package com.grupo18sub10.springboot.app.controllers;



import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo18sub10.springboot.app.models.entity.Proveedor;


import com.grupo18sub10.springboot.app.models.service.IProveedorService;

import com.grupo18sub10.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"proveedor"})
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;
    

    public ProveedorController() {
    }

    
    
    
    @GetMapping({"/verpro/{id}"})
    public String ver(@PathVariable("id") Long nit_proveedor, Map<String, Object> model, RedirectAttributes flash) {
        Proveedor proveedor = proveedorService.findOne(nit_proveedor);
        if (proveedor == null) {
            flash.addFlashAttribute("error", "El cliente no existe en DDBB");
            return "redirect:/listar";
        } else {
            model.put("cliente", proveedor);
            model.put("titulo", "Detalle cliente: " + proveedor.getNombre_proveedor());
            return "verpro";
        }
    }

    
    
    
    @RequestMapping(
        value = {"/listarpro"},
        method = {RequestMethod.GET}
    )
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Proveedor> proveedor = proveedorService.findAll(pageRequest);
        PageRender<Proveedor> pageRender = new PageRender<Proveedor>("/listarpro", proveedor);
        model.addAttribute("titulo", "LISTADO DE PROVEEDORES");
        model.addAttribute("proveedores", proveedor);
        model.addAttribute("page", pageRender);
        return "listarpro";
    }
    
    
    
    
    
    

    @RequestMapping({"/formpro"})
    public String crear(Map<String, Object> model) {
        Proveedor proveedor = new Proveedor();
        model.put("proveedor", proveedor);
        model.put("titulo", "FORMULARIO DE PROVEEDOR");
        return "formpro";
    }

    @RequestMapping({"/formpro/{id}"})
    public String editar(@PathVariable("id") Long nit_proveedor, Map<String, Object> model, RedirectAttributes flash) {
        Proveedor proveedor = null;
        if (nit_proveedor > 0L) {
            proveedor = proveedorService.findOne(nit_proveedor);
            if (proveedor == null) {
                flash.addFlashAttribute("error", "El NIT del proveedor no existe en la BBDD!");
                return "redirect:/listarpro";
            } else {
                model.put("proveedor", proveedor);
                model.put("titulo", "EDITAR PROVEEDOR");
                return "formpro";
            }
        } else {
            flash.addFlashAttribute("error", "El NIT del proveedor no puede ser cero!");
            return "redirect:/listarpro";
        }
    }

    @RequestMapping(
        value = {"/formpro"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "FORMULARIO DE PROVEEDOR");
            return "formpro";
        } else {
            String uniqueFilename;
            

            uniqueFilename = proveedor.getId() != null ? "Proveedor editado con éxito!" : "Proveedor creado con éxito!";
            proveedorService.save(proveedor);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listarpro";
        }
    }

    @RequestMapping({"/eliminarpro/{id}"})
    public String eliminar(@PathVariable("id") Long nit_proveedor, RedirectAttributes flash) {
        if (nit_proveedor > 0L) {
            Proveedor proveedor = proveedorService.findOne(nit_proveedor);
            proveedorService.delete(nit_proveedor);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
            
        }

        return "redirect:/listarpro";
    }
    
    @GetMapping("/marcasformproveedor")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Proveedor());
		return "marcaformproveedor";
		
	}
	
	@GetMapping("/marcaproveedor")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Proveedor coche, RedirectAttributes flash) {
		Proveedor valor = proveedorService.findOne(id);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El producto no existe en DDBB");
            return "redirect:/listarpro";
        }else {
        	model.addAttribute("cochesPorMarca", proveedorService.findOne(id));
        	return "marcaformproveedor";
        }
		
		
	}
    
    
}
