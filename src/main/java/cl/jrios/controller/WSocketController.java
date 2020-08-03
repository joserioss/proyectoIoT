package cl.jrios.controller;

import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WSocketController {
	@MessageMapping("user")
	@SendTo("/agente/user")
	public Integer[] valores() {
		Random rnd = new Random();

		Integer[] numeros = new Integer[10];

		for (int i = 0; i < 10; i++) {
			numeros[i] = rnd.nextInt((10 - 0) + 1) + 0;
		}

		return numeros;
	}
}
