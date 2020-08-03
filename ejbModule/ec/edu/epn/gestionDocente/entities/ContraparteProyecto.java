package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contraparte_proyecto database table.
 * 
 */
@Entity
@Table(name="contraparte_proyecto")
@NamedQuery(name="ContraparteProyecto.findAll", query="SELECT c FROM ContraparteProyecto c")
public class ContraparteProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contraparte")
	private String idContraparte;

	@Column(name="_participacion")
	private Integer participacion;

	@Column(name="entidad_cont")
	private String entidadCont;

	@Column(name="id_pais")
	private String idPais;

	@Column(name="id_proy")
	private String idProy;

	@Column(name="nombre_cont")
	private String nombreCont;

	public ContraparteProyecto() {
	}

	public String getIdContraparte() {
		return this.idContraparte;
	}

	public void setIdContraparte(String idContraparte) {
		this.idContraparte = idContraparte;
	}

	public Integer getParticipacion() {
		return this.participacion;
	}

	public void setParticipacion(Integer participacion) {
		this.participacion = participacion;
	}

	public String getEntidadCont() {
		return this.entidadCont;
	}

	public void setEntidadCont(String entidadCont) {
		this.entidadCont = entidadCont;
	}

	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getIdProy() {
		return this.idProy;
	}

	public void setIdProy(String idProy) {
		this.idProy = idProy;
	}

	public String getNombreCont() {
		return this.nombreCont;
	}

	public void setNombreCont(String nombreCont) {
		this.nombreCont = nombreCont;
	}

}