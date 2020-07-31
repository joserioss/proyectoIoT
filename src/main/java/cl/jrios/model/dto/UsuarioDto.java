package cl.jrios.model.dto;

import java.util.List;

import cl.jrios.model.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UsuarioDto extends GenericDto{
	
	@Setter
	@Getter
	private List<Usuario> usuarios;
	
	public UsuarioDto(String mensaje, String codigo){
		super(mensaje, codigo);
	}
	
	public UsuarioDto(List<Usuario> usuarios, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.usuarios = usuarios;
	}

}
