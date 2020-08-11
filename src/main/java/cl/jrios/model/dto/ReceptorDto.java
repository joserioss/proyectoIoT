package cl.jrios.model.dto;

import java.util.List;

import cl.jrios.model.entity.Receptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ReceptorDto {
	private Integer status;
	private List<Receptor> data;

}
