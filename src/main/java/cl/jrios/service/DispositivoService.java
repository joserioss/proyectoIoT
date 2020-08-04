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
public class DispositivoService {
	private static final Logger logger = LoggerFactory.getLogger(DispositivoService.class);

	@Autowired
	private DispositivoRespository dao;

	private DispositivoDto respuesta;

	// OBSERVAR ESTE METODO, INGRESADO POR DEFECTO
	@Transactional(readOnly = true)
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
			logger.trace("Dispositivo Service: Error en llenarDispositivoDto", e);
		}

		return respuesta;
	}
	//	FIN METODO
	
	public DispositivoDto ingresarDispositivo(Dispositivo dispositivo) {
		List<Dispositivo> dispositivos = new ArrayList<>();
		String mensaje = "Error";
		String codigo = "-1";
		respuesta = new DispositivoDto(dispositivos, mensaje, codigo);
		
		try {
			dao.save(dispositivo);
			respuesta.setCodigo("0");
			respuesta.setMensaje("éxito");
		} catch (Exception e) {
			 logger.error("error al ingresar Dispositivo: " + e.getMessage());
		}
		return respuesta;
	}

}
