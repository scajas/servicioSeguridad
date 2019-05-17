package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the horariomedico database table.
 * 
 */
@Entity
@Table(name="horariomedico", catalog="`bddcorpepn`", schema="`Medico`")
@NamedQuery(name="Horariomedico.findAll", query="SELECT h FROM HorarioMedico h")
public class HorarioMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="hora_desde_jueves_manana")
	private Date horaDesdeJuevesManana;

	@Column(name="hora_desde_jueves_tarde")
	private Date horaDesdeJuevesTarde;

	@Column(name="hora_desde_lunes_manana")
	private Date horaDesdeLunesManana;

	@Column(name="hora_desde_lunes_tarde")
	private Date horaDesdeLunesTarde;

	@Column(name="hora_desde_martes_manana")
	private Date horaDesdeMartesManana;

	@Column(name="hora_desde_martes_tarde")
	private Date horaDesdeMartesTarde;

	@Column(name="hora_desde_miercoles_manana")
	private Date horaDesdeMiercolesManana;

	@Column(name="hora_desde_miercoles_tarde")
	private Date horaDesdeMiercolesTarde;

	@Column(name="hora_desde_viernes_manana")
	private Date horaDesdeViernesManana;

	@Column(name="hora_desde_viernes_tarde")
	private Date horaDesdeViernesTarde;

	@Column(name="hora_hasta_jueves_manana")
	private Date horaHastaJuevesManana;

	@Column(name="hora_hasta_jueves_tarde")
	private Date horaHastaJuevesTarde;

	@Column(name="hora_hasta_lunes_manana")
	private Date horaHastaLunesManana;

	@Column(name="hora_hasta_lunes_tarde")
	private Date horaHastaLunesTarde;

	@Column(name="hora_hasta_martes_manana")
	private Date horaHastaMartesManana;

	@Column(name="hora_hasta_martes_tarde")
	private Date horaHastaMartesTarde;

	@Column(name="hora_hasta_miercoles_manana")
	private Date horaHastaMiercolesManana;

	@Column(name="hora_hasta_miercoles_tarde")
	private Date horaHastaMiercolesTarde;

	@Column(name="hora_hasta_viernes_manana")
	private Date horaHastaViernesManana;

	@Column(name="hora_hasta_viernes_tarde")
	private Date horaHastaViernesTarde;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_medico")
	private PersonalAtencion personal;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desde")
	private Date fechaDesde;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hasta")
	private Date fechaHasta;
	
	private Integer intervalo;

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public HorarioMedico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHoraDesdeJuevesManana() {
		return this.horaDesdeJuevesManana;
	}

	public void setHoraDesdeJuevesManana(Date horaDesdeJuevesManana) {
		this.horaDesdeJuevesManana = horaDesdeJuevesManana;
	}

	public Date getHoraDesdeJuevesTarde() {
		return this.horaDesdeJuevesTarde;
	}

	public void setHoraDesdeJuevesTarde(Date horaDesdeJuevesTarde) {
		this.horaDesdeJuevesTarde = horaDesdeJuevesTarde;
	}

	public Date getHoraDesdeLunesManana() {
		return this.horaDesdeLunesManana;
	}

	public void setHoraDesdeLunesManana(Date horaDesdeLunesManana) {
		this.horaDesdeLunesManana = horaDesdeLunesManana;
	}

	public Date getHoraDesdeLunesTarde() {
		return this.horaDesdeLunesTarde;
	}

	public void setHoraDesdeLunesTarde(Date horaDesdeLunesTarde) {
		this.horaDesdeLunesTarde = horaDesdeLunesTarde;
	}

	public Date getHoraDesdeMartesManana() {
		return this.horaDesdeMartesManana;
	}

	public void setHoraDesdeMartesManana(Date horaDesdeMartesManana) {
		this.horaDesdeMartesManana = horaDesdeMartesManana;
	}

	public Date getHoraDesdeMartesTarde() {
		return this.horaDesdeMartesTarde;
	}

	public void setHoraDesdeMartesTarde(Date horaDesdeMartesTarde) {
		this.horaDesdeMartesTarde = horaDesdeMartesTarde;
	}

	public Date getHoraDesdeMiercolesManana() {
		return this.horaDesdeMiercolesManana;
	}

	public void setHoraDesdeMiercolesManana(Date horaDesdeMiercolesManana) {
		this.horaDesdeMiercolesManana = horaDesdeMiercolesManana;
	}

	public Date getHoraDesdeMiercolesTarde() {
		return this.horaDesdeMiercolesTarde;
	}

	public void setHoraDesdeMiercolesTarde(Date horaDesdeMiercolesTarde) {
		this.horaDesdeMiercolesTarde = horaDesdeMiercolesTarde;
	}

	public Date getHoraDesdeViernesManana() {
		return this.horaDesdeViernesManana;
	}

	public void setHoraDesdeViernesManana(Date horaDesdeViernesManana) {
		this.horaDesdeViernesManana = horaDesdeViernesManana;
	}

	public Date getHoraDesdeViernesTarde() {
		return this.horaDesdeViernesTarde;
	}

	public void setHoraDesdeViernesTarde(Date horaDesdeViernesTarde) {
		this.horaDesdeViernesTarde = horaDesdeViernesTarde;
	}

	public Date getHoraHastaJuevesManana() {
		return this.horaHastaJuevesManana;
	}

	public void setHoraHastaJuevesManana(Date horaHastaJuevesManana) {
		this.horaHastaJuevesManana = horaHastaJuevesManana;
	}

	public Date getHoraHastaJuevesTarde() {
		return this.horaHastaJuevesTarde;
	}

	public void setHoraHastaJuevesTarde(Date horaHastaJuevesTarde) {
		this.horaHastaJuevesTarde = horaHastaJuevesTarde;
	}

	public Date getHoraHastaLunesManana() {
		return this.horaHastaLunesManana;
	}

	public void setHoraHastaLunesManana(Date horaHastaLunesManana) {
		this.horaHastaLunesManana = horaHastaLunesManana;
	}

	public Date getHoraHastaLunesTarde() {
		return this.horaHastaLunesTarde;
	}

	public void setHoraHastaLunesTarde(Date horaHastaLunesTarde) {
		this.horaHastaLunesTarde = horaHastaLunesTarde;
	}

	public Date getHoraHastaMartesManana() {
		return this.horaHastaMartesManana;
	}

	public void setHoraHastaMartesManana(Date horaHastaMartesManana) {
		this.horaHastaMartesManana = horaHastaMartesManana;
	}

	public Date getHoraHastaMartesTarde() {
		return this.horaHastaMartesTarde;
	}

	public void setHoraHastaMartesTarde(Date horaHastaMartesTarde) {
		this.horaHastaMartesTarde = horaHastaMartesTarde;
	}

	public Date getHoraHastaMiercolesManana() {
		return this.horaHastaMiercolesManana;
	}

	public void setHoraHastaMiercolesManana(Date horaHastaMiercolesManana) {
		this.horaHastaMiercolesManana = horaHastaMiercolesManana;
	}

	public Date getHoraHastaMiercolesTarde() {
		return this.horaHastaMiercolesTarde;
	}

	public void setHoraHastaMiercolesTarde(Date horaHastaMiercolesTarde) {
		this.horaHastaMiercolesTarde = horaHastaMiercolesTarde;
	}

	public Date getHoraHastaViernesManana() {
		return this.horaHastaViernesManana;
	}

	public void setHoraHastaViernesManana(Date horaHastaViernesManana) {
		this.horaHastaViernesManana = horaHastaViernesManana;
	}

	public Date getHoraHastaViernesTarde() {
		return this.horaHastaViernesTarde;
	}

	public void setHoraHastaViernesTarde(Date horaHastaViernesTarde) {
		this.horaHastaViernesTarde = horaHastaViernesTarde;
	}

	public PersonalAtencion getPersonal() {
		return this.personal;
	}

	public void setPersonal(PersonalAtencion personal) {
		this.personal = personal;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}

}