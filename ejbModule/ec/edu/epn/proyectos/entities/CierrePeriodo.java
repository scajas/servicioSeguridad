package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.*;

import ec.edu.epn.contratos.entities.Pensum;

/**
 * The persistent class for the "cierrePeriodo" database table.
 * 
 */
@Entity
@Table(name = "\"cierrePeriodo\"", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "CierrePeriodo.findAll", query = "SELECT c FROM CierrePeriodo c")
public class CierrePeriodo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Double avance;

	private String cerrado;

	@Column(name = "id_pensum")
	private Integer idPensum;

	private String meses;

	private String tipo;
	
	@Transient
	private Pensum pensum;

	private String path;
	private Integer idRhPr;

	private String phatfirmadr;
	private String pathfirmajd;
	private String ncedjd;
	private String enviadoalf;
	private String iddocalf,observaciones,revisado,
	  pathmodifica;
	
	private Date fechacierredocente ,
	  fechacierrejd ,
	  fechacierrevips;

	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private ProyectoP proyecto;

	public CierrePeriodo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAvance() {
		return this.avance;
	}

	public void setAvance(Double avance) {
		this.avance = avance;
	}

	public String getCerrado() {
		return this.cerrado;
	}

	public void setCerrado(String cerrado) {
		this.cerrado = cerrado;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPhatfirmadr() {
		return phatfirmadr;
	}

	public void setPhatfirmadr(String phatfirmadr) {
		this.phatfirmadr = phatfirmadr;
	}

	public String getPathfirmajd() {
		return pathfirmajd;
	}

	public void setPathfirmajd(String pathfirmajd) {
		this.pathfirmajd = pathfirmajd;
	}

	public String getNcedjd() {
		return ncedjd;
	}

	public void setNcedjd(String ncedjd) {
		this.ncedjd = ncedjd;
	}

	public String getEnviadoalf() {
		return enviadoalf;
	}

	public void setEnviadoalf(String enviadoalf) {
		this.enviadoalf = enviadoalf;
	}

	public String getIddocalf() {
		return iddocalf;
	}

	public void setIddocalf(String iddocalf) {
		this.iddocalf = iddocalf;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPathmodifica() {
		return pathmodifica;
	}

	public void setPathmodifica(String pathmodifica) {
		this.pathmodifica = pathmodifica;
	}

	public Integer getIdRhPr() {
		return idRhPr;
	}

	public void setIdRhPr(Integer idRhPr) {
		this.idRhPr = idRhPr;
	}

	/**
	 * @return the pensum
	 */
	public Pensum getPensum() {
		return pensum;
	}

	/**
	 * @param pensum the pensum to set
	 */
	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

	public String getRevisado() {
		return revisado;
	}

	public void setRevisado(String revisado) {
		this.revisado = revisado;
	}

	public Date getFechacierredocente() {
		return fechacierredocente;
	}

	public void setFechacierredocente(Date fechacierredocente) {
		this.fechacierredocente = fechacierredocente;
	}

	public Date getFechacierrejd() {
		return fechacierrejd;
	}

	public void setFechacierrejd(Date fechacierrejd) {
		this.fechacierrejd = fechacierrejd;
	}

	public Date getFechacierrevips() {
		return fechacierrevips;
	}

	public void setFechacierrevips(Date fechacierrevips) {
		this.fechacierrevips = fechacierrevips;
	}

}