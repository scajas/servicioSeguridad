package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.*;


/**
 * The persistent class for the carga_academica_sae database table.
 * 
 */
@Entity
@Table(name="carga_academica_sae",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CargaAcademicaSae.findAll", query="SELECT c FROM CargaAcademicaSae c")
public class CargaAcademicaSae implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_carga_academica_sae")
	@SequenceGenerator(name = "\"GestionDocente\".sec_carga_academica_sae", sequenceName = "\"GestionDocente\".sec_carga_academica_sae", allocationSize = 1)
	@Column(name="id_carga_academica")
	private Integer idCargaAcademica;
	
	@Column(name="num_dicta_materia")
	private Integer numDictaMateria;
	
	@Column(name="posee_asistente")
	private String poseeAsistente;	

	@Column(name="capacidad_alumnos_sae")
	private Integer capacidadAlumnosSae;

	@Column(name="cod_materia_sae")
	private String codMateriaSae;

	@Column(name="horas_modulo_sae")
	private Integer horasModuloSae;

	@Column(name="horas_total_semana_sae")
	private Integer horasTotalSemanaSae;

	@Column(name="id_pensum")
	private Integer idPensum;

	private String nced;

	@Column(name="nom_carrera_sae")
	private String nomCarreraSae;

	@Column(name="nom_materia_sae")
	private String nomMateriaSae;

	@Column(name="nom_paralelo_sae")
	private String nomParaleloSae;

	@Column(name="num_alumnos_sae")
	private Integer numAlumnosSae;
	
	@Column(name="hetero_materia")
	private Double heteroMateria;
	
	private String aula;
	
	/*private String regimen;
	
	private String nivel;*/
	
	
	/**PARA CALCULOS CON DECIMAL 2*/
	@Transient
	private BigDecimal heteroMateriaDecimal;

	public CargaAcademicaSae() {
	}

	public Integer getIdCargaAcademica() {
		return this.idCargaAcademica;
	}

	public void setIdCargaAcademica(Integer idCargaAcademica) {
		this.idCargaAcademica = idCargaAcademica;
	}

	public Integer getCapacidadAlumnosSae() {
		return this.capacidadAlumnosSae;
	}

	public void setCapacidadAlumnosSae(Integer capacidadAlumnosSae) {
		this.capacidadAlumnosSae = capacidadAlumnosSae;
	}

	public String getCodMateriaSae() {
		return this.codMateriaSae;
	}

	public void setCodMateriaSae(String codMateriaSae) {
		this.codMateriaSae = codMateriaSae;
	}

	public Integer getHorasModuloSae() {
		return this.horasModuloSae;
	}

	public void setHorasModuloSae(Integer horasModuloSae) {
		this.horasModuloSae = horasModuloSae;
	}

	public Integer getHorasTotalSemanaSae() {
		return this.horasTotalSemanaSae;
	}

	public void setHorasTotalSemanaSae(Integer horasTotalSemanaSae) {
		this.horasTotalSemanaSae = horasTotalSemanaSae;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomCarreraSae() {
		return this.nomCarreraSae;
	}

	public void setNomCarreraSae(String nomCarreraSae) {
		this.nomCarreraSae = nomCarreraSae;
	}

	

	public String getNomParaleloSae() {
		return this.nomParaleloSae;
	}

	public void setNomParaleloSae(String nomParaleloSae) {
		this.nomParaleloSae = nomParaleloSae;
	}

	public Integer getNumAlumnosSae() {
		return this.numAlumnosSae;
	}

	public void setNumAlumnosSae(Integer numAlumnosSae) {
		this.numAlumnosSae = numAlumnosSae;
	}

	/**
	 * @return the numDictaMateria
	 */
	public Integer getNumDictaMateria() {
		return numDictaMateria;
	}

	/**
	 * @param numDictaMateria the numDictaMateria to set
	 */
	public void setNumDictaMateria(Integer numDictaMateria) {
		this.numDictaMateria = numDictaMateria;
	}

	/**
	 * @return the poseeAsistente
	 */
	public String getPoseeAsistente() {
		return poseeAsistente;
	}

	/**
	 * @param poseeAsistente the poseeAsistente to set
	 */
	public void setPoseeAsistente(String poseeAsistente) {
		this.poseeAsistente = poseeAsistente;
	}

	/**
	 * @return the nomMateriaSae
	 */
	public String getNomMateriaSae() {
		return nomMateriaSae;
	}

	/**
	 * @param nomMateriaSae the nomMateriaSae to set
	 */
	public void setNomMateriaSae(String nomMateriaSae) {
		this.nomMateriaSae = nomMateriaSae;
	}

	/**
	 * @return the heteroMateria
	 */
	public Double getHeteroMateria() {
		return heteroMateria;
	}

	/**
	 * @param heteroMateria the heteroMateria to set
	 */
	public void setHeteroMateria(Double heteroMateria) {
		this.heteroMateria = heteroMateria;
	}

	/**
	 * @return the heteroMateriaDecimal
	 */
	public BigDecimal getHeteroMateriaDecimal() {
		
		heteroMateriaDecimal = new BigDecimal(heteroMateria==null?0.0:heteroMateria);
		return heteroMateriaDecimal.setScale(2, RoundingMode.HALF_UP);
		//return heteroMateriaDecimal;
	}

	/**
	 * @param heteroMateriaDecimal the heteroMateriaDecimal to set
	 */
	public void setHeteroMateriaDecimal(BigDecimal heteroMateriaDecimal) {
		this.heteroMateriaDecimal = heteroMateriaDecimal;
	}

	/**
	 * @return the aula
	 */
	public String getAula() {
		return aula;
	}

	/**
	 * @param aula the aula to set
	 */
	public void setAula(String aula) {
		this.aula = aula;
	}

	
}