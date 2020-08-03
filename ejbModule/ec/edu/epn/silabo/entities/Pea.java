package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pea database table.
 * 
 */
@Entity
@Table(name="pea", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name="Pea.findAll", query="SELECT p FROM Pea p")
public class Pea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pea", unique=true, nullable=false)
	private Integer idPea;

	@Column(length=15)
	private String anio;

	@Column(length=256)
	private String asignatura;

	@Column(length=256)
	private String carrera;

	@Column(name="categoria_materia", length=256)
	private String categoriaMateria;

	@Column(name="co_req_codigo", length=256)
	private String coReqCodigo;

	@Column(name="co_req_nombre", length=256)
	private String coReqNombre;

	@Column(length=10)
	private String codcarrera;

	@Column(length=256)
	private String codigo;

	@Column(length=256)
	private String creditos;

	@Column(length=256)
	private String eje;

	@Column(length=256)
	private String facultad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Temporal(TemporalType.DATE)
	private Date ffinsem;

	@Temporal(TemporalType.DATE)
	private Date finisem;

	@Column(name="id_pensum", nullable=false)
	private Integer idPensum;

	@Column(name="id_usuario", nullable=false)
	private Integer idUsuario;

	@Column(name="nombre_usuario", length=20)
	private String nombreUsuario;

	@Column(length=256)
	private String paralelo;

	@Column(name="pre_req_codigo", length=256)
	private String preReqCodigo;

	@Column(name="pre_req_nombre", length=256)
	private String preReqNombre;

	@Column(name="tipo_materia", length=256)
	private String tipoMateria;

	//bi-directional many-to-one association to BibliografiaPea
	@OneToMany(mappedBy="pea")
	private List<BibliografiaPea> bibliografiaPeas;

	//bi-directional many-to-one association to CapituloPea
	@OneToMany(mappedBy="pea")
	private List<CapituloPea> capituloPeas;

	//bi-directional many-to-one association to ResultadosPea
	@OneToMany(mappedBy="pea")
	private List<ResultadosPea> resultadosPeas;

	public Pea() {
	}

	public Integer getIdPea() {
		return this.idPea;
	}

	public void setIdPea(Integer idPea) {
		this.idPea = idPea;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCategoriaMateria() {
		return this.categoriaMateria;
	}

	public void setCategoriaMateria(String categoriaMateria) {
		this.categoriaMateria = categoriaMateria;
	}

	public String getCoReqCodigo() {
		return this.coReqCodigo;
	}

	public void setCoReqCodigo(String coReqCodigo) {
		this.coReqCodigo = coReqCodigo;
	}

	public String getCoReqNombre() {
		return this.coReqNombre;
	}

	public void setCoReqNombre(String coReqNombre) {
		this.coReqNombre = coReqNombre;
	}

	public String getCodcarrera() {
		return this.codcarrera;
	}

	public void setCodcarrera(String codcarrera) {
		this.codcarrera = codcarrera;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return this.creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getEje() {
		return this.eje;
	}

	public void setEje(String eje) {
		this.eje = eje;
	}

	public String getFacultad() {
		return this.facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Date getFfinsem() {
		return this.ffinsem;
	}

	public void setFfinsem(Date ffinsem) {
		this.ffinsem = ffinsem;
	}

	public Date getFinisem() {
		return this.finisem;
	}

	public void setFinisem(Date finisem) {
		this.finisem = finisem;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getPreReqCodigo() {
		return this.preReqCodigo;
	}

	public void setPreReqCodigo(String preReqCodigo) {
		this.preReqCodigo = preReqCodigo;
	}

	public String getPreReqNombre() {
		return this.preReqNombre;
	}

	public void setPreReqNombre(String preReqNombre) {
		this.preReqNombre = preReqNombre;
	}

	public String getTipoMateria() {
		return this.tipoMateria;
	}

	public void setTipoMateria(String tipoMateria) {
		this.tipoMateria = tipoMateria;
	}

	public List<BibliografiaPea> getBibliografiaPeas() {
		return this.bibliografiaPeas;
	}

	public void setBibliografiaPeas(List<BibliografiaPea> bibliografiaPeas) {
		this.bibliografiaPeas = bibliografiaPeas;
	}

	public BibliografiaPea addBibliografiaPea(BibliografiaPea bibliografiaPea) {
		getBibliografiaPeas().add(bibliografiaPea);
		bibliografiaPea.setPea(this);

		return bibliografiaPea;
	}

	public BibliografiaPea removeBibliografiaPea(BibliografiaPea bibliografiaPea) {
		getBibliografiaPeas().remove(bibliografiaPea);
		bibliografiaPea.setPea(null);

		return bibliografiaPea;
	}

	public List<CapituloPea> getCapituloPeas() {
		return this.capituloPeas;
	}

	public void setCapituloPeas(List<CapituloPea> capituloPeas) {
		this.capituloPeas = capituloPeas;
	}

	public CapituloPea addCapituloPea(CapituloPea capituloPea) {
		getCapituloPeas().add(capituloPea);
		capituloPea.setPea(this);

		return capituloPea;
	}

	public CapituloPea removeCapituloPea(CapituloPea capituloPea) {
		getCapituloPeas().remove(capituloPea);
		capituloPea.setPea(null);

		return capituloPea;
	}

	public List<ResultadosPea> getResultadosPeas() {
		return this.resultadosPeas;
	}

	public void setResultadosPeas(List<ResultadosPea> resultadosPeas) {
		this.resultadosPeas = resultadosPeas;
	}

	public ResultadosPea addResultadosPea(ResultadosPea resultadosPea) {
		getResultadosPeas().add(resultadosPea);
		resultadosPea.setPea(this);

		return resultadosPea;
	}

	public ResultadosPea removeResultadosPea(ResultadosPea resultadosPea) {
		getResultadosPeas().remove(resultadosPea);
		resultadosPea.setPea(null);

		return resultadosPea;
	}

}