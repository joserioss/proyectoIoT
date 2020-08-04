package cl.jrios.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import cl.jrios.config.EncoderUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter 
    private Integer id;
    @Setter @Getter 
    private String nombre;
    @Setter @Getter 
    private String correo;
    @Getter 
    private String contrasenia;
    @Setter @Getter 
    private Rol rol;

    @ManyToMany(
		cascade = { CascadeType.PERSIST, CascadeType.MERGE },
		mappedBy = "usuario")
	@JoinTable(
		name = "dispositivo_usuario", 
		joinColumns = @JoinColumn(name = "usuario_id"), 
		inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))

	@Setter @Getter
	private Set<Dispositivo> dispositivos = new HashSet<>();
   

    	// helpers
	public Usuario asignarDispositivo(Dispositivo dispostivo){
		this.dispositivos.add(dispostivo);
		return this;
	}

	public Usuario quitarDispotivo(Dispositivo dispositivo){
		this.dispositivos.remove(dispositivo);
		return this;
	}

	public Usuario eliminarDispositivos() {
		this.dispositivos.clear();
		return this;
	}
	
	// Set contraseña
    public void setContrasenia(String contrasenia) {
        this.contrasenia = EncoderUtils.passwordEncoder().encode(contrasenia);
    }
}
