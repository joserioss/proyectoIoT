package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {
	
    public String listarDispositivos() {
        
    }
    
	@GetMapping
	public String registroDispositivo(ModelMap mapa) {
		String vista = "dispositivos/index";
		return vista;
	}
}
