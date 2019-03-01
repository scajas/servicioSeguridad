package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the categorias_d database table.
 * 
 */
@Entity

@Table(name = "categorias_d", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "CategoriasD.findAll", query = "SELECT c FROM CategoriasD c")
public class CategoriasD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cat")
	private Integer idCat;

	@Column(name = "nombre_cat")
	private String nombreCat;

	private Integer serie;

	// bi-directional many-to-one association to Recategorizacion
	@OneToMany(mappedBy = "categoriasD")
	private List<Recategorizacion> recategorizacions;

	public CategoriasD() {
	}

	public Integer getIdCat() {
		return this.idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public String getNombreCat() {
		return this.nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public Integer getSerie() {
		return this.serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public List<Recategorizacion> getRecategorizacions() {
		return this.recategorizacions;
	}

	public void setRecategorizacions(List<Recategorizacion> recategorizacions) {
		this.recategorizacions = recategorizacions;
	}

	public Recategorizacion addRecategorizacion(Recategorizacion recategorizacion) {
		getRecategorizacions().add(recategorizacion);
		recategorizacion.setCategoriasD(this);

		return recategorizacion;
	}

	public Recategorizacion removeRecategorizacion(Recategorizacion recategorizacion) {
		getRecategorizacions().remove(recategorizacion);
		recategorizacion.setCategoriasD(null);

		return recategorizacion;
	}

}