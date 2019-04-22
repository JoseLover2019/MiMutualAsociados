/**
 * File UsuarioServiceImpl.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 15/04/2019 
 * @Package co.com.coomeva.mimutualasociados.service.impl
 */

package co.com.coomeva.mimutualasociados.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.com.coomeva.mimutualasociados.model.autentificacion.Usuario;
import co.com.coomeva.mimutualasociados.repository.UsuarioRepository;
import co.com.coomeva.mimutualasociados.service.UsuarioService;
import co.com.coomeva.mimutualasociados.util.Constantes;

/**
 * Class UsuarioServiceImpl
 *
 * @Version 1 
 * @Date 15/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
		
	Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	private MessageSource messageSource;
		
	public List<Usuario> buscarTodos() {		
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(Long id) {		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			return usuarioOptional.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				messageSource.getMessage(Constantes.USUARIO_NO_EXISTE, null, Locale.getDefault()));
	}
	
	public Usuario buscarPorNombre(String nombre) {		
		Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(nombre);
		if (usuarioOptional.isPresent()) {
			return usuarioOptional.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				messageSource.getMessage(Constantes.USUARIO_NO_EXISTE, null, Locale.getDefault()));
	}
	
	public Boolean existePorId(Long id) {		
		return usuarioRepository.existsById(id);
	}
	
	public Boolean existePorNombre(String nombre) {		
		return usuarioRepository.existsByUsuario(nombre);
	}
	
	public Usuario guardar(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario modificar(Usuario usuario) {		
		if (existePorId(usuario.getId() != null ? usuario.getId() : 0)) {			
			return usuarioRepository.save(usuario);
		}		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				messageSource.getMessage(Constantes.USUARIO_NO_EXISTE, null, Locale.getDefault()));
	}
	
	public Usuario modificar(Usuario usuario, Long id) {
		if (existePorId(id)) {
			usuario.setId(id);
			return usuarioRepository.save(usuario);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				messageSource.getMessage(Constantes.USUARIO_NO_EXISTE, null, Locale.getDefault()));
	}
	
	public boolean eliminar(Usuario usuario) {		
		if (existePorId(usuario.getId() != null ? usuario.getId() : 0)) {			
			usuarioRepository.deleteById(usuario.getId());
			return true;
		}
		return false;
	}
	
	public boolean eliminar(Long id) {
		if(id > 0)
		{
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}	
		
}