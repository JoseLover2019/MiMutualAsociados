/**
 * File UsuarioLogin.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 17/04/2019 
 * @Package co.com.coomeva.mimutualasociados.util
 */

package co.com.coomeva.mimutualasociados.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Class UsuarioLogin
 * 
 * @Version 1
 * @Date 17/04/2019 
 * @Author Jose Lover Daza Rojas
 */

public class UsuarioLogin {

	/**
     * Constructor vacío de la clase	 
     * */
	private UsuarioLogin() {}
	
	public static String obtenerUsuario() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}
	
	public static List<String> obtenerRoles() {
		Collection<? extends GrantedAuthority> authorities =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	}
	
}