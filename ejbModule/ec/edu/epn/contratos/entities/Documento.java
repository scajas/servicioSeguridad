package ec.edu.epn.contratos.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the documentos database table.
 * 
 */
@Entity
@Table(name = "documentos", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_docuemnto")
	private Integer idDocuemnto;

	@Column(name = "path")
	private String pathDocumento;

	@Column(name = "nombre_archivo")
	private String nombreDocumento;

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getPathDocumento() {
		return pathDocumento;
	}

	public void setPathDocumento(String pathDocumento) {
		this.pathDocumento = pathDocumento;
	}

	public Documento() {
	}

	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedido ped;

	public Pedido getPed() {
		return ped;
	}

	public void setPed(Pedido ped) {
		this.ped = ped;
	}

	public Integer getIdDocuemnto() {
		return this.idDocuemnto;
	}

	public void setIdDocuemnto(Integer idDocuemnto) {
		this.idDocuemnto = idDocuemnto;
	}

}