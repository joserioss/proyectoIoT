package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/")
	public String main() {
		return "redirect:/home";
	}
	
    @GetMapping("/login")
    public String login(ModelMap modelo, @RequestParam(name = "error", required = false) String error) {
		if (error != null)
			modelo.put("error", true);
    	return "login/login";
    }
    
	@GetMapping("/recurso-prohibido")
	public String prohibido() {
		return "error/403";
	}
    
	@GetMapping("/registro")
	public String registro(ModelMap mapa) {
		return "login/registro";
	}
}
