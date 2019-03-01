package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the miembros database table.
 * 
 */
@Entity(name = "MiembroVoto")
@Table(name="miembros" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class MiembroVoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_miembro")
	private Integer idMiembro;

	private String apellido;

	private String nced;

	private String nombre;
	
	private String votacion;

	@Column(name="numero_silla")
	private Integer numeroSilla;

	private String posicion;

	private String rol;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="miembro")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to Consejo
    @ManyToOne
	@JoinColumn(name="id_consejo")
	private Consejo consejo;

	//bi-directional many-to-one association to Votacion
	@OneToMany(mappedBy="miembro")
	private List<Votacion> votacions;
	
	
	private Double ponderado;

    public MiembroVoto() {
    }

	public Integer getIdMiembro() {
		return this.idMiembro;
	}

	public void setIdMiembro(Integer idMiembro) {
		this.idMiembro = idMiembro;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroSilla() {
		return this.numeroSilla;
	}

	public void setNumeroSilla(Integer numeroSilla) {
		this.numeroSilla = numeroSilla;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
	public Consejo getConsejo() {
		return this.consejo;
	}

	public void setConsejo(Consejo consejo) {
		this.consejo = consejo;
	}
	
	public List<Votacion> getVotacions() {
		return this.votacions;
	}

	public void setVotacions(List<Votacion> votacions) {
		this.votacions = votacions;
	}

	public String getVotacion() {
		return votacion;
	}

	public void setVotacion(String votacion) {
		this.votacion = votacion;
	}

	public Double getPonderado() {
		return ponderado;
	}

	public void setPonderado(Double ponderado) {
		this.ponderado = ponderado;
	}
	
}