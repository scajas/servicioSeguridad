package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tpublic database table.
 * 
 */
@Entity
@NamedQuery(name="Tpublic.findAll", query="SELECT t FROM Tpublic t")
public class Tpublic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cod_area_con")
	private String codAreaCon;

	@Column(name="id_public")
	private String idPublic;

	@Id
	@Column(name="id_tipo_public")
	private String idTipoPublic;

	private String nced;

	private String subindice;

	public Tpublic() {
	}

	public String getCodAreaCon() {
		return this.codAreaCon;
	}

	public void setCodAreaCon(String codAreaCon) {
		this.codAreaCon = codAreaCon;
	}

	public String getIdPublic() {
		return this.idPublic;
	}

	public void setIdPublic(String idPublic) {
		this.idPublic = idPublic;
	}

	public String getIdTipoPublic() {
		return this.idTipoPublic;
	}

	public void setIdTipoPublic(String idTipoPublic) {
		this.idTipoPublic = idTipoPublic;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getSubindice() {
		return this.subindice;
	}

	public void setSubindice(String subindice) {
		this.subindice = subindice;
	}

}