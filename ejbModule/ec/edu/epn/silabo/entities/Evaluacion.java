package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@Table(name="evaluacion", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evaluacion")
	private Integer idEvaluacion;

	@Column(name="porcen_nota_bim")
	private Double porcenNotaBim;

	@Column(name="desc_eval")
	private String descEval;

	private String elemento;

	@Column(name="porcen_nota_bim2")
	private Double porcenNotaBim2;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public Evaluacion() {
	}


	public String getDescEval() {
		return this.descEval;
	}

	public void setDescEval(String descEval) {
		this.descEval = descEval;
	}

	public String getElemento() {
		return this.elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}



	public Integer getIdEvaluacion() {
		return idEvaluacion;
	}



	public void setIdEvaluacion(Integer idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}


	public Double getPorcenNotaBim() {
		return porcenNotaBim;
	}


	public void setPorcenNotaBim(Double porcenNotaBim) {
		this.porcenNotaBim = porcenNotaBim;
	}


	public Double getPorcenNotaBim2() {
		return porcenNotaBim2;
	}


	public void setPorcenNotaBim2(Double porcenNotaBim2) {
		this.porcenNotaBim2 = porcenNotaBim2;
	}



	
	

}