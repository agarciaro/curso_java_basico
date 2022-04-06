package com.sopra.videoclub5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sopra.videoclub5.service.SociosService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class SociosController {

	@Autowired 
	SociosService sociosService;
	
	@GetMapping ("/")
	public String home(Model model) {
		model.addAttribute("socis", sociosService.findAll());
		model.addAttribute("message", "Estos resultados se han encontrado!");
		return "socis-home";
	}
	
}
