package cl.jrios.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.jrios.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UsuarioDto {
	@Getter
	private Usuario usuario;
	@Setter
	@Getter
	private List<Usuario> usuarios;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
