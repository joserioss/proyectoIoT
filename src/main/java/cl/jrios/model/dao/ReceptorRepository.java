package cl.jrios.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Receptor;

public interface ReceptorRepository extends JpaRepository<Receptor, Integer>{
	public List<Receptor> findAllByOrderByIdDesc();
	public List<Receptor> findAllByOrderByIdAsc();

}
