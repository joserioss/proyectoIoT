package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.Sensor;
import cl.jrios.model.entity.Usuario;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		String nombre = servicioUsuario.buscarUsuarioPorCorreo(name);
		UsuarioDto usuarioDto = servicioUsuario.buscarUsuarioPorNombre(nombre);
		Usuario usuario = usuarioDto.getUsuario();

		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();

//************************************PASAR A SERVICIO MAS ADELANTE*******************************

// Servicio de devuelve una lista con los dispositivos pertenecientes solo al usuario de la sesion

		List<Dispositivo> dispositivosPermitidos = new ArrayList<>();

		String nombreSesion = "[" + name + "]";
		for (Dispositivo disp : dispositivos) {
			String usuarioEnTexto = disp.getUsuarios().toString();
			if (nombreSesion.equals(usuarioEnTexto)) {
				dispositivosPermitidos.add(disp);
			}
		}

		logger.warn("*************** dispositico del usuario : " + dispositivosPermitidos);

//************************************ FIN FUTURO SERVICIO *******************************		
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

//		List<Sensor> sensoresPermitidos = new ArrayList<>();
//		for (Sensor sen : sensores) {
//			for (Dispositivo disp : dispositivosPermitidos) {
//				if ((sen.getDispositivo().getMac()).equals(disp.getMac())) {
//					sensoresPermitidos.add(sen);
//				}
//			}
//		}
//		logger.warn("*************** Sensores permitidos : " + sensoresPermitidos);
		modelo.addAttribute("sensores", sensores);
		modelo.addAttribute("dispositivos", dispositivosPermitidos);

		modelo.put("sensores", sensores);
		return "home/index";
	}

	@PostMapping
	public String vincularDispositivoSensor(ModelMap modelo, @RequestParam(name = "mac", required = true) String mac,
			@RequestParam(name = "nombre", required = true) String nombre) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		SensorDto sensorDto = servicioSensor.obtenerPorNombre(nombre);
		DispositivoDto dispositivoDto = servicioDispositivo.obtenerPorMac(mac);

		Sensor sensor = sensorDto.getSensor();
		Dispositivo dispositivo = dispositivoDto.getDispositivo();

		sensor.setDispositivo(dispositivo);
		servicioSensor.actualizarSensor(sensorDto);
//			dispositivo.asignarSensor(sensor);

		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		// ************************************PASAR A SERVICIO MAS
		// ADELANTE*******************************
		List<Dispositivo> dispositivosPermitidos = new ArrayList<>();

		String nombreSesion = "[" + name + "]";
		for (Dispositivo disp : dispositivos) {
			String usuarioEnTexto = disp.getUsuarios().toString();
			if (nombreSesion.equals(usuarioEnTexto)) {
				dispositivosPermitidos.add(disp);
			}
		}

		logger.warn("*************** dispositico del usuario : " + dispositivosPermitidos);

		// ************************************ FIN FUTURO SERVICIO
		// *******************************

		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();
		modelo.addAttribute("sensores", sensores);
		modelo.addAttribute("dispositivos", dispositivosPermitidos);

		modelo.put("sensores", sensores);
		return "home/index";
	}

	@GetMapping("/eliminar")
	public String eliminar(ModelMap modelo, 
			@RequestParam(name = "mac") String mac,
			@RequestParam(name = "nombre")String nombre) {
		logger.info("Vinculo a eliminar:" + mac + "con sensor: " + nombre);
		DispositivoDto dispositivoDto = servicioDispositivo.obtenerPorMac(mac);
		SensorDto sensorDto = servicioSensor.obtenerPorNombre(nombre);
		
		Sensor sensorDesvinculado = new Sensor();
		sensorDesvinculado.setDispositivo(null);
		sensorDesvinculado.setDescripcion(sensorDto.getSensor().getDescripcion());
		sensorDesvinculado.setNombre(sensorDto.getSensor().getNombre());
		sensorDesvinculado.setTipo(sensorDto.getSensor().getTipo());
		
		
		Dispositivo dispositivo = dispositivoDto.getDispositivo();
		
		dispositivo.quitarSensor(sensorDto.getSensor());
		servicioDispositivo.actualizarDispositivo(dispositivoDto);
		
		servicioSensor.registrarSensor(sensorDesvinculado);
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();
		modelo.addAttribute("sensores", sensores);
		
		logger.info("Vinculo eliminado");
		return "redirect:/home";
	}
}
