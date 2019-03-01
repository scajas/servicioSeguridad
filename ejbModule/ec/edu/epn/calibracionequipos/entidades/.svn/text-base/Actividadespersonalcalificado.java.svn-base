package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the actividadespersonalcalificado database table.
 * 
 */
@Entity
@Table(name = "actividadespersonalcalificado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Actividadespersonalcalificado.findAll", query = "SELECT a FROM Actividadespersonalcalificado a")
public class Actividadespersonalcalificado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_actividadecalif")
	private Integer idActividadecalif;

	@Column(name = "actividad_actividadecalif")
	private String actividadActividadecalif;

	// bi-directional many-to-many association to Personalcalificado
	/*
	 * @ManyToMany(mappedBy="actividadespersonalcalificados") private
	 * List<Personalcalificado> personalcalificados;
	 */
	@OneToMany(mappedBy = "actividades")
	private List<PerCalAct> perCalAct;

	public List<PerCalAct> getPerCalAct() {
		return perCalAct;
	}

	public void setPerCalAct(List<PerCalAct> perCalAct) {
		this.perCalAct = perCalAct;
	}

	public Actividadespersonalcalificado() {
	}

	public Integer getIdActividadecalif() {
		return this.idActividadecalif;
	}

	public void setIdActividadecalif(Integer idActividadecalif) {
		this.idActividadecalif = idActividadecalif;
	}

	public String getActividadActividadecalif() {
		return this.actividadActividadecalif;
	}

	public void setActividadActividadecalif(String actividadActividadecalif) {
		this.actividadActividadecalif = actividadActividadecalif;
	}

	/*
	 * public List<Personalcalificado> getPersonalcalificados() { return
	 * this.personalcalificados; }
	 * 
	 * public void setPersonalcalificados(List<Personalcalificado>
	 * personalcalificados) { this.personalcalificados = personalcalificados; }
	 */
}