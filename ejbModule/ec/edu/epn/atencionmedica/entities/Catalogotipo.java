package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogotipo database table.
 * 
 */
@Entity
@Table(name="catalogotipo", catalog="bddcorpepn", schema="`Medico`")
public class Catalogotipo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6703092247766362722L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_catalogotipo")
	private Integer idCatalogotipo;

	@Column(name="editable_cat")
	private Boolean editableCat;

	@Column(name="nombre_cat")
	private String nombreCat;

	//bi-directional many-to-one association to Catalogo
	@OneToMany(mappedBy="catalogotipo")
	private List<Catalogo> catalogos;

	public Catalogotipo() {
	}

	public Integer getIdCatalogotipo() {
		return this.idCatalogotipo;
	}

	public void setIdCatalogotipo(Integer idCatalogotipo) {
		this.idCatalogotipo = idCatalogotipo;
	}

	public Boolean getEditableCat() {
		return this.editableCat;
	}

	public void setEditableCat(Boolean editableCat) {
		this.editableCat = editableCat;
	}

	public String getNombreCat() {
		return this.nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	

}