package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dias_planificacion database table.
 * 
 */
@Entity
@Table(name="dias_planificacion", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="DiasPlanificacion.findAll", query="SELECT d FROM DiasPlanificacion d")
public class DiasPlanificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_diaplanificacion")
	private Integer idDiaplanificacion;

	@Column(name="estado_diaplanificacion")
	private String estadoDiaplanificacion;

	@Column(name="nombre_diaplanificacio")
	private String nombreDiaplanificacio;

	//bi-directional many-to-one association to Diashora
	@OneToMany(mappedBy="diasPlanificacion")
	private List<Diashora> diashoras;

	public DiasPlanificacion() {
	}

	public Integer getIdDiaplanificacion() {
		return this.idDiaplanificacion;
	}

	public void setIdDiaplanificacion(Integer idDiaplanificacion) {
		this.idDiaplanificacion = idDiaplanificacion;
	}

	public String getEstadoDiaplanificacion() {
		return this.estadoDiaplanificacion;
	}

	public void setEstadoDiaplanificacion(String estadoDiaplanificacion) {
		this.estadoDiaplanificacion = estadoDiaplanificacion;
	}

	public String getNombreDiaplanificacio() {
		return this.nombreDiaplanificacio;
	}

	public void setNombreDiaplanificacio(String nombreDiaplanificacio) {
		this.nombreDiaplanificacio = nombreDiaplanificacio;
	}

	public List<Diashora> getDiashoras() {
		return this.diashoras;
	}

	public void setDiashoras(List<Diashora> diashoras) {
		this.diashoras = diashoras;
	}

	public Diashora addDiashora(Diashora diashora) {
		getDiashoras().add(diashora);
		diashora.setDiasPlanificacion(this);

		return diashora;
	}

	public Diashora removeDiashora(Diashora diashora) {
		getDiashoras().remove(diashora);
		diashora.setDiasPlanificacion(null);

		return diashora;
	}

}