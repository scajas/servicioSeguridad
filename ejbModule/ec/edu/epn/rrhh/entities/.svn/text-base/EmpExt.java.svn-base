package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_ext database table.
 * 
 */
@Entity
@Table(name="emp_ext")
@NamedQuery(name="EmpExt.findAll", query="SELECT e FROM EmpExt e")
public class EmpExt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nced;

	private String cargo;

	@Column(name="cod_est")
	private String codEst;

	private String dependencia;

	private String nombres;

	private String relacion;

	private String vigencia;

	public EmpExt() {
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCodEst() {
		return this.codEst;
	}

	public void setCodEst(String codEst) {
		this.codEst = codEst;
	}

	public String getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRelacion() {
		return this.relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

}