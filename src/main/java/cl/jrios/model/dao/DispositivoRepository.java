package cl.jrios.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Dispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
	Optional<Dispositivo> findByMac(String mac);
}
