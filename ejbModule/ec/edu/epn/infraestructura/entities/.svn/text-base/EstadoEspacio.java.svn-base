package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the estado_espacio database table.
 * 
 */
@Entity

@Table(name = "estado_espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class EstadoEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_espacio")
	private Integer idEstadoEspacio;

	@Column(name="descripcion_estadoesp")
	private String descripcionEstadoesp;

	@Column(name="estado_espacio")
	private String estadoEspacio;

	//bi-directional many-to-one association to HorarioEspacio
	@OneToMany(mappedBy="estadoEspacio")
	private Set<HorarioEspacio> horarioEspacios;

    public EstadoEspacio() {
    }

	public Integer getIdEstadoEspacio() {
		return this.idEstadoEspacio;
	}

	public void setIdEstadoEspacio(Integer idEstadoEspacio) {
		this.idEstadoEspacio = idEstadoEspacio;
	}

	public String getDescripcionEstadoesp() {
		return this.descripcionEstadoesp;
	}

	public void setDescripcionEstadoesp(String descripcionEstadoesp) {
		this.descripcionEstadoesp = descripcionEstadoesp;
	}

	public String getEstadoEspacio() {
		return this.estadoEspacio;
	}

	public void setEstadoEspacio(String estadoEspacio) {
		this.estadoEspacio = estadoEspacio;
	}

	public Set<HorarioEspacio> getHorarioEspacios() {
		return this.horarioEspacios;
	}

	public void setHorarioEspacios(Set<HorarioEspacio> horarioEspacios) {
		this.horarioEspacios = horarioEspacios;
	}
	
}