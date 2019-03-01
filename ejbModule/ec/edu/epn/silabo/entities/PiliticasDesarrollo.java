package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the piliticas_desarrollo database table.
 * 
 */
@Entity
@Table(name="piliticas_desarrollo", catalog = "`bddcorpepn`", schema = "`Silabo`" )

@NamedQuery(name="PiliticasDesarrollo.findAll", query="SELECT p FROM PiliticasDesarrollo p")
public class PiliticasDesarrollo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_politicas")
	private Integer idPoliticas;

	@Column(name="desc_politica")
	private String descPolitica;

	private String politica;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public PiliticasDesarrollo() {
	}

	public Integer getIdPoliticas() {
		return this.idPoliticas;
	}

	public void setIdPoliticas(Integer idPoliticas) {
		this.idPoliticas = idPoliticas;
	}

	public String getDescPolitica() {
		return this.descPolitica;
	}

	public void setDescPolitica(String descPolitica) {
		this.descPolitica = descPolitica;
	}

	public String getPolitica() {
		return this.politica;
	}

	public void setPolitica(String politica) {
		this.politica = politica;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}