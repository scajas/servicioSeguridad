package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topografiacie database table.
 * 
 */
@Entity
@Table(name="topografiacie", catalog="bddcorpepn", schema="`Medico`")
public class Topografiacie implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3899757340068716222L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_topografia")
	private Integer idTopografia;

	@Column(name="codigo_top")
	private String codigoTop;

	@Column(name="nombre_top")
	private String nombreTop;

	//bi-directional many-to-one association to Topografiacie
	@ManyToOne
	@JoinColumn(name="id_grupotopografia")
	private Topografiacie topografiacie;

	//bi-directional many-to-one association to Topografiacie
	@OneToMany(mappedBy="topografiacie")
	private List<Topografiacie> topografiacies;

	public Topografiacie() {
	}

	public Integer getIdTopografia() {
		return this.idTopografia;
	}

	public void setIdTopografia(Integer idTopografia) {
		this.idTopografia = idTopografia;
	}

	public String getCodigoTop() {
		return this.codigoTop;
	}

	public void setCodigoTop(String codigoTop) {
		this.codigoTop = codigoTop;
	}

	public String getNombreTop() {
		return this.nombreTop;
	}

	public void setNombreTop(String nombreTop) {
		this.nombreTop = nombreTop;
	}

	public Topografiacie getTopografiacie() {
		return this.topografiacie;
	}

	public void setTopografiacie(Topografiacie topografiacie) {
		this.topografiacie = topografiacie;
	}

	public List<Topografiacie> getTopografiacies() {
		return this.topografiacies;
	}

	public void setTopografiacies(List<Topografiacie> topografiacies) {
		this.topografiacies = topografiacies;
	}

	public Topografiacie addTopografiacy(Topografiacie topografiacy) {
		getTopografiacies().add(topografiacy);
		topografiacy.setTopografiacie(this);

		return topografiacy;
	}

	public Topografiacie removeTopografiacy(Topografiacie topografiacy) {
		getTopografiacies().remove(topografiacy);
		topografiacy.setTopografiacie(null);

		return topografiacy;
	}

}