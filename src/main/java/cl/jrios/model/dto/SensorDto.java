package cl.jrios.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.jrios.model.entity.Sensor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class SensorDto {
	@Getter
	private Sensor sensor;
	@Setter
	@Getter
	private List<Sensor> sensores;

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
