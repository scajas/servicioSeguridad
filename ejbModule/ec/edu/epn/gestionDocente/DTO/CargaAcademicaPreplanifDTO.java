package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;

public class CargaAcademicaPreplanifDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5148480640227576427L;
	

	private String aula;
	private String codMateria;
	private Integer horasModulo;
	private Integer horasTotalSemana;
	private String nomCarrera;
	private String nomMateria;
	private String nomParalelo;
	private String nomMateriaComp;
	
	
	public CargaAcademicaPreplanifDTO(String aula, String codMateria, Integer horasModulo, Integer horasTotalSemana,
										String nomCarrera, String nomMateria, String nomParalelo, String nomMateriaComp) {
		super();
		
		this.aula=aula;
		this.codMateria= codMateria;
		this.horasModulo= horasModulo;
		this.horasTotalSemana= horasTotalSemana;
		this.nomCarrera= nomCarrera;
		this.nomMateria= nomMateria;
		this.nomParalelo= nomParalelo;
		this.nomMateriaComp= nomMateriaComp;
	}
	
	/**
	 * @return the aula
	 */
	public String getAula() {
		return aula;
	}
	/**
	 * @return the codMateria
	 */
	public String getCodMateria() {
		return codMateria;
	}
	/**
	 * @return the horasModulo
	 */
	public Integer getHorasModulo() {
		return horasModulo;
	}
	/**
	 * @return the horasTotalSemana
	 */
	public Integer getHorasTotalSemana() {
		return horasTotalSemana;
	}
	/**
	 * @return the nomCarrera
	 */
	public String getNomCarrera() {
		return nomCarrera;
	}
	/**
	 * @return the nomMateria
	 */
	public String getNomMateria() {
		return nomMateria;
	}
	/**
	 * @return the nomParalelo
	 */
	public String getNomParalelo() {
		return nomParalelo;
	}
	/**
	 * @param aula the aula to set
	 */
	public void setAula(String aula) {
		this.aula = aula;
	}
	/**
	 * @param codMateria the codMateria to set
	 */
	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}
	/**
	 * @param horasModulo the horasModulo to set
	 */
	public void setHorasModulo(Integer horasModulo) {
		this.horasModulo = horasModulo;
	}
	/**
	 * @param horasTotalSemana the horasTotalSemana to set
	 */
	public void setHorasTotalSemana(Integer horasTotalSemana) {
		this.horasTotalSemana = horasTotalSemana;
	}
	/**
	 * @param nomCarrera the nomCarrera to set
	 */
	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}
	/**
	 * @param nomMateria the nomMateria to set
	 */
	public void setNomMateria(String nomMateria) {
		this.nomMateria = nomMateria;
	}
	/**
	 * @param nomParalelo the nomParalelo to set
	 */
	public void setNomParalelo(String nomParalelo) {
		this.nomParalelo = nomParalelo;
	}
	/**
	 * @return the nomMateriaComp
	 */
	public String getNomMateriaComp() {
		return nomMateriaComp;
	}
	/**
	 * @param nomMateriaComp the nomMateriaComp to set
	 */
	public void setNomMateriaComp(String nomMateriaComp) {
		this.nomMateriaComp = nomMateriaComp;
	}
	
}
