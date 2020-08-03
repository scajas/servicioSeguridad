package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the estado_req database table.
 * 
 */
@Entity
@Table(name="estado_req", catalog="`bddcorpepn`", schema="`Desarrollo`")


@NamedQuery(name = "EstadoReq.findAll", query = "SELECT e FROM EstadoReq e")
public class EstadoReq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "f_fin")
	private Date fFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_asig")
	private Date fechaAsig;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private EstadoD estado;
	
	private String path;

	// bi-directional many-to-one association to ReqPersona
	@ManyToOne
	@JoinColumn(name = "id_req_perso")
	private ReqPersona reqPersona;

	public EstadoReq() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFFin() {
		return this.fFin;
	}

	public void setFFin(Date fFin) {
		this.fFin = fFin;
	}

	public Date getFechaAsig() {
		return this.fechaAsig;
	}

	public void setFechaAsig(Date fechaAsig) {
		this.fechaAsig = fechaAsig;
	}

	public ReqPersona getReqPersona() {
		return this.reqPersona;
	}

	public void setReqPersona(ReqPersona reqPersona) {
		this.reqPersona = reqPersona;
	}

	

	public EstadoD getEstado() {
		return estado;
	}

	public void setEstado(EstadoD estado) {
		this.estado = estado;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}