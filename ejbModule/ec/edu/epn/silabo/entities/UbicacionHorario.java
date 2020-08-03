package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacion_horarios database table.
 * 
 */
@Entity
@Table(name="ubicacion_horarios", catalog = "`bddcorpepn`", schema = "`Silabo`" )

@NamedQuery(name="UbicacionHorario.findAll", query="SELECT u FROM UbicacionHorario u")
public class UbicacionHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_horario")
	private Integer idHorario;

	private String aula;

	private String funcion;

	private String horario;

	private String ubicacion;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public UbicacionHorario() {
	}

	public Integer getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getAula() {
		return this.aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}