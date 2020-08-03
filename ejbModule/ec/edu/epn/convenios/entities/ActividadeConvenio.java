package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividades database table.
 * 
 */
@Entity(name = "ActividadeConvenio")
@Table(name="actividades", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class ActividadeConvenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_act")
	private Integer idAct;

	@Column(name="nombre_act")
	private String nombreAct;

	//bi-directional many-to-one association to Convenio
    @ManyToOne
	@JoinColumn(name="id_conv")
	private Convenio convenio;

    public ActividadeConvenio() {
    }

	public Integer getIdAct() {
		return this.idAct;
	}

	public void setIdAct(Integer idAct) {
		this.idAct = idAct;
	}

	public String getNombreAct() {
		return this.nombreAct;
	}

	public void setNombreAct(String nombreAct) {
		this.nombreAct = nombreAct;
	}

	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
}