package com.isilSoftSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilSoftSpring.entity.Usuario;
import com.isilSoftSpring.repository.UsuarioRepository;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	
	@PostMapping("/validarUsuario")
	public String validarUsuario(@RequestParam("correo")String correo, @RequestParam("password")String password, Model model){
		Usuario usuario = usuarioRepository.findByCorreoAndPassword(correo, password);
		if (usuario!=null) {
			return "principal";
		}
		else {
			String mensaje = "Usuario o contraseña incorrecta";
			model.addAttribute("mensaje", mensaje);
			return "index";
		}
	}
	
	@GetMapping("/nuevoUsuario")
	public String registrar(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "registroUsuario";
	}
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@ModelAttribute("usuario")Usuario usuario, Model model) {
		Usuario usuarioBD = usuarioRepository.findByCorreo(usuario.getCorreo());
		if(usuarioBD==null) {
			usuario.setActivo("activo");
			usuarioRepository.save(usuario);
			return "index";
		}
		else {
			String mensaje = "El usuario ya se encuentra registrado en el sistema";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("usuario", usuario);
			return "registroUsuario";
		}
	}
	
	@GetMapping("/recuperarPassword")
	public String recuperarPassword() {
		return "recuperarPassword";
	}
	
	
	@PostMapping("/recuperarPasswordXCorreo")
	public String recuperarPasswordXCorreo(@RequestParam("correo")String correo, Model model) {
	 	Usuario usuario = usuarioRepository.findByCorreo(correo);
	 	if(usuario!=null) {
	 		model.addAttribute("usuario",usuario);
	 		return "recuperarPassword";
	 	}
	 	else {
	 		String mensaje= "Usuario no encontrado";
			model.addAttribute("mensaje", mensaje);
			return "recuperarPassword";
	 	}
	}
	
	@PostMapping("/actualizarPassword")
	public String actualizarPassword(@RequestParam("id")int id ,@RequestParam("password1")String password1, @RequestParam("password2")String password2, Model model) {
		Usuario usuario= usuarioRepository.findById(id);
		if(password1.equals(password2)) {
			usuario.setPassword(password1);
			usuarioRepository.save(usuario);
			String mensaje="Contraseña cambiada con éxito";
			model.addAttribute("mensaje", mensaje);
			return "index";
		}
		else {
			String mensaje= "Las contraseñas no coinciden";
			model.addAttribute("mensaje",mensaje);
			return "recuperarPassword";
		}
		
	}

}

