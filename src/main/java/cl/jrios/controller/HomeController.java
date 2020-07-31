package cl.jrios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.service.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public String index() {
		return "home/index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(ModelMap mapa) {
		return "home/dashboard";
	}
}
