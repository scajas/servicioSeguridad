package ec.edu.epn.gestionDocente.DTO;



public class CargaPlanificacionDTO {
	
	private String nomMateriaSAE;
	private String codMateriaSAE;
	private String nomParaleloSAE;
	private String nomCarreraSAE;
	private Integer horasTotalSemanaSAE;
	private Integer horasModuloSAE;
	private Integer numAlumnosSAE;
	private Integer capacidadAlumnosSAE;
	private Double valHetero;
	private String aula;
	private String nivel;
	private String regimen;
	
	private Integer horasRemdiales;
	
	
	public CargaPlanificacionDTO(){
		
	}

	
	public CargaPlanificacionDTO(String nomMateriaSAE, String nomParaleloSAE, Integer horasTotalSemanaSAE, 
								Integer numAlumnosSAE,Integer capacidadAlumnosSAE, String codMateriaSAE, String nomCarreraSAE, Integer horasModuloSAE) {
		super();
		
		this.nomMateriaSAE= nomMateriaSAE;
		this.nomParaleloSAE= nomParaleloSAE;
		this.horasTotalSemanaSAE= horasTotalSemanaSAE;
		this.numAlumnosSAE= numAlumnosSAE;
		this.capacidadAlumnosSAE= capacidadAlumnosSAE;
		
		
		
		
			
	}


	/**
	 * @return the nomMateriaSAE
	 */
	public String getNomMateriaSAE() {
		return nomMateriaSAE;
	}


	/**
	 * @return the nomParaleloSAE
	 */
	public String getNomParaleloSAE() {
		return nomParaleloSAE;
	}


	/**
	 * @return the horasTotalSemanaSAE
	 */
	public Integer getHorasTotalSemanaSAE() {
		return horasTotalSemanaSAE;
	}


	/**
	 * @return the numAlumnosSAE
	 */
	public Integer getNumAlumnosSAE() {
		return numAlumnosSAE;
	}


	/**
	 * @return the capacidadAlumnosSAE
	 */
	public Integer getCapacidadAlumnosSAE() {
		return capacidadAlumnosSAE;
	}


	/**
	 * @param nomMateriaSAE the nomMateriaSAE to set
	 */
	public void setNomMateriaSAE(String nomMateriaSAE) {
		this.nomMateriaSAE = nomMateriaSAE;
	}


	/**
	 * @param nomParaleloSAE the nomParaleloSAE to set
	 */
	public void setNomParaleloSAE(String nomParaleloSAE) {
		this.nomParaleloSAE = nomParaleloSAE;
	}


	/**
	 * @param horasTotalSemanaSAE the horasTotalSemanaSAE to set
	 */
	public void setHorasTotalSemanaSAE(Integer horasTotalSemanaSAE) {
		this.horasTotalSemanaSAE = horasTotalSemanaSAE;
	}


	/**
	 * @param numAlumnosSAE the numAlumnosSAE to set
	 */
	public void setNumAlumnosSAE(Integer numAlumnosSAE) {
		this.numAlumnosSAE = numAlumnosSAE;
	}


	/**
	 * @param capacidadAlumnosSAE the capacidadAlumnosSAE to set
	 */
	public void setCapacidadAlumnosSAE(Integer capacidadAlumnosSAE) {
		this.capacidadAlumnosSAE = capacidadAlumnosSAE;
	}


	/**
	 * @return the codMateriaSAE
	 */
	public String getCodMateriaSAE() {
		return codMateriaSAE;
	}


	/**
	 * @param codMateriaSAE the codMateriaSAE to set
	 */
	public void setCodMateriaSAE(String codMateriaSAE) {
		this.codMateriaSAE = codMateriaSAE;
	}


	/**
	 * @return the nomCarreraSAE
	 */
	public String getNomCarreraSAE() {
		return nomCarreraSAE;
	}


	/**
	 * @param nomCarreraSAE the nomCarreraSAE to set
	 */
	public void setNomCarreraSAE(String nomCarreraSAE) {
		this.nomCarreraSAE = nomCarreraSAE;
	}


	/**
	 * @return the horasModuloSAE
	 */
	public Integer getHorasModuloSAE() {
		return horasModuloSAE;
	}


	/**
	 * @param horasModuloSAE the horasModuloSAE to set
	 */
	public void setHorasModuloSAE(Integer horasModuloSAE) {
		this.horasModuloSAE = horasModuloSAE;
	}


	/**
	 * @return the valHetero
	 */
	public Double getValHetero() {
		return valHetero;
	}


	/**
	 * @param valHetero the valHetero to set
	 */
	public void setValHetero(Double valHetero) {
		this.valHetero = valHetero;
	}


	/**
	 * @return the horasRemdiales
	 */
	public Integer getHorasRemdiales() {
		return horasRemdiales;
	}


	/**
	 * @param horasRemdiales the horasRemdiales to set
	 */
	public void setHorasRemdiales(Integer horasRemdiales) {
		this.horasRemdiales = horasRemdiales;
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


	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}


	/**
	 * @return the regimen
	 */
	public String getRegimen() {
		return regimen;
	}


	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	/**
	 * @param regimen the regimen to set
	 */
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}


	
}


