package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadesproceso database table.
 * 
 */
@Entity
@Table(name="actividadesproceso", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Actividadesproceso.findAll", query="SELECT a FROM Actividadesproceso a")
public class Actividadesproceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_actividadproceso")
	private Integer idActividadproceso;

	@Column(name="nombre_actividadproceso")
	private String nombreActividadproceso;

	//bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name="id_proceso")
	private Gestionsoo gestionsoo;

	public Actividadesproceso() {
	}

	public Integer getIdActividadproceso() {
		return this.idActividadproceso;
	}

	public void setIdActividadproceso(Integer idActividadproceso) {
		this.idActividadproceso = idActividadproceso;
	}

	public String getNombreActividadproceso() {
		return this.nombreActividadproceso;
	}

	public void setNombreActividadproceso(String nombreActividadproceso) {
		this.nombreActividadproceso = nombreActividadproceso;
	}

	public Gestionsoo getGestionsoo() {
		return this.gestionsoo;
	}

	public void setGestionsoo(Gestionsoo gestionsoo) {
		this.gestionsoo = gestionsoo;
	}

}