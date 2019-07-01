package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_producto database table.
 * 
 */
@Entity
@Table(name = "tipo_producto", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="TipoProducto.findAll", query="SELECT t FROM TipoProducto t")
public class TipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"id_tipoP\"")
	private Integer id_tipoP;

	private String activo;

	private String nombre;

	public TipoProducto() {
	}

	public Integer getId_tipoP() {
		return this.id_tipoP;
	}

	public void setId_tipoP(Integer id_tipoP) {
		this.id_tipoP = id_tipoP;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}