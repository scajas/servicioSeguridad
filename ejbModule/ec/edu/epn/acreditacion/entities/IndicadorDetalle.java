package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the indicador_detalle database table.
 * 
 */
@Entity
@Table(name="indicador_detalle", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="IndicadorDetalle.findAll", query="SELECT i FROM IndicadorDetalle i")
public class IndicadorDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Acreditacion\".sec_indicador_detalle")
	@SequenceGenerator(name = "\"Acreditacion\".sec_indicador_detalle", sequenceName = "\"Acreditacion\".sec_indicador_detalle", allocationSize = 1)	
	@Column(name="id_indet")
	private Integer idIndet;

	@Column(name="cod_inddet")
	private String codInddet;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_c")
	private Date fechaC;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_g")
	private Date fechaG;

	@Column(name="id_carrera")
	private String idCarrera;

	@Column(name="id_pensum")
	private Integer idPensum;

	@Column(name="id_usuario_c")
	private Integer idUsuarioC;

	@Column(name="id_usuario_g")
	private Integer idUsuarioG;

	private String resultado;

	private double valor1;

	private double valor2;

	private double valor3;

	private double valor4;

	private String valor5;

	private String valorc1;

	private String valorc2;

	private String valorc3;

	//bi-directional many-to-one association to Indicador
	
	@Column(name="id_indi")
	private Integer idIndicador;
	
	
	//bi-directional many-to-one association to Indicador
	@ManyToOne
	@JoinColumn(name="id_subcr_detalle")
	private SubcriterioDetalle subcriterioDetalle;

	public IndicadorDetalle() {
	}

	public Integer getIdIndet() {
		return this.idIndet;
	}

	public void setIdIndet(Integer idIndet) {
		this.idIndet = idIndet;
	}

	public String getCodInddet() {
		return this.codInddet;
	}

	public void setCodInddet(String codInddet) {
		this.codInddet = codInddet;
	}

	public Date getFechaC() {
		return this.fechaC;
	}

	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	public Date getFechaG() {
		return this.fechaG;
	}

	public void setFechaG(Date fechaG) {
		this.fechaG = fechaG;
	}

	
	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public Integer getIdUsuarioC() {
		return this.idUsuarioC;
	}

	public void setIdUsuarioC(Integer idUsuarioC) {
		this.idUsuarioC = idUsuarioC;
	}

	public Integer getIdUsuarioG() {
		return this.idUsuarioG;
	}

	public void setIdUsuarioG(Integer idUsuarioG) {
		this.idUsuarioG = idUsuarioG;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public double getValor1() {
		return this.valor1;
	}

	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public double getValor2() {
		return this.valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public double getValor3() {
		return this.valor3;
	}

	public void setValor3(double valor3) {
		this.valor3 = valor3;
	}

	public double getValor4() {
		return this.valor4;
	}

	public void setValor4(double valor4) {
		this.valor4 = valor4;
	}

	public String getValor5() {
		return this.valor5;
	}

	public void setValor5(String valor5) {
		this.valor5 = valor5;
	}

	public String getValorc1() {
		return this.valorc1;
	}

	public void setValorc1(String valorc1) {
		this.valorc1 = valorc1;
	}

	public String getValorc2() {
		return this.valorc2;
	}

	public void setValorc2(String valorc2) {
		this.valorc2 = valorc2;
	}

	public String getValorc3() {
		return this.valorc3;
	}

	public void setValorc3(String valorc3) {
		this.valorc3 = valorc3;
	}

	
	/**
	 * @return the subcriterioDetalle
	 */
	public SubcriterioDetalle getSubcriterioDetalle() {
		return subcriterioDetalle;
	}

	/**
	 * @param subcriterioDetalle the subcriterioDetalle to set
	 */
	public void setSubcriterioDetalle(SubcriterioDetalle subcriterioDetalle) {
		this.subcriterioDetalle = subcriterioDetalle;
	}

	/**
	 * @return the idIndicador
	 */
	public Integer getIdIndicador() {
		return idIndicador;
	}

	/**
	 * @param idIndicador the idIndicador to set
	 */
	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

}