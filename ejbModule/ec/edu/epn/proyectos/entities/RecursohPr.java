package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Emp;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the recursoh_pr database table.
 * 
 */
@Entity

@Table(name="recursoh_pr", catalog = "bddcorpepn", schema = "`Proyectos`")
public class RecursohPr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rh_pr")
	private Integer idRhPr;

	@Column(name="apellido_personal_pr")
	private String apellidoPersonalPr;

	@Column(name="estado_pr")
	private String estadoPr;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_f_asig")
	private Date fechaFAsig;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_i_asig")
	private Date fechaIAsig;

	@Column(name="mail_pr")
	private String mailPr;
	
	
	private String nced;
	
	private String externo;
	
	private String nrotesis ;
	private String  tesis ;
	private String estado ;
	private  String facultad ;
	private  String carrera;
	private String pathcv;
	private String cargo ;
	private String dpto ;
	
	private Integer idpensum;
	private String  memodesvinucla;
	
	private String ext, celular, observaciones,genero,memovincula;



	@Column(name="nombre_personal_pr")
	private String nombrePersonalPr;

	@Column(name="nro_horas")
	private Integer nroHoras;

	@Column(name="sueldo_personal_pr")
	private double sueldoPersonalPr;

	//bi-directional many-to-one association to ActividadProyecto
	@OneToMany(mappedBy="recursohPr")
	private List<ActividadProyectoP> actividadProyectos;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="recurso",fetch = FetchType.EAGER)
	private Set<Recursoavance> recursoavance;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	//bi-directional many-to-one association to RolProyecto
    @ManyToOne
	@JoinColumn(name="id_rol_proy")
	private RolProyectoP rolProyecto;
    
    
    private String mesesp;
    
  
    public RecursohPr() {
    }

	public Integer getIdRhPr() {
		return this.idRhPr;
	}

	public void setIdRhPr(Integer idRhPr) {
		this.idRhPr = idRhPr;
	}

	public String getApellidoPersonalPr() {
		return this.apellidoPersonalPr;
	}

	public void setApellidoPersonalPr(String apellidoPersonalPr) {
		this.apellidoPersonalPr = apellidoPersonalPr;
	}

	public String getEstadoPr() {
		return this.estadoPr;
	}

	public void setEstadoPr(String estadoPr) {
		this.estadoPr = estadoPr;
	}

	public Date getFechaFAsig() {
		return this.fechaFAsig;
	}

	public void setFechaFAsig(Date fechaFAsig) {
		this.fechaFAsig = fechaFAsig;
	}

	public Date getFechaIAsig() {
		return this.fechaIAsig;
	}

	public void setFechaIAsig(Date fechaIAsig) {
		this.fechaIAsig = fechaIAsig;
	}

	public String getMailPr() {
		return this.mailPr;
	}

	public void setMailPr(String mailPr) {
		this.mailPr = mailPr;
	}

	

	public String getNombrePersonalPr() {
		return this.nombrePersonalPr;
	}

	public void setNombrePersonalPr(String nombrePersonalPr) {
		this.nombrePersonalPr = nombrePersonalPr;
	}

	public Integer getNroHoras() {
		return this.nroHoras;
	}

	public void setNroHoras(Integer nroHoras) {
		this.nroHoras = nroHoras;
	}

	public double getSueldoPersonalPr() {
		return this.sueldoPersonalPr;
	}

	public void setSueldoPersonalPr(double sueldoPersonalPr) {
		this.sueldoPersonalPr = sueldoPersonalPr;
	}

	public List<ActividadProyectoP> getActividadProyectos() {
		return this.actividadProyectos;
	}

	public void setActividadProyectos(List<ActividadProyectoP> actividadProyectos) {
		this.actividadProyectos = actividadProyectos;
	}
	
	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	public RolProyectoP getRolProyecto() {
		return this.rolProyecto;
	}

	public void setRolProyecto(RolProyectoP rolProyecto) {
		this.rolProyecto = rolProyecto;
	}

	public String getNced() {
		return nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getExterno() {
		return externo;
	}

	public void setExterno(String externo) {
		this.externo = externo;
	}

	public String getNrotesis() {
		return nrotesis;
	}

	public void setNrotesis(String nrotesis) {
		this.nrotesis = nrotesis;
	}

	public String getTesis() {
		return tesis;
	}

	public void setTesis(String tesis) {
		this.tesis = tesis;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getPathcv() {
		return pathcv;
	}

	public void setPathcv(String pathcv) {
		this.pathcv = pathcv;
	}

	public String getMesesp() {
		return mesesp;
	}

	public void setMesesp(String mesesp) {
		this.mesesp = mesesp;
	}

	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public Set<Recursoavance> getRecursoavance() {
		
		return recursoavance;
	}

	public void setRecursoavance(Set<Recursoavance> recursoavance) {
		this.recursoavance = recursoavance;
	}

	public Integer getIdpensum() {
		return idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	public String getMemodesvinucla() {
		return memodesvinucla;
	}

	public void setMemodesvinucla(String memodesvinucla) {
		this.memodesvinucla = memodesvinucla;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMemovincula() {
		return memovincula;
	}

	public void setMemovincula(String memovincula) {
		this.memovincula = memovincula;
	}
	
	
	
	

	
	
}