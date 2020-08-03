package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
@Table(name = "dependencia", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_dep")
	private String codDep;

	@Column(name = "desc_dep")
	private String descDep;

	private String estado;

	@Column(name = "nom_dep")
	private String nomDep;

	@Column(name = "tipo")
	private String tipo;
	
	@Column(name="ext_dep")
	private String extDep;

	private String mailjefe;
private String sigla;
	
	@Column(name="id_facultad")
	private Integer idFacultad;

	

	// bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dep_padre")
	private Dependencia dependencia;

	// bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy = "dependencia")
	private List<Dependencia> dependencias;

	// bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy = "dependencia")
	private List<HistoriaLaboral> historiaLaborals;

	// bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy = "dependencia")
	private List<Designacion> designaciones;

	public Dependencia() {
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getDescDep() {
		return this.descDep;
	}

	public void setDescDep(String descDep) {
		this.descDep = descDep;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomDep() {
		return this.nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public List<Dependencia> getDependencias() {
		return this.dependencias;
	}

	public void setDependencias(List<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public Dependencia addDependencia(Dependencia dependencia) {
		getDependencias().add(dependencia);
		dependencia.setDependencia(this);

		return dependencia;
	}

	public Dependencia removeDependencia(Dependencia dependencia) {
		getDependencias().remove(dependencia);
		dependencia.setDependencia(null);

		return dependencia;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setDependencia(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setDependencia(null);

		return historiaLaboral;
	}

	public List<Designacion> getDesignaciones() {
		return designaciones;
	}

	public void setDesignaciones(List<Designacion> designaciones) {
		this.designaciones = designaciones;
	}


	public String getExtDep() {
		return extDep;
	}

	public void setExtDep(String extDep) {
		this.extDep = extDep;
	}

	public String getMailjefe() {
		return mailjefe;
	}

	public void setMailjefe(String mailjefe) {
		this.mailjefe = mailjefe;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Integer idFacultad) {
		this.idFacultad = idFacultad;
	}
	

}