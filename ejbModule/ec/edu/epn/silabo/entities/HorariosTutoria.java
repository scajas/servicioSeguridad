package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horarios_tutorias database table.
 * 
 */
@Entity
@Table(name="horarios_tutorias", catalog = "`bddcorpepn`", schema = "`Silabo`" )

@NamedQuery(name="HorariosTutoria.findAll", query="SELECT h FROM HorariosTutoria h")
public class HorariosTutoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_horario")
	private Integer idHorario;

	private String contacto;

	private String horario;

	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	private String mecanismo;

	public HorariosTutoria() {
	}

	public Integer getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	

	public Silabo getSilabo() {
		return silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

	public String getMecanismo() {
		return this.mecanismo;
	}

	public void setMecanismo(String mecanismo) {
		this.mecanismo = mecanismo;
	}

}