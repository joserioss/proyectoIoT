package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensores")
public class SensorController {

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
