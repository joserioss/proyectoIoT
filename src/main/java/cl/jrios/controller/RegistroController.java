package cl.jrios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.model.dto.RegistroDto;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.service.UsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private UsuarioService servicio;

	@GetMapping
	public String registro(ModelMap modelo) {
		modelo.put("usuario", new UsuarioDto());
		return "login/registro";
	}

	@PostMapping
	public String registroRealizado(ModelMap modelo, @ModelAttribute RegistroDto registroUsuario) {
		servicio.registrarUsuarioExterno(registroUsuario);
		modelo.put("usuario", new UsuarioDto());
		return "login/login";
	}
}
