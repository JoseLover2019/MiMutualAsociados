/**
 * File UsuarioController.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 16/04/2019 
 * @Package co.com.coomeva.mimutualasociados.controller
 */

package co.com.coomeva.mimutualasociados.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.coomeva.mimutualasociados.dto.ApiRespuestaDto;
import co.com.coomeva.mimutualasociados.model.autentificacion.Usuario;
import co.com.coomeva.mimutualasociados.service.MensajeService;
import co.com.coomeva.mimutualasociados.service.UsuarioService;
import co.com.coomeva.mimutualasociados.util.Constantes;

/**
 * Class UsuarioController
 *
 * @Version 1 
 * @Date 16/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@Autowired
	private MensajeService mensajeService;
		
	@PostMapping
	public ResponseEntity<ApiRespuestaDto> create(@Valid @RequestBody Usuario usuario, HttpServletRequest request) {				
		if (usuarioService.existePorNombre(usuario.getUsuario())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, (mensajeService.obtenerMensaje(Constantes.USUARIO_EXISTE)));
		}		
		
		usuario.setContrasena(usuario.getContrasena());
		usuario.setHabilitado(false);
		Usuario usuarioCreado = usuarioService.guardar(usuario);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioCreado.getId()).toUri();
		return ResponseEntity.created(location).body(new ApiRespuestaDto(mensajeService.obtenerMensaje(Constantes.USUARIO_CREADO)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiRespuestaDto> actualizar(@RequestBody Usuario usuario, @PathVariable Long id, HttpServletRequest request) {
		Usuario usuarioModificar = usuarioService.buscarPorId(id);
		if(usuario != null) {
			usuarioService.guardar(usuarioModificar);
			return ResponseEntity.ok(new ApiRespuestaDto(mensajeService.obtenerMensaje(Constantes.USUARIO_MODIFICADO)));
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, (mensajeService.obtenerMensaje(Constantes.USUARIO_NO_EXISTE)));
	}
}
