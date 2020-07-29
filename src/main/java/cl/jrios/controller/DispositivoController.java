package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	
	@GetMapping
	public String registroDispositivo(ModelMap mapa) {
		String vista = "dispositivos/index";
		return vista;
	}
}
