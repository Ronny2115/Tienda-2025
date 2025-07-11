package com.tienda.controllers;

import com.tienda.entities.Persona;
import com.tienda.servicies.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personaService.findAll());
        return "persona-List";
    }

    @GetMapping("/")
    public String mostearPaginaInicio() {
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostearFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-form";
    }

    @PostMapping
    public String guardarPersona(Persona persona) {
        personaService.save(persona);
        return "redirect:/personas/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.getById(id));
        return "persona-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.delete(id);
        return "redirect:/personas";
    }

}
