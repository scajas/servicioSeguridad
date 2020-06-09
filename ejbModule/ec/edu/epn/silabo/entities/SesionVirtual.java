package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sesion_virtual database table.
 * 
 */
@Entity

@Table(name="sesion_virtual", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="SesionVirtual.findAll", query="SELECT s FROM SesionVirtual s")
public class SesionVirtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sesion")
	private Integer idSesion;

	private String herramienta;

	private String horario;

	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	private String informacion;

	public SesionVirtual() {
	}

	public Integer getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(Integer idSesion) {
		this.idSesion = idSesion;
	}

	public String getHerramienta() {
		return this.herramienta;
	}

	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	

	public Silabo getSilabo() {
		return silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

}