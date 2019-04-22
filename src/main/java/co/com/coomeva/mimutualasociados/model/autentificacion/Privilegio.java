/**
 * File Privilegio.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 16/04/2019 
 * @Package co.com.coomeva.mimutualasociados.model.autentificacion
 */

package co.com.coomeva.mimutualasociados.model.autentificacion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Privilegio
 *
 * @Version 1 
 * @Date 16/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Getter
@Setter
@Entity
public class Privilegio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Size(max = 40)
    @Column(name="nombre")
    @NotNull
    private String nombre;
	
	@Size(max = 100)
    @Column(name="ruta")
    @NotNull
    private String ruta;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "valido")
    private Boolean valido;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy = "privilegios")
    @JsonIgnore
    private List<Rol> roles;
    
    @ManyToOne
    @JoinColumn(name = "ID_PADRE", referencedColumnName = "ID", nullable= true)    
    @JsonBackReference
    private Privilegio padre;
    
    @OneToMany(mappedBy = "padre", fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE}, targetEntity = Privilegio.class)
    @OrderBy("orden ASC")
    @JsonManagedReference
    private List<Privilegio> items;
	
}