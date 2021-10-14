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


import com.grupo18sub10.springboot.app.models.entity.Producto;
import com.grupo18sub10.springboot.app.models.entity.Proveedor;

import com.grupo18sub10.springboot.app.models.service.IProductoService;
import com.grupo18sub10.springboot.app.models.service.IProveedorService;

import com.grupo18sub10.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"producto"})
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private IProveedorService proveedorService;
    

    public ProductoController() {
    }

    
    
    
    @GetMapping({"/verduc/{id}"})
    public String ver(@PathVariable("id") Long codigo_producto, Map<String, Object> model, RedirectAttributes flash) {
        Producto producto = productoService.findOne(codigo_producto);
        if (producto == null) {
            flash.addFlashAttribute("error", "El producto no existe en DDBB");
            return "redirect:/listarproduc";
        } else {
        	
            model.put("producto", producto);
            model.put("titulo", "Detalle producto: " + producto.getNombre_producto());
            return "verduc";
        }
    }

    
    @RequestMapping(
        value = {"/listarduc"},
        method = {RequestMethod.GET}
    )
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        //Pageable pageRequestB = PageRequest.of(page, 4);
        Page<Producto> producto = productoService.findAll(pageRequest);
       //Page<Proveedor> proveedor = proveedorService.findAll(pageRequestB);
        PageRender<Producto> pageRender = new PageRender<Producto>("/listarduc", producto);
        //PageRender<Proveedor> pageRenderB = new PageRender<Proveedor>("/listarduc", proveedor);
        model.addAttribute("titulo", "LISTADO DE PRODUCTOS");
        //model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("productos", producto);
        //model.addAttribute("proveedores", proveedor);
        model.addAttribute("page", pageRender);
        //model.addAttribute("page", pageRenderB);
        return "listarduc";
    }

    @RequestMapping({"/formduc"})
    public String crear(Map<String, Object> model) {
        Producto producto = new Producto();
        model.put("producto", producto);
        model.put("titulo", "FORMULARIO DE PRODUCTO");
        return "formduc";
    }

    @RequestMapping({"/formduc/{id}"})
    public String editar(@PathVariable("id") Long codigo_producto, Map<String, Object> model, RedirectAttributes flash) {
        Producto producto = null;
        if (codigo_producto > 0L) {
            producto = productoService.findOne(codigo_producto);
            if (producto == null) {
                flash.addFlashAttribute("error", "El ID del producto no existe en la BBDD!");
                return "redirect:/listarduc";
            } else {
                model.put("producto", producto);
                model.put("titulo", "EDITAR / CREAR PRODUCTO");
                return "formduc";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del producto no puede ser cero!");
            return "redirect:/listarduc";
        }
    }
    
    @RequestMapping(
        value = {"/formduc"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Producto producto, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de producto");
            return "formduc";
        } else {
            String uniqueFilename;
            

            uniqueFilename = producto.getId() != null ? "Producto creado / editado con éxito!" : "Producto creado / editado con éxito!";
            productoService.save(producto);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listarduc";
        }
    }

    
    

    @RequestMapping({"/formproduc"})
    public String crearB(Map<String, Object> model) {
        Proveedor proveedor = new Proveedor();
        model.put("proveedor", proveedor);
        model.put("titulo", "Formulario de Proveedor");
        return "formproduc";
    }
    
    @RequestMapping({"/formproduc/{id}"})
    public String editarB(@PathVariable("id") Long nit_proveedor, Map<String, Object> model, RedirectAttributes flash) {
        Proveedor proveedor = null;
        if (nit_proveedor > 0L) {
            proveedor = proveedorService.findOne(nit_proveedor);
            if (proveedor == null) {
                flash.addFlashAttribute("error", "El NIT del proveedor no existe en la BBDD!");
                return "redirect:/listarduc";
            } else {
                model.put("proveedor", proveedor);
                model.put("titulo", "Editar Proveedor");
                return "formproduc";
            }
        } else {
            flash.addFlashAttribute("error", "El NIT del proveedor no puede ser cero!");
            return "redirect:/listarduc";
        }
    }
    
    
    @RequestMapping(
            value = {"/formproduc"},
            method = {RequestMethod.POST}
        )
        public String guardarB(@Valid Proveedor proveedor, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
            if (result.hasErrors()) {
                model.addAttribute("titulo", "Formulario de Proveedor");
                return "formproduc";
            } else {
                String uniqueFilename;
                

                uniqueFilename = proveedor.getId() != null ? "Proveedor editado con éxito!" : "Proveedor creado con éxito!";
                proveedorService.save(proveedor);
                status.setComplete();
                flash.addFlashAttribute("success", uniqueFilename);
                return "redirect:listarduc";
            }
        }
    
    
    
    
    
    
    
    @RequestMapping({"/eliminarduc/{id}"})
    public String eliminar(@PathVariable("id") Long codigo_producto, RedirectAttributes flash) {
        if (codigo_producto > 0L) {
            Producto producto = productoService.findOne(codigo_producto);
            productoService.delete(codigo_producto);
            flash.addFlashAttribute("success", "Producto eliminado con éxito!");
            
        }

        return "redirect:/listarduc";
    }
    
    

	@GetMapping("/marcasformproducto")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Producto());
		return "marcaformproducto";
		
	}
	
	@GetMapping("/marcaproducto")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Producto coche, RedirectAttributes flash) {
		Producto valor = productoService.findOne(id);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El producto no existe en DDBB");
            return "redirect:/listarduc";
        }else {
        	model.addAttribute("cochesPorMarca", productoService.findOne(id));
        	return "marcaformproducto";
        }
		
		
	}
	
	
	@GetMapping("/marcasformproductoventa")
	public String marcasformv(Model model) {
		model.addAttribute("coche", new Producto());
		return "ventas";
		
	}
	
	@GetMapping("/marcaproductoventa")
	public String buscarPorMarcav(@RequestParam Long nombre_producto, Model model, @ModelAttribute("coche") Producto coche, RedirectAttributes flash) {
		Producto valor = productoService.findOne(nombre_producto);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El producto no existe en DDBB");
            return "redirect:/ventas";
        }else {
        	model.addAttribute("cochesPorMarcab", productoService.findOne(nombre_producto));
        	return "ventas";
        }
		
		
	}
	
	
    
}
