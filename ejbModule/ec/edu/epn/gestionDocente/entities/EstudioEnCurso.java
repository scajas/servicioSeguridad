package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.epn.rrhh.entities.Emp;


/**
 * The persistent class for the estudio_en_curso database table.
 * 
 */
@Entity
//
@Table(name="estudio_en_curso" , catalog = "bddcorpepn", schema = "\"GestionDocente\"")
@NamedQuery(name="EstudioEnCurso.findAll", query="SELECT e FROM EstudioEnCurso e")
public class EstudioEnCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "estudio_en_curso_sec", sequenceName="estudio_en_curso_sec",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estudio_en_curso_sec")
	@Column(name="id_estudio")
	private Integer idEstudio;

	private Integer anio;

	private String estado;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_estudio")
	private Date fechaFinEstudio;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_estudio")
	private Date fechaInicioEstudio;
	
	
	@ManyToOne
	@JoinColumn(name="id_area_con")
	private AreaConocimiento areaConocimiento;

	/*@Column(name="id_area_con")
	private Integer idAreaCon;*/
	
	@ManyToOne
	@JoinColumn(name="id_nivel_titulo")
	private NivelTitulo nivelTitulo;

	/*@Column(name="id_nivel_titulo")
	private Integer idNivelTitulo;*/

	@Column(name="id_perfil")
	private Integer idPerfil;

	@ManyToOne
	@JoinColumn(name="id_universid")
	private Universidad universidad;
	
	/*@Column(name="id_universid")
	private Integer idUniversid;*/

	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	//private String nced;

	@Column(name="nombre_titulo_obtener")
	private String nombreTituloObtener;

	@Column(name="otra_universidad")
	private String otraUniversidad;
	
	
	private String path;

	public EstudioEnCurso() {
	}

	public Integer getIdEstudio() {
		return this.idEstudio;
	}

	public void setIdEstudio(Integer idEstudio) {
		this.idEstudio = idEstudio;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinEstudio() {
		return this.fechaFinEstudio;
	}

	public void setFechaFinEstudio(Date fechaFinEstudio) {
		this.fechaFinEstudio = fechaFinEstudio;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaInicioEstudio() {
		return this.fechaInicioEstudio;
	}

	public void setFechaInicioEstudio(Date fechaInicioEstudio) {
		this.fechaInicioEstudio = fechaInicioEstudio;
	}
	

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	public String getNombreTituloObtener() {
		return this.nombreTituloObtener;
	}

	public void setNombreTituloObtener(String nombreTituloObtener) {
		this.nombreTituloObtener = nombreTituloObtener;
	}

	public String getOtraUniversidad() {
		return this.otraUniversidad;
	}

	public void setOtraUniversidad(String otraUniversidad) {
		this.otraUniversidad = otraUniversidad;
	}

	/**
	 * @return the areaConocimiento
	 */
	public AreaConocimiento getAreaConocimiento() {
		return areaConocimiento;
	}

	/**
	 * @param areaConocimiento the areaConocimiento to set
	 */
	public void setAreaConocimiento(AreaConocimiento areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	/**
	 * @return the nivelTitulo
	 */
	public NivelTitulo getNivelTitulo() {
		return nivelTitulo;
	}

	/**
	 * @param nivelTitulo the nivelTitulo to set
	 */
	public void setNivelTitulo(NivelTitulo nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

	/**
	 * @return the universidad
	 */
	public Universidad getUniversidad() {
		return universidad;
	}

	/**
	 * @param universidad the universidad to set
	 */
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	/**
	 * @return the emp
	 */
	public Emp getEmp() {
		return emp;
	}

	/**
	 * @param emp the emp to set
	 */
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}