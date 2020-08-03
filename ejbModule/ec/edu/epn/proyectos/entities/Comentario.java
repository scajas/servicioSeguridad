package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cometario;

	private String estado;
	private String tipo;
	private String path;

	@ManyToOne
	@JoinColumn(name = "id_proy")
	private CierrePeriodo cierre;
	private String nced ,coddep,asunto,vips, de,para; 
	private Date fecha;

	public Comentario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCometario() {
		return this.cometario;
	}

	public void setCometario(String cometario) {
		this.cometario = cometario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	public String getNced() {
		return nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getCoddep() {
		return coddep;
	}

	public void setCoddep(String coddep) {
		this.coddep = coddep;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getVips() {
		return vips;
	}

	public void setVips(String vips) {
		this.vips = vips;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CierrePeriodo getCierre() {
		return cierre;
	}

	public void setCierre(CierrePeriodo cierre) {
		this.cierre = cierre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

	

}