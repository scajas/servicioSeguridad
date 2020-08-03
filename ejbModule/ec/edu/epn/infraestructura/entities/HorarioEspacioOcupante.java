package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario_espacio_ocupante database table.
 * 
 */
@Entity
@Table(name = "horario_espacio_ocupante", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class HorarioEspacioOcupante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_heo")
	private String idHeo;

	private String descripcion;

	//bi-directional many-to-one association to HorarioEspacio
    @ManyToOne
	@JoinColumn(name="id_horario_espacio")
	private HorarioEspacio horarioEspacio;

	//bi-directional many-to-one association to Ocupante
    @ManyToOne
	@JoinColumn(name="id_ocupante")
	private Ocupante ocupante;

    public HorarioEspacioOcupante() {
    }

	public String getIdHeo() {
		return this.idHeo;
	}

	public void setIdHeo(String idHeo) {
		this.idHeo = idHeo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public HorarioEspacio getHorarioEspacio() {
		return this.horarioEspacio;
	}

	public void setHorarioEspacio(HorarioEspacio horarioEspacio) {
		this.horarioEspacio = horarioEspacio;
	}
	
	public Ocupante getOcupante() {
		return this.ocupante;
	}

	public void setOcupante(Ocupante ocupante) {
		this.ocupante = ocupante;
	}
	
}