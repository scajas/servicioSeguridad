package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accionespersonalbtn database table.
 * 
 */
@Entity
@NamedQuery(name="Accionespersonalbtn.findAll", query="SELECT a FROM Accionespersonalbtn a")
public class Accionespersonalbtn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado;

	private String nombre;

	private String orden;

	private String url;

	//bi-directional many-to-many association to UsuarioRrhh
	@ManyToMany(mappedBy="accionespersonalbtns")
	private List<UsuarioRrhh> usuarios;


	public Accionespersonalbtn() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<UsuarioRrhh> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioRrhh> usuarios) {
		this.usuarios = usuarios;
	}



}