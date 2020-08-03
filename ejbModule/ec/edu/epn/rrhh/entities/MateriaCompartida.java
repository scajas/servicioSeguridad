package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materia_compartida database table.
 * 
 */
@Entity
@Table(name="materia_compartida")
@NamedQuery(name="MateriaCompartida.findAll", query="SELECT m FROM MateriaCompartida m")
public class MateriaCompartida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mat_comp")
	private Integer idMatComp;

	private String categoria;

	private String cedpro;

	private String codprf;

	private String dedicacion;

	private String emailepn;

	private String emailp;

	private String estadop;

	private String fecnac;

	private String nompro;

	private String telefp;

	public MateriaCompartida() {
	}

	public Integer getIdMatComp() {
		return this.idMatComp;
	}

	public void setIdMatComp(Integer idMatComp) {
		this.idMatComp = idMatComp;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCedpro() {
		return this.cedpro;
	}

	public void setCedpro(String cedpro) {
		this.cedpro = cedpro;
	}

	public String getCodprf() {
		return this.codprf;
	}

	public void setCodprf(String codprf) {
		this.codprf = codprf;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getEmailepn() {
		return this.emailepn;
	}

	public void setEmailepn(String emailepn) {
		this.emailepn = emailepn;
	}

	public String getEmailp() {
		return this.emailp;
	}

	public void setEmailp(String emailp) {
		this.emailp = emailp;
	}

	public String getEstadop() {
		return this.estadop;
	}

	public void setEstadop(String estadop) {
		this.estadop = estadop;
	}

	public String getFecnac() {
		return this.fecnac;
	}

	public void setFecnac(String fecnac) {
		this.fecnac = fecnac;
	}

	public String getNompro() {
		return this.nompro;
	}

	public void setNompro(String nompro) {
		this.nompro = nompro;
	}

	public String getTelefp() {
		return this.telefp;
	}

	public void setTelefp(String telefp) {
		this.telefp = telefp;
	}

}