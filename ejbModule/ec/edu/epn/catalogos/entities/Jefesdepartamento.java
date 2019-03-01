package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jefesdepartamento database table.
 * 
 */
@Entity
@NamedQuery(name="Jefesdepartamento.findAll", query="SELECT j FROM Jefesdepartamento j")
public class Jefesdepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jefedept")
	private Integer idJefedept;

	@Column(name="apel_jefdepart")
	private String apelJefdepart;

	@Temporal(TemporalType.DATE)
	private Date fechaf;

	@Temporal(TemporalType.DATE)
	private Date fechaini;

	private String nced;

	@Column(name="nom_jefdepart")
	private String nomJefdepart;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_depart")
	private Departamento departamento;

	public Jefesdepartamento() {
	}

	public Integer getIdJefedept() {
		return this.idJefedept;
	}

	public void setIdJefedept(Integer idJefedept) {
		this.idJefedept = idJefedept;
	}

	public String getApelJefdepart() {
		return this.apelJefdepart;
	}

	public void setApelJefdepart(String apelJefdepart) {
		this.apelJefdepart = apelJefdepart;
	}

	public Date getFechaf() {
		return this.fechaf;
	}

	public void setFechaf(Date fechaf) {
		this.fechaf = fechaf;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomJefdepart() {
		return this.nomJefdepart;
	}

	public void setNomJefdepart(String nomJefdepart) {
		this.nomJefdepart = nomJefdepart;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}