package ec.edu.epn.atencionmedica.entities;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the nutricion database table.
 * 
 */
@Entity
@Table(name="nutricion", catalog="bddcorpepn", schema="`Medico`")
@NamedQuery(name="Nutricion.findAll", query="SELECT n FROM Nutricion n")
public class Nutricion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nutricion")
	private Integer idNutricion;

	@Column(name="agua_diario")
	private double aguaDiario;

	@Column(name="agua_mensual")
	private double aguaMensual;

	@Column(name="agua_nunca")
	private String aguaNunca;

	@Column(name="agua_semanal")
	private double aguaSemanal;

	@Column(name="almuerzo_detalle")
	private String almuerzoDetalle;

	@Column(name="almuerzo_horario")
	private String almuerzoHorario;

	@Column(name="azucares_diario")
	private double azucaresDiario;

	@Column(name="azucares_mensual")
	private double azucaresMensual;

	@Column(name="azucares_nunca")
	private String azucaresNunca;

	@Column(name="azucares_semanal")
	private double azucaresSemanal;

	@Column(name="carnes_diario")
	private double carnesDiario;

	@Column(name="carnes_mensual")
	private double carnesMensual;

	@Column(name="carnes_nunca")
	private String carnesNunca;

	@Column(name="carnes_semanal")
	private double carnesSemanal;

	@Column(name="cb_circunf")
	private double cbCircunf;

	@Column(name="ccad_nut")
	private double ccadNut;

	@Column(name="ccint_circunf")
	private double ccintCircunf;

	@Column(name="cereales_diario")
	private double cerealesDiario;

	@Column(name="cereales_mensual")
	private double cerealesMensual;

	@Column(name="cereales_nunca")
	private String cerealesNunca;

	@Column(name="cereales_semanal")
	private double cerealesSemanal;

	@Column(name="cintcad_circunf")
	private double cintcadCircunf;

	@Column(name="colacion_detalle")
	private String colacionDetalle;

	@Column(name="colacion_horario")
	private String colacionHorario;

	@Column(name="colacional_detalle")
	private String colacionalDetalle;

	@Column(name="colacional_horario")
	private String colacionalHorario;

	@Column(name="desayuno_detalle")
	private String desayunoDetalle;

	@Column(name="desayuno_horario")
	private String desayunoHorario;

	@Column(name="frutas_diario")
	private double frutasDiario;

	@Column(name="frutas_mensual")
	private double frutasMensual;

	@Column(name="frutas_nunca")
	private String frutasNunca;

	@Column(name="frutas_semanal")
	private double frutasSemanal;

	@Column(name="grasakg_corporal")
	private double grasakgCorporal;

	@Column(name="grasaporcent_corporal")
	private double grasaporcentCorporal;

	@Column(name="grasas_diario")
	private double grasasDiario;

	@Column(name="grasas_mensual")
	private double grasasMensual;

	@Column(name="grasas_nunca")
	private String grasasNunca;

	@Column(name="grasas_semanal")
	private double grasasSemanal;

	@Column(name="id_atencionmed")
	private Integer idAtencionmed;

	@Column(name="imc_eval")
	private double imcEval;

	@Column(name="lacteos_diario")
	private double lacteosDiario;

	@Column(name="lacteos_mensual")
	private double lacteosMensual;

	@Column(name="lacteos_nunca")
	private String lacteosNunca;

	@Column(name="lacteos_semanal")
	private double lacteosSemanal;

	@Column(name="merienda_detalle")
	private String meriendaDetalle;

	@Column(name="merienda_horario")
	private String meriendaHorario;

	@Column(name="muscularkg_corporal")
	private double muscularkgCorporal;

	@Column(name="obs_recordatorio")
	private String obsRecordatorio;

	@Column(name="pb_pliegue")
	private double pbPliegue;

	@Column(name="pesoact_eval")
	private double pesoactEval;

	@Column(name="pesohab_eval")
	private double pesohabEval;

	@Column(name="pesoideal_eval")
	private double pesoidealEval;

	@Column(name="pspl_pliegue")
	private double psplPliegue;

	@Column(name="psubesc_pliegue")
	private double psubescPliegue;

	@Column(name="pt_pliegue")
	private double ptPliegue;

	@Column(name="talla_eval")
	private double tallaEval;

	@Column(name="vegetales_diario")
	private double vegetalesDiario;

	@Column(name="vegetales_mensual")
	private double vegetalesMensual;

	@Column(name="vegetales_nunca")
	private String vegetalesNunca;

	@Column(name="vegetales_semanal")
	private double vegetalesSemanal;

	@Column(name="visceral_corporal")
	private double visceralCorporal;
	
	@Transient
	private boolean lacteosCheck;
	
	@Transient
	private boolean carnesCheck;
	
	@Transient
	private boolean cerealesCheck;
	
	@Transient
	private boolean frutasCheck;
	
	@Transient
	private boolean vegetalesCheck;
	
	@Transient
	private boolean grasasCheck;
	
	@Transient
	private boolean azucaresCheck;
	
	@Transient
	private boolean aguaCheck;
		
	

	public Nutricion() {
	}

	public Integer getIdNutricion() {
		return this.idNutricion;
	}

	public void setIdNutricion(Integer idNutricion) {
		this.idNutricion = idNutricion;
	}

	public double getAguaDiario() {
		return this.aguaDiario;
	}

	public void setAguaDiario(double aguaDiario) {
		this.aguaDiario = aguaDiario;
	}

	public double getAguaMensual() {
		return this.aguaMensual;
	}

	public void setAguaMensual(double aguaMensual) {
		this.aguaMensual = aguaMensual;
	}

	public String getAguaNunca() {
		return this.aguaNunca;
	}

	public void setAguaNunca(String aguaNunca) {
		this.aguaNunca = aguaNunca;
	}

	public double getAguaSemanal() {
		return this.aguaSemanal;
	}

	public void setAguaSemanal(double aguaSemanal) {
		this.aguaSemanal = aguaSemanal;
	}

	public String getAlmuerzoDetalle() {
		return this.almuerzoDetalle;
	}

	public void setAlmuerzoDetalle(String almuerzoDetalle) {
		this.almuerzoDetalle = almuerzoDetalle;
	}

	public String getAlmuerzoHorario() {
		return this.almuerzoHorario;
	}

	public void setAlmuerzoHorario(String almuerzoHorario) {
		this.almuerzoHorario = almuerzoHorario;
	}

	public double getAzucaresDiario() {
		return this.azucaresDiario;
	}

	public void setAzucaresDiario(double azucaresDiario) {
		this.azucaresDiario = azucaresDiario;
	}

	public double getAzucaresMensual() {
		return this.azucaresMensual;
	}

	public void setAzucaresMensual(double azucaresMensual) {
		this.azucaresMensual = azucaresMensual;
	}

	public String getAzucaresNunca() {
		return this.azucaresNunca;
	}

	public void setAzucaresNunca(String azucaresNunca) {
		this.azucaresNunca = azucaresNunca;
	}

	public double getAzucaresSemanal() {
		return this.azucaresSemanal;
	}

	public void setAzucaresSemanal(double azucaresSemanal) {
		this.azucaresSemanal = azucaresSemanal;
	}

	public double getCarnesDiario() {
		return this.carnesDiario;
	}

	public void setCarnesDiario(double carnesDiario) {
		this.carnesDiario = carnesDiario;
	}

	public double getCarnesMensual() {
		return this.carnesMensual;
	}

	public void setCarnesMensual(double carnesMensual) {
		this.carnesMensual = carnesMensual;
	}

	public String getCarnesNunca() {
		return this.carnesNunca;
	}

	public void setCarnesNunca(String carnesNunca) {
		this.carnesNunca = carnesNunca;
	}

	public double getCarnesSemanal() {
		return this.carnesSemanal;
	}

	public void setCarnesSemanal(double carnesSemanal) {
		this.carnesSemanal = carnesSemanal;
	}

	public double getCbCircunf() {
		return this.cbCircunf;
	}

	public void setCbCircunf(double cbCircunf) {
		this.cbCircunf = cbCircunf;
	}

	public double getCcadNut() {
		return this.ccadNut;
	}

	public void setCcadNut(double ccadNut) {
		this.ccadNut = ccadNut;
	}

	public double getCcintCircunf() {
		return this.ccintCircunf;
	}

	public void setCcintCircunf(double ccintCircunf) {
		this.ccintCircunf = ccintCircunf;
	}

	public double getCerealesDiario() {
		return this.cerealesDiario;
	}

	public void setCerealesDiario(double cerealesDiario) {
		this.cerealesDiario = cerealesDiario;
	}

	public double getCerealesMensual() {
		return this.cerealesMensual;
	}

	public void setCerealesMensual(double cerealesMensual) {
		this.cerealesMensual = cerealesMensual;
	}

	public String getCerealesNunca() {
		return this.cerealesNunca;
	}

	public void setCerealesNunca(String cerealesNunca) {
		this.cerealesNunca = cerealesNunca;
	}

	public double getCerealesSemanal() {
		return this.cerealesSemanal;
	}

	public void setCerealesSemanal(double cerealesSemanal) {
		this.cerealesSemanal = cerealesSemanal;
	}

	public double getCintcadCircunf() {
		return this.cintcadCircunf;
	}

	public void setCintcadCircunf(double cintcadCircunf) {
		this.cintcadCircunf = cintcadCircunf;
	}

	public String getColacionDetalle() {
		return this.colacionDetalle;
	}

	public void setColacionDetalle(String colacionDetalle) {
		this.colacionDetalle = colacionDetalle;
	}

	public String getColacionHorario() {
		return this.colacionHorario;
	}

	public void setColacionHorario(String colacionHorario) {
		this.colacionHorario = colacionHorario;
	}

	public String getColacionalDetalle() {
		return this.colacionalDetalle;
	}

	public void setColacionalDetalle(String colacionalDetalle) {
		this.colacionalDetalle = colacionalDetalle;
	}

	public String getColacionalHorario() {
		return this.colacionalHorario;
	}

	public void setColacionalHorario(String colacionalHorario) {
		this.colacionalHorario = colacionalHorario;
	}

	public String getDesayunoDetalle() {
		return this.desayunoDetalle;
	}

	public void setDesayunoDetalle(String desayunoDetalle) {
		this.desayunoDetalle = desayunoDetalle;
	}

	public String getDesayunoHorario() {
		return this.desayunoHorario;
	}

	public void setDesayunoHorario(String desayunoHorario) {
		this.desayunoHorario = desayunoHorario;
	}

	public double getFrutasDiario() {
		return this.frutasDiario;
	}

	public void setFrutasDiario(double frutasDiario) {
		this.frutasDiario = frutasDiario;
	}

	public double getFrutasMensual() {
		return this.frutasMensual;
	}

	public void setFrutasMensual(double frutasMensual) {
		this.frutasMensual = frutasMensual;
	}

	public String getFrutasNunca() {
		return this.frutasNunca;
	}

	public void setFrutasNunca(String frutasNunca) {
		this.frutasNunca = frutasNunca;
	}

	public double getFrutasSemanal() {
		return this.frutasSemanal;
	}

	public void setFrutasSemanal(double frutasSemanal) {
		this.frutasSemanal = frutasSemanal;
	}

	public double getGrasakgCorporal() {
		return this.grasakgCorporal;
	}

	public void setGrasakgCorporal(double grasakgCorporal) {
		this.grasakgCorporal = grasakgCorporal;
	}

	public double getGrasaporcentCorporal() {
		return this.grasaporcentCorporal;
	}

	public void setGrasaporcentCorporal(double grasaporcentCorporal) {
		this.grasaporcentCorporal = grasaporcentCorporal;
	}

	public double getGrasasDiario() {
		return this.grasasDiario;
	}

	public void setGrasasDiario(double grasasDiario) {
		this.grasasDiario = grasasDiario;
	}

	public double getGrasasMensual() {
		return this.grasasMensual;
	}

	public void setGrasasMensual(double grasasMensual) {
		this.grasasMensual = grasasMensual;
	}

	public String getGrasasNunca() {
		return this.grasasNunca;
	}

	public void setGrasasNunca(String grasasNunca) {
		this.grasasNunca = grasasNunca;
	}

	public double getGrasasSemanal() {
		return this.grasasSemanal;
	}

	public void setGrasasSemanal(double grasasSemanal) {
		this.grasasSemanal = grasasSemanal;
	}

	public Integer getIdAtencionmed() {
		return this.idAtencionmed;
	}

	public void setIdAtencionmed(Integer idAtencionmed) {
		this.idAtencionmed = idAtencionmed;
	}

	public double getImcEval() {
		return this.imcEval;
	}

	public void setImcEval(double imcEval) {
		this.imcEval = imcEval;
	}

	public double getLacteosDiario() {
		return this.lacteosDiario;
	}

	public void setLacteosDiario(double lacteosDiario) {
		this.lacteosDiario = lacteosDiario;
	}

	public double getLacteosMensual() {
		return this.lacteosMensual;
	}

	public void setLacteosMensual(double lacteosMensual) {
		this.lacteosMensual = lacteosMensual;
	}

	public String getLacteosNunca() {
		return this.lacteosNunca;
	}

	public void setLacteosNunca(String lacteosNunca) {
		this.lacteosNunca = lacteosNunca;
	}

	public double getLacteosSemanal() {
		return this.lacteosSemanal;
	}

	public void setLacteosSemanal(double lacteosSemanal) {
		this.lacteosSemanal = lacteosSemanal;
	}

	public String getMeriendaDetalle() {
		return this.meriendaDetalle;
	}

	public void setMeriendaDetalle(String meriendaDetalle) {
		this.meriendaDetalle = meriendaDetalle;
	}

	public String getMeriendaHorario() {
		return this.meriendaHorario;
	}

	public void setMeriendaHorario(String meriendaHorario) {
		this.meriendaHorario = meriendaHorario;
	}

	public double getMuscularkgCorporal() {
		return this.muscularkgCorporal;
	}

	public void setMuscularkgCorporal(double muscularkgCorporal) {
		this.muscularkgCorporal = muscularkgCorporal;
	}

	public String getObsRecordatorio() {
		return this.obsRecordatorio;
	}

	public void setObsRecordatorio(String obsRecordatorio) {
		this.obsRecordatorio = obsRecordatorio;
	}

	public double getPbPliegue() {
		return this.pbPliegue;
	}

	public void setPbPliegue(double pbPliegue) {
		this.pbPliegue = pbPliegue;
	}

	public double getPesoactEval() {
		return this.pesoactEval;
	}

	public void setPesoactEval(double pesoactEval) {
		this.pesoactEval = pesoactEval;
	}

	public double getPesohabEval() {
		return this.pesohabEval;
	}

	public void setPesohabEval(double pesohabEval) {
		this.pesohabEval = pesohabEval;
	}

	public double getPesoidealEval() {
		return this.pesoidealEval;
	}

	public void setPesoidealEval(double pesoidealEval) {
		this.pesoidealEval = pesoidealEval;
	}

	public double getPsplPliegue() {
		return this.psplPliegue;
	}

	public void setPsplPliegue(double psplPliegue) {
		this.psplPliegue = psplPliegue;
	}

	public double getPsubescPliegue() {
		return this.psubescPliegue;
	}

	public void setPsubescPliegue(double psubescPliegue) {
		this.psubescPliegue = psubescPliegue;
	}

	public double getPtPliegue() {
		return this.ptPliegue;
	}

	public void setPtPliegue(double ptPliegue) {
		this.ptPliegue = ptPliegue;
	}

	public double getTallaEval() {
		return this.tallaEval;
	}

	public void setTallaEval(double tallaEval) {
		this.tallaEval = tallaEval;
	}

	public double getVegetalesDiario() {
		return this.vegetalesDiario;
	}

	public void setVegetalesDiario(double vegetalesDiario) {
		this.vegetalesDiario = vegetalesDiario;
	}

	public double getVegetalesMensual() {
		return this.vegetalesMensual;
	}

	public void setVegetalesMensual(double vegetalesMensual) {
		this.vegetalesMensual = vegetalesMensual;
	}

	public String getVegetalesNunca() {
		return this.vegetalesNunca;
	}

	public void setVegetalesNunca(String vegetalesNunca) {
		this.vegetalesNunca = vegetalesNunca;
	}

	public double getVegetalesSemanal() {
		return this.vegetalesSemanal;
	}

	public void setVegetalesSemanal(double vegetalesSemanal) {
		this.vegetalesSemanal = vegetalesSemanal;
	}

	public double getVisceralCorporal() {
		return this.visceralCorporal;
	}

	public void setVisceralCorporal(double visceralCorporal) {
		this.visceralCorporal = visceralCorporal;
	}

	/**
	 * @return the lacteosCheck
	 */
	public boolean isLacteosCheck() {
		return lacteosCheck;
	}

	/**
	 * @param lacteosCheck the lacteosCheck to set
	 */
	public void setLacteosCheck(boolean lacteosCheck) {
		this.lacteosCheck = lacteosCheck;
	}

	/**
	 * @return the carnesCheck
	 */
	public boolean isCarnesCheck() {
		return carnesCheck;
	}

	/**
	 * @param carnesCheck the carnesCheck to set
	 */
	public void setCarnesCheck(boolean carnesCheck) {
		this.carnesCheck = carnesCheck;
	}

	/**
	 * @return the cerealesCheck
	 */
	public boolean isCerealesCheck() {
		return cerealesCheck;
	}

	/**
	 * @param cerealesCheck the cerealesCheck to set
	 */
	public void setCerealesCheck(boolean cerealesCheck) {
		this.cerealesCheck = cerealesCheck;
	}

	/**
	 * @return the frutasCheck
	 */
	public boolean isFrutasCheck() {
		return frutasCheck;
	}

	/**
	 * @param frutasCheck the frutasCheck to set
	 */
	public void setFrutasCheck(boolean frutasCheck) {
		this.frutasCheck = frutasCheck;
	}

	/**
	 * @return the vegetalesCheck
	 */
	public boolean isVegetalesCheck() {
		return vegetalesCheck;
	}

	/**
	 * @param vegetalesCheck the vegetalesCheck to set
	 */
	public void setVegetalesCheck(boolean vegetalesCheck) {
		this.vegetalesCheck = vegetalesCheck;
	}

	/**
	 * @return the grasasCheck
	 */
	public boolean isGrasasCheck() {
		return grasasCheck;
	}

	/**
	 * @param grasasCheck the grasasCheck to set
	 */
	public void setGrasasCheck(boolean grasasCheck) {
		this.grasasCheck = grasasCheck;
	}

	/**
	 * @return the azucaresCheck
	 */
	public boolean isAzucaresCheck() {
		return azucaresCheck;
	}

	/**
	 * @param azucaresCheck the azucaresCheck to set
	 */
	public void setAzucaresCheck(boolean azucaresCheck) {
		this.azucaresCheck = azucaresCheck;
	}

	/**
	 * @return the aguaCheck
	 */
	public boolean isAguaCheck() {
		return aguaCheck;
	}

	/**
	 * @param aguaCheck the aguaCheck to set
	 */
	public void setAguaCheck(boolean aguaCheck) {
		this.aguaCheck = aguaCheck;
	}

}