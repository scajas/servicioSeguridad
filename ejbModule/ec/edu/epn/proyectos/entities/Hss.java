package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the hss database table.
 * 
 */
@Entity
@Table(name = "hss", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "Hss.findAll", query = "SELECT h FROM Hss h")
public class Hss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer maximo;

	private Integer minimo,anio;

	@ManyToOne
	@JoinColumn(name = "idrolproy")
	private RolProyectoP rol;

	@ManyToOne
	@JoinColumn(name = "id_tipo_proy")
	private TipoProyectoP tipoproyecto;

	public Hss() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaximo() {
		return this.maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getMinimo() {
		return this.minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

	public RolProyectoP getRol() {
		return rol;
	}

	public void setRol(RolProyectoP rol) {
		this.rol = rol;
	}

	public TipoProyectoP getTipoproyecto() {
		return tipoproyecto;
	}

	public void setTipoproyecto(TipoProyectoP tipoproyecto) {
		this.tipoproyecto = tipoproyecto;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	
	

}