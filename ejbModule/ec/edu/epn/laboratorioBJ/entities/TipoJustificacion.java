package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_justificacion database table.
 * 
 */
@Entity
@Table(name = "`tipo_justificacion`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="TipoJustificacion.findAll", query="SELECT t FROM TipoJustificacion t")
public class TipoJustificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipojust")
	private String idTipojust;

	@Column(name="nombre_just")
	private String nombreJust;

	public TipoJustificacion() {
	}

	public String getIdTipojust() {
		return this.idTipojust;
	}

	public void setIdTipojust(String idTipojust) {
		this.idTipojust = idTipojust;
	}

	public String getNombreJust() {
		return this.nombreJust;
	}

	public void setNombreJust(String nombreJust) {
		this.nombreJust = nombreJust;
	}

}