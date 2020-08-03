package ec.edu.epn.acreditacion.reportes.dto;

public class ReporteDistribucionHorariaDTO {

	private String nced;
	private String nombres;
	private String departamento;
	private String periodo;
	private String tipo;
	private String dedicacion;
	private String horasClase;
	private String horasTutoria;
	private String horasGestion;
	private String horasInvestig;
	private String horasVincul;

	public ReporteDistribucionHorariaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReporteDistribucionHorariaDTO(String nced, String nombres, String departamento, String periodo, String tipo,
			String dedicacion, String horasClase, String horasTutoria, String horasGestion, String horasInvestig, String horasVincul) {
		super();
		this.nced = nced;
		this.nombres = nombres;
		this.departamento = departamento;
		this.periodo = periodo;
		this.tipo = tipo;
		this.dedicacion = dedicacion;
		this.horasClase = horasClase;
		this.horasTutoria = horasTutoria;
		this.horasGestion = horasGestion;
		this.horasInvestig = horasInvestig;
		this.horasVincul = horasVincul;
	}

	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}

	/**
	 * @param nced
	 *            the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion
	 *            the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the horasClase
	 */
	public String getHorasClase() {
		return horasClase;
	}

	/**
	 * @param horasClase
	 *            the horasClase to set
	 */
	public void setHorasClase(String horasClase) {
		this.horasClase = horasClase;
	}

	/**
	 * @return the horasTutoria
	 */
	public String getHorasTutoria() {
		return horasTutoria;
	}

	/**
	 * @param horasTutoria
	 *            the horasTutoria to set
	 */
	public void setHorasTutoria(String horasTutoria) {
		this.horasTutoria = horasTutoria;
	}

	/**
	 * @return the horasGestion
	 */
	public String getHorasGestion() {
		return horasGestion;
	}

	/**
	 * @param horasGestion
	 *            the horasGestion to set
	 */
	public void setHorasGestion(String horasGestion) {
		this.horasGestion = horasGestion;
	}

	/**
	 * @return the horasIvestig
	 */
	public String getHorasInvestig() {
		return horasInvestig;
	}

	/**
	 * @param horasIvestig
	 *            the horasIvestig to set
	 */
	public void setHorasInvestig(String horasInvestig) {
		this.horasInvestig = horasInvestig;
	}

	/**
	 * @return the horasVincul
	 */
	public String getHorasVincul() {
		return horasVincul;
	}

	/**
	 * @param horasVincul
	 *            the horasVincul to set
	 */
	public void setHorasVincul(String horasVincul) {
		this.horasVincul = horasVincul;
	}

}
