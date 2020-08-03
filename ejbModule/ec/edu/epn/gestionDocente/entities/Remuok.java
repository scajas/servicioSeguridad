package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the remuok database table.
 * 
 */
@Entity
@NamedQuery(name="Remuok.findAll", query="SELECT r FROM Remuok r")
public class Remuok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nombres;

	private String dedicacion;

	private String nced;

	private BigDecimal remuneracion;

	public Remuok() {
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public BigDecimal getRemuneracion() {
		return this.remuneracion;
	}

	public void setRemuneracion(BigDecimal remuneracion) {
		this.remuneracion = remuneracion;
	}

}