package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadogestioncompra database table.
 * 
 */
@Entity
@Table(name="estadogestioncompra", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Estadogestioncompra.findAll", query="SELECT e FROM Estadogestioncompra e")
public class Estadogestioncompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadogcompra")
	private Integer idEstadogcompra;

	@Column(name="descripcion_estadogcompra")
	private String descripcionEstadogcompra;

	@Column(name="nombre_esatdogestioncompra")
	private String nombreEsatdogestioncompra;

	//bi-directional many-to-one association to Gestioncompra
	@OneToMany(mappedBy="estadogestioncompra")
	private List<Gestioncompra> gestioncompras;

	public Estadogestioncompra() {
	}

	public Integer getIdEstadogcompra() {
		return this.idEstadogcompra;
	}

	public void setIdEstadogcompra(Integer idEstadogcompra) {
		this.idEstadogcompra = idEstadogcompra;
	}

	public String getDescripcionEstadogcompra() {
		return this.descripcionEstadogcompra;
	}

	public void setDescripcionEstadogcompra(String descripcionEstadogcompra) {
		this.descripcionEstadogcompra = descripcionEstadogcompra;
	}

	public String getNombreEsatdogestioncompra() {
		return this.nombreEsatdogestioncompra;
	}

	public void setNombreEsatdogestioncompra(String nombreEsatdogestioncompra) {
		this.nombreEsatdogestioncompra = nombreEsatdogestioncompra;
	}

	public List<Gestioncompra> getGestioncompras() {
		return this.gestioncompras;
	}

	public void setGestioncompras(List<Gestioncompra> gestioncompras) {
		this.gestioncompras = gestioncompras;
	}

	public Gestioncompra addGestioncompra(Gestioncompra gestioncompra) {
		getGestioncompras().add(gestioncompra);
		gestioncompra.setEstadogestioncompra(this);

		return gestioncompra;
	}

	public Gestioncompra removeGestioncompra(Gestioncompra gestioncompra) {
		getGestioncompras().remove(gestioncompra);
		gestioncompra.setEstadogestioncompra(null);

		return gestioncompra;
	}

}