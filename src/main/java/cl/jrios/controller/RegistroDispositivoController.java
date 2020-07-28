package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registroDispositivo")
public class RegistroDispositivoController {
	
	@GetMapping
	public String registroDispositivo(ModelMap mapa) {

		return "dispositivos/registroDispositivo";
	}
}
