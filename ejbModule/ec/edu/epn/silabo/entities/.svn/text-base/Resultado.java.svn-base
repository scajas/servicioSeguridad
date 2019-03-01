package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resultados database table.
 * 
 */
@Entity
@Table(name="resultados", catalog = "`bddcorpepn`", schema = "`Silabo`" )

@NamedQuery(name="Resultado.findAll", query="SELECT r FROM Resultado r")
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resultados")
	private Integer idResultados;

	private String formas;

	private String resultados;

	@Column(name="tipo_bilbiografia")
	private String tipoBilbiografia;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public Resultado() {
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

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}