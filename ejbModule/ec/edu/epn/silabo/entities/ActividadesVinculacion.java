package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividades_vinculacion database table.
 * 
 */
@Entity
@Table(name="actividades_vinculacion", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="ActividadesVinculacion.findAll", query="SELECT a FROM ActividadesVinculacion a")
public class ActividadesVinculacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_actividades")
	private Integer idActividades;

	private String actividad;

	@Column(name="des_act")
	private String desAct;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;

	public ActividadesVinculacion() {
	}

	public Integer getIdActividades() {
		return this.idActividades;
	}

	public void setIdActividades(Integer idActividades) {
		this.idActividades = idActividades;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getDesAct() {
		return this.desAct;
	}

	public void setDesAct(String desAct) {
		this.desAct = desAct;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

}