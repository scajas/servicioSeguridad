package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mocion database table.
 * 
 */
@Entity

@Table(name="mocion" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Mocion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mocion")
	private Integer idMocion;

	private String apellido;

	@Column(name="estado_m")
	private String estadoM;

	private String mocion;

	@Column(name="nced_proponente")
	private String ncedProponente;

	private String nombre;

	@Column(name="novedad_mocion")
	private String novedadMocion;

	private String votada;
	
	private String resultado;

	//bi-directional many-to-one association to OrdenDia
    @ManyToOne
	@JoinColumn(name="id_orden")
	private OrdenDia ordenDia;

	//bi-directional many-to-one association to Resolucion
	@OneToMany(mappedBy="mocion")
	private List<Resolucion> resolucions;

	//bi-directional many-to-one association to RegVotación
	@OneToMany(mappedBy="mocion")
	private List<RegVotacion> regVotacións;

    public Mocion() {
    }

	public Integer getIdMocion() {
		return this.idMocion;
	}

	public void setIdMocion(Integer idMocion) {
		this.idMocion = idMocion;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstadoM() {
		return this.estadoM;
	}

	public void setEstadoM(String estadoM) {
		this.estadoM = estadoM;
	}

	public String getMocion() {
		return this.mocion;
	}

	public void setMocion(String mocion) {
		this.mocion = mocion;
	}

	public String getNcedProponente() {
		return this.ncedProponente;
	}

	public void setNcedProponente(String ncedProponente) {
		this.ncedProponente = ncedProponente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNovedadMocion() {
		return this.novedadMocion;
	}

	public void setNovedadMocion(String novedadMocion) {
		this.novedadMocion = novedadMocion;
	}

	public String getVotada() {
		return this.votada;
	}

	public void setVotada(String votada) {
		this.votada = votada;
	}

	public OrdenDia getOrdenDia() {
		return this.ordenDia;
	}

	public void setOrdenDia(OrdenDia ordenDia) {
		this.ordenDia = ordenDia;
	}
	
	public List<Resolucion> getResolucions() {
		return this.resolucions;
	}

	public void setResolucions(List<Resolucion> resolucions) {
		this.resolucions = resolucions;
	}
	
	public List<RegVotacion> getRegVotacións() {
		return this.regVotacións;
	}

	public void setRegVotacións(List<RegVotacion> regVotacións) {
		this.regVotacións = regVotacións;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}