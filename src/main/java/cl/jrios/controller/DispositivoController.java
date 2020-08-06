package cl.jrios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.service.DispositivoService;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {
	private Logger logger = LoggerFactory.getLogger(DispositivoController.class);

	@Autowired
	private DispositivoService servicio;

	@GetMapping
	public String index(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		return "dispositivos/index";
	}
	
	@PostMapping("/agregar")
	public String agregarDispositivo(@ModelAttribute Dispositivo dispositivo) {
		DispositivoDto respuestaServicio = servicio.registrarDispositivo(dispositivo);
			
			return "dispositivos/index";

	}
	
}
