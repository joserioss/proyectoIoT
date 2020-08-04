package cl.jrios.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public String dashboard(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		return "user/index";
	}

	@MessageMapping("grafico")
	@SendTo("/agente/grafico")
	public Integer[] valores() {
		Random rnd = new Random();

		Integer[] numeros = new Integer[10];

		for (int i = 0; i < 10; i++) {
			numeros[i] = rnd.nextInt((10 - 0) + 1) + 0;
		}

		return numeros;
	}
}
