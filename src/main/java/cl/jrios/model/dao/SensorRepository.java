package cl.jrios.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
	Optional<Sensor> findByNombre(String nombre);
//	
}
