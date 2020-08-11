package cl.jrios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.jrios.model.dto.ReceptorDto;
import cl.jrios.model.dto.ReceptorFormDto;
import cl.jrios.service.ReceptorService;

@RestController
@RequestMapping("/api/v1/receptores")
public class ReceptorController {

	@Autowired
	private ReceptorService servicioReceptor;

	@GetMapping
	public ReceptorDto receptores() {
		return servicioReceptor.obtenerTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ReceptorDto registrar(@RequestBody ReceptorFormDto receptorForm) {
		return servicioReceptor.registrar(receptorForm);
	}

}
