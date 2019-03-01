package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the docentes database table.
 * 
 */
@Entity
@Table(name="docentes")
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_doc")
	private Integer idDoc;

	private String cargo;

	private String contrato;

	private String dedica;

	private String dedicacion;

	private String nced;

	private String nombres;

	private String registro;

	@Column(name="relacion_actual")
	private String relacionActual;

	private String tipocon;

	public Docente() {
	}

	public Integer getIdDoc() {
		return this.idDoc;
	}

	public void setIdDoc(Integer idDoc) {
		this.idDoc = idDoc;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getDedica() {
		return this.dedica;
	}

	public void setDedica(String dedica) {
		this.dedica = dedica;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getRelacionActual() {
		return this.relacionActual;
	}

	public void setRelacionActual(String relacionActual) {
		this.relacionActual = relacionActual;
	}

	public String getTipocon() {
		return this.tipocon;
	}

	public void setTipocon(String tipocon) {
		this.tipocon = tipocon;
	}

}