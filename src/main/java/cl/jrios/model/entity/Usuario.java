package cl.jrios.model.entity;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String toString() {
		return correo;
	}
    
    @Setter @Getter
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
		name = "usuario_dispositivo", 
		joinColumns = @JoinColumn(name = "usuario_id"), 
		inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))
	private List<Dispositivo> dispositivos = new ArrayList();

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
