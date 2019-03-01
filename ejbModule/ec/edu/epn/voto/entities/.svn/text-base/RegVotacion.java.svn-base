package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reg_votación database table.
 * 
 */
@Entity
@Table(name="reg_votacion" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class RegVotacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reg_vot")
	private Integer idRegVot;

	private String estaod;

	@Column(name="id_miembro")
	private Integer idMiembro;

	@Column(name="vot_abs")
	private Double votAbs;

	@Column(name="vot_encn")
	private Double votEncn;

	@Column(name="vot_favor")
	private Double votFavor;
	
	@Column(name="total_ponderado")
	private Double totalPond;
	
	@Column(name="totpond_mitad")
	private Double totalPondMitad;
	
	
	private String resultado;

	//bi-directional many-to-one association to Mocion
    @ManyToOne
	@JoinColumn(name="id_mocion")
	private Mocion mocion;

	//bi-directional many-to-one association to Votacion
	@OneToMany(mappedBy="regVotación")
	private List<Votacion> votacions;

    public RegVotacion() {
    }

	public Integer getIdRegVot() {
		return this.idRegVot;
	}

	public void setIdRegVot(Integer idRegVot) {
		this.idRegVot = idRegVot;
	}

	public String getEstaod() {
		return this.estaod;
	}

	public void setEstaod(String estaod) {
		this.estaod = estaod;
	}

	public Integer getIdMiembro() {
		return this.idMiembro;
	}

	public void setIdMiembro(Integer idMiembro) {
		this.idMiembro = idMiembro;
	}

	public Double getVotAbs() {
		return this.votAbs;
	}

	public void setVotAbs(Double votAbs) {
		this.votAbs = votAbs;
	}

	public Double getVotEncn() {
		return this.votEncn;
	}

	public void setVotEncn(Double votEncn) {
		this.votEncn = votEncn;
	}

	public Double getVotFavor() {
		return this.votFavor;
	}

	public void setVotFavor(Double votFavor) {
		this.votFavor = votFavor;
	}

	public Mocion getMocion() {
		return this.mocion;
	}

	public void setMocion(Mocion mocion) {
		this.mocion = mocion;
	}
	
	public List<Votacion> getVotacions() {
		return this.votacions;
	}

	public void setVotacions(List<Votacion> votacions) {
		this.votacions = votacions;
	}

	public Double getTotalPond() {
		return totalPond;
	}

	public void setTotalPond(Double totalPond) {
		this.totalPond = totalPond;
	}

	public Double getTotalPondMitad() {
		return totalPondMitad;
	}

	public void setTotalPondMitad(Double totalPondMitad) {
		this.totalPondMitad = totalPondMitad;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}