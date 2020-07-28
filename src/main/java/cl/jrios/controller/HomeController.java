package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class HomeController {
	@GetMapping
	public String index(ModelMap mapa) {
		List<String> palabras = new ArrayList<>();

		palabras.add("foo");
		palabras.add("bar");

		mapa.put("palabras", palabras);

		return "usuarios/home";
	}
}
