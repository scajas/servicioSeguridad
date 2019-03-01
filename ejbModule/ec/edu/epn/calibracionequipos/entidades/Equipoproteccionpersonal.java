package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipoproteccionpersonal database table.
 * 
 */
@Entity
@Table(name="equipoproteccionpersonal", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Equipoproteccionpersonal.findAll", query="SELECT e FROM Equipoproteccionpersonal e")
public class Equipoproteccionpersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_epp")
	private Integer idEpp;

	@Column(name="cantidad_epp")
	private Integer cantidadEpp;

	@Column(name="custorio_epp")
	private String custorioEpp;

	@Column(name="nombre_epp")
	private String nombreEpp;

	//bi-directional many-to-one association to Detalleequipoproteccionpersonal
	@OneToMany(mappedBy="equipoproteccionpersonal")
	private List<Detalleequipoproteccionpersonal> detalleequipoproteccionpersonals;

	//bi-directional many-to-one association to Estadoepp
	@ManyToOne
	@JoinColumn(name="id_estadoepp")
	private Estadoepp estadoepp;

	//bi-directional many-to-one association to Unidadepp
	@ManyToOne
	@JoinColumn(name="id_unidadepp")
	private Unidadepp unidadepp;

	//bi-directional many-to-many association to Gestionepp
	@ManyToMany(mappedBy="equipoproteccionpersonals")
	private List<Gestionepp> gestionepps;

	public Equipoproteccionpersonal() {
	}

	public Integer getIdEpp() {
		return this.idEpp;
	}

	public void setIdEpp(Integer idEpp) {
		this.idEpp = idEpp;
	}

	public Integer getCantidadEpp() {
		return this.cantidadEpp;
	}

	public void setCantidadEpp(Integer cantidadEpp) {
		this.cantidadEpp = cantidadEpp;
	}

	public String getCustorioEpp() {
		return this.custorioEpp;
	}

	public void setCustorioEpp(String custorioEpp) {
		this.custorioEpp = custorioEpp;
	}

	public String getNombreEpp() {
		return this.nombreEpp;
	}

	public void setNombreEpp(String nombreEpp) {
		this.nombreEpp = nombreEpp;
	}

	public List<Detalleequipoproteccionpersonal> getDetalleequipoproteccionpersonals() {
		return this.detalleequipoproteccionpersonals;
	}

	public void setDetalleequipoproteccionpersonals(List<Detalleequipoproteccionpersonal> detalleequipoproteccionpersonals) {
		this.detalleequipoproteccionpersonals = detalleequipoproteccionpersonals;
	}

	public Detalleequipoproteccionpersonal addDetalleequipoproteccionpersonal(Detalleequipoproteccionpersonal detalleequipoproteccionpersonal) {
		getDetalleequipoproteccionpersonals().add(detalleequipoproteccionpersonal);
		detalleequipoproteccionpersonal.setEquipoproteccionpersonal(this);

		return detalleequipoproteccionpersonal;
	}

	public Detalleequipoproteccionpersonal removeDetalleequipoproteccionpersonal(Detalleequipoproteccionpersonal detalleequipoproteccionpersonal) {
		getDetalleequipoproteccionpersonals().remove(detalleequipoproteccionpersonal);
		detalleequipoproteccionpersonal.setEquipoproteccionpersonal(null);

		return detalleequipoproteccionpersonal;
	}

	public Estadoepp getEstadoepp() {
		return this.estadoepp;
	}

	public void setEstadoepp(Estadoepp estadoepp) {
		this.estadoepp = estadoepp;
	}

	public Unidadepp getUnidadepp() {
		return this.unidadepp;
	}

	public void setUnidadepp(Unidadepp unidadepp) {
		this.unidadepp = unidadepp;
	}

	public List<Gestionepp> getGestionepps() {
		return this.gestionepps;
	}

	public void setGestionepps(List<Gestionepp> gestionepps) {
		this.gestionepps = gestionepps;
	}

}