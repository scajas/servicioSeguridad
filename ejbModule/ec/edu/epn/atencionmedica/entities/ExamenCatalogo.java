package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the examen_catalogo database table.
 * 
 */
@Entity
@Table(name="examen_catalogo", catalog="`bddcorpepn`", schema="`Medico`")
@NamedQuery(name="ExamenCatalogo.findAll", query="SELECT e FROM ExamenCatalogo e")
public class ExamenCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_examen")
	private Integer idExamen;

	private String descripcion;

	private String orden;

	private String tipo;

	public ExamenCatalogo() {
	}

	public Integer getIdExamen() {
		return this.idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}