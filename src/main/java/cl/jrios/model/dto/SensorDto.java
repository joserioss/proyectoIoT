package cl.jrios.model.dto;

import java.util.List;

import cl.jrios.model.entity.Sensor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SensorDto extends GenericDto{

	@Setter
	@Getter
	private List<Sensor> sensores;
	
	public SensorDto(String mensaje, String codigo){
		super(mensaje, codigo);
	}

	public SensorDto(List<Sensor> sensores,String mensaje, String codigo){
		super(mensaje, codigo);
		this.sensores = sensores;
	}
	
}
