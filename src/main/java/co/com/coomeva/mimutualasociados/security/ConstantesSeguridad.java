/**
 * File ConstantesSeguridad.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 16/04/2019 
 * @Package co.com.coomeva.mimutualasociados.security
 */

package co.com.coomeva.mimutualasociados.security;

/**
 * Class ConstantesSeguridad
 *
 * @Version 1 
 * @Date 16/04/2019 
 * @Author Jose Lover Daza Rojas
 */
public class ConstantesSeguridad {

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 3600; // 1 Hora
	public static final String SIGNING_KEY = "";
	public static final String TOKEN_PREFIX = "";
	public static final String HEADER_STRING = "";
	public static final String AUTHORITIES_KEY = "";
	public static final String PASS_DEFAULT = "";

	/**
     * Constructor de la clase	
     * */
	private ConstantesSeguridad() {
		throw new IllegalStateException("ConstantesSeguridad.class");
	}
}