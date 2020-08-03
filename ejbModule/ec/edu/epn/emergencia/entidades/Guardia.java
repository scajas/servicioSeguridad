package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the guardias database table.
 * 
 */
@Entity
@Table(name = "guardias", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="Guardia.findAll", query="SELECT g FROM Guardia g")
public class Guardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_guardia")
	private Integer idGuardia;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	private String nced;

	private String nombres;

	private String passwd;

	@Column(name="usuario_registro")
	private String usuarioRegistro;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="guardia", fetch=FetchType.EAGER)
	private List<AsistenciaEmergencia> asistencias;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoEmergencia estado;

	public Guardia() {
	}

	public Integer getIdGuardia() {
		return this.idGuardia;
	}

	public void setIdGuardia(Integer idGuardia) {
		this.idGuardia = idGuardia;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public List<AsistenciaEmergencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<AsistenciaEmergencia> asistencias) {
		this.asistencias = asistencias;
	}

	public AsistenciaEmergencia addAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setGuardia(this);

		return asistencia;
	}

	public AsistenciaEmergencia removeAsistencia(AsistenciaEmergencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setGuardia(null);

		return asistencia;
	}

	public EstadoEmergencia getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoEmergencia estado) {
		this.estado = estado;
	}

}