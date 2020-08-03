package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_proyecto database table.
 * 
 */
@Entity

@Table(name="estado_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class EstadoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private Integer idEstado;

	@Column(name="estado_proy")
	private String estadoProy;
	
	@Column(name="descripcion")
	private String descripcion;
	

	//bi-directional many-to-one association to HistoriaEstado
	@OneToMany(mappedBy="estadoProyecto")
	private List<HistoriaEstadoP> historiaEstados;

    public EstadoProyecto() {
    }

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstadoProy() {
		return this.estadoProy;
	}

	public void setEstadoProy(String estadoProy) {
		this.estadoProy = estadoProy;
	}

	public List<HistoriaEstadoP> getHistoriaEstados() {
		return this.historiaEstados;
	}

	public void setHistoriaEstados(List<HistoriaEstadoP> historiaEstados) {
		this.historiaEstados = historiaEstados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}