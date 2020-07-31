package cl.jrios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.service.SensorService;

@Controller
@RequestMapping("/sensores")
public class SensorController {

	@Autowired
	private SensorService servicio;
	
    @GetMapping
    public String registroSensor(
        ModelMap mapa,
        @ModelAttribute("mensaje") String mensaje) {

        if(mensaje != null)
            mapa.put("mensaje", mensaje);
        //mapa.put("dispositivos", servicio.traerTodos());

        return "sensores/index";
    }
}
