package cl.jrios.config;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cl.jrios.service.DispositivoService;
import cl.jrios.service.ReceptorService;

@EnableScheduling
@Configuration
public class SchedulerConfig {
	@Autowired
	SimpMessagingTemplate template;

	@Autowired
	private ReceptorService servicio;

	@Scheduled(fixedDelay = 15000)
	public void sendAdhocMessages() {
		List<Integer> numeros = servicio.obtenerUltimos();

		template.convertAndSend("/agente/grafico", numeros);
	}
}
