package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity(name = "DepartamentoCatalogo")
@Table(name = "`departamento`", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name="DepartamentoCatalogo.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_depart")
	private Integer idDepart;

	@Column(name="mail_jefe")
	private String mailJefe;

	private String nced;

	@Column(name="nom_depart")
	private String nomDepart;

	@Column(name="nom_jefe_actual")
	private String nomJefeActual;

	//bi-directional many-to-one association to Facultad
	@ManyToOne
	@JoinColumn(name="id_facultad")
	private FacultadCatalogos facultad;

	//bi-directional many-to-one association to Jefesdepartamento
	@OneToMany(mappedBy="departamento")
	private List<Jefesdepartamento> jefesdepartamentos;

	//bi-directional many-to-one association to Laboratorio
	@OneToMany(mappedBy="departamento")
	private List<Laboratorio> laboratorios;

	//bi-directional many-to-one association to LineasInvestigacion
	@OneToMany(mappedBy="departamento")
	private List<LineasInvestigacion> lineasInvestigacions;

	public Departamento() {
	}

	public Integer getIdDepart() {
		return this.idDepart;
	}

	public void setIdDepart(Integer idDepart) {
		this.idDepart = idDepart;
	}

	public String getMailJefe() {
		return this.mailJefe;
	}

	public void setMailJefe(String mailJefe) {
		this.mailJefe = mailJefe;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomDepart() {
		return this.nomDepart;
	}

	public void setNomDepart(String nomDepart) {
		this.nomDepart = nomDepart;
	}

	public String getNomJefeActual() {
		return this.nomJefeActual;
	}

	public void setNomJefeActual(String nomJefeActual) {
		this.nomJefeActual = nomJefeActual;
	}

	public FacultadCatalogos getFacultad() {
		return this.facultad;
	}

	public void setFacultad(FacultadCatalogos facultad) {
		this.facultad = facultad;
	}

	public List<Jefesdepartamento> getJefesdepartamentos() {
		return this.jefesdepartamentos;
	}

	public void setJefesdepartamentos(List<Jefesdepartamento> jefesdepartamentos) {
		this.jefesdepartamentos = jefesdepartamentos;
	}

	public Jefesdepartamento addJefesdepartamento(Jefesdepartamento jefesdepartamento) {
		getJefesdepartamentos().add(jefesdepartamento);
		jefesdepartamento.setDepartamento(this);

		return jefesdepartamento;
	}

	public Jefesdepartamento removeJefesdepartamento(Jefesdepartamento jefesdepartamento) {
		getJefesdepartamentos().remove(jefesdepartamento);
		jefesdepartamento.setDepartamento(null);

		return jefesdepartamento;
	}

	public List<Laboratorio> getLaboratorios() {
		return this.laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public List<LineasInvestigacion> getLineasInvestigacions() {
		return this.lineasInvestigacions;
	}

	public void setLineasInvestigacions(List<LineasInvestigacion> lineasInvestigacions) {
		this.lineasInvestigacions = lineasInvestigacions;
	}

	public LineasInvestigacion addLineasInvestigacion(LineasInvestigacion lineasInvestigacion) {
		getLineasInvestigacions().add(lineasInvestigacion);
		lineasInvestigacion.setDepartamento(this);

		return lineasInvestigacion;
	}

	public LineasInvestigacion removeLineasInvestigacion(LineasInvestigacion lineasInvestigacion) {
		getLineasInvestigacions().remove(lineasInvestigacion);
		lineasInvestigacion.setDepartamento(null);

		return lineasInvestigacion;
	}

}