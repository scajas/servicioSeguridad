package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;

import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Emp;

import java.util.List;
import java.util.Set;

/**
 * The persistent class for the espacio database table.
 * 
 */
@Entity
@Table(name = "espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Espacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_espacio")
	private Integer idEspacio;

	@Column(name = "descripcion_espacio")
	private String descripcionEspacio;

	@Column(name = "nom_espacio")
	private String nomEspacio;

	@Column(name = "facultad_departamento")
	private String facudepart;
	
	@Column(name = "dependencia")
	private String dependencia;
	

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getFacudepart() {
		return facudepart;
	}

	public void setFacudepart(String facudepart) {
		this.facudepart = facudepart;
	}

	private String referencia;

	@OneToMany(mappedBy = "espacio")
	private List<Sesione> sesiones;

	@OneToMany(mappedBy = "espacio")
	private List<Rubro> rubros;

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}

	public List<Sesione> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesione> sesiones) {
		this.sesiones = sesiones;
	}

	// bi-directional many-to-one association to LugarEspacio
	@ManyToOne
	@JoinColumn(name = "id_lugar_espacio")
	private LugarEspacio lugarEspacio;

	// bi-directional many-to-one association to TipoEspacio
	@ManyToOne
	@JoinColumn(name = "id_tipo_espacio")
	private TipoEspacio tipoEspacio;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Dep dep;
	
	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@ManyToOne
	@JoinColumn(name = "nced")
	private Emp emp;
	


	// bi-directional many-to-one association to EventoEspacio
	@OneToMany(mappedBy = "espacio")
	private Set<EventoEspacio> eventoEspacios;

	// bi-directional many-to-one association to HorarioEspacio
	@OneToMany(mappedBy = "espacio")
	private Set<HorarioEspacio> horarioEspacios;

	public Espacio() {
	}

	public Integer getIdEspacio() {
		return this.idEspacio;
	}

	public void setIdEspacio(Integer idEspacio) {
		this.idEspacio = idEspacio;
	}

	public String getDescripcionEspacio() {
		return this.descripcionEspacio;
	}

	public void setDescripcionEspacio(String descripcionEspacio) {
		this.descripcionEspacio = descripcionEspacio;
	}

	public String getNomEspacio() {
		return this.nomEspacio;
	}

	public void setNomEspacio(String nomEspacio) {
		this.nomEspacio = nomEspacio;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public LugarEspacio getLugarEspacio() {
		return this.lugarEspacio;
	}

	public void setLugarEspacio(LugarEspacio lugarEspacio) {
		this.lugarEspacio = lugarEspacio;
	}

	public TipoEspacio getTipoEspacio() {
		return this.tipoEspacio;
	}

	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}

	public Set<EventoEspacio> getEventoEspacios() {
		return this.eventoEspacios;
	}

	public void setEventoEspacios(Set<EventoEspacio> eventoEspacios) {
		this.eventoEspacios = eventoEspacios;
	}

	public Set<HorarioEspacio> getHorarioEspacios() {
		return this.horarioEspacios;
	}

	public void setHorarioEspacios(Set<HorarioEspacio> horarioEspacios) {
		this.horarioEspacios = horarioEspacios;
	}

}