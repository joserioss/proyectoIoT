package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.SensorRepository;
import cl.jrios.model.dto.SensorDto;
import cl.jrios.model.entity.Sensor;

@Service
public class SensorServiceImpl implements SensorService {

	private static final Logger log = LoggerFactory.getLogger(SensorServiceImpl.class);

	@Autowired
	private SensorRepository dao;

	private SensorDto respuesta;

	@Transactional(readOnly = true)
	@Override
	public SensorDto llenarSensorDto() {
		List<Sensor> sensores = new ArrayList<>();
		String mensaje = "Ha ocurrido un error";
		String codigo = "-1";

		respuesta = new SensorDto(sensores, mensaje, codigo);
		try {
			respuesta.setSensores(dao.findAll());
			respuesta.setMensaje("Éxito");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Sensor Service: Error en llenarSensorDto", e);
		}

		return respuesta;
	}

}
