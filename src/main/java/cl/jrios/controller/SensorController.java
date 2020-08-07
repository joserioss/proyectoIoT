package cl.jrios.controller;

import java.util.List;

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

import cl.jrios.model.dto.SensorDto;
import cl.jrios.model.entity.Sensor;
import cl.jrios.service.SensorService;

@Controller
@RequestMapping("/sensores")
public class SensorController {
	private Logger logger = LoggerFactory.getLogger(SensorController.class);

	@Autowired
	private SensorService servicioSensor;

	@GetMapping
	public String indexSensor(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensores", sensores);
		modelo.put("sensores", sensores);
		return "sensores/index";
	}
	
	@GetMapping("/actualizar")
	public String actualizar(ModelMap modelo, @RequestParam(name = "id") Integer id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		Sensor sensor = servicioSensor.obtenerPorId(id).getSensor();
		
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensor", sensor);
		modelo.addAttribute("sensores", sensores);
		
		return "sensores/sensorActualizar";
	}

	@PostMapping
	public String registroSensor(@ModelAttribute Sensor sensor, ModelMap modelo) {
		logger.info("Nuevo sensor registrado");
		SensorDto sensorDto = servicioSensor.registrarSensor(sensor);
		
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensor", sensor);
		modelo.addAttribute("sensores", sensores);
		return "sensores/index";
	}

	@PostMapping("/actualizar")
	public String hacerActualizar(@ModelAttribute Sensor sensor, ModelMap modelo, RedirectAttributes attributes) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		SensorDto dtoEnBase = servicioSensor.obtenerPorNombre(sensor.getNombre());
		dtoEnBase.getSensor().setNombre(sensor.getNombre());
		dtoEnBase.getSensor().setDescripcion(sensor.getDescripcion());
		dtoEnBase.getSensor().setTipo(sensor.getTipo());
		
		servicioSensor.actualizarSensor(dtoEnBase);
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensor", dtoEnBase.getSensor());
		modelo.addAttribute("sensores", sensores);
		return "redirect:/sensores";
	}

	@GetMapping("/eliminar")
	public String eliminar(ModelMap modelo, @RequestParam(name = "id") Integer id) {
		logger.info("Sensor a eliminar:" + id);
		Sensor sensor = servicioSensor.obtenerPorId(id).getSensor();
		servicioSensor.eliminarSensor(sensor);

		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensor", sensor);
		modelo.addAttribute("sensores", sensores);
		return "redirect:/sensores";
	}

}
