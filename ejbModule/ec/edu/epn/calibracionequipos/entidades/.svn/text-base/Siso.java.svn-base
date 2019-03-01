package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the siso database table.
 * 
 */
@Entity
@Table(name="siso", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Siso.findAll", query="SELECT s FROM Siso s")
public class Siso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_siso")
	private Integer idSiso;

	@Column(name="aforopersonaslab_siso")
	private Integer aforopersonaslabSiso;

	@Column(name="cumplenormasseguridad_siso")
	private String cumplenormasseguridadSiso;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaactualizacion_siso")
	private Date fechaactualizacionSiso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecharegistro_siso")
	private Date fecharegistroSiso;

	@Column(name="idresponsablessolab_siso")
	private Integer idresponsablessolabSiso;

	@Column(name="infdemogaforopersonaslab_siso")
	private Integer infdemogaforopersonaslabSiso;

	@Column(name="infdemognumdiscapacitados_siso")
	private Integer infdemognumdiscapacitadosSiso;

	@Column(name="infdemognumembarazadas_siso")
	private Integer infdemognumembarazadasSiso;

	@Column(name="infdemognumhombres_siso")
	private Integer infdemognumhombresSiso;

	@Column(name="infdemognummujeres_siso")
	private Integer infdemognummujeresSiso;

	@Column(name="matrizgestionsso_siso")
	private String matrizgestionssoSiso;

	//bi-directional many-to-one association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private Laboratorioscalibracionequipo laboratorioscalibracionequipo;


	@OneToMany(mappedBy="siso")	
	private List<Gestionsoo> gestionsoos;

	public Siso() {
	}

	public Integer getIdSiso() {
		return this.idSiso;
	}

	public void setIdSiso(Integer idSiso) {
		this.idSiso = idSiso;
	}

	public Integer getAforopersonaslabSiso() {
		return this.aforopersonaslabSiso;
	}

	public void setAforopersonaslabSiso(Integer aforopersonaslabSiso) {
		this.aforopersonaslabSiso = aforopersonaslabSiso;
	}

	public String getCumplenormasseguridadSiso() {
		return this.cumplenormasseguridadSiso;
	}

	public void setCumplenormasseguridadSiso(String cumplenormasseguridadSiso) {
		this.cumplenormasseguridadSiso = cumplenormasseguridadSiso;
	}

	public Date getFechaactualizacionSiso() {
		return this.fechaactualizacionSiso;
	}

	public void setFechaactualizacionSiso(Date fechaactualizacionSiso) {
		this.fechaactualizacionSiso = fechaactualizacionSiso;
	}

	public Date getFecharegistroSiso() {
		return this.fecharegistroSiso;
	}

	public void setFecharegistroSiso(Date fecharegistroSiso) {
		this.fecharegistroSiso = fecharegistroSiso;
	}

	public Integer getIdresponsablessolabSiso() {
		return this.idresponsablessolabSiso;
	}

	public void setIdresponsablessolabSiso(Integer idresponsablessolabSiso) {
		this.idresponsablessolabSiso = idresponsablessolabSiso;
	}

	public Integer getInfdemogaforopersonaslabSiso() {
		return this.infdemogaforopersonaslabSiso;
	}

	public void setInfdemogaforopersonaslabSiso(Integer infdemogaforopersonaslabSiso) {
		this.infdemogaforopersonaslabSiso = infdemogaforopersonaslabSiso;
	}

	public Integer getInfdemognumdiscapacitadosSiso() {
		return this.infdemognumdiscapacitadosSiso;
	}

	public void setInfdemognumdiscapacitadosSiso(Integer infdemognumdiscapacitadosSiso) {
		this.infdemognumdiscapacitadosSiso = infdemognumdiscapacitadosSiso;
	}

	public Integer getInfdemognumembarazadasSiso() {
		return this.infdemognumembarazadasSiso;
	}

	public void setInfdemognumembarazadasSiso(Integer infdemognumembarazadasSiso) {
		this.infdemognumembarazadasSiso = infdemognumembarazadasSiso;
	}

	public Integer getInfdemognumhombresSiso() {
		return this.infdemognumhombresSiso;
	}

	public void setInfdemognumhombresSiso(Integer infdemognumhombresSiso) {
		this.infdemognumhombresSiso = infdemognumhombresSiso;
	}

	public Integer getInfdemognummujeresSiso() {
		return this.infdemognummujeresSiso;
	}

	public void setInfdemognummujeresSiso(Integer infdemognummujeresSiso) {
		this.infdemognummujeresSiso = infdemognummujeresSiso;
	}

	public String getMatrizgestionssoSiso() {
		return this.matrizgestionssoSiso;
	}

	public void setMatrizgestionssoSiso(String matrizgestionssoSiso) {
		this.matrizgestionssoSiso = matrizgestionssoSiso;
	}

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipo() {
		return this.laboratorioscalibracionequipo;
	}

	public void setLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		this.laboratorioscalibracionequipo = laboratorioscalibracionequipo;
	}

	public List<Gestionsoo> getGestionsoos() {
		return this.gestionsoos;
	}

	public void setGestionsoos(List<Gestionsoo> gestionsoos) {
		this.gestionsoos = gestionsoos;
	}

}