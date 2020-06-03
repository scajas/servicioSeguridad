package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@Table(name = "horario", catalog = "bddcorpepn", schema = "\"Emergencia\"")
public class HorarioEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_horario")
	private Integer idHorario;

	private String estado;

	@Column(name="hora_entrada")
	private Time horaEntrada;

	@Column(name="hora_salida")
	private Time horaSalida;

	@Column(name="nombre_horario")
	private String nombreHorario;

	//bi-directional many-to-one association to Autorizacion
	@OneToMany(mappedBy="horario", fetch=FetchType.EAGER)
	private List<AutorizacionEmergencia> autorizacions;

	public HorarioEmergencia() {
	}

	public Integer getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNombreHorario() {
		return this.nombreHorario;
	}

	public void setNombreHorario(String nombreHorario) {
		this.nombreHorario = nombreHorario;
	}

	public List<AutorizacionEmergencia> getAutorizacions() {
		return this.autorizacions;
	}

	public void setAutorizacions(List<AutorizacionEmergencia> autorizacions) {
		this.autorizacions = autorizacions;
	}

	public AutorizacionEmergencia addAutorizacion(AutorizacionEmergencia autorizacion) {
		getAutorizacions().add(autorizacion);
		autorizacion.setHorario(this);

		return autorizacion;
	}

	public AutorizacionEmergencia removeAutorizacion(AutorizacionEmergencia autorizacion) {
		getAutorizacions().remove(autorizacion);
		autorizacion.setHorario(null);

		return autorizacion;
	}

}