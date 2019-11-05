package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the accion_p database table.
 * 
 */
@Entity
@Table(name = "accion_p", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name = "AccionP.findAll", query = "SELECT a FROM AccionP a")
public class AccionP implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccionPPK id;

	private String autnom;

	@Column(name = "cargo_solic")
	private String cargoSolic;

	private String dirtalento;

	@Temporal(TemporalType.DATE)
	private Date fechadispres;

	private String numdispres;

	@Column(name = "pais_estudios")
	private String paisEstudios;

	private String respelaboracion;

	private String solicitante;

	@Column(name = "titulo_obtenerse")
	private String tituloObtenerse;

	private String universidad;

	@Column(name = "cargo_aut")
	private String cargoAut;

	@Column(name = "motivlicenextraord")
	private String motivoLicenciaExtraordinaria;

	@Column(name = "cargo_dir_talentoh")
	private String cargoDirTalentoH;
	
	@Column(name = "nro_acta_concurso")
	private String nroActaConcurso;
	
	@Column(name = "fecha_acta_concurso")
	private Date fechaActaConcurso;

	@Column(name = "resp_registro")
	private String  responsableRegistro;
	
	public String getCargoAut() {
		return cargoAut;
	}

	public void setCargoAut(String cargoAut) {
		this.cargoAut = cargoAut;
	}

	// bi-directional many-to-one association to SubtipoAccion
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_stpa")
	private SubtipoAccion subtipoAccion;

	// bi-directional many-to-one association to SubtipoAccion
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_habilitante")
	private HabilitanteAccion habilitanteAccion;

	// bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy = "accionP")
	private List<HistoriaLaboral> historiaLaborals;

	public AccionP() {
	}

	public AccionPPK getId() {
		return this.id;
	}

	public void setId(AccionPPK id) {
		this.id = id;
	}

	public String getAutnom() {
		return this.autnom;
	}

	public void setAutnom(String autnom) {
		this.autnom = autnom;
	}

	public String getCargoSolic() {
		return this.cargoSolic;
	}

	public void setCargoSolic(String cargoSolic) {
		this.cargoSolic = cargoSolic;
	}

	public String getDirtalento() {
		return this.dirtalento;
	}

	public void setDirtalento(String dirtalento) {
		this.dirtalento = dirtalento;
	}

	public Date getFechadispres() {
		return this.fechadispres;
	}

	public void setFechadispres(Date fechadispres) {
		this.fechadispres = fechadispres;
	}

	public String getNumdispres() {
		return this.numdispres;
	}

	public void setNumdispres(String numdispres) {
		this.numdispres = numdispres;
	}

	public String getPaisEstudios() {
		return this.paisEstudios;
	}

	public void setPaisEstudios(String paisEstudios) {
		this.paisEstudios = paisEstudios;
	}

	public String getRespelaboracion() {
		return this.respelaboracion;
	}

	public void setRespelaboracion(String respelaboracion) {
		this.respelaboracion = respelaboracion;
	}

	public String getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTituloObtenerse() {
		return this.tituloObtenerse;
	}

	public void setTituloObtenerse(String tituloObtenerse) {
		this.tituloObtenerse = tituloObtenerse;
	}

	public String getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public SubtipoAccion getSubtipoAccion() {
		return this.subtipoAccion;
	}

	public void setSubtipoAccion(SubtipoAccion subtipoAccion) {
		this.subtipoAccion = subtipoAccion;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public String getCargoDirTalentoH() {
		return cargoDirTalentoH;
	}


	public HabilitanteAccion getHabilitanteAccion() {
		return habilitanteAccion;
	}

	public void setHabilitanteAccion(HabilitanteAccion habilitanteAccion) {
		this.habilitanteAccion = habilitanteAccion;
	}

	public void setCargoDirTalentoH(String cargoDirTalentoH) {
		this.cargoDirTalentoH = cargoDirTalentoH;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setAccionP(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setAccionP(null);

		return historiaLaboral;
	}

	public String getMotivoLicenciaExtraordinaria() {
		return motivoLicenciaExtraordinaria;
	}

	public void setMotivoLicenciaExtraordinaria(String motivoLicenciaExtraordinaria) {
		this.motivoLicenciaExtraordinaria = motivoLicenciaExtraordinaria;
	}

	public String getNroActaConcurso() {
		return nroActaConcurso;
	}

	public void setNroActaConcurso(String nroActaConcurso) {
		this.nroActaConcurso = nroActaConcurso;
	}

	public Date getFechaActaConcurso() {
		return fechaActaConcurso;
	}

	public void setFechaActaConcurso(Date fechaActaConcurso) {
		this.fechaActaConcurso = fechaActaConcurso;
	}

	public String getResponsableRegistro() {
		return responsableRegistro;
	}

	public void setResponsableRegistro(String responsableRegistro) {
		this.responsableRegistro = responsableRegistro;
	}
	
	
	
	

}