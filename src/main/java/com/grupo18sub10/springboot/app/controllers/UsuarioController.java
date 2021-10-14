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


import com.grupo18sub10.springboot.app.models.entity.Usuario;


import com.grupo18sub10.springboot.app.models.service.IUsuarioService;

import com.grupo18sub10.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({"usuario"})
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    

    public UsuarioController() {
    }

    

    @GetMapping({"/verusu/{id}"})
    public String ver(@PathVariable("id") Long cedula_usuario, Map<String, Object> model, RedirectAttributes flash) {
        
         Usuario usuario = usuarioService.findOne(cedula_usuario);
        if (usuario == null) {
            flash.addFlashAttribute("error", "El usuario no existe en DDBB");
            return "redirect:/listarusu";
        } else {
            model.put("usuario", usuario);
            model.put("titulo", "Detalle usuario: " + usuario.getNombre_usuario());
            return "verusu";
        }
    }

    
    
    
    @RequestMapping(
        value = {"/listarusu"},
        method = {RequestMethod.GET}
    )
    public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Usuario> usuario = usuarioService.findAll(pageRequest);
        PageRender<Usuario> pageRender = new PageRender<Usuario>("/listarusu", usuario);
        model.addAttribute("titulo", "LISTADO DE USUARIOS");
        model.addAttribute("usuarios", usuario);
        model.addAttribute("page", pageRender);
        return "listarusu";
    }
    

    
    
    
    @RequestMapping(
            value = {"/listarusureporte"},
            method = {RequestMethod.GET}
        )
        public String listarB(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
            Pageable pageRequest = PageRequest.of(page, 5);
            Page<Usuario> usuario = usuarioService.findAll(pageRequest);
            PageRender<Usuario> pageRender = new PageRender<Usuario>("/listarusureporte", usuario);
            model.addAttribute("titulo", "REPORTE DE USUARIOS");
            model.addAttribute("usuarios", usuario);
            model.addAttribute("page", pageRender);
            return "listarusureporte";
        }
    

    @RequestMapping({"/formusu"})
    public String crear(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "FORMULARIO DE USUARIO");
        return "formusu";
    }

    @RequestMapping({"/formusu/{id}"})
    public String editar(@PathVariable("id") Long cedula_usuario, Map<String, Object> model, RedirectAttributes flash) {
        Usuario usuario = null;
        if (cedula_usuario > 0L) {
            usuario = usuarioService.findOne(cedula_usuario);
            if (usuario == null) {
                flash.addFlashAttribute("error", "El ID del usuario no existe en la BBDD!");
                return "redirect:/listar";
            } else {
                model.put("usuario", usuario);
                model.put("titulo", "EDITAR USUARIO");
                return "formusu";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del usuario no puede ser cero!");
            return "redirect:/listarusu";
        }
    }

    @RequestMapping(
        value = {"/formusu"},
        method = {RequestMethod.POST}
    )
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model,  RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "FORMULARIO DE USUARIO");
            return "formusu";
        } else {
            String uniqueFilename;
            

            uniqueFilename = usuario.getId() != null ? "usuario editado con éxito!" : "Usuario creado con éxito!";
            usuarioService.save(usuario);
            status.setComplete();
            flash.addFlashAttribute("success", uniqueFilename);
            return "redirect:listarusu";
        }
    }

    @RequestMapping({"/eliminarusu/{id}"})
    public String eliminar(@PathVariable("id") Long cedula_usuario, RedirectAttributes flash) {
        if (cedula_usuario > 0L) {
            Usuario usuario = usuarioService.findOne(cedula_usuario);
            usuarioService.delete(cedula_usuario);
            flash.addFlashAttribute("success", "Usuario eliminado con éxito!");
            
        }

        return "redirect:/listarusu";
    }
    
    @GetMapping("/marcasformusuario")
	public String marcasform(Model model) {
		model.addAttribute("coche", new Usuario());
		return "marcaformusuario";
		
	}
	
	@GetMapping("/marcausuario")
	public String buscarPorMarca(@RequestParam Long id, Model model, @ModelAttribute("coche") Usuario coche, RedirectAttributes flash) {
		Usuario valor = usuarioService.findOne(id);		
		
        if (valor == null) {
            flash.addFlashAttribute("error", "El producto no existe en DDBB");
            return "redirect:/listarduc";
        }else {
        	model.addAttribute("cochesPorMarca", usuarioService.findOne(id));
        	return "marcaformusuario";
        }
		
		
	}
	
	
}
