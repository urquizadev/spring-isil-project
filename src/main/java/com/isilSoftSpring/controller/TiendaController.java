package com.isilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.isilSoftSpring.entity.Colaborador;
import com.isilSoftSpring.entity.Tienda;
import com.isilSoftSpring.repository.ColaboradorRepository;
import com.isilSoftSpring.repository.TiendaRepository;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

	
	@Autowired
	TiendaRepository tiendaRepository; 
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("distrito")String distrito, Model model) {
		List<Tienda> listaTiendas = tiendaRepository.findByDistritoContains(distrito);
		if(!listaTiendas.isEmpty()) {
			model.addAttribute("listaTiendas", listaTiendas);
			return "gestionTienda";
		}
		else {
			String mensaje="No se encuentra coincidencia";
			model.addAttribute("mensaje", mensaje);
			return "gestionTienda";
		}
	}
	
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
		List<Colaborador> listaColaboradores = colaboradorRepository.findAll();
		model.addAttribute("listaColaboradores", listaColaboradores);
		Tienda tienda = new Tienda();
		model.addAttribute("tienda", tienda);
		return "nuevaTienda";
	}
	
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("tienda")Tienda tienda, Model model){
		Tienda tiendaBD = tiendaRepository.findByDireccion(tienda.getDireccion());
		if(tiendaBD==null) {
			tiendaRepository.save(tienda);
			List<Tienda> listaTiendas = tiendaRepository.findAll();
			model.addAttribute("listaTiendas", listaTiendas);
			return "gestionTienda";
		}
		else {
			String mensaje = "La tienda ya se encuentra registrada en el sistema. Ingresa otra direccion";
			List<Colaborador> listaColaboradores = colaboradorRepository.findAll();
			model.addAttribute("listaColaboradores", listaColaboradores);
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("tienda", tienda);
			return "nuevaTienda";
		}
	}
}
