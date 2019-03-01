package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Date;
import java.sql.Array;
import java.sql.Timestamp;


/**
 * The persistent class for the vaca database table.
 * 
 */
@Entity
@Table(name = "vaca", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Vaca.findAll", query="SELECT v FROM Vaca v")
public class Vaca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String detalle;

	@Column(name="dias_concecutivos")
	private Integer diasConcecutivos;

	@Column(name="dias_utiles")
	private Integer diasUtiles;

	@Column(name="docu_solicutud")
	private String docuSolicutud;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_calculo_vac")
	private Date fechaCalculoVac;


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name="hora_regreso")
	private Time horaRegreso;

	@Column(name="hora_salida")
	private Time horaSalida;

	@Column(name="nom_aut")
	private String nomAut;

	@Column(name="nro_documento")
	private String nroDocumento;

	@Column(name="saldo_vac_dias")
	private Integer saldoVacDias;

	@Column(name="saldo_vac_horas")
	private Integer saldoVacHoras;

	@Column(name="saldo_vac_minutos")
	private Integer saldoVacMinutos;

	private String usuario;

	@Column(name="xpath_documento")
	private String xpathDocumento;
	
	@Column(name="dias_acreditados_deb")
	private Integer diasAcreditadosDeb;
	

	@Column(name="horas_acreditados_deb")
	private Integer horasAcreditadosDeb;

	@Column(name="min_acreditados_deb")
	private Integer minAcreditadosDeb;

	//bi-directional one-to-one association to DetalleVacacionCatalogo
	@ManyToOne
	@JoinColumn(name="id_detalle")
	private DetalleVacacionCatalogo iddetalleVacacionCatalogo;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Emp emp;

	public Vaca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getDiasConcecutivos() {
		return this.diasConcecutivos;
	}

	public void setDiasConcecutivos(Integer diasConcecutivos) {
		this.diasConcecutivos = diasConcecutivos;
	}

	public Integer getDiasUtiles() {
		return this.diasUtiles;
	}

	public void setDiasUtiles(Integer diasUtiles) {
		this.diasUtiles = diasUtiles;
	}

	public String getDocuSolicutud() {
		return this.docuSolicutud;
	}

	public void setDocuSolicutud(String docuSolicutud) {
		this.docuSolicutud = docuSolicutud;
	}

	public Date getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Date fecSis) {
		this.fecSis = fecSis;
	}

	public Date getFechaCalculoVac() {
		return this.fechaCalculoVac;
	}

	public void setFechaCalculoVac(Date fechaCalculoVac) {
		this.fechaCalculoVac = fechaCalculoVac;
	}

	public Date getFechaRegreso() {
		return this.fechaRegreso;
	}

	public void setFechaRegreso(Date fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Time getHoraRegreso() {
		return this.horaRegreso;
	}

	public void setHoraRegreso(Time horaRegreso) {
		this.horaRegreso = horaRegreso;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNomAut() {
		return this.nomAut;
	}

	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Integer getSaldoVacDias() {
		return this.saldoVacDias;
	}

	public void setSaldoVacDias(Integer saldoVacDias) {
		this.saldoVacDias = saldoVacDias;
	}

	public Integer getSaldoVacHoras() {
		return this.saldoVacHoras;
	}

	public void setSaldoVacHoras(Integer saldoVacHoras) {
		this.saldoVacHoras = saldoVacHoras;
	}

	public Integer getSaldoVacMinutos() {
		return this.saldoVacMinutos;
	}

	public void setSaldoVacMinutos(Integer saldoVacMinutos) {
		this.saldoVacMinutos = saldoVacMinutos;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getXpathDocumento() {
		return this.xpathDocumento;
	}

	public void setXpathDocumento(String xpathDocumento) {
		this.xpathDocumento = xpathDocumento;
	}

	public DetalleVacacionCatalogo getIddetalleVacacionCatalogo() {
		return iddetalleVacacionCatalogo;
	}

	public void setIddetalleVacacionCatalogo(DetalleVacacionCatalogo iddetalleVacacionCatalogo) {
		this.iddetalleVacacionCatalogo = iddetalleVacacionCatalogo;
	}


	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public Integer getDiasAcreditadosDeb() {
		return diasAcreditadosDeb;
	}

	public void setDiasAcreditadosDeb(Integer diasAcreditadosDeb) {
		this.diasAcreditadosDeb = diasAcreditadosDeb;
	}

	public Integer getHorasAcreditadosDeb() {
		return horasAcreditadosDeb;
	}

	public void setHorasAcreditadosDeb(Integer horasAcreditadosDeb) {
		this.horasAcreditadosDeb = horasAcreditadosDeb;
	}

	public Integer getMinAcreditadosDeb() {
		return minAcreditadosDeb;
	}

	public void setMinAcreditadosDeb(Integer minAcreditadosDeb) {
		this.minAcreditadosDeb = minAcreditadosDeb;
	}


}