package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calculo_horas_docencia database table.
 * 
 */
@Entity
@Table(name="calculo_horas_docencia",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CalculoHorasDocencia.findAll", query="SELECT c FROM CalculoHorasDocencia c")
public class CalculoHorasDocencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_calculo")
	private Integer idCalculo;

	private String descricpion;

	@Column(name="horas_calculo")
	private Integer horasCalculo;

	private String nivel;

	private String regimen;

	public CalculoHorasDocencia() {
	}

	public Integer getIdCalculo() {
		return this.idCalculo;
	}

	public void setIdCalculo(Integer idCalculo) {
		this.idCalculo = idCalculo;
	}

	public String getDescricpion() {
		return this.descricpion;
	}

	public void setDescricpion(String descricpion) {
		this.descricpion = descricpion;
	}

	public Integer getHorasCalculo() {
		return this.horasCalculo;
	}

	public void setHorasCalculo(Integer horasCalculo) {
		this.horasCalculo = horasCalculo;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getRegimen() {
		return this.regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

}