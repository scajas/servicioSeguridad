package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resultados_pea database table.
 * 
 */
@Entity
@Table(name="resultados_pea", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name="ResultadosPea.findAll", query="SELECT r FROM ResultadosPea r")
public class ResultadosPea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resultados", unique=true, nullable=false)
	private Integer idResultados;

	@Column(length=5000)
	private String formas;

	@Column(length=5000)
	private String resultados;

	@Column(name="tipo_bilbiografia", length=5000)
	private String tipoBilbiografia;

	//bi-directional many-to-one association to Pea
	@ManyToOne
	@JoinColumn(name="id_pea")
	private Pea pea;

	public ResultadosPea() {
	}

	public Integer getIdResultados() {
		return this.idResultados;
	}

	public void setIdResultados(Integer idResultados) {
		this.idResultados = idResultados;
	}

	public String getFormas() {
		return this.formas;
	}

	public void setFormas(String formas) {
		this.formas = formas;
	}

	public String getResultados() {
		return this.resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getTipoBilbiografia() {
		return this.tipoBilbiografia;
	}

	public void setTipoBilbiografia(String tipoBilbiografia) {
		this.tipoBilbiografia = tipoBilbiografia;
	}

	public Pea getPea() {
		return this.pea;
	}

	public void setPea(Pea pea) {
		this.pea = pea;
	}

}