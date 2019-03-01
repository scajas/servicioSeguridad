package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resolucion database table.
 * 
 */
@Entity
@Table(name="resolucion" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Resolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resolucion")
	private Integer idResolucion;

	private String resuelto;

	//bi-directional many-to-one association to Mocion
    @ManyToOne
	@JoinColumn(name="id_mocion")
	private Mocion mocion;

    public Resolucion() {
    }

	public Integer getIdResolucion() {
		return this.idResolucion;
	}

	public void setIdResolucion(Integer idResolucion) {
		this.idResolucion = idResolucion;
	}

	public String getResuelto() {
		return this.resuelto;
	}

	public void setResuelto(String resuelto) {
		this.resuelto = resuelto;
	}

	public Mocion getMocion() {
		return this.mocion;
	}

	public void setMocion(Mocion mocion) {
		this.mocion = mocion;
	}
	
}