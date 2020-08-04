package cl.jrios.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Setter @Getter private String nombre;
	
//	@Column(unique = true)
	@Setter @Getter private String mac;
	@Setter @Getter private String ubicacion;
	@Setter @Getter private PrivacidadDispositivo privacidad;
	
	@OneToMany( mappedBy = "dispositivo" )
	@Setter @Getter private List<Sensor> sensores;
	
	public Dispositivo agregarSensor(Sensor sensor) {
		this.sensores.add(sensor);
		
		return this;
	}
	
	
}
