package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sinPassword")
public class SinPasswordController {
	
	@GetMapping
	public String sinPassword(ModelMap mapa) {
		String vista = "login/sinPassword";
		return vista;
	}

}
