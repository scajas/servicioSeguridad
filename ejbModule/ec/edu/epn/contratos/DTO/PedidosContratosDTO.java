package ec.edu.epn.contratos.DTO;


public class PedidosContratosDTO {
	private String numCedula;
	private String nombreDocente;
	private String fechaPedido;
	private String fechaInicioContrato;
	private String fechaFinContrato;
	private String facultadDepartamento;
	private String tipoContrato;
	private String estadoPedido;
	private String nroPedido;
	private String relacionActual;
	
	
	
	
	public PedidosContratosDTO(){
		
	}

	

	public PedidosContratosDTO(String numCedula, String nombreDocente, String fechaPedido, String fechaInicioContrato, 
								String fechaFinContrato,  String facultadDepartamento, String tipoContrato, String estadoPedido,
								String nroPedido, String relacionActual) {
		super();
		this.numCedula= numCedula;
		this.nombreDocente= nombreDocente;
		this.fechaPedido= fechaPedido;
		this.fechaInicioContrato= fechaInicioContrato;
		this.fechaFinContrato= fechaFinContrato;
		this.facultadDepartamento= facultadDepartamento;
		this.tipoContrato= tipoContrato;
		this.estadoPedido= estadoPedido;
		this.nroPedido= nroPedido;
		this.relacionActual= relacionActual;
		
	}



	/**
	 * @return the numCedula
	 */
	public String getNumCedula() {
		return numCedula;
	}



	/**
	 * @param numCedula the numCedula to set
	 */
	public void setNumCedula(String numCedula) {
		this.numCedula = numCedula;
	}



	/**
	 * @return the nombreDocente
	 */
	public String getNombreDocente() {
		return nombreDocente;
	}



	/**
	 * @param nombreDocente the nombreDocente to set
	 */
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}



	/**
	 * @return the fechaPedido
	 */
	public String getFechaPedido() {
		return fechaPedido;
	}



	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	/**
	 * @return the fechaInicioContrato
	 */
	public String getFechaInicioContrato() {
		return fechaInicioContrato;
	}



	/**
	 * @param fechaInicioContrato the fechaInicioContrato to set
	 */
	public void setFechaInicioContrato(String fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}



	/**
	 * @return the fechaFinContrato
	 */
	public String getFechaFinContrato() {
		return fechaFinContrato;
	}



	/**
	 * @param fechaFinContrato the fechaFinContrato to set
	 */
	public void setFechaFinContrato(String fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}



	/**
	 * @return the facultadDepartamento
	 */
	public String getFacultadDepartamento() {
		return facultadDepartamento;
	}



	/**
	 * @param facultadDepartamento the facultadDepartamento to set
	 */
	public void setFacultadDepartamento(String facultadDepartamento) {
		this.facultadDepartamento = facultadDepartamento;
	}



	/**
	 * @return the tipoContrato
	 */
	public String getTipoContrato() {
		return tipoContrato;
	}



	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}



	/**
	 * @return the estadoPedido
	 */
	public String getEstadoPedido() {
		return estadoPedido;
	}



	/**
	 * @param estadoPedido the estadoPedido to set
	 */
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}



	/**
	 * @return the nroPedido
	 */
	public String getNroPedido() {
		return nroPedido;
	}



	/**
	 * @param nroPedido the nroPedido to set
	 */
	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}



	/**
	 * @return the relacionActual
	 */
	public String getRelacionActual() {
		return relacionActual;
	}



	/**
	 * @param relacionActual the relacionActual to set
	 */
	public void setRelacionActual(String relacionActual) {
		this.relacionActual = relacionActual;
	}

	

	

		
}
