package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the metodologia_de_ensenanza database table.
 * 
 */
@Entity

@Table(name="metodologia_de_ensenanza", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="MetodologiaDeEnsenanza.findAll", query="SELECT m FROM MetodologiaDeEnsenanza m")
public class MetodologiaDeEnsenanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_metodologia")
	private Integer idMetodologia;

	private String escenarios;

	@Column(name="metodo_ensenanza")
	private String metodoEnsenanza;

	private String recursos;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public MetodologiaDeEnsenanza() {
	}

	public Integer getIdMetodologia() {
		return this.idMetodologia;
	}

	public void setIdMetodologia(Integer idMetodologia) {
		this.idMetodologia = idMetodologia;
	}

	public String getEscenarios() {
		return this.escenarios;
	}

	public void setEscenarios(String escenarios) {
		this.escenarios = escenarios;
	}

	public String getMetodoEnsenanza() {
		return this.metodoEnsenanza;
	}

	public void setMetodoEnsenanza(String metodoEnsenanza) {
		this.metodoEnsenanza = metodoEnsenanza;
	}

	public String getRecursos() {
		return this.recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}