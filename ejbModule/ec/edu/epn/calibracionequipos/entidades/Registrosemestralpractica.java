package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the registrosemestralpracticas database table.
 * 
 */
@Entity
@Table(name="registrosemestralpracticas", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Registrosemestralpractica.findAll", query="SELECT r FROM Registrosemestralpractica r")
public class Registrosemestralpractica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_registrosemestralpracticas")
	private Integer idRegistrosemestralpracticas;

	@Column(name="gruiaprac_regsemp")
	private String gruiapracRegsemp;

	@Column(name="id_semestre")
	private Integer idSemestre;

	@Column(name="regpracrlzdas_regsemp")
	private String regpracrlzdasRegsemp;

	//bi-directional many-to-many association to Laboratorioscalibracionequipo
	@ManyToMany
	@JoinTable(
		name="labsem"
		, joinColumns={
			@JoinColumn(name="id_registrosemestralpracticas")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_laboratorio")
			}
		)
	private List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos;

	public Registrosemestralpractica() {
	}

	public Integer getIdRegistrosemestralpracticas() {
		return this.idRegistrosemestralpracticas;
	}

	public void setIdRegistrosemestralpracticas(Integer idRegistrosemestralpracticas) {
		this.idRegistrosemestralpracticas = idRegistrosemestralpracticas;
	}

	public String getGruiapracRegsemp() {
		return this.gruiapracRegsemp;
	}

	public void setGruiapracRegsemp(String gruiapracRegsemp) {
		this.gruiapracRegsemp = gruiapracRegsemp;
	}

	public Integer getIdSemestre() {
		return this.idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getRegpracrlzdasRegsemp() {
		return this.regpracrlzdasRegsemp;
	}

	public void setRegpracrlzdasRegsemp(String regpracrlzdasRegsemp) {
		this.regpracrlzdasRegsemp = regpracrlzdasRegsemp;
	}

	public List<Laboratorioscalibracionequipo> getLaboratorioscalibracionequipos() {
		return this.laboratorioscalibracionequipos;
	}

	public void setLaboratorioscalibracionequipos(List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos) {
		this.laboratorioscalibracionequipos = laboratorioscalibracionequipos;
	}

}