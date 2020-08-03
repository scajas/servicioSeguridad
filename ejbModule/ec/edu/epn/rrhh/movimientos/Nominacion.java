package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Emp;

import java.util.Date;


/**
 * The persistent class for the nominacion database table.
 * 
 */
@Entity
@Table(name = "nominacion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Nominacion.findAll", query="SELECT n FROM Nominacion n")
public class Nominacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nominacion")
	private Integer idNominacion;

	@Column(name="xpath")
	private String xpath;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to Emp_nominacion
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Emp emp;

	//bi-directional many-to-one association to NominacionCatalogo
	@ManyToOne
	@JoinColumn(name="id")
	private NominacionCatalogo nominacionCatalogo;

	public Nominacion() {
	}

	public Integer getIdNominacion() {
		return this.idNominacion;
	}

	public void setIdNominacion(Integer idNominacion) {
		this.idNominacion = idNominacion;
	}

	public String getXpath() {
		return this.xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public NominacionCatalogo getNominacionCatalogo() {
		return this.nominacionCatalogo;
	}

	public void setNominacionCatalogo(NominacionCatalogo nominacionCatalogo) {
		this.nominacionCatalogo = nominacionCatalogo;
	}

}