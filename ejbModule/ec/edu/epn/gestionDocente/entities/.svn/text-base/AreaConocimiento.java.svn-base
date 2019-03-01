package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area_conocimiento database table.
 * 
 */
@Entity
@Table(name="area_conocimiento", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="AreaConocimiento.findAll", query="SELECT a FROM AreaConocimiento a order by a.idAreaCon ")
public class AreaConocimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_area_con")
	private String idAreaCon;

	@Column(name="cod_area_con")
	private String codAreaCon;

	@Column(name="nombre_area_con")
	private String nombreAreaCon;

	@Column(name="nombre_area_padre")
	private String nombreAreaPadre;

	@Column(name="nombre_subindice")
	private String nombreSubindice;

	private String subindice;
	
	
	@OneToMany(mappedBy="area")
	private List<TituloFormacionAcademica> titulo;

	//bi-directional many-to-one association to AreaConocDocente
	@OneToMany(mappedBy="areaConocimiento")
	private List<AreaConocDocente> areaConocDocentes;

	public AreaConocimiento() {
	}

	public String getIdAreaCon() {
		return this.idAreaCon;
	}

	public void setIdAreaCon(String idAreaCon) {
		this.idAreaCon = idAreaCon;
	}

	public String getCodAreaCon() {
		return this.codAreaCon;
	}

	public void setCodAreaCon(String codAreaCon) {
		this.codAreaCon = codAreaCon;
	}

	public String getNombreAreaCon() {
		return this.nombreAreaCon;
	}

	public void setNombreAreaCon(String nombreAreaCon) {
		this.nombreAreaCon = nombreAreaCon;
	}

	public String getNombreAreaPadre() {
		return this.nombreAreaPadre;
	}

	public void setNombreAreaPadre(String nombreAreaPadre) {
		this.nombreAreaPadre = nombreAreaPadre;
	}

	public String getNombreSubindice() {
		return this.nombreSubindice;
	}

	public void setNombreSubindice(String nombreSubindice) {
		this.nombreSubindice = nombreSubindice;
	}

	public String getSubindice() {
		return this.subindice;
	}

	public void setSubindice(String subindice) {
		this.subindice = subindice;
	}

	public List<AreaConocDocente> getAreaConocDocentes() {
		return this.areaConocDocentes;
	}

	public void setAreaConocDocentes(List<AreaConocDocente> areaConocDocentes) {
		this.areaConocDocentes = areaConocDocentes;
	}

	public AreaConocDocente addAreaConocDocente(AreaConocDocente areaConocDocente) {
		getAreaConocDocentes().add(areaConocDocente);
		areaConocDocente.setAreaConocimiento(this);

		return areaConocDocente;
	}

	public AreaConocDocente removeAreaConocDocente(AreaConocDocente areaConocDocente) {
		getAreaConocDocentes().remove(areaConocDocente);
		areaConocDocente.setAreaConocimiento(null);

		return areaConocDocente;
	}

	public List<TituloFormacionAcademica> getTitulo() {
		return titulo;
	}

	public void setTitulo(List<TituloFormacionAcademica> titulo) {
		this.titulo = titulo;
	}
	
	

}