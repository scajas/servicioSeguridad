package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the facultad database table.
 * 
 */
@Entity(name = "FacultadCatalogos")
@Table(name = "`facultad`", catalog = "`bddcorpepn`", schema = "`Catalogos`")
public class FacultadCatalogos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_facultad")
	private String idFacultad;

	@Column(name = "nom_decano")
	private String nomDecano;

	@Column(name = "nom_facultad")
	private String nomFacultad;

	@Column(name = "nom_subdecano")
	private String nomSubdecano;

	public FacultadCatalogos() {
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomDecano() {
		return this.nomDecano;
	}

	public void setNomDecano(String nomDecano) {
		this.nomDecano = nomDecano;
	}

	public String getNomFacultad() {
		return this.nomFacultad;
	}

	public void setNomFacultad(String nomFacultad) {
		this.nomFacultad = nomFacultad;
	}

	public String getNomSubdecano() {
		return this.nomSubdecano;
	}

	public void setNomSubdecano(String nomSubdecano) {
		this.nomSubdecano = nomSubdecano;
	}

}