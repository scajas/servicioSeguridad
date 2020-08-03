package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the investigador database table.
 * 
 */
@Entity
@Table(name="investigador", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Investigador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_inv")
	private Integer idInv;

	private String apellidos;

	@Column(name="attribute_7")
	private String attribute7;

	private String email;

	@Column(name="lugar_trabajo")
	private String lugarTrabajo;

	private String nidentificacion;

	private String nombres;

	//bi-directional many-to-one association to InvestigadorLinv
	@OneToMany(mappedBy="investigador")
	private List<InvestigadorLinv> investigadorLinvs;

	//bi-directional many-to-one association to InvestigadorObservacione
	@OneToMany(mappedBy="investigador")
	private List<InvestigadorObservacione> investigadorObservaciones;

    public Investigador() {
    }

	public Integer getIdInv() {
		return this.idInv;
	}

	public void setIdInv(Integer idInv) {
		this.idInv = idInv;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getNidentificacion() {
		return this.nidentificacion;
	}

	public void setNidentificacion(String nidentificacion) {
		this.nidentificacion = nidentificacion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<InvestigadorLinv> getInvestigadorLinvs() {
		return this.investigadorLinvs;
	}

	public void setInvestigadorLinvs(List<InvestigadorLinv> investigadorLinvs) {
		this.investigadorLinvs = investigadorLinvs;
	}
	
	public List<InvestigadorObservacione> getInvestigadorObservaciones() {
		return this.investigadorObservaciones;
	}

	public void setInvestigadorObservaciones(List<InvestigadorObservacione> investigadorObservaciones) {
		this.investigadorObservaciones = investigadorObservaciones;
	}
	
}