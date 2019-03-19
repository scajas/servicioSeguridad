package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pruebas database table.
 * 
 */
@Entity
@Table(name="pruebas", catalog="`bddcorpepn`", schema="`Desarrollo`")

@NamedQuery(name="Prueba.findAll", query="SELECT p FROM Prueba p")
public class Prueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="autoriza_paso_prod")
	private String autorizaPasoProd;

	@Column(name="ejecuta_paso_prod")
	private String ejecutaPasoProd;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="f_culminacion")
	private Date fCulminacion;

	@Temporal(TemporalType.DATE)
	@Column(name="f_entrega_pruebas")
	private Date fEntregaPruebas;


	@ManyToOne
	@JoinColumn(name="id_req")
	private Requerimiento requerimiento;

	private String numero;

	private String observaciones;

	@Column(name="resp_pruebas")
	private String respPruebas;

	@Column(name="resultado_global_pruebas")
	private String resultadoGlobalPruebas;

	@Column(name="revisa_informe")
	private String revisaInforme;

	//bi-directional many-to-one association to ResultadosPrueba
	@OneToMany(mappedBy="prueba")
	private List<ResultadosPrueba> resultadosPruebas;

	public Prueba() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutorizaPasoProd() {
		return this.autorizaPasoProd;
	}

	public void setAutorizaPasoProd(String autorizaPasoProd) {
		this.autorizaPasoProd = autorizaPasoProd;
	}

	public String getEjecutaPasoProd() {
		return this.ejecutaPasoProd;
	}

	public void setEjecutaPasoProd(String ejecutaPasoProd) {
		this.ejecutaPasoProd = ejecutaPasoProd;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFCulminacion() {
		return this.fCulminacion;
	}

	public void setFCulminacion(Date fCulminacion) {
		this.fCulminacion = fCulminacion;
	}

	public Date getFEntregaPruebas() {
		return this.fEntregaPruebas;
	}

	public void setFEntregaPruebas(Date fEntregaPruebas) {
		this.fEntregaPruebas = fEntregaPruebas;
	}

	
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRespPruebas() {
		return this.respPruebas;
	}

	public void setRespPruebas(String respPruebas) {
		this.respPruebas = respPruebas;
	}

	public String getResultadoGlobalPruebas() {
		return this.resultadoGlobalPruebas;
	}

	public void setResultadoGlobalPruebas(String resultadoGlobalPruebas) {
		this.resultadoGlobalPruebas = resultadoGlobalPruebas;
	}

	public String getRevisaInforme() {
		return this.revisaInforme;
	}

	public void setRevisaInforme(String revisaInforme) {
		this.revisaInforme = revisaInforme;
	}

	public List<ResultadosPrueba> getResultadosPruebas() {
		return this.resultadosPruebas;
	}

	public void setResultadosPruebas(List<ResultadosPrueba> resultadosPruebas) {
		this.resultadosPruebas = resultadosPruebas;
	}

	public ResultadosPrueba addResultadosPrueba(ResultadosPrueba resultadosPrueba) {
		getResultadosPruebas().add(resultadosPrueba);
		resultadosPrueba.setPrueba(this);

		return resultadosPrueba;
	}

	public ResultadosPrueba removeResultadosPrueba(ResultadosPrueba resultadosPrueba) {
		getResultadosPruebas().remove(resultadosPrueba);
		resultadosPrueba.setPrueba(null);

		return resultadosPrueba;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}
	
	

}