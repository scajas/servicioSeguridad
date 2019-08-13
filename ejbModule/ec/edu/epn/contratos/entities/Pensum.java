package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Cont;
import ec.edu.epn.rrhh.entities.NombTemp;

/**
 * The persistent class for the pensum database table.
 * 
 */
@Entity
@Table(name = "pensum", catalog = "bddcorpepn", schema = "\"Contratos\"")
@NamedQuery(name = "Pensum.findAll", query = "SELECT p FROM Pensum p")
public class Pensum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pensum")
	private Integer idPensum;

	@Column(name = "año_pensum")
	private String añoPensum;

	@Column(name = "id_pensum_anterior")
	private Integer idPensumAnterior;

	private String estado;

	@Column(name = "meses_pensem")
	private String mesesPensem;

	@Column(name = "numero_pensum")
	private String numeroPensum;

	private Integer secuencia;

	@Column(name = "secuencia_convenio")
	private Integer secuenciaConvenio;

	private String vacaciones;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_planif")
	private Date fechaPlanif;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auto")
	private Date fechaAuto;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_coe")
	private Date fechaCoe;

	@OneToMany(mappedBy = "pensum")
	private List<Cont> contratos;

	@OneToMany(mappedBy = "pensum")
	private List<NombTemp> nombramientos;

	private String meses;
	private String visibledips;
	
	@Temporal(TemporalType.DATE)
	private Date vipsplanifica;

	@Temporal(TemporalType.DATE)
	private Date vipsreporta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_preplanif")
	private Date fechaPreplanif;
	
	
	

	public Pensum() {
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getAñoPensum() {
		return this.añoPensum;
	}

	public void setAñoPensum(String añoPensum) {
		this.añoPensum = añoPensum;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMesesPensem() {
		return this.mesesPensem;
	}

	public void setMesesPensem(String mesesPensem) {
		this.mesesPensem = mesesPensem;
	}

	public String getNumeroPensum() {
		return this.numeroPensum;
	}

	public void setNumeroPensum(String numeroPensum) {
		this.numeroPensum = numeroPensum;
	}

	public Integer getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Integer getSecuenciaConvenio() {
		return this.secuenciaConvenio;
	}

	public void setSecuenciaConvenio(Integer secuenciaConvenio) {
		this.secuenciaConvenio = secuenciaConvenio;
	}

	public String getVacaciones() {
		return this.vacaciones;
	}

	public void setVacaciones(String vacaciones) {
		this.vacaciones = vacaciones;
	}

	public List<Cont> getContratos() {
		return contratos;
	}

	public void setContratos(List<Cont> contratos) {
		this.contratos = contratos;
	}

	public List<NombTemp> getNombramientos() {
		return nombramientos;
	}

	public void setNombramientos(List<NombTemp> nombramientos) {
		this.nombramientos = nombramientos;
	}

	/**
	 * @return the fechaPlanif
	 */
	public Date getFechaPlanif() {
		return fechaPlanif;
	}

	/**
	 * @return the fechaAuto
	 */
	public Date getFechaAuto() {
		return fechaAuto;
	}

	/**
	 * @return the fechaCoe
	 */
	public Date getFechaCoe() {
		return fechaCoe;
	}

	/**
	 * @param fechaPlanif
	 *            the fechaPlanif to set
	 */
	public void setFechaPlanif(Date fechaPlanif) {
		this.fechaPlanif = fechaPlanif;
	}

	/**
	 * @param fechaAuto
	 *            the fechaAuto to set
	 */
	public void setFechaAuto(Date fechaAuto) {
		this.fechaAuto = fechaAuto;
	}

	/**
	 * @param fechaCoe
	 *            the fechaCoe to set
	 */
	public void setFechaCoe(Date fechaCoe) {
		this.fechaCoe = fechaCoe;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getVisibledips() {
		return visibledips;
	}

	public void setVisibledips(String visibledips) {
		this.visibledips = visibledips;
	}

	public Integer getIdPensumAnterior() {
		return idPensumAnterior;
	}

	public void setIdPensumAnterior(Integer idPensumAnterior) {
		this.idPensumAnterior = idPensumAnterior;
	}

	public Date getVipsplanifica() {
		return vipsplanifica;
	}

	public void setVipsplanifica(Date vipsplanifica) {
		this.vipsplanifica = vipsplanifica;
	}

	public Date getVipsreporta() {
		return vipsreporta;
	}

	public void setVipsreporta(Date vipsreporta) {
		this.vipsreporta = vipsreporta;
	}

	public Date getFechaPreplanif() {
		return fechaPreplanif;
	}

	public void setFechaPreplanif(Date fechaPreplanif) {
		this.fechaPreplanif = fechaPreplanif;
	}
	

}