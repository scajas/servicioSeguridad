package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoinvolucrado database table.
 * 
 */
@Entity
@Table(name="tipoinvolucrado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoinvolucrado.findAll", query="SELECT t FROM Tipoinvolucrado t")
public class Tipoinvolucrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoinvolucrado")
	private Integer idTipoinvolucrado;

	@Column(name="descripcion_tipoinvolucrado")
	private String descripcionTipoinvolucrado;

	@Column(name="nombre_tipoinvolucrado")
	private String nombreTipoinvolucrado;

	//bi-directional one-to-one association to Involucrado
	@OneToOne(mappedBy="tipoinvolucrado")
	private Involucrado involucrado;

	public Tipoinvolucrado() {
	}

	public Integer getIdTipoinvolucrado() {
		return this.idTipoinvolucrado;
	}

	public void setIdTipoinvolucrado(Integer idTipoinvolucrado) {
		this.idTipoinvolucrado = idTipoinvolucrado;
	}

	public String getDescripcionTipoinvolucrado() {
		return this.descripcionTipoinvolucrado;
	}

	public void setDescripcionTipoinvolucrado(String descripcionTipoinvolucrado) {
		this.descripcionTipoinvolucrado = descripcionTipoinvolucrado;
	}

	public String getNombreTipoinvolucrado() {
		return this.nombreTipoinvolucrado;
	}

	public void setNombreTipoinvolucrado(String nombreTipoinvolucrado) {
		this.nombreTipoinvolucrado = nombreTipoinvolucrado;
	}

	public Involucrado getInvolucrado() {
		return this.involucrado;
	}

	public void setInvolucrado(Involucrado involucrado) {
		this.involucrado = involucrado;
	}

}