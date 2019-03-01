package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the publi_part database table.
 * 
 */
@Entity
@Table(name = "publi_part", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="PubliPart.findAll", query="SELECT p FROM PubliPart p")
public class PubliPart implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	
	@Id
	
	@SequenceGenerator(name = "publi_part_id_pub", sequenceName="publi_part_id_pub",allocationSize=1, catalog="bddcorpepn",schema="`Rrhh`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="publi_part_id_pub")
	
	@Column(name="id_pub")
	private Integer idPub;

	private String actividad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ini")
	private Date fechaIni;

	private String lugar;

	private String observacion;

	private String path;

	private String tipo;

	@Column(name="tipo_pr")
	private String tipoPr;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public PubliPart() {
	}

	public Integer getIdPub() {
		return this.idPub;
	}

	public void setIdPub(Integer idPub) {
		this.idPub = idPub;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoPr() {
		return this.tipoPr;
	}

	public void setTipoPr(String tipoPr) {
		this.tipoPr = tipoPr;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}