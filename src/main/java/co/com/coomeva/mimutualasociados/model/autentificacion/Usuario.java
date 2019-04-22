/**
 * File Usuario.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 15/04/2019 
 * @Package co.com.coomeva.mimutualasociados.model.autentificacion
 */

package co.com.coomeva.mimutualasociados.model.autentificacion;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Class Usuario
 *
 * @Version 1 
 * @Date 15/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
    
    @Size(max = 40)
    @Column(name="usuario")
    @NotNull
    private String usuario;
	
    @Size(max = 40)
    @Column(name="contrasena")
    @NotNull
    private String contrasena;
	
    @NotNull
    private Boolean habilitado;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( 
        name = "usuario_roles", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;
    
    /**
     * Constructor vacío de la clase	 
     * */
    public Usuario() {}

    /**
     * Constructor de la clase	 
     * @param usuario
     * @param contrasena
     * */    
    public Usuario(String usuario, String contrasena) {
    	this.usuario = usuario;
    	this.contrasena = contrasena;
    }
}