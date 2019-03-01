package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name="asistencia" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asistencia")
	private Integer idAsistencia;

	private String estado;

	@Column(name="hora_in")
	private Time horaIn;

	//bi-directional many-to-one association to MiembroVoto
    @ManyToOne
	@JoinColumn(name="id_miembro")
	private MiembroVoto miembro;

	//bi-directional many-to-one association to Sesion
    @ManyToOne
	@JoinColumn(name="id_sesion")
	private Sesion sesion;

    public Asistencia() {
    }

	public Integer getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Time getHoraIn() {
		return this.horaIn;
	}

	public void setHoraIn(Time horaIn) {
		this.horaIn = horaIn;
	}

	public MiembroVoto getMiembro() {
		return this.miembro;
	}

	public void setMiembro(MiembroVoto miembro) {
		this.miembro = miembro;
	}
	
	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	
}