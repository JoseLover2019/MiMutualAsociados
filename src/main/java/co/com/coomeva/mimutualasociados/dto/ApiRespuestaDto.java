/**
 * File RespuestaDto.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 16/04/2019 
 * @Package co.com.coomeva.mimutualasociados.dto
 */

package co.com.coomeva.mimutualasociados.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Class RespuestaDto
 *
 * @Version 1 
 * @Date 16/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Getter
@Setter
public class ApiRespuestaDto {

    private String mensaje;
    
    /**
     * Constructor vacío de la clase	 
     * */
    public ApiRespuestaDto() {}
        
    /**
     * Constructor de la clase	 
     * @param mensaje    
     * */
    public ApiRespuestaDto(String mensaje) { 
    	this.mensaje = mensaje;
    }

}