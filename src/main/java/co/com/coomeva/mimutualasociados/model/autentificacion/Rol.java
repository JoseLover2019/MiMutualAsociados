/**
 * File Rol.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 15/04/2019 
 * @Package co.com.coomeva.mimutualasociados.model.autentificacion
 */

package co.com.coomeva.mimutualasociados.model.autentificacion;

import java.io.Serializable;
import java.util.List;
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
 * Class Rol
 *
 * @Version 1 
 * @Date 15/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
    
    @Size(max = 40)
    @Column(name="nombre")
    @NotNull
    private String nombre;
	
    @Size(max = 40)
    @Column(name="descripcion")
    @NotNull
    private String descripcion;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_privilegios", 
		joinColumns = @JoinColumn(name = "rol_id"), 
		inverseJoinColumns = @JoinColumn(name = "privilegio_id"))
	private List<Privilegio> privilegios;
	
    /**
     * Constructor vacío de la clase	 
     * */
    public Rol() {}

    /**
     * Constructor de la clase	 
     * @param id     
     * */    
    public Rol(Long id) {
    	this.id = id;    	
    }
}