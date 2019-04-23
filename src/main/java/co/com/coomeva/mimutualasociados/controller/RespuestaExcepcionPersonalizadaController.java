/**
 * File RespuestaExcepcionPersonalizadaController.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 17/04/2019 
 * @Package co.com.coomeva.mimutualasociados.controller
 */

package co.com.coomeva.mimutualasociados.controller;

import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.coomeva.mimutualasociados.dto.ApiRespuestaDto;

/**
 * Class RespuestaExcepcionPersonalizadaController
 *
 * @Version 1 
 * @Date 17/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@ControllerAdvice
public class RespuestaExcepcionPersonalizadaController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> argumentoExcepcionNotValido(MethodArgumentNotValidException ex, Locale local) {
		String errorMsg = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getField() + " " + x.getDefaultMessage()).collect(Collectors.joining(","));
		
        return new ResponseEntity<>(new ApiRespuestaDto(errorMsg), HttpStatus.BAD_REQUEST);
    }
	
	/*@ExceptionHandler(AccessDeniedException.class)    
    public ResponseEntity<Object> manejarExcepcionAutorizacion(AccessDeniedException ex) {
		return new ResponseEntity<>(new ApiRespuestaDto("No tiene permisos para la opción seleccionada"), HttpStatus.FORBIDDEN);
    }*/
	
}