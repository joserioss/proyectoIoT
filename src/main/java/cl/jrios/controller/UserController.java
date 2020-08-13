package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.dto.SensorDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.Sensor;
import cl.jrios.service.DispositivoService;
import cl.jrios.service.SensorService;
import cl.jrios.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsuarioService servicioUsuario;

	@Autowired
	private DispositivoService servicioDispositivo;

	@Autowired
	private SensorService servicioSensor;

	@GetMapping
	public String dashboard(ModelMap modelo, @RequestParam(name = "mac") String mac,
			@RequestParam(name = "nombre") String nombre) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		logger.info("Vinculo ingresado:" + mac + "con sensor: " + nombre + "usuario: " + name);

		DispositivoDto dispositivoDto = servicioDispositivo.obtenerPorMac(mac);
		SensorDto sensorDto = servicioSensor.obtenerPorNombre(nombre);

		// ********* Llena dispositivos y selecciona solo los del ususario
		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		List<Dispositivo> dispositivosPermitidos = servicioUsuario.dispositivosPermitidos(name, dispositivos);
		// Llena los sensores y selecciona solo los del dispositivo
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		List<Sensor> sensoresDisponibles = new ArrayList<>();
		for (Sensor sens : sensores) {
			logger.warn("*************** dispositivos de sensores: " + sens.getDispositivo());
			if (sens.getDispositivo() != null) {
				for (Dispositivo disp : dispositivosPermitidos) {
					String dispoSens = sens.getDispositivo().getMac();
					String dispo = disp.getMac();
					if (dispoSens.equals(dispo)) {
						logger.warn("*************** sensor con  dispositivo: " + sens);
						sensoresDisponibles.add(sens);
					} 
				}
			}
		}

		modelo.addAttribute("dispositivos", dispositivosPermitidos);
		modelo.addAttribute("dispositivoDto", dispositivoDto);
		logger.info("dispositivo seleccionado:" + dispositivosPermitidos);
		modelo.addAttribute("sensor", sensorDto.getSensor());
		modelo.addAttribute("sensores", sensoresDisponibles);
		return "user/index";
	}

	@MessageMapping("grafico")
	@SendTo("/agente/grafico")
	public Integer[] valores() {
		Integer[] numeros = new Integer[50];

		return numeros;
	}
}
