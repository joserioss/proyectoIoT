package cl.jrios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.service.DispositivoService;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {

	@Autowired
	private DispositivoService servicio;

	@GetMapping
	public String index(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		return "dispositivos/index";
	}
}
