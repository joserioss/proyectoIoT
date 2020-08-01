package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.UsuarioRepository;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Usuario;

@Service
public class UsuarioService{

	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository dao;

	private UsuarioDto respuesta;

	public UsuarioDto llenarUsuarioDto() {
		List<Usuario> usuarios = new ArrayList<>();
		String mensaje = "Ha ocurrido un error";
		String codigo = "-1";

		respuesta = new UsuarioDto(usuarios, mensaje, codigo);

		try {
			respuesta.setUsuarios(dao.findAll());
			respuesta.setMensaje("Éxito");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en llenarUsuarioDto", e);
		}
		return respuesta;
	}

}
