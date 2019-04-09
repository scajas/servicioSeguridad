package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the control_existencia_metodo database table.
 * 
 */
@Entity
@Table(name = "control_existencia_metodo", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="ControlExistenciaMetodo.findAll", query="SELECT c FROM ControlExistenciaMetodo c")
public class ControlExistenciaMetodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cem")
	private String idCem;

	@Column(name="estado_cem")
	private String estadoCem;

	@Column(name="id_detallemetodo")
	private String idDetallemetodo;

	@Column(name="id_existencia")
	private String idExistencia;

	@Column(name="id_metodo")
	private String idMetodo;

	@Column(name="id_orden")
	private String idOrden;

	@Column(name="id_usuario")
	private Integer idUsuario;

	public ControlExistenciaMetodo() {
	}

	public String getIdCem() {
		return this.idCem;
	}

	public void setIdCem(String idCem) {
		this.idCem = idCem;
	}

	public String getEstadoCem() {
		return this.estadoCem;
	}

	public void setEstadoCem(String estadoCem) {
		this.estadoCem = estadoCem;
	}

	public String getIdDetallemetodo() {
		return this.idDetallemetodo;
	}

	public void setIdDetallemetodo(String idDetallemetodo) {
		this.idDetallemetodo = idDetallemetodo;
	}

	public String getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}

	public String getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(String idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}