package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distributivo database table.
 * 
 */
@Entity
@Table(name = "distributivo", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Distributivo.findAll", query="SELECT d FROM Distributivo d")
public class Distributivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_distributivo")
	private Integer idDistributivo;

	private String cargo;

	private String estado;

	@Column(name="partida_general")
	private String partidaGeneral;

	@Column(name="partida_individual")
	private String partidaIndividual;

	private double rmu;

	//bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy="distributivo")
	private List<HistoriaLaboral> historiaLaborals;

	public Distributivo() {
	}

	public Integer getIdDistributivo() {
		return this.idDistributivo;
	}

	public void setIdDistributivo(Integer idDistributivo) {
		this.idDistributivo = idDistributivo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPartidaGeneral() {
		return this.partidaGeneral;
	}

	public void setPartidaGeneral(String partidaGeneral) {
		this.partidaGeneral = partidaGeneral;
	}

	public String getPartidaIndividual() {
		return this.partidaIndividual;
	}

	public void setPartidaIndividual(String partidaIndividual) {
		this.partidaIndividual = partidaIndividual;
	}

	public double getRmu() {
		return this.rmu;
	}

	public void setRmu(double rmu) {
		this.rmu = rmu;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setDistributivo(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setDistributivo(null);

		return historiaLaboral;
	}

}