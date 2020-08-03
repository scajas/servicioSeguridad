package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodocumentoasociado database table.
 * 
 */
@Entity
@Table(name="tipodocumentoasociado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipodocumentoasociado.findAll", query="SELECT t FROM Tipodocumentoasociado t")
public class Tipodocumentoasociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipodocumento")
	private Integer idTipodocumento;

	@Column(name="descripcion_tipodocumento")
	private String descripcionTipodocumento;

	@Column(name="nombre_tipodocumento")
	private String nombreTipodocumento;

	//bi-directional many-to-one association to Documentacionasociada
	@OneToMany(mappedBy="tipodocumentoasociado")
	private List<Documentacionasociada> documentacionasociadas;

	public Tipodocumentoasociado() {
	}

	public Integer getIdTipodocumento() {
		return this.idTipodocumento;
	}

	public void setIdTipodocumento(Integer idTipodocumento) {
		this.idTipodocumento = idTipodocumento;
	}

	public String getDescripcionTipodocumento() {
		return this.descripcionTipodocumento;
	}

	public void setDescripcionTipodocumento(String descripcionTipodocumento) {
		this.descripcionTipodocumento = descripcionTipodocumento;
	}

	public String getNombreTipodocumento() {
		return this.nombreTipodocumento;
	}

	public void setNombreTipodocumento(String nombreTipodocumento) {
		this.nombreTipodocumento = nombreTipodocumento;
	}

	public List<Documentacionasociada> getDocumentacionasociadas() {
		return this.documentacionasociadas;
	}

	public void setDocumentacionasociadas(List<Documentacionasociada> documentacionasociadas) {
		this.documentacionasociadas = documentacionasociadas;
	}

	public Documentacionasociada addDocumentacionasociada(Documentacionasociada documentacionasociada) {
		getDocumentacionasociadas().add(documentacionasociada);
		documentacionasociada.setTipodocumentoasociado(this);

		return documentacionasociada;
	}

	public Documentacionasociada removeDocumentacionasociada(Documentacionasociada documentacionasociada) {
		getDocumentacionasociadas().remove(documentacionasociada);
		documentacionasociada.setTipodocumentoasociado(null);

		return documentacionasociada;
	}

}