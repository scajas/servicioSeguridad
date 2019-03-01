package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obras database table.
 * 
 */
@Entity
@Table(name="obras")
@NamedQuery(name="Obra.findAll", query="SELECT o FROM Obra o")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_obra")
	private Integer idObra;

	@Column(name="descr_obra")
	private String descrObra;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_obra")
	private Date fechaObra;

	private String nced;

	@Column(name="nombre_obra")
	private String nombreObra;

	private String revisada;

	private String valida;

	public Obra() {
	}

	public Integer getIdObra() {
		return this.idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public String getDescrObra() {
		return this.descrObra;
	}

	public void setDescrObra(String descrObra) {
		this.descrObra = descrObra;
	}

	public Date getFechaObra() {
		return this.fechaObra;
	}

	public void setFechaObra(Date fechaObra) {
		this.fechaObra = fechaObra;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreObra() {
		return this.nombreObra;
	}

	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}

	public String getRevisada() {
		return this.revisada;
	}

	public void setRevisada(String revisada) {
		this.revisada = revisada;
	}

	public String getValida() {
		return this.valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

}