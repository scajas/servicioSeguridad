package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.Carrera;
import ec.edu.epn.rrhh.entities.Dep;

/**
 * The persistent class for the usuario_carrera database table.
 * 
 */
@Entity
@Table(name = "usuario_carrera", catalog = "`bddcorpepn`", schema = "`Acreditacion`")
@NamedQuery(name = "UsuarioCarrera.findAll", query = "SELECT u FROM UsuarioCarrera u")
public class UsuarioCarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_uc")
	private Integer idUc;

	@Column(name = "descr_uc")
	private String descrUc;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	public UsuarioCarrera() {
	}

	public Integer getIdUc() {
		return this.idUc;
	}

	public void setIdUc(Integer idUc) {
		this.idUc = idUc;
	}

	public String getDescrUc() {
		return this.descrUc;
	}

	public void setDescrUc(String descrUc) {
		this.descrUc = descrUc;
	}

	

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	

}