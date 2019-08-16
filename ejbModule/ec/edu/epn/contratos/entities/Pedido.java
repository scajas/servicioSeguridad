package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.seguridad.vo.Usuario;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name = "pedido", catalog = "`bddcorpepn`", schema = "`Contratos`")
@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "resolucion339")
	private String resolucion339;

	@Column(name = "justificacion_devolucion")
	private String obsDevolucion;

	@Column(name = "adenda")
	private String adenda;

	@OneToOne(mappedBy = "pedido")
	private PreplanificacionDocencia prePlanifDocencia;

	public PreplanificacionDocencia getPrePlanifDocencia() {
		return prePlanifDocencia;
	}

	public void setPrePlanifDocencia(PreplanificacionDocencia prePlanifDocencia) {
		this.prePlanifDocencia = prePlanifDocencia;
	}

	public String getAdenda() {
		return adenda;
	}

	public void setAdenda(String adenda) {
		this.adenda = adenda;
	}

	public String getObsDevolucion() {
		return obsDevolucion;
	}

	public void setObsDevolucion(String obsDevolucion) {
		this.obsDevolucion = obsDevolucion;
	}

	@ManyToOne
	@JoinColumn(name = "id_cat")
	private CategoriaContratos categoria;

	public CategoriaContratos getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaContratos categoria) {
		this.categoria = categoria;
	}

	@Column(name = "calle_domicilio")
	private String calleDomicilio;

	@Column(name = "celular_docente")
	private String celularDocente;

	@Column(name = "certif_presup")
	private String certifPresup;

	private String checktitulo;

	@Column(name = "cod_autorizacion")
	private String codAutorizacion;

	private String contrato;

	@Column(name = "correos_notificacion")
	private Integer correosNotificacion;

	private String dedicacion;

	@Column(name = "email_docente")
	private String emailDocente;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Column(name = "continuidad")
	private String continuidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_continuidad")
	private Date fechaContinuidad;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_genera_contrato")
	private Date fechaGeneraContrato;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_genera_informe")
	private Date fechaGeneraInforme;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_max_titulo")
	private Date fechaMaxTitulo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pedido")
	private Date fechaPedido;

	@Temporal(TemporalType.DATE)
	private Date fechafirma;

	private String firmado;

	@Column(name = "id_facultad")
	private String idFacultad;

	@Column(name = "cod_dep")
	private String codDep;

	/*
	 * @Column(name="id_pensum") private Integer idPensum;
	 */

	/*
	 * @Column(name="id_usuario") private Integer idUsuario;
	 */

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "id_usuario_revisor1")
	private Integer idUsuarioRevisor1;

	private String idpedido;

	private String informe;

	/*
	 * @Column(name = "monto_partida") private double montoPartida;
	 */

	@Column(name = "nacionalidad_docente")
	private String nacionalidadDocente;

	private String nced;

	@Column(name = "nombres_docente")
	private String nombresDocente;

	@Column(name = "nro_memo")
	private String nroMemo;

	private String observacionautorizacion;

	private String observaciones;

	private String observacionrevision;

	private String observacionverificado;

	@Column(name = "path_archivo")
	private String pathArchivo;

	private String pathfirma;

	private double puntos;

	@Column(name = "relacion_actual")
	private String relacionActual;

	private String renovacion;

	private double rmu;

	private String semestre;

	private String sexo;

	@Column(name = "telefono_docente")
	private String telefonoDocente;

	@Column(name = "tipo_docente")
	private String tipoDocente;

	@Column(name = "titulo_por_registar")
	private String tituloPorRegistar;

	// bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy = "pedido")
	private List<Actividades> actividades;

	// bi-directional many-to-one association to CargaAcademica
	@OneToMany(mappedBy = "pedido")
	private List<CargaAcademica> cargaAcademicas;

	// bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	// bi-directional many-to-one association to TipoContrato
	@ManyToOne
	@JoinColumn(name = "id_tcont")
	private TipoContrato tipoContrato;

	// bi-directional many-to-one association to RecorridoPedido
	@OneToMany(mappedBy = "pedido")
	private List<RecorridoPedido> recorridoPedidos;

	// bi-directional many-to-one association to TitulosDocente
	@OneToMany(mappedBy = "pedido")
	private List<TitulosDocente> titulosDocentes;

	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Pensum pensum;

	public Pensum getPensum() {
		return pensum;
	}

	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

	public Pedido() {
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getCalleDomicilio() {
		return this.calleDomicilio;
	}

	public void setCalleDomicilio(String calleDomicilio) {
		this.calleDomicilio = calleDomicilio;
	}

	public String getCelularDocente() {
		return this.celularDocente;
	}

	public void setCelularDocente(String celularDocente) {
		this.celularDocente = celularDocente;
	}

	public String getCertifPresup() {
		return this.certifPresup;
	}

	public void setCertifPresup(String certifPresup) {
		this.certifPresup = certifPresup;
	}

	public String getChecktitulo() {
		return this.checktitulo;
	}

	public void setChecktitulo(String checktitulo) {
		this.checktitulo = checktitulo;
	}

	public String getCodAutorizacion() {
		return this.codAutorizacion;
	}

	public void setCodAutorizacion(String codAutorizacion) {
		this.codAutorizacion = codAutorizacion;
	}

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Integer getCorreosNotificacion() {
		return this.correosNotificacion;
	}

	public void setCorreosNotificacion(Integer correosNotificacion) {
		this.correosNotificacion = correosNotificacion;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getEmailDocente() {
		return this.emailDocente;
	}

	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaGeneraContrato() {
		return this.fechaGeneraContrato;
	}

	public void setFechaGeneraContrato(Date fechaGeneraContrato) {
		this.fechaGeneraContrato = fechaGeneraContrato;
	}

	public Date getFechaGeneraInforme() {
		return this.fechaGeneraInforme;
	}

	public void setFechaGeneraInforme(Date fechaGeneraInforme) {
		this.fechaGeneraInforme = fechaGeneraInforme;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaMaxTitulo() {
		return this.fechaMaxTitulo;
	}

	public void setFechaMaxTitulo(Date fechaMaxTitulo) {
		this.fechaMaxTitulo = fechaMaxTitulo;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechafirma() {
		return this.fechafirma;
	}

	public void setFechafirma(Date fechafirma) {
		this.fechafirma = fechafirma;
	}

	public String getFirmado() {
		return this.firmado;
	}

	public void setFirmado(String firmado) {
		this.firmado = firmado;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	/*
	 * public Integer getIdPensum() { return this.idPensum; }
	 * 
	 * public void setIdPensum(Integer idPensum) { this.idPensum = idPensum; }
	 */

	/*
	 * public Integer getIdUsuario() { return this.idUsuario; }
	 * 
	 * public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
	 */

	public Integer getIdUsuarioRevisor1() {
		return this.idUsuarioRevisor1;
	}

	public void setIdUsuarioRevisor1(Integer idUsuarioRevisor1) {
		this.idUsuarioRevisor1 = idUsuarioRevisor1;
	}

	public String getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getInforme() {
		return this.informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	/*
	 * public double getMontoPartida() { return this.montoPartida; }
	 * 
	 * public void setMontoPartida(double montoPartida) { this.montoPartida =
	 * montoPartida; }
	 */

	public String getNacionalidadDocente() {
		return this.nacionalidadDocente;
	}

	public void setNacionalidadDocente(String nacionalidadDocente) {
		this.nacionalidadDocente = nacionalidadDocente;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombresDocente() {
		return this.nombresDocente;
	}

	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	public String getNroMemo() {
		return this.nroMemo;
	}

	public void setNroMemo(String nroMemo) {
		this.nroMemo = nroMemo;
	}

	public String getObservacionautorizacion() {
		return this.observacionautorizacion;
	}

	public void setObservacionautorizacion(String observacionautorizacion) {
		this.observacionautorizacion = observacionautorizacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservacionrevision() {
		return this.observacionrevision;
	}

	public void setObservacionrevision(String observacionrevision) {
		this.observacionrevision = observacionrevision;
	}

	public String getObservacionverificado() {
		return this.observacionverificado;
	}

	public void setObservacionverificado(String observacionverificado) {
		this.observacionverificado = observacionverificado;
	}

	public String getPathArchivo() {
		return this.pathArchivo;
	}

	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}

	public String getPathfirma() {
		return this.pathfirma;
	}

	public void setPathfirma(String pathfirma) {
		this.pathfirma = pathfirma;
	}

	public double getPuntos() {
		return this.puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	public String getRelacionActual() {
		return this.relacionActual;
	}

	public void setRelacionActual(String relacionActual) {
		this.relacionActual = relacionActual;
	}

	public String getRenovacion() {
		return this.renovacion;
	}

	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

	public double getRmu() {
		return this.rmu;
	}

	public void setRmu(double rmu) {
		this.rmu = rmu;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefonoDocente() {
		return this.telefonoDocente;
	}

	public void setTelefonoDocente(String telefonoDocente) {
		this.telefonoDocente = telefonoDocente;
	}

	public String getTipoDocente() {
		return this.tipoDocente;
	}

	public void setTipoDocente(String tipoDocente) {
		this.tipoDocente = tipoDocente;
	}

	public String getTituloPorRegistar() {
		return this.tituloPorRegistar;
	}

	public void setTituloPorRegistar(String tituloPorRegistar) {
		this.tituloPorRegistar = tituloPorRegistar;
	}

	public List<Actividades> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividades> actividades) {
		this.actividades = actividades;
	}

	public Actividades addActividade(Actividades actividade) {
		getActividades().add(actividade);
		actividade.setPedido(this);

		return actividade;
	}

	public Actividades removeActividade(Actividades actividade) {
		getActividades().remove(actividade);
		actividade.setPedido(null);

		return actividade;
	}

	public List<CargaAcademica> getCargaAcademicas() {
		return this.cargaAcademicas;
	}

	public void setCargaAcademicas(List<CargaAcademica> cargaAcademicas) {
		this.cargaAcademicas = cargaAcademicas;
	}

	public CargaAcademica addCargaAcademica(CargaAcademica cargaAcademica) {
		getCargaAcademicas().add(cargaAcademica);
		cargaAcademica.setPedido(this);

		return cargaAcademica;
	}

	public CargaAcademica removeCargaAcademica(CargaAcademica cargaAcademica) {
		getCargaAcademicas().remove(cargaAcademica);
		cargaAcademica.setPedido(null);

		return cargaAcademica;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoContrato getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public List<RecorridoPedido> getRecorridoPedidos() {
		return this.recorridoPedidos;
	}

	public void setRecorridoPedidos(List<RecorridoPedido> recorridoPedidos) {
		this.recorridoPedidos = recorridoPedidos;
	}

	public RecorridoPedido addRecorridoPedido(RecorridoPedido recorridoPedido) {
		getRecorridoPedidos().add(recorridoPedido);
		recorridoPedido.setPedido(this);

		return recorridoPedido;
	}

	public RecorridoPedido removeRecorridoPedido(RecorridoPedido recorridoPedido) {
		getRecorridoPedidos().remove(recorridoPedido);
		recorridoPedido.setPedido(null);

		return recorridoPedido;
	}

	public List<TitulosDocente> getTitulosDocentes() {
		return this.titulosDocentes;
	}

	public void setTitulosDocentes(List<TitulosDocente> titulosDocentes) {
		this.titulosDocentes = titulosDocentes;
	}

	public TitulosDocente addTitulosDocente(TitulosDocente titulosDocente) {
		getTitulosDocentes().add(titulosDocente);
		titulosDocente.setPedido(this);

		return titulosDocente;
	}

	public TitulosDocente removeTitulosDocente(TitulosDocente titulosDocente) {
		getTitulosDocentes().remove(titulosDocente);
		titulosDocente.setPedido(null);

		return titulosDocente;
	}

	/**
	 * @return the codDep
	 */
	public String getCodDep() {
		return codDep;
	}

	/**
	 * @param codDep the codDep to set
	 */
	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getResolucion339() {
		return resolucion339;
	}

	public void setResolucion339(String resolucion339) {
		this.resolucion339 = resolucion339;
	}

	public String getContinuidad() {
		return continuidad;
	}

	public void setContinuidad(String continuidad) {
		this.continuidad = continuidad;
	}

	public Date getFechaContinuidad() {
		return fechaContinuidad;
	}

	public void setFechaContinuidad(Date fechaContinuidad) {
		this.fechaContinuidad = fechaContinuidad;
	}

}