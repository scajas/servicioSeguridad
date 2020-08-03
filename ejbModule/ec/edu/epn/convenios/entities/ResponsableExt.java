package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the responsable_ext database table.
 * 
 */
@Entity
@Table(name = "responsable_ext", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class ResponsableExt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_perx")
	private Integer codPerx;

	private String cargo;

	@Column(name = "cod_emp")
	private Integer codEmp;

	private String direc;

	private String ext;

	private String fono;

	private String mail;

	private String nombres;

	private String tit;

	private String apellido;

	public ResponsableExt() {
	}

	public Integer getCodPerx() {
		return this.codPerx;
	}

	public void setCodPerx(Integer codPerx) {
		this.codPerx = codPerx;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getDirec() {
		return this.direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFono() {
		return this.fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTit() {
		return this.tit;
	}

	public void setTit(String tit) {
		this.tit = tit;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}