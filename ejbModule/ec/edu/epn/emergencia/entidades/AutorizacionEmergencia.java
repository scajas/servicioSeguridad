package ec.edu.epn.emergencia.entidades;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import ec.edu.epn.rrhh.entities.Emp;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "autorizacion", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name = "AutorizacionEmergencia.findAll", query = "SELECT a FROM AutorizacionEmergencia a")
public class AutorizacionEmergencia implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_autorizacion")
    private Integer idAutorizacion;
    @Column(name = "autorizado_por")
    private String autorizadoPor;
    @Column(name = "cargo_autoriza")
    private String cargoAutoriza;
    @Column(name = "dependencia_destino")
    private String dependenciaDestino;
    @Column(name = "dependencia_origen")
    private String dependenciaOrigen;
    @Column(name = "placa")
    private String placa;
    @Column(name = "semaforo")
    private String semaforo;
    @Column(name = "fecha_desde")
    private Date fechaDesde;
    @Column(name = "fecha_hasta")
    private Date fechaHasta;
    @Column(name = "fecha_registro")
    private Timestamp fechaRegistro;
    @Column(name = "motivo_autorizacion")
    private String motivoAutorizacion;
    @Column(name = "nced")
    private String cedula;
    @Column(name = "nombre_usuario_registro")
    private String nombreUsuarioRegistro;
    private String nombres;
    private String cargo;
    private String email;
    private String telefono;
    private Boolean excepcion;
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Column(name = "fin_de_semana")
    private Boolean finDeSemana;
    private String observaciones;
    @OneToMany(mappedBy = "autorizacion")
    private List<AsistenciaEmergencia> asistencias;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEmergencia estado;
    @Column(name = "estado_persona")
    private String estadoPersona;
    @ManyToOne
    @JoinColumn(name = "horario")
    private HorarioEmergencia horario;   
    @JoinColumn(name = "nced", referencedColumnName = "nced", insertable=false, updatable=false)
    @NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	private Emp empleado;

	@Column(name="fecha_ultima_actualizacion")
	private Date fechaUltimaActualizacion;
	
	@Column(name="usuario_actualiza")
	private String usuarioActualza;
    
    public String getUsuarioActualza() {
		return usuarioActualza;
	}

	public void setUsuarioActualza(String usuarioActualza) {
		this.usuarioActualza = usuarioActualza;
	}

	@ManyToOne
    @JoinColumn(name="tipo_autorizacion")
	private TipoAutorizacion tipoAutorizacion;

    public TipoAutorizacion getTipoAutorizacion() {
		return tipoAutorizacion;
	}

	public void setTipoAutorizacion(TipoAutorizacion tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}

	public Integer getIdAutorizacion() {
        return this.idAutorizacion;
    }
    
    public void setIdAutorizacion(final Integer idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }
    
    public String getAutorizadoPor() {
        return this.autorizadoPor;
    }
    
    public void setAutorizadoPor(final String autorizadoPor) {
        this.autorizadoPor = autorizadoPor;
    }
    
    public String getCargoAutoriza() {
        return this.cargoAutoriza;
    }
    
    public void setCargoAutoriza(final String cargoAutoriza) {
        this.cargoAutoriza = cargoAutoriza;
    }
    
    public String getDependenciaDestino() {
        return this.dependenciaDestino;
    }
    
    public void setDependenciaDestino(final String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }
    
    public String getDependenciaOrigen() {
        return this.dependenciaOrigen;
    }
    
    public void setDependenciaOrigen(final String dependenciaOrigen) {
        this.dependenciaOrigen = dependenciaOrigen;
    }
    
    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    
    public void setFechaDesde(final Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    
    public Date getFechaHasta() {
        return this.fechaHasta;
    }
    
    public void setFechaHasta(final Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    public Timestamp getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(final Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getMotivoAutorizacion() {
        return this.motivoAutorizacion;
    }
    
    public void setMotivoAutorizacion(final String motivoAutorizacion) {
        this.motivoAutorizacion = motivoAutorizacion;
    }
    
    public String getNced() {
        return this.cedula;
    }
    
    public void setNced(final String nced) {
        this.cedula = nced;
    }
    
    public String getNombreUsuarioRegistro() {
        return this.nombreUsuarioRegistro;
    }
    
    public void setNombreUsuarioRegistro(final String nombreUsuarioRegistro) {
        this.nombreUsuarioRegistro = nombreUsuarioRegistro;
    }
    
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }
    
    public List<AsistenciaEmergencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(final List<AsistenciaEmergencia> asistencias) {
        this.asistencias = asistencias;
    }
    
    public AsistenciaEmergencia addAsistencia(final AsistenciaEmergencia asistencia) {
        this.getAsistencias().add(asistencia);
        asistencia.setAutorizacionEmergencia(this);
        return asistencia;
    }
    
    public AsistenciaEmergencia removeAsistencia(final AsistenciaEmergencia asistencia) {
        this.getAsistencias().remove(asistencia);
        asistencia.setAutorizacionEmergencia((AutorizacionEmergencia)null);
        return asistencia;
    }
    
    public EstadoEmergencia getEstado() {
        return this.estado;
    }
    
    public void setEstado(final EstadoEmergencia estado) {
        this.estado = estado;
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(final String placa) {
        this.placa = placa;
    }
    
    public String getSemaforo() {
        return this.semaforo;
    }
    
    public void setSemaforo(final String semaforo) {
        this.semaforo = semaforo;
    }
    
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(final String cargo) {
        this.cargo = cargo;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }
    
    public String getTipoPersona() {
        return this.tipoPersona;
    }
    
    public void setTipoPersona(final String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    public String getEstadoPersona() {
        return this.estadoPersona;
    }
    
    public void setEstadoPersona(final String estadoPersona) {
        this.estadoPersona = estadoPersona;
    }
    
    public HorarioEmergencia getHorario() {
        return this.horario;
    }
    
    public void setHorario(final HorarioEmergencia horario) {
        this.horario = horario;
    }
    
    public Boolean getExcepcion() {
        return this.excepcion;
    }
    
    public void setExcepcion(final Boolean excepcion) {
        this.excepcion = excepcion;
    }
    
    public Boolean getFinDeSemana() {
        return this.finDeSemana;
    }
    
    public void setFinDeSemana(final Boolean finDeSemana) {
        this.finDeSemana = finDeSemana;
    }
    
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(final String observaciones) {
        this.observaciones = observaciones;
    }

	public Emp getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Emp empleado) {
		this.empleado = empleado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}
    
    
}