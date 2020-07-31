package cl.jrios.model.dto;

import java.util.List;

import cl.jrios.model.entity.Dispositivo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DispositivoDto extends GenericDto{

	@Setter
	@Getter
	private List<Dispositivo> dispositivos;
	
	public DispositivoDto(String mensaje, String codigo) {
		super(mensaje, codigo);
	}
	
	public DispositivoDto(List<Dispositivo> dispositivos, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.dispositivos = dispositivos;
	}
}
