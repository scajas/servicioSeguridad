package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the recorrido_cierre database table.
 * 
 */
@Entity
@Table(name="recorrido_cierre", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="RecorridoCierre.findAll", query="SELECT r FROM RecorridoCierre r")
public class RecorridoCierre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado,de,para;

	private Date fecha;


	@ManyToOne
	@JoinColumn(name = "id_proy")
	private CierrePeriodo cierre;
	public RecorridoCierre() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
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
	
	


	

	

}