package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the req_persona database table.
 * 
 */
@Entity
@Table(name="req_persona", catalog="`bddcorpepn`", schema="`Desarrollo`")


@NamedQuery(name="ReqPersona.findAll", query="SELECT r FROM ReqPersona r")
public class ReqPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	
	
	
	@ManyToOne
	@JoinColumn(name="id_perso")
	private PersonalArea personal;
	
	
	@ManyToOne
	@JoinColumn(name="id_req")
	private Requerimiento requerimiento;
	
	
	

	//bi-directional many-to-one association to EstadoReq
	@OneToMany(mappedBy="reqPersona")
	private List<EstadoReq> estadoReqs;

	public ReqPersona() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public List<EstadoReq> getEstadoReqs() {
		return this.estadoReqs;
	}

	public void setEstadoReqs(List<EstadoReq> estadoReqs) {
		this.estadoReqs = estadoReqs;
	}

	public EstadoReq addEstadoReq(EstadoReq estadoReq) {
		getEstadoReqs().add(estadoReq);
		estadoReq.setReqPersona(this);

		return estadoReq;
	}

	public EstadoReq removeEstadoReq(EstadoReq estadoReq) {
		getEstadoReqs().remove(estadoReq);
		estadoReq.setReqPersona(null);

		return estadoReq;
	}

	public PersonalArea getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalArea personal) {
		this.personal = personal;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}
	

}