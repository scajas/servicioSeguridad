package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the corte_evaluacion database table.
 * 
 */
@Entity
@Table(name="materia_docente_sae",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="MateriaDocenteSae.findAll", query="SELECT m FROM MateriaDocenteSae m")
public class MateriaDocenteSae implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_mat_sae")
	@SequenceGenerator(name = "\"GestionDocente\".sec_mat_sae", sequenceName = "\"GestionDocente\".sec_mat_sae", allocationSize = 1)
	@Column(name="id_mat_sae")
	private Integer idMatSae;

	@Column(name="nced")
	private String nCed;

	@Column(name="nom_materia")
	private String nomMateria;
	
	@Column(name="cod_materia")
	private String codMateria;
	
	@Column(name="nom_paralelo")
	private String nomParalelo;
	
	@Column(name="carrera")
	private String carrera;
	
	
	@Column(name="facutlad")
	private String facutlad;
	
	@Column(name="periodo")
	private String periodo;

	@Column(name="horas")
	private Integer horas;
	
	@Column(name="nivel")
	private String nivel;
	
	@Column(name="num_estudiantes")
	private Integer numEstudiantes;

	public MateriaDocenteSae() {
	}

	/**
	 * @return the idMatSae
	 */
	public Integer getIdMatSae() {
		return idMatSae;
	}

	/**
	 * @return the nCed
	 */
	public String getnCed() {
		return nCed;
	}

	/**
	 * @return the nomMateria
	 */
	public String getNomMateria() {
		return nomMateria;
	}

	/**
	 * @return the codMateria
	 */
	public String getCodMateria() {
		return codMateria;
	}

	/**
	 * @return the nomParalelo
	 */
	public String getNomParalelo() {
		return nomParalelo;
	}

	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @return the facutlad
	 */
	public String getFacutlad() {
		return facutlad;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @return the horas
	 */
	public Integer getHoras() {
		return horas;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @return the numEstudiantes
	 */
	public Integer getNumEstudiantes() {
		return numEstudiantes;
	}

	/**
	 * @param idMatSae the idMatSae to set
	 */
	public void setIdMatSae(Integer idMatSae) {
		this.idMatSae = idMatSae;
	}

	/**
	 * @param nCed the nCed to set
	 */
	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	/**
	 * @param nomMateria the nomMateria to set
	 */
	public void setNomMateria(String nomMateria) {
		this.nomMateria = nomMateria;
	}

	/**
	 * @param codMateria the codMateria to set
	 */
	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	/**
	 * @param nomParalelo the nomParalelo to set
	 */
	public void setNomParalelo(String nomParalelo) {
		this.nomParalelo = nomParalelo;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @param facutlad the facutlad to set
	 */
	public void setFacutlad(String facutlad) {
		this.facutlad = facutlad;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @param numEstudiantes the numEstudiantes to set
	 */
	public void setNumEstudiantes(Integer numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	
}