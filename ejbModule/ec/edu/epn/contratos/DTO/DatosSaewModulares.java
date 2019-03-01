package ec.edu.epn.contratos.DTO;

import java.util.Date;

public class DatosSaewModulares {

	// VARIABLES
	private String fecha;
	private int nroSesion;
	private int de;
	private int a;
	private int subTotal;

	// SETTERS y GETTERS
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNroSesion() {
		return nroSesion;
	}

	public void setNroSesion(int nroSesion) {
		this.nroSesion = nroSesion;
	}

	public int getDe() {
		return de;
	}

	public void setDe(int de) {
		this.de = de;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

}
