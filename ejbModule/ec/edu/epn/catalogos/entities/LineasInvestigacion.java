package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lineas_investigacion database table.
 * 
 */
@Entity
@Table(name="lineas_investigacion", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name="LineasInvestigacion.findAll", query="SELECT l FROM LineasInvestigacion l")
public class LineasInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_linin")
	private Integer idLinin;

	@Column(name="area_linin")
	private String areaLinin;

	@Column(name="descr_linin")
	private String descrLinin;

	@Column(name="est_linea")
	private String estLinea;

	@Column(name="nom_linin")
	private String nomLinin;
	
	private String codigo;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_depart")
	private Departamento departamento;

	public LineasInvestigacion() {
	}

	public Integer getIdLinin() {
		return this.idLinin;
	}

	public void setIdLinin(Integer idLinin) {
		this.idLinin = idLinin;
	}

	public String getAreaLinin() {
		return this.areaLinin;
	}

	public void setAreaLinin(String areaLinin) {
		this.areaLinin = areaLinin;
	}

	public String getDescrLinin() {
		return this.descrLinin;
	}

	public void setDescrLinin(String descrLinin) {
		this.descrLinin = descrLinin;
	}

	public String getEstLinea() {
		return this.estLinea;
	}

	public void setEstLinea(String estLinea) {
		this.estLinea = estLinea;
	}

	public String getNomLinin() {
		return this.nomLinin;
	}

	public void setNomLinin(String nomLinin) {
		this.nomLinin = nomLinin;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}