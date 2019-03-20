package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the hora_planificacion database table.
 * 
 */
@Entity
@Table(name="hora_planificacion", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="HoraPlanificacion.findAll", query="SELECT h FROM HoraPlanificacion h")
public class HoraPlanificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_horaplanificacion")
	private Integer idHoraplanificacion;

	@Column(name="activo_horaplanificacion")
	private String activoHoraplanificacion;

	@Column(name="hora_final")
	private Time horaFinal;

	@Column(name="hora_inicial")
	private Time horaInicial;

	//bi-directional many-to-one association to Diashora
	@OneToMany(mappedBy="horaPlanificacion")
	private List<Diashora> diashoras;

	public HoraPlanificacion() {
	}

	public Integer getIdHoraplanificacion() {
		return this.idHoraplanificacion;
	}

	public void setIdHoraplanificacion(Integer idHoraplanificacion) {
		this.idHoraplanificacion = idHoraplanificacion;
	}

	public String getActivoHoraplanificacion() {
		return this.activoHoraplanificacion;
	}

	public void setActivoHoraplanificacion(String activoHoraplanificacion) {
		this.activoHoraplanificacion = activoHoraplanificacion;
	}

	public Time getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Time getHoraInicial() {
		return this.horaInicial;
	}

	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public List<Diashora> getDiashoras() {
		return this.diashoras;
	}

	public void setDiashoras(List<Diashora> diashoras) {
		this.diashoras = diashoras;
	}

	public Diashora addDiashora(Diashora diashora) {
		getDiashoras().add(diashora);
		diashora.setHoraPlanificacion(this);

		return diashora;
	}

	public Diashora removeDiashora(Diashora diashora) {
		getDiashoras().remove(diashora);
		diashora.setHoraPlanificacion(null);

		return diashora;
	}

}