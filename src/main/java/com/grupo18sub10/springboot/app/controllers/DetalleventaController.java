package com.grupo18sub10.springboot.app.controllers;



import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

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

import com.grupo18sub10.springboot.app.models.entity.Detalleventa;


import com.grupo18sub10.springboot.app.models.service.IDetalleventaService;



@Controller
@SessionAttributes({"cliente"})
public class DetalleventaController {
    @Autowired
    private IDetalleventaService detalleventaService;
    

    public DetalleventaController() {
    }

    
    
    
    @GetMapping({"/verdetalle/{id}"})
    public String ver(@PathVariable("id") Long codigo_detalle_venta, Map<String, Object> model, RedirectAttributes flash) {
        Detalleventa detalleventa = detalleventaService.findOne(codigo_detalle_venta);
        if (detalleventa == null) {
            flash.addFlashAttribute("error", "El cliente no existe en DDBB");
            return "redirect:/listardetalle";
        } else {
            model.put("detalleventa", detalleventa);
            model.put("titulo", "Detalle Venta: " + detalleventa.getCodigo_venta());
            return "verdettalle";
        }
    }

    
    
    
    

    @RequestMapping({"/formdetalle"})
    public String crear(Map<String, Object> model) {
        Detalleventa detalleventa = new Detalleventa();
        model.put("detalleventa", detalleventa);
        model.put("titulo", "Formulario de Detalle Venta");
        return "formdetalle";
    }

    @RequestMapping({"/formdetalle/{id}"})
    public String editar(@PathVariable("id") Long codigo_detalle_venta, Map<String, Object> model, RedirectAttributes flash) {
        Detalleventa detalleventa = null;
        if (codigo_detalle_venta > 0L) {
            detalleventa = detalleventaService.findOne(codigo_detalle_venta);
            if (detalleventa == null) {
                flash.addFlashAttribute("error", "El ID de la venta no existe en la BBDD!");
                return "redirect:/listardetalle";
            } else {
                model.put("detalleventa", detalleventa);
                model.put("titulo", "Editar Detalle Venta");
                return "formdetalle";
            }
        } else {
            flash.addFlashAttribute("error", "El ID de detalle venta no puede ser cero!");
            return "redirect:/listardetalle";
        }
    }

    @RequestMapping(
        value = {"/formdetalle"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Detalleventa detalleventa, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Dettalle Venta");
            return "formdetalle";
        } else {
            String uniqueFilename;
            

            uniqueFilename = detalleventa.getId() != null ? "Detalle Venta editado con éxito!" : "Detalle Venta creado con éxito!";
            detalleventaService.save(detalleventa);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listardetalle";
        }
    }

    @RequestMapping({"/eliminardetalle/{id}"})
    public String eliminar(@PathVariable("id") Long codigo_detalle_venta, RedirectAttributes flash) {
        if (codigo_detalle_venta > 0L) {
            Detalleventa detalleventa = detalleventaService.findOne(codigo_detalle_venta);
            detalleventaService.delete(codigo_detalle_venta);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
            
        }

        return "redirect:/listardetalle";
    }
    
    
    
	
	@GetMapping("/marcasformclientedetalle")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Detalleventa());
		return "marcaformclientedtalle";
		
	}
	
	@GetMapping("/marcaclientedetalle")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Detalleventa coche, RedirectAttributes flash) {
		//model.addAttribute("cochesPorMarca", clienteService.findOne(id));
		//return "marcaformcliente";
		Detalleventa valor = detalleventaService.findOne(id);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "Detalle Venta no existe en DDBB");
            return "redirect:/vista";
        }else {
        	model.addAttribute("cochesPorMarca", detalleventaService.findOne(id));
        	return "marcaformclientedetalle";
        }
		
		
	}
    
}
