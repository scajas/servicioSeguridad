package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the practicas_laboratorio database table.
 * 
 */
@Entity
@Table(name="practicas_laboratorio", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="PracticasLaboratorio.findAll", query="SELECT p FROM PracticasLaboratorio p")
public class PracticasLaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_practica")
	private Integer idPractica;

	@Column(name="desc_practicas")
	private String descPracticas;

	@Column(name="nombre_practica")
	private String nombrePractica;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public PracticasLaboratorio() {
	}

	public Integer getIdPractica() {
		return this.idPractica;
	}

	public void setIdPractica(Integer idPractica) {
		this.idPractica = idPractica;
	}

	public String getDescPracticas() {
		return this.descPracticas;
	}

	public void setDescPracticas(String descPracticas) {
		this.descPracticas = descPracticas;
	}

	public String getNombrePractica() {
		return this.nombrePractica;
	}

	public void setNombrePractica(String nombrePractica) {
		this.nombrePractica = nombrePractica;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}