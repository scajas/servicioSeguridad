package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "fechasWS" database table.
 * 
 */
@Entity
@Table(name="\"fechasWS\"")
@NamedQuery(name="FechasW.findAll", query="SELECT f FROM FechasW f")
public class FechasW implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cedula1;

	private String cedula2;

	private String fecha1;

	private String fecha2;

	public FechasW() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula1() {
		return this.cedula1;
	}

	public void setCedula1(String cedula1) {
		this.cedula1 = cedula1;
	}

	public String getCedula2() {
		return this.cedula2;
	}

	public void setCedula2(String cedula2) {
		this.cedula2 = cedula2;
	}

	public String getFecha1() {
		return this.fecha1;
	}

	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}

	public String getFecha2() {
		return this.fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}

}