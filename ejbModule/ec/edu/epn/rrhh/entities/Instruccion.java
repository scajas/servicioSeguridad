package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instruccion database table.
 * 
 */
@Entity
@Table(name = "instruccion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Instruccion.findAll", query="SELECT i FROM Instruccion i")
public class Instruccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ins")
	private Integer idIns;

	private String nivel;

	//bi-directional many-to-one association to Familiare
	@OneToMany(mappedBy="instruccion")
	private List<Familiare> familiares;

	public Instruccion() {
	}

	public Integer getIdIns() {
		return this.idIns;
	}

	public void setIdIns(Integer idIns) {
		this.idIns = idIns;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<Familiare> getFamiliares() {
		return this.familiares;
	}

	public void setFamiliares(List<Familiare> familiares) {
		this.familiares = familiares;
	}

	public Familiare addFamiliare(Familiare familiare) {
		getFamiliares().add(familiare);
		familiare.setInstruccion(this);

		return familiare;
	}

	public Familiare removeFamiliare(Familiare familiare) {
		getFamiliares().remove(familiare);
		familiare.setInstruccion(null);

		return familiare;
	}
	
}