package cl.jrios.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String descripcion;
	private TipoSensor tipo;
	private Integer dato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dispositivo_id", referencedColumnName = "id")
	private Dispositivo dispositivo;

}
