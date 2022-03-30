package com.sopra.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sopra.biblioteca.model.Soci;
import com.sopra.biblioteca.service.SocisService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SocisController {
	
	@Autowired
	SocisService socisService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("socis", socisService.findAll());
		model.addAttribute("message", "Hola mundo!");
		return "socis-home";
	}
	
	@GetMapping("/socis/nav-editar/{codi}")
	public String navEditar(Model model, @PathVariable Integer codi) {
		model.addAttribute("mode", "editar");
		model.addAttribute("soci", socisService.findByCodi(codi));
		return "socis-edicio";
	}
	
	@GetMapping("/socis/nav-nou")
	public String navNou(Model model) {
		model.addAttribute("mode", "nou");
		model.addAttribute("soci", new Soci());
		return "socis-edicio";
	}
	
	@GetMapping("/socis/eliminar/{codi}")
	public ModelAndView eliminar(Model model, @PathVariable Integer codi) {
		socisService.delete(codi);
		return new ModelAndView("redirect:/");
	}
	
}
