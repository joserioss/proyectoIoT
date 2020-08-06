package cl.jrios.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.jrios.model.entity.Dispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class DispositivoDto {
	@Getter
	private Dispositivo dispositivo;
	@Setter
	@Getter
	private List<Dispositivo> dispositivos;

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

}
