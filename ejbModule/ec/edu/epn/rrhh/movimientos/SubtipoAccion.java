package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subtipo_accion database table.
 * 
 */
@Entity

@Table(name = "subtipo_accion", catalog = "bddcorpepn", schema = "\"Rrhh\"")

@NamedQuery(name="SubtipoAccion.findAll", query="SELECT s FROM SubtipoAccion s")
public class SubtipoAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_stpa")
	private Integer idStpa;

	@Column(name="descripcion_subaccion")
	private String descripcionSubaccion;

	@Column(name="nombre_subaccion")
	private String nombreSubaccion;

	//bi-directional many-to-one association to AccionP
	@OneToMany(mappedBy="subtipoAccion")
	private List<AccionP> accionPs;

	//bi-directional many-to-one association to TipoAccion
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tpa")
	private TipoAccion tipoAccion;

	public SubtipoAccion() {
	}

	public Integer getIdStpa() {
		return this.idStpa;
	}

	public void setIdStpa(Integer idStpa) {
		this.idStpa = idStpa;
	}

	public String getDescripcionSubaccion() {
		return this.descripcionSubaccion;
	}

	public void setDescripcionSubaccion(String descripcionSubaccion) {
		this.descripcionSubaccion = descripcionSubaccion;
	}

	public String getNombreSubaccion() {
		return this.nombreSubaccion;
	}

	public void setNombreSubaccion(String nombreSubaccion) {
		this.nombreSubaccion = nombreSubaccion;
	}

	public List<AccionP> getAccionPs() {
		return this.accionPs;
	}

	public void setAccionPs(List<AccionP> accionPs) {
		this.accionPs = accionPs;
	}

	public AccionP addAccionP(AccionP accionP) {
		getAccionPs().add(accionP);
		accionP.setSubtipoAccion(this);

		return accionP;
	}

	public AccionP removeAccionP(AccionP accionP) {
		getAccionPs().remove(accionP);
		accionP.setSubtipoAccion(null);

		return accionP;
	}

	public TipoAccion getTipoAccion() {
		return this.tipoAccion;
	}

	public void setTipoAccion(TipoAccion tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

}