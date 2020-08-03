package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@Table(name = "clase", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_clase")
	private Integer codClase;

	@Column(name="descr_clase")
	private String descrClase;

	private String estado;

	@Column(name="nom_clase")
	private String nomClase;

	//bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy="clase")
	private List<HistoriaLaboral> historiaLaborals;

	public Clase() {
	}

	public Integer getCodClase() {
		return this.codClase;
	}

	public void setCodClase(Integer codClase) {
		this.codClase = codClase;
	}

	public String getDescrClase() {
		return this.descrClase;
	}

	public void setDescrClase(String descrClase) {
		this.descrClase = descrClase;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomClase() {
		return this.nomClase;
	}

	public void setNomClase(String nomClase) {
		this.nomClase = nomClase;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setClase(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setClase(null);

		return historiaLaboral;
	}

}