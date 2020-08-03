package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipo_proyecto database table.
 * 
 */
@Entity

@Table(name = "tipo_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class TipoProyectoP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_proy")
	private Integer idTipoProy;

	@Column(name = "tipo_proy")
	private String tipoProy;

	private Double montoproy;

	private String descripcion;

	private Integer colaboradores;

	private Integer duracion;
	private Integer orden;

	// bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy = "tipoProyecto")
	private List<ProyectoP> proyectos;

	public TipoProyectoP() {
	}

	public Integer getIdTipoProy() {
		return this.idTipoProy;
	}

	public void setIdTipoProy(Integer idTipoProy) {
		this.idTipoProy = idTipoProy;
	}

	public String getTipoProy() {
		return this.tipoProy;
	}

	public void setTipoProy(String tipoProy) {
		this.tipoProy = tipoProy;
	}

	public List<ProyectoP> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<ProyectoP> proyectos) {
		this.proyectos = proyectos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMontoproy() {
		return montoproy;
	}

	public void setMontoproy(Double montoproy) {
		this.montoproy = montoproy;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(Integer colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}