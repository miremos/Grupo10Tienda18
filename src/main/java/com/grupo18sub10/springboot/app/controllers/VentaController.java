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

import com.grupo18sub10.springboot.app.models.entity.Venta;

import com.grupo18sub10.springboot.app.models.service.IVentaService;
import com.grupo18sub10.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"venta"})
public class VentaController {
    @Autowired
    private IVentaService ventaService;
    

    public VentaController() {
    }

    
    
    
    @GetMapping({"/verventa/{id}"})
    public String ver(@PathVariable("id") Long codigo_venta, Map<String, Object> model, RedirectAttributes flash) {
        Venta venta = ventaService.findOne(codigo_venta);
        if (venta == null) {
            flash.addFlashAttribute("error", "El cliente no existe en DDBB");
            return "redirect:/listarventa";
        } else {
            model.put("cliente", venta);
            model.put("titulo", "Detalle cliente: " + venta.getCedula_cliente());
            return "verventa";
        }
    }

    
    
    
    @RequestMapping(
        value = {"/ventas"},
        method = {RequestMethod.GET}
    )
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Venta> venta = ventaService.findAll(pageRequest);
        PageRender<Venta> pageRender = new PageRender<Venta>("/listarventa", venta);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("venta", venta);
        model.addAttribute("page", pageRender);
        return "ventas";
    }
    
    @RequestMapping(
            value = {"/listarventas"},
            method = {RequestMethod.GET}
        )
        public String listarb(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
    	var personas = ventaService.findAll();
    	var saldoTotal = 0D;
    	for(var p: personas){
            saldoTotal += p.getTotal_venta();
        }
            Pageable pageRequest = PageRequest.of(page, 4);
            Page<Venta> venta = ventaService.findAll(pageRequest);
            PageRender<Venta> pageRender = new PageRender<Venta>("/listarventas", venta);
            
            model.addAttribute("titulo", "REPORTE DE VENTAS");
            model.addAttribute("venta", venta);
            model.addAttribute("page", pageRender);
            model.addAttribute("saldoTotal", saldoTotal);
            return "listarventas";
        }
    

    @RequestMapping({"/formventa"})
    public String crear(Map<String, Object> model) {
        Venta venta = new Venta();
        model.put("venta", venta);
        model.put("titulo", "Formulario de Venta");
        return "formventa";
    }

    @RequestMapping({"/formventa/{id}"})
    public String editar(@PathVariable("id") Long codigo_venta, Map<String, Object> model, RedirectAttributes flash) {
        Venta venta = null;
        if (codigo_venta > 0L) {
            venta = ventaService.findOne(codigo_venta);
            if (venta == null) {
                flash.addFlashAttribute("error", "El ID del la venta no existe en la BBDD!");
                return "redirect:/listar";
            } else {
                model.put("venta", venta);
                model.put("titulo", "Editar Venta");
                return "formventa";
            }
        } else {
            flash.addFlashAttribute("error", "El ID de la venta no puede ser cero!");
            return "redirect:/listarventa";
        }
    }

    @RequestMapping(
        value = {"/formventa"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Venta venta, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Venta");
            return "formventa";
        } else {
            String uniqueFilename;
            

            uniqueFilename = venta.getId() != null ? "Venta editada con éxito!" : "Venta creada con éxito!";
            ventaService.save(venta);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listarventas";
        }
    }
    
    
    
    
    
    
    @RequestMapping({"/formventacrear"})
    public String crearb(Map<String, Object> model) {
        Venta venta = new Venta();
        model.put("venta", venta);
        model.put("titulo", "Formulario de Venta crear");
        return "formventacrear";
    }

    @RequestMapping({"/formventacrear/{id}"})
    public String editarb(@PathVariable("id") Long codigo_venta, Map<String, Object> model, RedirectAttributes flash) {
        Venta venta = null;
        if (codigo_venta > 0L) {
            venta = ventaService.findOne(codigo_venta);
            if (venta == null) {
                flash.addFlashAttribute("error", "El ID del la venta no existe en la BBDD!");
                return "redirect:/listar";
            } else {
                model.put("venta", venta);
                model.put("titulo", "Editar Venta");
                return "formventacrear";
            }
        } else {
            flash.addFlashAttribute("error", "El ID de la venta no puede ser cero!");
            return "redirect:/listarventa";
        }
    }

    @RequestMapping(
        value = {"/formventacrear"},
        method = {RequestMethod.POST}
    )
    public String guardarb(@Valid Venta venta, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Venta crear");
            return "formventacrear";
        } else {
            String uniqueFilename;
            

            uniqueFilename = venta.getId() != null ? "Venta editada con éxito!" : "Venta creada con éxito!";
            ventaService.save(venta);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listarventas";
        }
    }
    
    
    

    @RequestMapping({"/eliminarventa/{id}"})
    public String eliminar(@PathVariable("id") Long codigo_venta, RedirectAttributes flash) {
        if (codigo_venta > 0L) {
            Venta venta = ventaService.findOne(codigo_venta);
            ventaService.delete(codigo_venta);
            flash.addFlashAttribute("success", "Venta eliminada con éxito!");
            
        }

        return "redirect:/listarventas";
    }
    
    
    
	
	@GetMapping("/marcasformventa")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Venta());
		return "ventas";
		
	}
	
	@GetMapping("/marcacventa")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Venta coche, RedirectAttributes flash) {
		//model.addAttribute("cochesPorMarca", ventaService.findOne(id));
		//return "marcaformcliente";
		
		Venta venta = ventaService.findOne(id);
		//model.addAttribute("cochesPorMarca", productoService.findOne(id));
		//Producto producto = productoService.findOne(id);
        if (venta == null) {
            flash.addFlashAttribute("error", "La venta no existe en DDBB");
            return "redirect:/ventas";
        }else {
        	model.addAttribute("cochesPorMarca", ventaService.findOne(id));
        	return "ventas";
        }
		
		//return "marcaformproducto";
	}
    
}
