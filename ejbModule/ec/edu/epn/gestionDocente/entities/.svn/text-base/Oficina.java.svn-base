package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oficina")
	private String idOficina;

	private String extens;

	@Column(name="id_edificio")
	private String idEdificio;

	@Column(name="num_oficina")
	private Integer numOficina;

	private String telef;

	public Oficina() {
	}

	public String getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public String getExtens() {
		return this.extens;
	}

	public void setExtens(String extens) {
		this.extens = extens;
	}

	public String getIdEdificio() {
		return this.idEdificio;
	}

	public void setIdEdificio(String idEdificio) {
		this.idEdificio = idEdificio;
	}

	public Integer getNumOficina() {
		return this.numOficina;
	}

	public void setNumOficina(Integer numOficina) {
		this.numOficina = numOficina;
	}

	public String getTelef() {
		return this.telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

}