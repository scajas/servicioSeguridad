package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the relacion_actual database table.
 * 
 */
@Entity
@Table(name = "relacion_actual", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class RelacionActual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_relacion")
	private Integer idRelacion;

	private String activo;

	@Column(name = "relacion_dependencia")
	private String relacionDependencia;

	@OneToMany(mappedBy = "relacionActual")
	private List<RelacionDedicacion> relaciondedicacion;

	@OneToMany(mappedBy = "relacionActual")
	private List<GestionDocumentacionSolicitada> gestionDoc;

	public List<GestionDocumentacionSolicitada> getGestionDoc() {
		return gestionDoc;
	}

	public void setGestionDoc(List<GestionDocumentacionSolicitada> gestionDoc) {
		this.gestionDoc = gestionDoc;
	}

	@ManyToOne
	@JoinColumn(name = "id_tipocontrato")
	private TipoContrato tipoContrato;

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public RelacionActual() {
	}

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public List<RelacionDedicacion> getRelaciondedicacion() {
		return relaciondedicacion;
	}

	public void setRelaciondedicacion(
			List<RelacionDedicacion> relaciondedicacion) {
		this.relaciondedicacion = relaciondedicacion;
	}

	public String getRelacionDependencia() {
		return this.relacionDependencia;
	}

	public void setRelacionDependencia(String relacionDependencia) {
		this.relacionDependencia = relacionDependencia;
	}

}