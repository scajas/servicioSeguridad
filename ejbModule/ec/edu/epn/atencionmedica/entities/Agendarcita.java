package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the agendarcita database table.
 * 
 */
@Entity
@Table(name="agendarcita", catalog="`bddcorpepn`", schema="`Medico`")
@NamedQuery(name="Agendarcita.findAll", query="SELECT a FROM Agendarcita a")
public class Agendarcita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agenda")
	private Integer idAgenda;

	private Boolean activo;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="hora_final")
	private String horaFinal;

	@Column(name="hora_inicio")
	private String horaInicio;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_medico")
	private PersonalAtencion personal;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente paciente;
	
	@Column(name="hora_final_t")
	private Date horaFinalT;
	
	@Column(name="hora_inicio_t")
	private Date horaInicioT;



	public Agendarcita() {
	}

	public Integer getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public PersonalAtencion getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalAtencion personal) {
		this.personal = personal;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Date getHoraInicioT() {
		return horaInicioT;
	}

	public void setHoraInicioT(Date horaInicioT) {
		this.horaInicioT = horaInicioT;
	}

}