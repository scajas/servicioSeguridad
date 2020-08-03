package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the restringerecurso database table.
 * 
 */
@Entity

@Table(name="restringerecurso", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Restringerecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cantidad;

	private Integer idrol;

	private Integer idtipoproy;

    public Restringerecurso() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public Integer getIdtipoproy() {
		return this.idtipoproy;
	}

	public void setIdtipoproy(Integer idtipoproy) {
		this.idtipoproy = idtipoproy;
	}

}