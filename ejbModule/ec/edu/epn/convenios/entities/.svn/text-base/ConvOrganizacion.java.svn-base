package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the conv_organizacion database table.
 * 
 */
@Entity
@Table(name = "conv_organizacion" , catalog = "`bddcorpepn`", schema = "`Convenios`")
public class ConvOrganizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_conv_org")
	private Integer idConvOrg;

	@ManyToOne
	@JoinColumn(name = "id_conv")
	private Convenio convenio;

	// bi-directional many-to-one association to EstadoC
	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	private Organizacion organizacion;

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public ConvOrganizacion() {
	}

	public Integer getIdConvOrg() {
		return this.idConvOrg;
	}

	public void setIdConvOrg(Integer idConvOrg) {
		this.idConvOrg = idConvOrg;
	}

}