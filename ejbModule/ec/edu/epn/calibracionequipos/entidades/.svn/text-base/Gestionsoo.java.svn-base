package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the gestionsoo database table.
 * 
 */
@Entity
@Table(name = "gestionsoo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Gestionsoo.findAll", query = "SELECT g FROM Gestionsoo g")
public class Gestionsoo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proceso")
	private Integer idProceso;

	@Column(name = "acto_proceso")
	private String actoProceso;

	@Column(name = "fuentesituacion_proceso")
	private String fuentesituacionProceso;

	@Column(name = "involucradosactividad_proceso")
	private String involucradosactividadProceso;

	@Column(name = "nivelriesgo_proceso")
	private String nivelriesgoProceso;

	@Column(name = "nombre_proceso")
	private String nombreProceso;

	@Column(name = "numpersonasact_proceso")
	private Integer numpersonasactProceso;

	@Column(name = "probabilidad_proceso")
	private String probabilidadProceso;

	@Column(name = "severidad_proceso")
	private String severidadProceso;

	// bi-directional many-to-one association to Actividadesproceso
	@OneToMany(mappedBy = "gestionsoo")
	private List<Actividadesproceso> actividadesprocesos;

	// bi-directional many-to-one association to Gsooindp
	@OneToMany(mappedBy = "gestionsoo")
	private List<Gsooindp> gsooindps;

	// bi-directional many-to-one association to Puestostrabajoinvolucrado
	@OneToMany(mappedBy = "gestionsoo")
	private List<Puestostrabajoinvolucrado> puestostrabajoinvolucrados;

	@ManyToOne
	@JoinColumn(name = "id_siso")
	private Siso siso;

	public Gestionsoo() {
	}

	public Integer getIdProceso() {
		return this.idProceso;
	}

	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

	public String getActoProceso() {
		return this.actoProceso;
	}

	public void setActoProceso(String actoProceso) {
		this.actoProceso = actoProceso;
	}

	public String getFuentesituacionProceso() {
		return this.fuentesituacionProceso;
	}

	public void setFuentesituacionProceso(String fuentesituacionProceso) {
		this.fuentesituacionProceso = fuentesituacionProceso;
	}

	public String getInvolucradosactividadProceso() {
		return this.involucradosactividadProceso;
	}

	public void setInvolucradosactividadProceso(String involucradosactividadProceso) {
		this.involucradosactividadProceso = involucradosactividadProceso;
	}

	public String getNivelriesgoProceso() {
		return this.nivelriesgoProceso;
	}

	public void setNivelriesgoProceso(String nivelriesgoProceso) {
		this.nivelriesgoProceso = nivelriesgoProceso;
	}

	public String getNombreProceso() {
		return this.nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public Integer getNumpersonasactProceso() {
		return this.numpersonasactProceso;
	}

	public void setNumpersonasactProceso(Integer numpersonasactProceso) {
		this.numpersonasactProceso = numpersonasactProceso;
	}

	public String getProbabilidadProceso() {
		return this.probabilidadProceso;
	}

	public void setProbabilidadProceso(String probabilidadProceso) {
		this.probabilidadProceso = probabilidadProceso;
	}

	public String getSeveridadProceso() {
		return this.severidadProceso;
	}

	public void setSeveridadProceso(String severidadProceso) {
		this.severidadProceso = severidadProceso;
	}

	public List<Actividadesproceso> getActividadesprocesos() {
		return this.actividadesprocesos;
	}

	public void setActividadesprocesos(List<Actividadesproceso> actividadesprocesos) {
		this.actividadesprocesos = actividadesprocesos;
	}

	public Actividadesproceso addActividadesproceso(Actividadesproceso actividadesproceso) {
		getActividadesprocesos().add(actividadesproceso);
		actividadesproceso.setGestionsoo(this);

		return actividadesproceso;
	}

	public Actividadesproceso removeActividadesproceso(Actividadesproceso actividadesproceso) {
		getActividadesprocesos().remove(actividadesproceso);
		actividadesproceso.setGestionsoo(null);

		return actividadesproceso;
	}

	public List<Gsooindp> getGsooindps() {
		return this.gsooindps;
	}

	public void setGsooindps(List<Gsooindp> gsooindps) {
		this.gsooindps = gsooindps;
	}

	public Gsooindp addGsooindp(Gsooindp gsooindp) {
		getGsooindps().add(gsooindp);
		gsooindp.setGestionsoo(this);

		return gsooindp;
	}

	public Gsooindp removeGsooindp(Gsooindp gsooindp) {
		getGsooindps().remove(gsooindp);
		gsooindp.setGestionsoo(null);

		return gsooindp;
	}

	public List<Puestostrabajoinvolucrado> getPuestostrabajoinvolucrados() {
		return this.puestostrabajoinvolucrados;
	}

	public void setPuestostrabajoinvolucrados(List<Puestostrabajoinvolucrado> puestostrabajoinvolucrados) {
		this.puestostrabajoinvolucrados = puestostrabajoinvolucrados;
	}

	public Puestostrabajoinvolucrado addPuestostrabajoinvolucrado(Puestostrabajoinvolucrado puestostrabajoinvolucrado) {
		getPuestostrabajoinvolucrados().add(puestostrabajoinvolucrado);
		puestostrabajoinvolucrado.setGestionsoo(this);

		return puestostrabajoinvolucrado;
	}

	public Puestostrabajoinvolucrado removePuestostrabajoinvolucrado(
			Puestostrabajoinvolucrado puestostrabajoinvolucrado) {
		getPuestostrabajoinvolucrados().remove(puestostrabajoinvolucrado);
		puestostrabajoinvolucrado.setGestionsoo(null);

		return puestostrabajoinvolucrado;
	}

	public Siso getSiso() {
		return this.siso;
	}

	public void setSiso(Siso siso) {
		this.siso = siso;
	}

}