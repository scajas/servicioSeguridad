package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the eliminacion_servicio database table.
 * 
 */
@Entity
@Table(name="eliminacion_servicio", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="EliminacionServicio.findAll", query="SELECT e FROM EliminacionServicio e")
public class EliminacionServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="codigo_eliminado")
	private String codigoEliminado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String registro;

	private String usuario;

	public EliminacionServicio() {
	}

	public String getCodigoEliminado() {
		return this.codigoEliminado;
	}

	public void setCodigoEliminado(String codigoEliminado) {
		this.codigoEliminado = codigoEliminado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


}