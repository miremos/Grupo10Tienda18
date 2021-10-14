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

import com.grupo18sub10.springboot.app.models.entity.Cliente;

import com.grupo18sub10.springboot.app.models.service.IClienteService;


import com.grupo18sub10.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"cliente"})
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    

    public ClienteController() {
    }

    
    
    
    @GetMapping({"/ver/{id}"})
    public String ver(@PathVariable("id") Long cedula_cliente, Map<String, Object> model, RedirectAttributes flash) {
        Cliente cliente = clienteService.findOne(cedula_cliente);
        if (cliente == null) {
            flash.addFlashAttribute("error", "El cliente no existe en DDBB");
            return "redirect:/listar";
        } else {
            model.put("cliente", cliente);
            model.put("titulo", "Detalle cliente: " + cliente.getNombre_cliente());
            return "ver";
        }
    }

    
    
    
    @RequestMapping(
        value = {"/listar"},
        method = {RequestMethod.GET}
    )
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", clientes);
        model.addAttribute("titulo", "LISTADO DE CLIENTES");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page", pageRender);
        return "listar";
    }
    
    @RequestMapping(
            value = {"/listarclientereporte"},
            method = {RequestMethod.GET}
        )
        public String listarB(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
            Pageable pageRequest = PageRequest.of(page, 4);
            Page<Cliente> clientes = clienteService.findAll(pageRequest);
            PageRender<Cliente> pageRender = new PageRender<Cliente>("/listarclientereporte", clientes);
            model.addAttribute("titulo", "REPORTE DE CLIENTES");
            model.addAttribute("clientes", clientes);
            model.addAttribute("page", pageRender);
            return "listarclientereporte";
        }

    @RequestMapping({"/form"})
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "FORMULARIO DE CLIENTE");
        return "form";
    }

    @RequestMapping({"/form/{id}"})
    public String editar(@PathVariable("id") Long cedula_cliente, Map<String, Object> model, RedirectAttributes flash) {
        Cliente cliente = null;
        if (cedula_cliente > 0L) {
            cliente = clienteService.findOne(cedula_cliente);
            if (cliente == null) {
                flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
                return "redirect:/listar";
            } else {
                model.put("cliente", cliente);
                model.put("titulo", "EDITAR CLIENTE");
                return "form";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
            return "redirect:/listar";
        }
    }

    @RequestMapping(
        value = {"/form"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "FORMULARIO DE CLIENTE");
            return "form";
        } else {
            String uniqueFilename;
            

            uniqueFilename = cliente.getId() != null ? "Cliente editado con éxito!" : "Cliente creado con éxito!";
            clienteService.save(cliente);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listar";
        }
    }

    @RequestMapping({"/eliminar/{id}"})
    public String eliminar(@PathVariable("id") Long cedula_cliente, RedirectAttributes flash) {
        if (cedula_cliente > 0L) {
            Cliente cliente = clienteService.findOne(cedula_cliente);
            clienteService.delete(cedula_cliente);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
            
        }

        return "redirect:/listar";
    }
    
    
    
	
	@GetMapping("/marcasformcliente")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Cliente());
		return "marcaformcliente";
		
	}
	
	@GetMapping("/marcacliente")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Cliente coche, RedirectAttributes flash) {
		//model.addAttribute("cochesPorMarca", clienteService.findOne(id));
		//return "marcaformcliente";
		Cliente valor = clienteService.findOne(id);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El Cliente no existe en DDBB");
            return "redirect:/listar";
        }else {
        	model.addAttribute("cochesPorMarca", clienteService.findOne(id));
        	return "marcaformcliente";
        }
		
		
	}
	
	@GetMapping("/marcasformclienteventa")
	public String marcasformv(Model model) {
		model.addAttribute("coche", new Cliente());
		return "formventacrear";
		
	}
	
	@GetMapping("/marcaclienteventa")
	public String buscarPorMarcav(@RequestParam Long idb, Model model, @ModelAttribute("coche") Cliente coche, RedirectAttributes flash) {
		//model.addAttribute("cochesPorMarca", clienteService.findOne(id));
		//return "marcaformcliente";
		Cliente valor = clienteService.findOne(idb);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El Cliente no existe en DDBB");
            return "redirect:/formventacrear";
        }else {
        	model.addAttribute("cochesPorMarca", clienteService.findOne(idb));
        	return "formventacrear";
        }
		
		
	}
    
}
