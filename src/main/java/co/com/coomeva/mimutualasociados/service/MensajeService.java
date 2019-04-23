/**
 * File MensajeService.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 15/04/2019 
 * @Package co.com.coomeva.mimutualasociados.service
 */

package co.com.coomeva.mimutualasociados.service;

/**
 * Interface MensajeService
 *
 * @Version 1 
 * @Date 15/04/2019 
 * @Author Jose Lover Daza Rojas
 */

public interface MensajeService {
	
	String obtenerMensaje(String id);

	String obtenerMensaje(String id, Object[] args);
}