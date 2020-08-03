package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the actividad_docencia database table.
 * 
 */
@Entity

@Table(name="preg_resultado_eval",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class PregResultadoEval implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_preg_resultado_eval")
	@SequenceGenerator(name = "sec_preg_resultados_eval", sequenceName = "sec_preg_resultados_eval", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_preg_resultados_eval")	
	private Integer idPregResultadoEval;

	@Column(name="id_preguntas_eval")
	private Integer idPreguntasEval;
	
	@Column(name="valor")
	private Double valor;
	
	
	@Column(name="valor_2")
	private Double valor2;
	
	
	//bi-directional many-to-one association to ResultadoEval
    @ManyToOne
	@JoinColumn(name="id_resultado_eval")
	private ResultadoEval resultadoEval;

	

	public Integer getIdPregResultadoEval() {
		return idPregResultadoEval;
	}

	public void setIdPregResultadoEval(Integer idPregResultadoEval) {
		this.idPregResultadoEval = idPregResultadoEval;
	}

	/**
	 * @return the idPreguntasEval
	 */
	public Integer getIdPreguntasEval() {
		return idPreguntasEval;
	}

	/**
	 * @param idPreguntasEval the idPreguntasEval to set
	 */
	public void setIdPreguntasEval(Integer idPreguntasEval) {
		this.idPreguntasEval = idPreguntasEval;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the resultadoEval
	 */
	public ResultadoEval getResultadoEval() {
		return resultadoEval;
	}

	/**
	 * @param resultadoEval the resultadoEval to set
	 */
	public void setResultadoEval(ResultadoEval resultadoEval) {
		this.resultadoEval = resultadoEval;
	}

	/**
	 * @return the valor2
	 */
	public Double getValor2() {
		return valor2;
	}

	/**
	 * @param valor2 the valor2 to set
	 */
	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}
    
   	
}