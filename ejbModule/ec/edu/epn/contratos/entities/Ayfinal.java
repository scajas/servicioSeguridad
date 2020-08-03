package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ayfinal database table.
 * 
 */
@Entity
@NamedQuery(name="Ayfinal.findAll", query="SELECT a FROM Ayfinal a")
public class Ayfinal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String contrato;

	@Column(name="id_pensum")
	private Integer idPensum;

	private String nced;

	private String nombres;

	private String vacio;

	public Ayfinal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
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

	public String getVacio() {
		return this.vacio;
	}

	public void setVacio(String vacio) {
		this.vacio = vacio;
	}

}