package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the psicologia database table.
 * 
 */
@Entity
@Table(name="psicologia", catalog="bddcorpepn", schema="`Medico`")
@NamedQuery(name="Psicologia.findAll", query="SELECT p FROM Psicologia p")
public class Psicologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_psicologia")
	private Integer idPsicologia;

	@Column(name="anamnesis_familiar")
	private String anamnesisFamiliar;

	@Column(name="anamnesis_personal")
	private String anamnesisPersonal;

	private String evaluacion;

	private String evolucion;

	@Column(name="id_paciente")
	private Integer idPaciente;

	@Column(name="path_anamnesis_fam")
	private String pathAnamnesisFam;

	public Psicologia() {
	}

	public Integer getIdPsicologia() {
		return this.idPsicologia;
	}

	public void setIdPsicologia(Integer idPsicologia) {
		this.idPsicologia = idPsicologia;
	}

	public String getAnamnesisFamiliar() {
		return this.anamnesisFamiliar;
	}

	public void setAnamnesisFamiliar(String anamnesisFamiliar) {
		this.anamnesisFamiliar = anamnesisFamiliar;
	}

	public String getAnamnesisPersonal() {
		return this.anamnesisPersonal;
	}

	public void setAnamnesisPersonal(String anamnesisPersonal) {
		this.anamnesisPersonal = anamnesisPersonal;
	}

	public String getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getEvolucion() {
		return this.evolucion;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getPathAnamnesisFam() {
		return this.pathAnamnesisFam;
	}

	public void setPathAnamnesisFam(String pathAnamnesisFam) {
		this.pathAnamnesisFam = pathAnamnesisFam;
	}

}