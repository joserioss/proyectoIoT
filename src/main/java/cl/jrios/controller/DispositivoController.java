package cl.jrios.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.Sensor;
import cl.jrios.model.entity.Usuario;
import cl.jrios.service.DispositivoService;
import cl.jrios.service.SensorService;
import cl.jrios.service.UsuarioService;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {
	private Logger logger = LoggerFactory.getLogger(DispositivoController.class);

	@Autowired
	private UsuarioService servicioUsuario;
	
	@Autowired
	private DispositivoService servicioDispositivo;

	@Autowired
	private SensorService servicioSensor;

	@GetMapping
	public String indexDispositivo(ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		String nombre = servicioUsuario.buscarUsuarioPorCorreo(name);
		UsuarioDto usuarioDto = servicioUsuario.buscarUsuarioPorNombre(nombre);
		Usuario usuario = usuarioDto.getUsuario();
		
		List<Dispositivo> listaDispositivos = usuario.getDispositivos();
		logger.warn("***************** LUsuario: "+ usuario);
		logger.warn("***************** Lista de dispositivos: "+ listaDispositivos);
		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		List<Sensor> sensores = servicioSensor.llenarSensores().getSensores();

		modelo.addAttribute("sensores", sensores);
		modelo.addAttribute("dispositivos", dispositivos);
		modelo.put("dispositivos", dispositivos);
		return "dispositivos/index";
	}

	@GetMapping("/actualizar")
	public String actualizar(ModelMap modelo, @RequestParam(name = "id") Integer id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		
		Dispositivo dispositivo = servicioDispositivo.obtenerPorId(id).getDispositivo();
		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();

		modelo.addAttribute("sensores", dispositivo);
		modelo.addAttribute("dispositivos", dispositivos);
		return "dispositivos/index";
	}

	@PostMapping
	public String agregarDispositivo(@ModelAttribute Dispositivo dispositivo, ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);

		String nombre = servicioUsuario.buscarUsuarioPorCorreo(name);
		UsuarioDto usuarioDto = servicioUsuario.buscarUsuarioPorNombre(nombre);
		Usuario usuario = usuarioDto.getUsuario();
		
		logger.info("Nuevo dispositivo registrado");
		DispositivoDto dispositivoDto = servicioDispositivo.registrarDispositivo(dispositivo);
		
		logger.warn("***************** USUARIO: "+ usuario);
		usuario.asignarDispositivo(dispositivo);
		servicioUsuario.actualizarUsuario(usuarioDto);
		dispositivo.asignarUsuario(usuario);
		servicioDispositivo.actualizarDispositivo(dispositivoDto);
		
		

		if (dispositivoDto.getDispositivo() == null) {
			logger.warn("Registro vacio");
			return "dispositivos/index";
		}
		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		modelo.addAttribute("sensores", dispositivo);
		modelo.addAttribute("dispositivos", dispositivos);
		return "dispositivos/index";
	}

	@PostMapping("/actualizar")
	public String hacerActualizar(@ModelAttribute Dispositivo dispositivo, ModelMap modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		modelo.addAttribute("username", name);
		logger.info("Nuevo dispositivo registrado");

		DispositivoDto dto = servicioDispositivo.obtenerPorMac(dispositivo.getMac());
		dto.getDispositivo().setNombre(dispositivo.getNombre());
		dto.getDispositivo().setMac(dispositivo.getMac());
		dto.getDispositivo().setUbicacion(dispositivo.getUbicacion());
		dto.getDispositivo().setPrivacidad(dispositivo.getPrivacidad());
		
		servicioDispositivo.actualizarDispositivo(dto);

		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		modelo.addAttribute("sensores", dispositivo);
		modelo.addAttribute("dispositivos", dispositivos);
		return "redirect:/dispositivos";
	}

	@GetMapping("/eliminar")
	public String eliminar(ModelMap modelo, @RequestParam(name = "id") Integer id) {
		logger.info("Dispositivo a eliminar:" + id);
		Dispositivo dispositivo = servicioDispositivo.obtenerPorId(id).getDispositivo();
		servicioDispositivo.eliminarDispositivo(dispositivo);

		List<Dispositivo> dispositivos = servicioDispositivo.llenarDispositivos().getDispositivos();
		modelo.addAttribute("sensores", dispositivo);
		modelo.addAttribute("dispositivos", dispositivos);
		return "redirect:/dispositivos";
	}

}
