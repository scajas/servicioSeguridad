package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipo_c database table.
 * 
 */
@Entity
@Table(name="tipo_c", catalog = "`bddcorpepn`", schema = "`Convenios`")

public class TipoC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoc")
	private Integer idTipoc;

	@Column(name="descr_tc")
	private String descrTc;

	@Column(name="nombre_tc")
	private String nombreTc;

	//bi-directional many-to-one association to Convenio
	@OneToMany(mappedBy="tipoC")
	private List<Convenio> convenios;

    public TipoC() {
    }

	public Integer getIdTipoc() {
		return this.idTipoc;
	}

	public void setIdTipoc(Integer idTipoc) {
		this.idTipoc = idTipoc;
	}

	public String getDescrTc() {
		return this.descrTc;
	}

	public void setDescrTc(String descrTc) {
		this.descrTc = descrTc;
	}

	public String getNombreTc() {
		return this.nombreTc;
	}

	public void setNombreTc(String nombreTc) {
		this.nombreTc = nombreTc;
	}

	public List<Convenio> getConvenios() {
		return this.convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}
	
}