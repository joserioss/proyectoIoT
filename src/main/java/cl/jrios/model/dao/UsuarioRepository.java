package cl.jrios.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
//	
}
