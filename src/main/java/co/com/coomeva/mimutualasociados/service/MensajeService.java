package co.com.coomeva.mimutualasociados.service;

public interface MensajeService {
	
	String obtenerMensaje(String id);

	String obtenerMensaje(String id, Object[] args);
}
