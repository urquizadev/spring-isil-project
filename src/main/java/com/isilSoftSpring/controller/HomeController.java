package com.isilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isilSoftSpring.entity.Tienda;
import com.isilSoftSpring.repository.TiendaRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	TiendaRepository tiendaRepository;

	@GetMapping("/gestionTienda")
	public String gestionTienda(Model model) {
		List<Tienda> listaTiendas = tiendaRepository.findAll();
		model.addAttribute("listaTiendas", listaTiendas);
		return "gestionTienda";
	}
	
}
