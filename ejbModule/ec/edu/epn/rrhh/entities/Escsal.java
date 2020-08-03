package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the escsal database table.
 * 
 */
@Entity
@NamedQuery(name="Escsal.findAll", query="SELECT e FROM Escsal e")
public class Escsal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_escsal")
	private String codEscsal;

	private String cargo;

	@Column(name="cod_clase")
	private String codClase;

	private BigDecimal sueldob;

	//bi-directional many-to-one association to Partind
	@ManyToOne
	@JoinColumn(name="cod_pind")
	private Partind partind;

	public Escsal() {
	}

	public String getCodEscsal() {
		return this.codEscsal;
	}

	public void setCodEscsal(String codEscsal) {
		this.codEscsal = codEscsal;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCodClase() {
		return this.codClase;
	}

	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}

	public BigDecimal getSueldob() {
		return this.sueldob;
	}

	public void setSueldob(BigDecimal sueldob) {
		this.sueldob = sueldob;
	}

	public Partind getPartind() {
		return this.partind;
	}

	public void setPartind(Partind partind) {
		this.partind = partind;
	}

}