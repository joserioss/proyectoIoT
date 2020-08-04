package cl.jrios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.service.SensorService;

@Controller
@RequestMapping("/sensores")
public class SensorController {
	private Logger logger = LoggerFactory.getLogger(SensorController.class);

	@Autowired
	private SensorService servicio;

	@GetMapping
	public String registroSensor(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		return "sensores/index";
	}
}
