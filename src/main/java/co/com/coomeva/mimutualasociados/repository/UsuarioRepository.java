/**
 * File UsuarioRepository.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 16/04/2019 
 * @Package co.com.coomeva.mimutualasociados.repository
 */

package co.com.coomeva.mimutualasociados.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.com.coomeva.mimutualasociados.model.autentificacion.Usuario;

/**
 * Interface UsuarioRepository
 *
 * @Version 1 
 * @Date 16/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
	Optional<Usuario> findByUsuario(@Param("usuario") String nombre);
	
	Boolean existsByUsuario(String nombre);
	
}