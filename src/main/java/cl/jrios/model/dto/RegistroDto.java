package cl.jrios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class RegistroDto {
	private Integer id;
	private String nombre;
	private String correo;

	private String contrasenia;
	private String contrasenia_;

}
