package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sesion database table.
 * 
 */
@Entity
@Table(name="sesion" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sesion")
	private Integer idSesion;

	private String estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_sesion")
	private Date fechaSesion;

	@Column(name="hora_fin")
	private Time horaFin;

	@Column(name="hora_inicio")
	private Time horaInicio;

	@Column(name="nced_preside")
	private String ncedPreside;

	//bi-directional many-to-one association to Acta
	@OneToMany(mappedBy="sesion")
	private List<Acta> actas;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="sesion")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to ConvocatoriaVoto
    @ManyToOne
	@JoinColumn(name="id_con")
	private ConvocatoriaVoto convocatoria;

    public Sesion() {
    }

	public Integer getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(Integer idSesion) {
		this.idSesion = idSesion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaSesion() {
		return this.fechaSesion;
	}

	public void setFechaSesion(Date fechaSesion) {
		this.fechaSesion = fechaSesion;
	}

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getNcedPreside() {
		return this.ncedPreside;
	}

	public void setNcedPreside(String ncedPreside) {
		this.ncedPreside = ncedPreside;
	}

	public List<Acta> getActas() {
		return this.actas;
	}

	public void setActas(List<Acta> actas) {
		this.actas = actas;
	}
	
	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
	public ConvocatoriaVoto getConvocatoria() {
		return this.convocatoria;
	}

	public void setConvocatoria(ConvocatoriaVoto convocatoria) {
		this.convocatoria = convocatoria;
	}
	
}