package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.dao.UsuarioRepository;
import cl.jrios.model.dto.RegistroDto;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.Rol;
import cl.jrios.model.entity.Usuario;

@Service
public class UsuarioService {
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository dao;

	public UsuarioDto registrarUsuario(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();

		Usuario usuarioEnBase = dao.findByCorreo(usuario.getCorreo()).orElse(null);

		if (usuarioEnBase != null) {
			usuarioDto.setUsuario(usuarioEnBase);
			logger.warn("El usuario que desea ingresar ya existe");
		} else {
			usuarioDto.setUsuario(dao.save(usuario));
		}

		return usuarioDto;
	}

	// Servicio que recibe datos desde un formulario exterior y crea a un usuario
	// del sistema con rol USER

	public Usuario registrarUsuarioExterno(RegistroDto registroUsuario) {
		Usuario usuario = new Usuario();

		boolean contraseniaOk = registroUsuario.getContrasenia().equals(registroUsuario.getContrasenia_());
		if (contraseniaOk) {
			usuario.setId(null);
			usuario.setNombre(registroUsuario.getNombre());
			usuario.setCorreo(registroUsuario.getCorreo());
			usuario.setContrasenia(registroUsuario.getContrasenia());
			usuario.setRol(Rol.ROLE_USER);
			registrarUsuario(usuario);
			logger.info("Usuario Registrado");
		} else {
			logger.warn("Contraseñas incorrectas");
		}
		return usuario;
	}

	public UsuarioDto llenarUsuarios() {
		UsuarioDto usuarioDto = new UsuarioDto(new Usuario(), dao.findAll());

		return usuarioDto;
	}

	public UsuarioDto eliminarUsuario(Integer id) {
		UsuarioDto dto = new UsuarioDto();
		dto.setUsuario(dao.findById(id).orElse(null));

		dao.delete(dto.getUsuario());

		return dto;
	}
	
	public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {
		usuarioDto.setUsuario(dao.save(usuarioDto.getUsuario()));
		return usuarioDto;
	} 

	public String buscarUsuarioPorCorreo(String correo) {
		Optional<Usuario> usuarioDto = Optional.empty();
		usuarioDto = dao.findByCorreo(correo);
		String nombre = usuarioDto.get().getNombre();
		return nombre;
	}

	public UsuarioDto buscarUsuarioPorNombre(String nombre) {
		UsuarioDto aux = new UsuarioDto(new Usuario(), dao.findAll());
		aux.setUsuario(dao.findByNombre(nombre).orElse(null));
		return aux;
	}

	public UsuarioDto obtenerPorId(Integer id) {
		UsuarioDto aux = new UsuarioDto();
		aux.setUsuario(dao.findById(id).orElse(null));
		return aux;
	}
	
	public List<Dispositivo> dispositivosPermitidos(String name, List<Dispositivo> dispositivos){
		List<Dispositivo> dispositivosPermitidos = new ArrayList<>();

		String nombreSesion = "[" + name + "]";
		for (Dispositivo disp : dispositivos) {
			String usuarioEnTexto = disp.getUsuarios().toString();
			if (nombreSesion.equals(usuarioEnTexto)) {
				dispositivosPermitidos.add(disp);
			}
		}
		return dispositivosPermitidos;
	}
}
