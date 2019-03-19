package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity(name = "ProyectoD")
@Table(name = "proyecto", catalog = "`bddcorpepn`", schema = "`Desarrollo`")

@NamedQuery(name = "ProyectoD.findAll", query = "SELECT p FROM ProyectoD p")
public class ProyectoD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date ffin;

	@Temporal(TemporalType.DATE)
	private Date finicio;

	private String nombre;

	private String solicitado;

	@Column(name = "id_area")
	private Integer idarea;

	// bi-directional many-to-one association to Requerimiento
	@OneToMany(mappedBy = "proyecto")
	private List<Requerimiento> requerimientos;

	public ProyectoD() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFfin() {
		return this.ffin;
	}

	public void setFfin(Date ffin) {
		this.ffin = ffin;
	}

	public Date getFinicio() {
		return this.finicio;
	}

	public void setFinicio(Date finicio) {
		this.finicio = finicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSolicitado() {
		return this.solicitado;
	}

	public void setSolicitado(String solicitado) {
		this.solicitado = solicitado;
	}

	public List<Requerimiento> getRequerimientos() {
		return this.requerimientos;
	}

	public void setRequerimientos(List<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}

	public Requerimiento addRequerimiento(Requerimiento requerimiento) {
		getRequerimientos().add(requerimiento);
		requerimiento.setProyectoD(this);

		return requerimiento;
	}

	public Requerimiento removeRequerimiento(Requerimiento requerimiento) {
		getRequerimientos().remove(requerimiento);
		requerimiento.setProyectoD(null);

		return requerimiento;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}
	
	

}