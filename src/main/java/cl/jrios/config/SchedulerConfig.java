package cl.jrios.config;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cl.jrios.service.DispositivoService;

@EnableScheduling
@Configuration
public class SchedulerConfig {
    @Autowired
    SimpMessagingTemplate template;
    
    @Autowired
	private DispositivoService servicio;

    @Scheduled(fixedDelay = 1000)
    public void sendAdhocMessages() {
        Random rnd = new Random();
        
        Integer[] numeros = new Integer[10];
        
        for(int i = 0; i < 10; i ++) {
            numeros[i] =  rnd.nextInt((10 - 0) + 1) + 0;
        }
        //Integer[] numeros = servicio.obtenerNumeros()

        template.convertAndSend("/agente/grafico", numeros);
    }
}
