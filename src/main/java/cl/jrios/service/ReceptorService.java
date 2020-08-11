package cl.jrios.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.ReceptorRepository;
import cl.jrios.model.dto.ReceptorDto;
import cl.jrios.model.dto.ReceptorFormDto;
import cl.jrios.model.entity.Receptor;

@Service
public class ReceptorService {

	@Autowired
	private ReceptorRepository dao;

	@Transactional(readOnly = true)
	public ReceptorDto obtenerTodos() {
		return new ReceptorDto(200, dao.findAll());
	}

	@Transactional
	public List<Integer> obtenerUltimos() {
		String mac = "60:01:94:61:B1:FD";
		List<Integer> resp = new ArrayList<>();
		List<Receptor> receptores;

		receptores = dao.findAllByOrderByIdDesc();

		for (Receptor rec : receptores) {
			if (mac.equals(rec.getMac())) {
				resp.add(Integer.parseInt(rec.getDatos()));

			}
		}
		return resp;
	}

	@Transactional
	public ReceptorDto registrar(ReceptorFormDto receptorForm) {
		Receptor receptor = new Receptor();
		receptor.setMac(receptorForm.getMac());
//		receptor.setSensor(receptorForm.getSensor());
		receptor.setDatos(receptorForm.getDatos());
		Receptor respuesta = dao.save(receptor);

		return new ReceptorDto(201, Arrays.asList(respuesta));
	}

}
