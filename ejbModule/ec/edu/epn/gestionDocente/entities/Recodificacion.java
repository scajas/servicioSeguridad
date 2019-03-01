package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the recodificacion database table.
 * 
 */
@Entity
@Table(name = "recodificacion", catalog = "bddcorpepn", schema = "`GestionDocente`")
public class Recodificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

    @Temporal( TemporalType.DATE)
	private Date fecha;

	private String motivo;

	private String numreg;

	private String usuario;

    public Recodificacion() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNumreg() {
		return this.numreg;
	}

	public void setNumreg(String numreg) {
		this.numreg = numreg;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}