package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.LineasInvestigacion;


/**
 * The persistent class for the investigador_linv database table.
 * 
 */
@Entity
@Table(name="investigador_linv", catalog = "bddcorpepn", schema = "`Proyectos`")
public class InvestigadorLinv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_lininv")
	private Integer idLininv;

	
	
	
	
	

	//bi-directional many-to-one association to Investigador
    @ManyToOne
	@JoinColumn(name="id_inv")
	private Investigador investigador;
    
    
    
  //bi-directional many-to-one association to Investigador
    @ManyToOne
	@JoinColumn(name="id_inv_lin")
	private LineasInvestigacion lin_inves;

    public InvestigadorLinv() {
    }

	public Integer getIdLininv() {
		return this.idLininv;
	}

	public void setIdLininv(Integer idLininv) {
		this.idLininv = idLininv;
	}


	public Investigador getInvestigador() {
		return this.investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public LineasInvestigacion getLin_inves() {
		return lin_inves;
	}

	public void setLin_inves(LineasInvestigacion lin_inves) {
		this.lin_inves = lin_inves;
	}
	
	
	
}