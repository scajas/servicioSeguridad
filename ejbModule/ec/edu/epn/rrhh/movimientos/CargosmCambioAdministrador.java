package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hlaboral_cambio_administrador database table.
 * 
 */
@Entity
@Table(name="cargosm_cambio_administrador",  catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="CargosmCambioAdministrador.findAll", query="SELECT h FROM CargosmCambioAdministrador h")
public class CargosmCambioAdministrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "id_cargo")
	private Integer idCargo;

	private String motivo;
	
	@Column(name = "tipo_cambio")
	private String tipo;

	private String usuario;

	public CargosmCambioAdministrador() {
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

	public Integer getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Integer idhist) {
		this.idCargo = idhist;
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