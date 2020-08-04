package cl.jrios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Usuario;
import cl.jrios.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UsuarioService servicio;

	@GetMapping
	public String administradorIndex(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		modelo.put("usuarioDto", servicio.llenarUsuarios());

		return "admin/index";
	}

	@PostMapping
	public String mantenedorUsuarios(@ModelAttribute Usuario usuario) {
		UsuarioDto usuarioDto = servicio.registrarUsuario(usuario);
		if (usuarioDto.getUsuario() == null)
			return "admin";

		return "redirect:admin";
	}

    @RequestMapping(value = "/eliminar")
    public String eliminar(
        ModelMap modelo,
        @RequestParam(name = "id") Integer id,
        RedirectAttributes attributes
    ) {

        servicio.eliminarUsuario(id);

        return "redirect:/admin";
    }
	
	
}
