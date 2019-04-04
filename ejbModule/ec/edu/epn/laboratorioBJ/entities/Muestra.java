package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the muestra database table.
 * 
 */
@Entity
@Table(name = "`muestra`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Muestra.findAll", query="SELECT m FROM Muestra m")
public class Muestra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_muestra")
	private String idMuestra;

	@Column(name="aux_muestra")
	private Integer auxMuestra;

	@Column(name="codigo_m_cliente")
	private String codigoMCliente;

	@Column(name="descr_m")
	private String descrM;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_toma_m")
	private Date fechaTomaM;

	@Column(name="id_factura")
	private String idFactura;

	@Column(name="id_ti")
	private String idTi;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="num_muestra_fact")
	private Integer numMuestraFact;

	@Column(name="origen_m")
	private String origenM;

	@Column(name="preservante_m")
	private String preservanteM;

	@Column(name="refrigeracion_m")
	private String refrigeracionM;

	@Column(name="tipo_m")
	private String tipoM;

	@Column(name="tipoenvase_m")
	private String tipoenvaseM;

	@Column(name="tipopreservante_m")
	private String tipopreservanteM;

	//bi-directional many-to-one association to Detalleorden
	@OneToMany(mappedBy="muestra")
	private List<Detalleorden> detalleordens;

	public Muestra() {
	}

	public String getIdMuestra() {
		return this.idMuestra;
	}

	public void setIdMuestra(String idMuestra) {
		this.idMuestra = idMuestra;
	}

	public Integer getAuxMuestra() {
		return this.auxMuestra;
	}

	public void setAuxMuestra(Integer auxMuestra) {
		this.auxMuestra = auxMuestra;
	}

	public String getCodigoMCliente() {
		return this.codigoMCliente;
	}

	public void setCodigoMCliente(String codigoMCliente) {
		this.codigoMCliente = codigoMCliente;
	}

	public String getDescrM() {
		return this.descrM;
	}

	public void setDescrM(String descrM) {
		this.descrM = descrM;
	}

	public Date getFechaTomaM() {
		return this.fechaTomaM;
	}

	public void setFechaTomaM(Date fechaTomaM) {
		this.fechaTomaM = fechaTomaM;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdTi() {
		return this.idTi;
	}

	public void setIdTi(String idTi) {
		this.idTi = idTi;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Integer getNumMuestraFact() {
		return this.numMuestraFact;
	}

	public void setNumMuestraFact(Integer numMuestraFact) {
		this.numMuestraFact = numMuestraFact;
	}

	public String getOrigenM() {
		return this.origenM;
	}

	public void setOrigenM(String origenM) {
		this.origenM = origenM;
	}

	public String getPreservanteM() {
		return this.preservanteM;
	}

	public void setPreservanteM(String preservanteM) {
		this.preservanteM = preservanteM;
	}

	public String getRefrigeracionM() {
		return this.refrigeracionM;
	}

	public void setRefrigeracionM(String refrigeracionM) {
		this.refrigeracionM = refrigeracionM;
	}

	public String getTipoM() {
		return this.tipoM;
	}

	public void setTipoM(String tipoM) {
		this.tipoM = tipoM;
	}

	public String getTipoenvaseM() {
		return this.tipoenvaseM;
	}

	public void setTipoenvaseM(String tipoenvaseM) {
		this.tipoenvaseM = tipoenvaseM;
	}

	public String getTipopreservanteM() {
		return this.tipopreservanteM;
	}

	public void setTipopreservanteM(String tipopreservanteM) {
		this.tipopreservanteM = tipopreservanteM;
	}

	public List<Detalleorden> getDetalleordens() {
		return this.detalleordens;
	}

	public void setDetalleordens(List<Detalleorden> detalleordens) {
		this.detalleordens = detalleordens;
	}

	public Detalleorden addDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().add(detalleorden);
		detalleorden.setMuestra(this);

		return detalleorden;
	}

	public Detalleorden removeDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().remove(detalleorden);
		detalleorden.setMuestra(null);

		return detalleorden;
	}

}