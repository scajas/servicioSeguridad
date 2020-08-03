package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentacionasociada database table.
 * 
 */
@Entity
@Table(name="documentacionasociada", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Documentacionasociada.findAll", query="SELECT d FROM Documentacionasociada d")
public class Documentacionasociada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_documentoasociado")
	private Integer idDocumentoasociado;

	@Column(name="nombre_documentoasociado")
	private String nombreDocumentoasociado;

	@Column(name="url_documentoasociado")
	private String urlDocumentoasociado;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	//bi-directional many-to-one association to Tipodocumentoasociado
	@ManyToOne
	@JoinColumn(name="id_tipodocumento")
	private Tipodocumentoasociado tipodocumentoasociado;

	public Documentacionasociada() {
	}

	public Integer getIdDocumentoasociado() {
		return this.idDocumentoasociado;
	}

	public void setIdDocumentoasociado(Integer idDocumentoasociado) {
		this.idDocumentoasociado = idDocumentoasociado;
	}

	public String getNombreDocumentoasociado() {
		return this.nombreDocumentoasociado;
	}

	public void setNombreDocumentoasociado(String nombreDocumentoasociado) {
		this.nombreDocumentoasociado = nombreDocumentoasociado;
	}

	public String getUrlDocumentoasociado() {
		return this.urlDocumentoasociado;
	}

	public void setUrlDocumentoasociado(String urlDocumentoasociado) {
		this.urlDocumentoasociado = urlDocumentoasociado;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

	public Tipodocumentoasociado getTipodocumentoasociado() {
		return this.tipodocumentoasociado;
	}

	public void setTipodocumentoasociado(Tipodocumentoasociado tipodocumentoasociado) {
		this.tipodocumentoasociado = tipodocumentoasociado;
	}

}