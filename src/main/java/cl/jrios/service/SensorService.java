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
public class SensorService {

	private static final Logger logger = LoggerFactory.getLogger(SensorService.class);

	@Autowired
	private SensorRepository dao;

	public SensorDto registrarSensor(Sensor sensor) {
		SensorDto sensorDto = new SensorDto();
		sensorDto.setSensor(dao.save(sensor));

		return sensorDto;
	}

	public SensorDto llenarSensores() {
		SensorDto sensorDto = new SensorDto(new Sensor(), dao.findAll());
		return sensorDto;
	}

	public void eliminarSensor(Sensor sensor) {
		Sensor sensorEnBase = dao.findById(sensor.getId()).orElse(null);
		if (sensorEnBase != null) {
			try {
				dao.delete(sensor);
				logger.info("Sensor eliminado : " + sensor.getId());
			} catch (Exception e) {
				logger.info("Error al intentar eliminar : " + sensor.getId());
			}
		}
	}

	public SensorDto actualizarSensor(SensorDto sensorDto) {
		sensorDto.setSensor(dao.save(sensorDto.getSensor()));
		return sensorDto;
	}

	public SensorDto obtenerPorId(Integer id) {
		SensorDto sensorDto = new SensorDto();
		sensorDto.setSensor(dao.findById(id).orElse(null));
		return sensorDto;
	}
	
	public SensorDto obtenerPorNombre(String nombre) {
		SensorDto sensorDto = new SensorDto(dao.findByNombre(nombre).get(), dao.findAll());
		return sensorDto;
	}
	
}
