package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the concentracion database table.
 * 
 */
@Entity
@Table(name = "concentracion", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Concentracion.findAll", query="SELECT c FROM Concentracion c")
public class Concentracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@SequenceGenerator(name="CONCENTRACION_IDCONCENTRACION_GENERATOR", sequenceName="secuencia_concentracion",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCENTRACION_IDCONCENTRACION_GENERATOR")
	
	@Column(name="id_concentracion")
	private int idConcentracion;

	@Column(name="descr_con")
	private String descrCon;

	@Column(name="nombre_con")
	private String nombreCon;

	//bi-directional many-to-one association to Existencia
	//@OneToMany(mappedBy="concentracion")
	//private List<Existencia> existencias;

	public Concentracion() {
	}

	public int getIdConcentracion() {
		return idConcentracion;
	}

	public void setIdConcentracion(int idConcentracion) {
		this.idConcentracion = idConcentracion;
	}



	public String getDescrCon() {
		return this.descrCon;
	}

	public void setDescrCon(String descrCon) {
		this.descrCon = descrCon;
	}

	public String getNombreCon() {
		return this.nombreCon;
	}

	public void setNombreCon(String nombreCon) {
		this.nombreCon = nombreCon;
	}

	/*public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setConcentracion(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setConcentracion(null);

		return existencia;
	}*/

}