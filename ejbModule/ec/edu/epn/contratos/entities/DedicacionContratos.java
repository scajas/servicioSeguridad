package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the dedicacion database table.
 * 
 */
@Entity
@Table(name = "dedicacion", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class DedicacionContratos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_dedicacion")
	private Integer idDedicacion;

	private String activo;

	private String dedicacion;

	private int numero_horas;

	@OneToMany(mappedBy = "dedicacion")
	private List<RelacionDedicacion> relaciondedicacion;
	
	@OneToMany(mappedBy = "dedicacion")
	private List<GestionDocumentacionSolicitada> gestionDoc;

	public List<GestionDocumentacionSolicitada> getGestionDoc() {
		return gestionDoc;
	}

	public void setGestionDoc(List<GestionDocumentacionSolicitada> gestionDoc) {
		this.gestionDoc = gestionDoc;
	}

	public List<RelacionDedicacion> getRelaciondedicacion() {
		return relaciondedicacion;
	}

	public void setRelaciondedicacion(
			List<RelacionDedicacion> relaciondedicacion) {
		this.relaciondedicacion = relaciondedicacion;
	}

	public DedicacionContratos() {
	}

	public Integer getIdDedicacion() {
		return this.idDedicacion;
	}

	public void setIdDedicacion(Integer idDedicacion) {
		this.idDedicacion = idDedicacion;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public int getNumero_horas() {
		return numero_horas;
	}

	public void setNumero_horas(int numero_horas) {
		this.numero_horas = numero_horas;
	}

}