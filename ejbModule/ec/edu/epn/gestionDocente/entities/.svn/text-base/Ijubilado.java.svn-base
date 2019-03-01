package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ijubilado database table.
 * 
 */
@Entity
@NamedQuery(name="Ijubilado.findAll", query="SELECT i FROM Ijubilado i")
public class Ijubilado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ij")
	private Integer idIj;

	private String aexperticia;

	private String dictadopos;

	private String dictadopre;

	private String dictadotec;

	private String dirtespos;

	private String dirtespre;

	private String empub;

	private String entcap;

	private String entcec;

	private String entsem;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desv")
	private Date fechaDesv;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reg")
	private Date fechaReg;

	private String nced;

	private String proyectos;

	public Ijubilado() {
	}

	public Integer getIdIj() {
		return this.idIj;
	}

	public void setIdIj(Integer idIj) {
		this.idIj = idIj;
	}

	public String getAexperticia() {
		return this.aexperticia;
	}

	public void setAexperticia(String aexperticia) {
		this.aexperticia = aexperticia;
	}

	public String getDictadopos() {
		return this.dictadopos;
	}

	public void setDictadopos(String dictadopos) {
		this.dictadopos = dictadopos;
	}

	public String getDictadopre() {
		return this.dictadopre;
	}

	public void setDictadopre(String dictadopre) {
		this.dictadopre = dictadopre;
	}

	public String getDictadotec() {
		return this.dictadotec;
	}

	public void setDictadotec(String dictadotec) {
		this.dictadotec = dictadotec;
	}

	public String getDirtespos() {
		return this.dirtespos;
	}

	public void setDirtespos(String dirtespos) {
		this.dirtespos = dirtespos;
	}

	public String getDirtespre() {
		return this.dirtespre;
	}

	public void setDirtespre(String dirtespre) {
		this.dirtespre = dirtespre;
	}

	public String getEmpub() {
		return this.empub;
	}

	public void setEmpub(String empub) {
		this.empub = empub;
	}

	public String getEntcap() {
		return this.entcap;
	}

	public void setEntcap(String entcap) {
		this.entcap = entcap;
	}

	public String getEntcec() {
		return this.entcec;
	}

	public void setEntcec(String entcec) {
		this.entcec = entcec;
	}

	public String getEntsem() {
		return this.entsem;
	}

	public void setEntsem(String entsem) {
		this.entsem = entsem;
	}

	public Date getFechaDesv() {
		return this.fechaDesv;
	}

	public void setFechaDesv(Date fechaDesv) {
		this.fechaDesv = fechaDesv;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(String proyectos) {
		this.proyectos = proyectos;
	}

}