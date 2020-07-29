package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/",""})
public class LoginController {

    @GetMapping
    public String index(ModelMap mapa) {
        String vista = "login/login";
		return vista;
    }
}
