package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carga_academica_preplanif database table.
 * 
 */
@Entity
@Table(name="carga_academica_preplanif",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CargaAcademicaPreplanif.findAll", query="SELECT c FROM CargaAcademicaPreplanif c")
public class CargaAcademicaPreplanif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carga_preplanif")
	private Integer idCargaPreplanif;

	private String aula;

	@Column(name="cod_materia")
	private String codMateria;

	@Column(name="horas_modulo")
	private Integer horasModulo;

	@Column(name="horas_total_semana_")
	private Integer horasTotalSemana;

	@Column(name="nom_carrera")
	private String nomCarrera;

	@Column(name="nom_materia")
	private String nomMateria;

	@Column(name="nom_paralelo")
	private String nomParalelo;

	//bi-directional many-to-one association to PreplanificacionDocencia
	@ManyToOne
	@JoinColumn(name="id_preplanif")
	private PreplanificacionDocencia preplanificacionDocencia;

	public CargaAcademicaPreplanif() {
	}

	public Integer getIdCargaPreplanif() {
		return this.idCargaPreplanif;
	}

	public void setIdCargaPreplanif(Integer idCargaPreplanif) {
		this.idCargaPreplanif = idCargaPreplanif;
	}

	public String getAula() {
		return this.aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getCodMateria() {
		return this.codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public Integer getHorasModulo() {
		return this.horasModulo;
	}

	public void setHorasModulo(Integer horasModulo) {
		this.horasModulo = horasModulo;
	}

	public Integer getHorasTotalSemana() {
		return this.horasTotalSemana;
	}

	public void setHorasTotalSemana(Integer horasTotalSemana) {
		this.horasTotalSemana = horasTotalSemana;
	}

	public String getNomCarrera() {
		return this.nomCarrera;
	}

	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}

	public String getNomMateria() {
		return this.nomMateria;
	}

	public void setNomMateria(String nomMateria) {
		this.nomMateria = nomMateria;
	}

	public String getNomParalelo() {
		return this.nomParalelo;
	}

	public void setNomParalelo(String nomParalelo) {
		this.nomParalelo = nomParalelo;
	}

	public PreplanificacionDocencia getPreplanificacionDocencia() {
		return this.preplanificacionDocencia;
	}

	public void setPreplanificacionDocencia(PreplanificacionDocencia preplanificacionDocencia) {
		this.preplanificacionDocencia = preplanificacionDocencia;
	}

}