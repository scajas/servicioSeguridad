package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name = "categoria" , catalog = "`bddcorpepn`", schema = "`Contratos`")
public class CategoriaContratos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cat")
	private Integer idCat;

	@Column(name="descr_cat")
	private String descrCat;

	@Column(name="nombre_cat")
	private String nombreCat;

	

    public CategoriaContratos() {
    }

	public Integer getIdCat() {
		return this.idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public String getDescrCat() {
		return this.descrCat;
	}

	public void setDescrCat(String descrCat) {
		this.descrCat = descrCat;
	}

	public String getNombreCat() {
		return this.nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	
}