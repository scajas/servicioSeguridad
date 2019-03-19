package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hlaboral_cambio_administrador database table.
 * 
 */
@Entity
@Table(name="hlaboral_cambio_administrador",  catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="HlaboralCambioAdministrador.findAll", query="SELECT h FROM HlaboralCambioAdministrador h")
public class HlaboralCambioAdministrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer idhist;

	private String motivo;

	private String tipo;

	private String usuario;

	public HlaboralCambioAdministrador() {
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

	public Integer getIdhist() {
		return this.idhist;
	}

	public void setIdhist(Integer idhist) {
		this.idhist = idhist;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}