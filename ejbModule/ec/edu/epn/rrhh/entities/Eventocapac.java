package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eventocapac database table.
 * 
 */
@Entity
@Table(name = "eventocapac", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Eventocapac.findAll", query="SELECT e FROM Eventocapac e")
public class Eventocapac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigoevento;

	@Column(name="area_c")
	private String areaC;

	private String auspiciante;

	private String contenido;

	private String duracion;

	private String facilitador;

	@Temporal(TemporalType.DATE)
	private Date fechadesde;

	@Temporal(TemporalType.DATE)
	private Date fechahasta;

	private String formaaprobacion;

	private String horario;

	private Integer idevento;

	private String logistica;

	private String lugar;

	private String metodologia;

	private String nced;

	@Column(name="nom_pais")
	private String nomPais;

	private String nombre;

	private String objespecificos;

	private String objgeneral;

	private String observaciones;

	private String path;

	private String recyactivinstruc;

	private String tipocertificado;

	private String tipoevento;

	//bi-directional many-to-one association to Deteventocapac
	@OneToMany(mappedBy="eventocapac")
	private List<Deteventocapac> deteventocapacs;

	public Eventocapac() {
	}

	public String getCodigoevento() {
		return this.codigoevento;
	}

	public void setCodigoevento(String codigoevento) {
		this.codigoevento = codigoevento;
	}

	public String getAreaC() {
		return this.areaC;
	}

	public void setAreaC(String areaC) {
		this.areaC = areaC;
	}

	public String getAuspiciante() {
		return this.auspiciante;
	}

	public void setAuspiciante(String auspiciante) {
		this.auspiciante = auspiciante;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFacilitador() {
		return this.facilitador;
	}

	public void setFacilitador(String facilitador) {
		this.facilitador = facilitador;
	}

	public Date getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getFormaaprobacion() {
		return this.formaaprobacion;
	}

	public void setFormaaprobacion(String formaaprobacion) {
		this.formaaprobacion = formaaprobacion;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getIdevento() {
		return this.idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

	public String getLogistica() {
		return this.logistica;
	}

	public void setLogistica(String logistica) {
		this.logistica = logistica;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMetodologia() {
		return this.metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObjespecificos() {
		return this.objespecificos;
	}

	public void setObjespecificos(String objespecificos) {
		this.objespecificos = objespecificos;
	}

	public String getObjgeneral() {
		return this.objgeneral;
	}

	public void setObjgeneral(String objgeneral) {
		this.objgeneral = objgeneral;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRecyactivinstruc() {
		return this.recyactivinstruc;
	}

	public void setRecyactivinstruc(String recyactivinstruc) {
		this.recyactivinstruc = recyactivinstruc;
	}

	public String getTipocertificado() {
		return this.tipocertificado;
	}

	public void setTipocertificado(String tipocertificado) {
		this.tipocertificado = tipocertificado;
	}

	public String getTipoevento() {
		return this.tipoevento;
	}

	public void setTipoevento(String tipoevento) {
		this.tipoevento = tipoevento;
	}

	public List<Deteventocapac> getDeteventocapacs() {
		return this.deteventocapacs;
	}

	public void setDeteventocapacs(List<Deteventocapac> deteventocapacs) {
		this.deteventocapacs = deteventocapacs;
	}

	public Deteventocapac addDeteventocapac(Deteventocapac deteventocapac) {
		getDeteventocapacs().add(deteventocapac);
		deteventocapac.setEventocapac(this);

		return deteventocapac;
	}

	public Deteventocapac removeDeteventocapac(Deteventocapac deteventocapac) {
		getDeteventocapacs().remove(deteventocapac);
		deteventocapac.setEventocapac(null);

		return deteventocapac;
	}

}