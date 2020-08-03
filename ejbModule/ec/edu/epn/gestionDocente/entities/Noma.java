package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noma database table.
 * 
 */
@Entity
@NamedQuery(name="Noma.findAll", query="SELECT n FROM Noma n")
public class Noma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String area;

	private String nombreareapadre;

	private String nombresubindice;

	private String subindice;

	public Noma() {
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNombreareapadre() {
		return this.nombreareapadre;
	}

	public void setNombreareapadre(String nombreareapadre) {
		this.nombreareapadre = nombreareapadre;
	}

	public String getNombresubindice() {
		return this.nombresubindice;
	}

	public void setNombresubindice(String nombresubindice) {
		this.nombresubindice = nombresubindice;
	}

	public String getSubindice() {
		return this.subindice;
	}

	public void setSubindice(String subindice) {
		this.subindice = subindice;
	}

}