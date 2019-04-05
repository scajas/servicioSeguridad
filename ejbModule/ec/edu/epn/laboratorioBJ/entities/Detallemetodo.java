package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallemetodo database table.
 * 
 */
@Entity
@Table(name = "`detallemetodo`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Detallemetodo.findAll", query="SELECT d FROM Detallemetodo d")
public class Detallemetodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detallemetodo")
	private String idDetallemetodo;

	private String aux;

	private String aux2;

	@Column(name="cantidad_dmt")
	private float cantidadDmt;

	@Column(name="id_existencia")
	private String idExistencia;

	@Column(name="id_umedida")
	private String idUmedida;

	//bi-directional many-to-one association to Metodo
	@ManyToOne
	@JoinColumn(name="id_metodo")
	private Metodo metodo;

	public Detallemetodo() {
	}

	public String getIdDetallemetodo() {
		return this.idDetallemetodo;
	}

	public void setIdDetallemetodo(String idDetallemetodo) {
		this.idDetallemetodo = idDetallemetodo;
	}

	public String getAux() {
		return this.aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public String getAux2() {
		return this.aux2;
	}

	public void setAux2(String aux2) {
		this.aux2 = aux2;
	}

	public float getCantidadDmt() {
		return this.cantidadDmt;
	}

	public void setCantidadDmt(float cantidadDmt) {
		this.cantidadDmt = cantidadDmt;
	}

	public String getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}

	public String getIdUmedida() {
		return this.idUmedida;
	}

	public void setIdUmedida(String idUmedida) {
		this.idUmedida = idUmedida;
	}

	public Metodo getMetodo() {
		return this.metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

}