package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orga_adic database table.
 * 
 */
@Entity
@Table(name="orga_adic", catalog = "`bddcorpepn`", schema = "`Convenios`")

public class OrgaAdic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_orgac")
	private Integer idOrgac;

	@Column(name="id_organizacion")
	private Integer idOrganizacion;

	//bi-directional many-to-one association to Convenio
    @ManyToOne
	@JoinColumn(name="id_conv")
	private Convenio convenio;

    public OrgaAdic() {
    }

	public Integer getIdOrgac() {
		return this.idOrgac;
	}

	public void setIdOrgac(Integer idOrgac) {
		this.idOrgac = idOrgac;
	}

	public Integer getIdOrganizacion() {
		return this.idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
}