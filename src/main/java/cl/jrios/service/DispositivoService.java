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

	public DispositivoDto registrarDispositivo(Dispositivo dispositivo) {
		DispositivoDto dispositivoDto = new DispositivoDto();
		Dispositivo dispositivoEnBase = dao.findByMac(dispositivo.getMac()).orElse(null);
		
		if(dispositivoEnBase != null) {
			dispositivoDto.setDispositivo(dispositivoEnBase);
			logger.warn("El dispositivo ya existe");
		}else {
			dispositivoDto.setDispositivo(dao.save(dispositivo));
		}
		return dispositivoDto;
	}

	public DispositivoDto llenarDispositivo() {
		DispositivoDto dispositivoDto = new DispositivoDto(new Dispositivo(), dao.findAll());
		return dispositivoDto;
	}

}
