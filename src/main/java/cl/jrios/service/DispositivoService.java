package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.DispositivoRepository;
import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.entity.Dispositivo;

@Service
public class DispositivoService {
	private static final Logger logger = LoggerFactory.getLogger(DispositivoService.class);

	@Autowired
	private DispositivoRepository dao;

	public DispositivoDto registrarDispositivo(Dispositivo dispositivo) {
		DispositivoDto dispositivoDto = new DispositivoDto();
		dispositivoDto.setDispositivo(dao.save(dispositivo));

		return dispositivoDto;
	}

	public DispositivoDto llenarDispositivos() {
		DispositivoDto dispositivoDto = new DispositivoDto(new Dispositivo(), dao.findAll());
		return dispositivoDto;
	}

	public void eliminarDispositivo(Dispositivo dispositivo) {
		Dispositivo dispositivoEnBase = dao.findById(dispositivo.getId()).orElse(null);
		if (dispositivoEnBase != null) {
			try {
				dao.delete(dispositivo);
				logger.info("Dispositivo eliminado : " + dispositivo.getId());
			} catch (Exception e) {
				logger.info("Error al intentar eliminar : " + dispositivo.getId());
			}
		}
	}

	public DispositivoDto actualizarDispositivo(DispositivoDto dispositivoDto) {
		dispositivoDto.setDispositivo(dao.save(dispositivoDto.getDispositivo()));
		return dispositivoDto;
	}

	public DispositivoDto obtenerPorId(Integer id) {
		DispositivoDto dispositivoDto = new DispositivoDto();
		dispositivoDto.setDispositivo(dao.findById(id).orElse(null));
		return dispositivoDto;
	}

	public DispositivoDto obtenerPorMac(String mac) {
		DispositivoDto dispositivoDto = new DispositivoDto(dao.findByMac(mac).get(), dao.findAll());
		return dispositivoDto;
	}
}
