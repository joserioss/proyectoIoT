package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.DispositivoRespository;
import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.entity.Dispositivo;

@Service
public class DispositivoServiceImpl implements DispositivoService {
	private static final Logger log = LoggerFactory.getLogger(DispositivoServiceImpl.class);

	@Autowired
	private DispositivoRespository dao;

	private DispositivoDto respuesta;

	@Transactional(readOnly = true)
	@Override
	public DispositivoDto llenarDispositivoDto() {
		List<Dispositivo> dispositivos = new ArrayList<>();
		String mensaje = "Ha ocurrido un error";
		String codigo = "-1";

		respuesta = new DispositivoDto(dispositivos, mensaje, codigo);

		try {
			respuesta.setDispositivos(dao.findAll());
			respuesta.setMensaje("Exito");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Dispositivo Service: Error en llenarDispositivoDto", e);
		}

		return respuesta;
	}

}
