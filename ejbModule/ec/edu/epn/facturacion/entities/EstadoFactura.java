package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_factura database table.
 * 
 */
@Entity
@Table(name = "estado_factura", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="EstadoFactura.findAll", query="SELECT e FROM EstadoFactura e")
public class EstadoFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_factura")
	private String idEstadoFactura;

	@Column(name="descr_ef")
	private String descrEf;

	@Column(name="nombre_ef")
	private String nombreEf;

	public EstadoFactura() {
	}

	public String getIdEstadoFactura() {
		return this.idEstadoFactura;
	}

	public void setIdEstadoFactura(String idEstadoFactura) {
		this.idEstadoFactura = idEstadoFactura;
	}

	public String getDescrEf() {
		return this.descrEf;
	}

	public void setDescrEf(String descrEf) {
		this.descrEf = descrEf;
	}

	public String getNombreEf() {
		return this.nombreEf;
	}

	public void setNombreEf(String nombreEf) {
		this.nombreEf = nombreEf;
	}

}