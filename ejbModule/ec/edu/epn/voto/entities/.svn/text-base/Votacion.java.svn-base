package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the votacion database table.
 * 
 */
@Entity
@Table(name="votacion" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Votacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_votacion")
	private Integer idVotacion;

	private String voto;

	//bi-directional many-to-one association to MiembroVoto
    @ManyToOne
	@JoinColumn(name="id_miembro")
	private MiembroVoto miembro;

	//bi-directional many-to-one association to RegVotación
    @ManyToOne
	@JoinColumn(name="id_reg_vot")
	private RegVotacion regVotación;
    
    
    private Double ponderado;

    public Votacion() {
    }

	public Integer getIdVotacion() {
		return this.idVotacion;
	}

	public void setIdVotacion(Integer idVotacion) {
		this.idVotacion = idVotacion;
	}

	public String getVoto() {
		return this.voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public MiembroVoto getMiembro() {
		return this.miembro;
	}

	public void setMiembro(MiembroVoto miembro) {
		this.miembro = miembro;
	}
	
	public RegVotacion getRegVotación() {
		return this.regVotación;
	}

	public void setRegVotación(RegVotacion regVotación) {
		this.regVotación = regVotación;
	}

	public Double getPonderado() {
		return ponderado;
	}

	public void setPonderado(Double ponderado) {
		this.ponderado = ponderado;
	}
	
}