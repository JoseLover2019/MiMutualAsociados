/**
 * File UsuarioService.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 15/04/2019 
 * @Package co.com.coomeva.mimutualasociados.service
 */

package co.com.coomeva.mimutualasociados.service;

import java.util.List;
import co.com.coomeva.mimutualasociados.model.autentificacion.Usuario;

/**
 * Interface UsuarioService
 *
 * @Version 1 
 * @Date 15/04/2019 
 * @Author Jose Lover Daza Rojas
 */

public interface UsuarioService {
	
	public List<Usuario> buscarTodos();	
	public Usuario buscarPorId(Long id);
	public Usuario buscarPorNombre(String nombre);
	public Boolean existePorId(Long id);
	public Boolean existePorNombre(String nombre);
	public Usuario guardar(Usuario usuario);
	public Usuario modificar(Usuario usuario);
	public boolean eliminar(Usuario usuario);
	public boolean eliminar(Long id);	
	
}