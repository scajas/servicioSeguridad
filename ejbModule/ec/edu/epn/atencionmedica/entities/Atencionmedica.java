package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



/**
 * The persistent class for the atencionmedica database table.
 * 
 */
@Entity
@Table(name="atencionmedica", catalog="`bddcorpepn`", schema="`Medico`")
public class Atencionmedica implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4046022673552226271L;

	@Id	
	@Column(name="id_atencionmed" , unique=true, nullable=false)
	@SequenceGenerator (name="\"Medico\".atencionmedica_id_atencionmed_seq", sequenceName="\"Medico\".atencionmedica_id_atencionmed_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".atencionmedica_id_atencionmed_seq")
	private Integer idAtencionmed;

	@Column(name="diagnosticodescriptivo_atm", length=3000)
	private String diagnosticodescriptivoAtm;

	@Column(name="examenesmedicos_atm", length=3000)
	private String examenesmedicosAtm;

	@Column(name="examenfisico_atm", length=3000)
	private String examenfisicoAtm;

	@Column(name="fechahora_atm", nullable=false)
	private Timestamp fechahoraAtm;	

	@Column(name="motivo_atm", length=3000)
	private String motivoAtm;

	@Column(name="signosvitales_atm", length=3000)
	private String signosvitalesAtm;

	@Column(name="tratamiento_atm", length=3000)
	private String tratamientoAtm;
	
	@Column(name="reposo_atm")
	private Integer reposoAtm;
	
	@Column(name="pedidosexamenesmedicos_atm", length=100)
	private String pedidosexamenesmedicosAtm;
	
	@Column(name="fechahorainicio_atm")
	private Timestamp fechahorainicioAtm;	
	
	@Column(name="pesohabnut_atm")
	private Double pesohabnutAtm;
	
	@Column(name="pesoactnut_atm")
	private Double pesoactnutAtm;
	
	@Column(name="pesoidealnut_atm")
	private Double pesoidealnutAtm;
	
	@Column(name="tallanut_atm")
	private Double tallanutAtm;

	@Column(name="imcnut_atm")
	private Double imcnutAtm;
	
	@Column(name="ptnut_atm")
	private Double ptnutAtm;
	
	@Column(name="pbnut_atm")
	private Double pbnutAtm;
	
	@Column(name="psubescnut_atm")
	private Double psubescnutAtm;
	
	@Column(name="psplnut_atm")
	private Double psplnutAtm;	
	
	@Column(name="cbnut_atm")
	private Double cbnutAtm;
	
	@Column(name="ccintnut_atm")
	private Double ccintnutAtm;

	@Column(name="ccadnut_atm")
	private Double ccadnutAtm;
	
	@Column(name="talla_atm")
	private Double tallaAtm;
	
	@Column(name="temperatura_atm")
	private Double temperaturaAtm;
	
	@Column(name="pulso_atm")
	private Double pulsoAtm;
	
	@Column(name="tensionsis_atm")
	private Double tensionsisAtm;
	
	@Column(name="tensiondias_atm")
	private Double tensiondiasAtm;
	
	@Column(name="respiracion_atm")
	private Double respiracionAtm;
	
	@Column(name="peso_atm")
	private Double pesoAtm;
	
	@Column(name="recetaprocedimiento_atm", length=3000)
	private String recetaprocedimientoAtm;
	
	@Column(name="observacionprocedimiento_atm", length=3000)
	private String observacionProcedimientoAtm;
		
	@Column(name="esprocedenfermeria_atm")
	private Boolean esprocedenfermeriaAtm;
	
	@Column(name="examenesimagendesc_atm", length=3000)
	private String examenesimagendescAtm;
	
	@Column(name="cariados_odont")
	private Integer cariadosOdont;
	
	@Column(name="perdidos_odont")
	private Integer perdidosOdont;
	
	@Column(name="obturados_odont")
	private Integer obturadosOdont;
	
	@Column(name="incluidos_odont")
	private Integer incluidosOdont;
	
	@Column(name="pat_gingival_odont")
	private String patGingivalOdont;
	
	@Column(name="pat_lingual_odont")
	private String patLingualOdont;
	
	@Column(name="pat_carrillos_odont")
	private String patCarrillosOdont;
	
	@Column(name="pat_labial_odont")
	private String patLabialOdont;
	
	@Column(name="maloclusion_odont")
	private String maloclusionOdont;
	
	@Column(name="obligatoriedad_est_nivelacion_atm")
	private String obligatoriedadEstNivelacionAtm;	
	
	@Column(name="enfermedad_actual")
	private String enfermedadActual;
	
	@Column(name="reposo_atm_dias")
	private Integer reposoAtmDias;	
	
	@Column(name="laboratorio_resultado")
	private String laboratorioResultado;	
	
	@Column(name="otros_diagnostico")
	private String otrosDiagnostico;
	
	@Column(name="atencion_tipo")
	private Integer atencionTipo;
	
	

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="id_tipoatencionmedica", nullable=false)
	private Catalogo catalogo;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal", nullable=false)
	private PersonalAtencion personal;
	
	//bi-directional many-to-one association to Topografiacie
    @ManyToOne
	@JoinColumn(name="id_topografia")
	private Topografiacie topografiacie;
      
        
	@Column(name="id_diagdefin")
	private Integer idDiagDefinitivo;
	
	@Column(name="id_diagdefin_2")
	private Integer idDiagDefinitivo2;
	
	@Column(name="id_diagdefin_3")
	private Integer idDiagDefinitivo3;	
	
	
	@Column(name="id_topografia_2")
	private Integer idTopografia2;
	
	@Column(name="id_topografia_3")
	private Integer idTopografia3;
	
	
	

	
	public PersonalAtencion getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalAtencion personal) {
		this.personal = personal;
	}

	//bi-directional many-to-one association to Movimientoinventario
	/*@OneToMany(mappedBy="atencionmedica")
	private List<Movimientoinventario> movimientoinventarios;*/

	public Atencionmedica() {
	}

	public Integer getIdAtencionmed() {
		return this.idAtencionmed;
	}

	public void setIdAtencionmed(Integer idAtencionmed) {
		this.idAtencionmed = idAtencionmed;
	}

	public String getDiagnosticodescriptivoAtm() {
		return this.diagnosticodescriptivoAtm;
	}

	public void setDiagnosticodescriptivoAtm(String diagnosticodescriptivoAtm) {
		this.diagnosticodescriptivoAtm = diagnosticodescriptivoAtm;
	}

	public String getExamenesmedicosAtm() {
		return this.examenesmedicosAtm;
	}

	public void setExamenesmedicosAtm(String examenesmedicosAtm) {
		this.examenesmedicosAtm = examenesmedicosAtm;
	}

	public String getExamenfisicoAtm() {
		return this.examenfisicoAtm;
	}

	public void setExamenfisicoAtm(String examenfisicoAtm) {
		this.examenfisicoAtm = examenfisicoAtm;
	}

	public Timestamp getFechahoraAtm() {
		return this.fechahoraAtm;
	}

	public void setFechahoraAtm(Timestamp fechahoraAtm) {
		this.fechahoraAtm = fechahoraAtm;
	}
	

	public String getMotivoAtm() {
		return this.motivoAtm;
	}

	public void setMotivoAtm(String motivoAtm) {
		this.motivoAtm = motivoAtm;
	}

	public String getSignosvitalesAtm() {
		return this.signosvitalesAtm;
	}

	public void setSignosvitalesAtm(String signosvitalesAtm) {
		this.signosvitalesAtm = signosvitalesAtm;
	}

	public String getTratamientoAtm() {
		return this.tratamientoAtm;
	}

	public void setTratamientoAtm(String tratamientoAtm) {
		this.tratamientoAtm = tratamientoAtm;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	/*public List<Movimientoinventario> getMovimientoinventarios() {
		return this.movimientoinventarios;
	}

	public void setMovimientoinventarios(List<Movimientoinventario> movimientoinventarios) {
		this.movimientoinventarios = movimientoinventarios;
	}*/

	public Topografiacie getTopografiacie() {
		return topografiacie;
	}

	public void setTopografiacie(Topografiacie topografiacie) {
		this.topografiacie = topografiacie;
	}

	public Integer getReposoAtm() {
		return reposoAtm;
	}

	public void setReposoAtm(Integer reposoAtm) {
		this.reposoAtm = reposoAtm;
	}
	
	public String getPedidosexamenesmedicosAtm() {
		return pedidosexamenesmedicosAtm;
	}

	public void setPedidosexamenesmedicosAtm(String pedidosexamenesmedicosAtm) {
		this.pedidosexamenesmedicosAtm = pedidosexamenesmedicosAtm;
	}

	public Timestamp getFechahorainicioAtm() {
		return fechahorainicioAtm;
	}

	public void setFechahorainicioAtm(Timestamp fechahorainicioAtm) {
		this.fechahorainicioAtm = fechahorainicioAtm;
	}

	public Integer getIdDiagDefinitivo() {
		return idDiagDefinitivo;
	}

	public void setIdDiagDefinitivo(Integer idDiagDefinitivo) {
		this.idDiagDefinitivo = idDiagDefinitivo;
	}

	public Double getPesohabnutAtm() {
		return pesohabnutAtm;
	}

	public void setPesohabnutAtm(Double pesohabnutAtm) {
		this.pesohabnutAtm = pesohabnutAtm;
	}

	public Double getPesoactnutAtm() {
		return pesoactnutAtm;
	}

	public void setPesoactnutAtm(Double pesoactnutAtm) {
		this.pesoactnutAtm = pesoactnutAtm;
	}

	public Double getPesoidealnutAtm() {
		return pesoidealnutAtm;
	}

	public void setPesoidealnutAtm(Double pesoidealnutAtm) {
		this.pesoidealnutAtm = pesoidealnutAtm;
	}

	public Double getTallanutAtm() {
		return tallanutAtm;
	}

	public void setTallanutAtm(Double tallanutAtm) {
		this.tallanutAtm = tallanutAtm;
	}

	public Double getImcnutAtm() {
		return imcnutAtm;
	}

	public void setImcnutAtm(Double imcnutAtm) {
		this.imcnutAtm = imcnutAtm;
	}

	public Double getPtnutAtm() {
		return ptnutAtm;
	}

	public void setPtnutAtm(Double ptnutAtm) {
		this.ptnutAtm = ptnutAtm;
	}

	public Double getPbnutAtm() {
		return pbnutAtm;
	}

	public void setPbnutAtm(Double pbnutAtm) {
		this.pbnutAtm = pbnutAtm;
	}

	public Double getPsubescnutAtm() {
		return psubescnutAtm;
	}

	public void setPsubescnutAtm(Double psubescnutAtm) {
		this.psubescnutAtm = psubescnutAtm;
	}

	public Double getPsplnutAtm() {
		return psplnutAtm;
	}

	public void setPsplnutAtm(Double psplnutAtm) {
		this.psplnutAtm = psplnutAtm;
	}

	public Double getCbnutAtm() {
		return cbnutAtm;
	}

	public void setCbnutAtm(Double cbnutAtm) {
		this.cbnutAtm = cbnutAtm;
	}

	public Double getCcintnutAtm() {
		return ccintnutAtm;
	}

	public void setCcintnutAtm(Double ccintnutAtm) {
		this.ccintnutAtm = ccintnutAtm;
	}

	public Double getCcadnutAtm() {
		return ccadnutAtm;
	}

	public void setCcadnutAtm(Double ccadnutAtm) {
		this.ccadnutAtm = ccadnutAtm;
	}

	public Double getTallaAtm() {
		return tallaAtm;
	}

	public void setTallaAtm(Double tallaAtm) {
		this.tallaAtm = tallaAtm;
	}

	public Double getTemperaturaAtm() {
		return temperaturaAtm;
	}

	public void setTemperaturaAtm(Double temperaturaAtm) {
		this.temperaturaAtm = temperaturaAtm;
	}

	public Double getPulsoAtm() {
		return pulsoAtm;
	}

	public void setPulsoAtm(Double pulsoAtm) {
		this.pulsoAtm = pulsoAtm;
	}

	public Double getTensionsisAtm() {
		return tensionsisAtm;
	}

	public void setTensionsisAtm(Double tensionsisAtm) {
		this.tensionsisAtm = tensionsisAtm;
	}

	public Double getTensiondiasAtm() {
		return tensiondiasAtm;
	}

	public void setTensiondiasAtm(Double tensiondiasAtm) {
		this.tensiondiasAtm = tensiondiasAtm;
	}

	public Double getRespiracionAtm() {
		return respiracionAtm;
	}

	public void setRespiracionAtm(Double respiracionAtm) {
		this.respiracionAtm = respiracionAtm;
	}

	public Double getPesoAtm() {
		return pesoAtm;
	}

	public void setPesoAtm(Double pesoAtm) {
		this.pesoAtm = pesoAtm;
	}

	public String getRecetaprocedimientoAtm() {
		return recetaprocedimientoAtm;
	}

	public void setRecetaprocedimientoAtm(String recetaprocedimientoAtm) {
		this.recetaprocedimientoAtm = recetaprocedimientoAtm;
	}

	public String getObservacionProcedimientoAtm() {
		return observacionProcedimientoAtm;
	}

	public void setObservacionProcedimientoAtm(String observacionProcedimientoAtm) {
		this.observacionProcedimientoAtm = observacionProcedimientoAtm;
	}

	public Boolean getEsprocedenfermeriaAtm() {
		return esprocedenfermeriaAtm;
	}

	public void setEsprocedenfermeriaAtm(Boolean esprocedenfermeriaAtm) {
		this.esprocedenfermeriaAtm = esprocedenfermeriaAtm;
	}

	public String getExamenesimagendescAtm() {
		return examenesimagendescAtm;
	}

	public void setExamenesimagendescAtm(String examenesimagendescAtm) {
		this.examenesimagendescAtm = examenesimagendescAtm;
	}

	

	public String getPatGingivalOdont() {
		return patGingivalOdont;
	}

	public void setPatGingivalOdont(String patGingivalOdont) {
		this.patGingivalOdont = patGingivalOdont;
	}

	public String getPatLingualOdont() {
		return patLingualOdont;
	}

	public void setPatLingualOdont(String patLingualOdont) {
		this.patLingualOdont = patLingualOdont;
	}

	public String getPatCarrillosOdont() {
		return patCarrillosOdont;
	}

	public void setPatCarrillosOdont(String patCarrillosOdont) {
		this.patCarrillosOdont = patCarrillosOdont;
	}

	public String getPatLabialOdont() {
		return patLabialOdont;
	}

	public void setPatLabialOdont(String patLabialOdont) {
		this.patLabialOdont = patLabialOdont;
	}

	public String getMaloclusionOdont() {
		return maloclusionOdont;
	}

	public void setMaloclusionOdont(String maloclusionOdont) {
		this.maloclusionOdont = maloclusionOdont;
	}

	public Integer getCariadosOdont() {
		return cariadosOdont;
	}

	public void setCariadosOdont(Integer cariadosOdont) {
		this.cariadosOdont = cariadosOdont;
	}

	public Integer getPerdidosOdont() {
		return perdidosOdont;
	}

	public void setPerdidosOdont(Integer perdidosOdont) {
		this.perdidosOdont = perdidosOdont;
	}

	public Integer getObturadosOdont() {
		return obturadosOdont;
	}

	public void setObturadosOdont(Integer obturadosOdont) {
		this.obturadosOdont = obturadosOdont;
	}

	public Integer getIncluidosOdont() {
		return incluidosOdont;
	}

	public void setIncluidosOdont(Integer incluidosOdont) {
		this.incluidosOdont = incluidosOdont;
	}

	public Integer getIdDiagDefinitivo2() {
		return idDiagDefinitivo2;
	}

	public void setIdDiagDefinitivo2(Integer idDiagDefinitivo2) {
		this.idDiagDefinitivo2 = idDiagDefinitivo2;
	}

	public Integer getIdDiagDefinitivo3() {
		return idDiagDefinitivo3;
	}

	public void setIdDiagDefinitivo3(Integer idDiagDefinitivo3) {
		this.idDiagDefinitivo3 = idDiagDefinitivo3;
	}

	public Integer getIdTopografia2() {
		return idTopografia2;
	}

	public void setIdTopografia2(Integer idTopografia2) {
		this.idTopografia2 = idTopografia2;
	}

	public Integer getIdTopografia3() {
		return idTopografia3;
	}

	public void setIdTopografia3(Integer idTopografia3) {
		this.idTopografia3 = idTopografia3;
	}

	public String getObligatoriedadEstNivelacionAtm() {
		return obligatoriedadEstNivelacionAtm;
	}

	public void setObligatoriedadEstNivelacionAtm(String obligatoriedadEstNivelacionAtm) {
		this.obligatoriedadEstNivelacionAtm = obligatoriedadEstNivelacionAtm;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public Integer getReposoAtmDias() {
		return reposoAtmDias;
	}

	public void setReposoAtmDias(Integer reposoAtmDias) {
		this.reposoAtmDias = reposoAtmDias;
	}

	public String getLaboratorioResultado() {
		return laboratorioResultado;
	}

	public void setLaboratorioResultado(String laboratorioResultado) {
		this.laboratorioResultado = laboratorioResultado;
	}

	public String getOtrosDiagnostico() {
		return otrosDiagnostico;
	}

	public void setOtrosDiagnostico(String otrosDiagnostico) {
		this.otrosDiagnostico = otrosDiagnostico;
	}

	public Integer getAtencionTipo() {
		return atencionTipo;
	}

	public void setAtencionTipo(Integer atencionTipo) {
		this.atencionTipo = atencionTipo;
	}

	
	

	

}