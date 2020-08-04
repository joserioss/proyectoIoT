package cl.jrios.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Setter @Getter
	private String nombre;
	@Setter @Getter
	private String mac;
	@Setter @Getter
	private String ubicacion;
	@Setter @Getter
	private PrivacidadDispositivo privacidad;

	@OneToMany(cascade = CascadeType.ALL,
              mappedBy = "dispositivo", orphanRemoval = true)
    private List<Sensor> sensores = new ArrayList<>();

	@ManyToMany
	@Setter @Getter
	private Set<Usuario> usuarios = new HashSet<>();

	// helpers
	public Dispositivo asignarUsuario(Usuario usuario){
		this.usuarios.add(usuario);
		return this;
	}

	public Dispositivo quitarUsuario(Usuario usuario){
		this.usuarios.remove(usuario);
		return this;
	}

	public Dispositivo eliminarUsuarios() {
		this.usuarios.clear();
		return this;
	}

}
