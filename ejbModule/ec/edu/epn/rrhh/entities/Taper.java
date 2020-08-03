package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taper database table.
 * 
 */
@Entity
@Table(name = "taper", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="Taper.findAll", query="SELECT t FROM Taper t")
public class Taper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String taper;

	@Column(name="desc_taper")
	private String descTaper;

	//bi-directional many-to-one association to Aper
	@OneToMany(mappedBy="taperBean")
	private List<Aper> apers;

	public Taper() {
	}

	public String getTaper() {
		return this.taper;
	}

	public void setTaper(String taper) {
		this.taper = taper;
	}

	public String getDescTaper() {
		return this.descTaper;
	}

	public void setDescTaper(String descTaper) {
		this.descTaper = descTaper;
	}

	public List<Aper> getApers() {
		return this.apers;
	}

	public void setApers(List<Aper> apers) {
		this.apers = apers;
	}

	public Aper addAper(Aper aper) {
		getApers().add(aper);
		aper.setTaperBean(this);

		return aper;
	}

	public Aper removeAper(Aper aper) {
		getApers().remove(aper);
		aper.setTaperBean(null);

		return aper;
	}

}