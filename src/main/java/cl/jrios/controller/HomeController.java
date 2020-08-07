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
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("home")
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UsuarioService servicioUsuario;

	@Autowired
	private DispositivoService servicioDispositivo;

	@Autowired
	private SensorService servicioSensor;

	@GetMapping
	public String home(ModelMap modelo) {
		// capturo el nombre de usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensores", sensores);
		modelo.addAttribute("dispositivos", dispositivos);

		modelo.put("sensores", sensores);
		return "home/index";
	}

	@PostMapping
	public String vincularDispositivoSensor(ModelMap modelo,
			@RequestParam(name = "mac", required = true) String mac,
			@RequestParam(name = "nombre", required = true) String nombre) {
		
			SensorDto sensorDto = servicioSensor.obtenerPorNombre(nombre);
			DispositivoDto dispositivoDto = servicioDispositivo.obtenerPorMac(mac);
			
			Sensor sensor = sensorDto.getSensor();	
			Dispositivo dispositivo = dispositivoDto.getDispositivo();
			
			sensor.setDispositivo(dispositivo);
			logger.warn("***************** sensor: "+ sensorDto.getSensor().getId());
			logger.warn("***************** sensor: "+ sensorDto.getSensor().getNombre());
			logger.warn("***************** sensor: "+ sensorDto.getSensor().getDispositivo());
			
			
			servicioSensor.actualizarSensor(sensorDto);
//			dispositivo.asignarSensor(sensor);
			
			
			List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
			List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();
			modelo.addAttribute("sensores", sensores);
			modelo.addAttribute("dispositivos", dispositivos);

			modelo.put("sensores", sensores);
			return "home/index";
	}

}
