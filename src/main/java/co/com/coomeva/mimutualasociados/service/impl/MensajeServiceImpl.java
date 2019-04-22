/**
 * File MensajeServicioLocal.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 17/04/2019 
 * @Package co.com.coomeva.mimutualasociados.security
 */

package co.com.coomeva.mimutualasociados.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import co.com.coomeva.mimutualasociados.service.MensajeService;

/**
 * Class MensajeServicioLocal
 *
 * @Version 1 
 * @Date 17/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Service
public class MensajeServiceImpl implements MensajeService{

	@Autowired
    private MessageSource messageSource;

    public String obtenerMensaje(String id) {
        Locale local = Locale.getDefault();
        return messageSource.getMessage(id, null, local);
    }
    
    public String obtenerMensaje(String id, Object[] args) {
        Locale local = Locale.getDefault();
        return messageSource.getMessage(id, args, local);
    }
	
}