package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name = "estado", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="EstadoEmergencia.findAll", query="SELECT e FROM EstadoEmergencia e")
public class EstadoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private Integer idEstado;

	private String nombre;

	private String tipo;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="estado")
	private List<AsistenciaEmergencia> asistencias;

	//bi-directional many-to-one association to Autorizacion
	@OneToMany(mappedBy="estado")
	private List<AutorizacionEmergencia> autorizacions;

	//bi-directional one-to-one association to Guardia
	@OneToMany(mappedBy="estado")
	private List<Guardia> guardias;

	public EstadoEmergencia() {
	}

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<AsistenciaEmergencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<AsistenciaEmergencia> asistencias) {
		this.asistencias = asistencias;
	}

	public AsistenciaEmergencia addAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setEstado(this);

		return asistencia;
	}

	public AsistenciaEmergencia removeAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setEstado(null);

		return asistencia;
	}

	public List<AutorizacionEmergencia> getAutorizacions() {
		return this.autorizacions;
	}

	public void setAutorizacions(List<AutorizacionEmergencia> autorizacions) {
		this.autorizacions = autorizacions;
	}

	public AutorizacionEmergencia addAutorizacion(AutorizacionEmergencia autorizacion) {
		getAutorizacions().add(autorizacion);
		autorizacion.setEstado(this);

		return autorizacion;
	}

	public AutorizacionEmergencia removeAutorizacion(AutorizacionEmergencia autorizacion) {
		getAutorizacions().remove(autorizacion);
		autorizacion.setEstado(null);

		return autorizacion;
	}

	public List<Guardia> getGuardias() {
		return guardias;
	}

	public void setGuardias(List<Guardia> guardias) {
		this.guardias = guardias;
	}

	public Guardia addGuardia(Guardia guardia) {
		getGuardias().add(guardia);
		guardia.setEstado(this);

		return guardia;
	}

	public Guardia removeGuardia(Guardia guardia) {
		getGuardias().remove(guardias);
		guardia.setEstado(null);

		return guardia;
	}


}