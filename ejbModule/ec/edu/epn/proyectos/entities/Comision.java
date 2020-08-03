package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comision database table.
 * 
 */
@Entity

@Table(name="comision", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Comision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_com")
	private Integer idCom;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_c")
	private Date fechaC;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_i")
	private Date fechaI;

    
    private Integer congruencia;
    
    private Integer metodo;
    
    private Integer coherencia;
    
    private Integer impacto;
    
    private Integer total;
    
    private String formato;
    private String firma;
    private String firmajefe;
    private String nombrelinea;
    private Double monto;
    private String enmarca;
    private String genara;
    private String juscongr;
    private String jusmeto;
    private String justforma;
    private String justimpacto;
    private String fechrev;
    
    
    private Integer coherenciatit;
    private String juscohetit;
    
    
    private Integer personal;
    private String juspersonal;
    
    private Integer vinculacion;
    private String jusvinculacion;
    
    private Integer revision;
    private String jusrevision;
    
    private Integer personalcolab;
    private String justpersonacolab;
    
	
	

	private String observacion;
	
	private String estado;

	@Column(name="url_archivo")
	private String urlArchivo;

	
	@OneToMany(mappedBy="comision")
	private List<Miembro> miembros;
	
	 @ManyToOne
		@JoinColumn(name="id_proy")
		private ProyectoP proyecto;
	

    public Comision() {
    }

	public Integer getIdCom() {
		return this.idCom;
	}

	public void setIdCom(Integer idCom) {
		this.idCom = idCom;
	}

	public Date getFechaC() {
		return this.fechaC;
	}

	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	public Date getFechaI() {
		return this.fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUrlArchivo() {
		return this.urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public List<Miembro> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCongruencia() {
		return congruencia;
	}

	public void setCongruencia(Integer congruencia) {
		this.congruencia = congruencia;
	}

	public Integer getMetodo() {
		return metodo;
	}

	public void setMetodo(Integer metodo) {
		this.metodo = metodo;
	}

	public Integer getCoherencia() {
		return coherencia;
	}

	public void setCoherencia(Integer coherencia) {
		this.coherencia = coherencia;
	}

	public Integer getImpacto() {
		return impacto;
	}

	public void setImpacto(Integer impacto) {
		this.impacto = impacto;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getFirmajefe() {
		return firmajefe;
	}

	public void setFirmajefe(String firmajefe) {
		this.firmajefe = firmajefe;
	}

	public String getNombrelinea() {
		return nombrelinea;
	}

	public void setNombrelinea(String nombrelinea) {
		this.nombrelinea = nombrelinea;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getEnmarca() {
		return enmarca;
	}

	public void setEnmarca(String enmarca) {
		this.enmarca = enmarca;
	}

	public String getGenara() {
		return genara;
	}

	public void setGenara(String genara) {
		this.genara = genara;
	}

	public String getJuscongr() {
		return juscongr;
	}

	public void setJuscongr(String juscongr) {
		this.juscongr = juscongr;
	}

	public String getJusmeto() {
		return jusmeto;
	}

	public void setJusmeto(String jusmeto) {
		this.jusmeto = jusmeto;
	}

	public String getJustforma() {
		return justforma;
	}

	public void setJustforma(String justforma) {
		this.justforma = justforma;
	}

	public String getJustimpacto() {
		return justimpacto;
	}

	public void setJustimpacto(String justimpacto) {
		this.justimpacto = justimpacto;
	}

	public String getFechrev() {
		return fechrev;
	}

	public void setFechrev(String fechrev) {
		this.fechrev = fechrev;
	}

	/**
	 * @return the coherenciatit
	 */
	public Integer getCoherenciatit() {
		return coherenciatit;
	}

	/**
	 * @param coherenciatit the coherenciatit to set
	 */
	public void setCoherenciatit(Integer coherenciatit) {
		this.coherenciatit = coherenciatit;
	}

	/**
	 * @return the juscohetit
	 */
	public String getJuscohetit() {
		return juscohetit;
	}

	/**
	 * @param juscohetit the juscohetit to set
	 */
	public void setJuscohetit(String juscohetit) {
		this.juscohetit = juscohetit;
	}

	/**
	 * @return the personal
	 */
	public Integer getPersonal() {
		return personal;
	}

	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(Integer personal) {
		this.personal = personal;
	}

	/**
	 * @return the juspersonal
	 */
	public String getJuspersonal() {
		return juspersonal;
	}

	/**
	 * @param juspersonal the juspersonal to set
	 */
	public void setJuspersonal(String juspersonal) {
		this.juspersonal = juspersonal;
	}

	/**
	 * @return the vinculacion
	 */
	public Integer getVinculacion() {
		return vinculacion;
	}

	/**
	 * @param vinculacion the vinculacion to set
	 */
	public void setVinculacion(Integer vinculacion) {
		this.vinculacion = vinculacion;
	}

	/**
	 * @return the jusvinculacion
	 */
	public String getJusvinculacion() {
		return jusvinculacion;
	}

	/**
	 * @param jusvinculacion the jusvinculacion to set
	 */
	public void setJusvinculacion(String jusvinculacion) {
		this.jusvinculacion = jusvinculacion;
	}

	/**
	 * @return the revision
	 */
	public Integer getRevision() {
		return revision;
	}

	/**
	 * @param revision the revision to set
	 */
	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	/**
	 * @return the jusrevision
	 */
	public String getJusrevision() {
		return jusrevision;
	}

	/**
	 * @param jusrevision the jusrevision to set
	 */
	public void setJusrevision(String jusrevision) {
		this.jusrevision = jusrevision;
	}

	/**
	 * @return the personalcolab
	 */
	public Integer getPersonalcolab() {
		return personalcolab;
	}

	/**
	 * @param personalcolab the personalcolab to set
	 */
	public void setPersonalcolab(Integer personalcolab) {
		this.personalcolab = personalcolab;
	}

	/**
	 * @return the justpersonacolab
	 */
	public String getJustpersonacolab() {
		return justpersonacolab;
	}

	/**
	 * @param justpersonacolab the justpersonacolab to set
	 */
	public void setJustpersonacolab(String justpersonacolab) {
		this.justpersonacolab = justpersonacolab;
	}
	
}