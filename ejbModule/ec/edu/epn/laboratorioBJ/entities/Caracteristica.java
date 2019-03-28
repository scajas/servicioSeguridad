package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the caracteristica database table.
 * 
 */
@Entity
@Table(name = "caracteristica", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Caracteristica.findAll", query="SELECT c FROM Caracteristica c")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICA_IDCARACTERISTICA_GENERATOR", sequenceName="secuencia_caracteristica",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARACTERISTICA_IDCARACTERISTICA_GENERATOR")
	@Column(name="id_caracteristica")
	private int idCaracteristica;

	@Column(name="descr_cr")
	private String descrCr;

	@Column(name="nombre_cr")
	private String nombreCr;

	//bi-directional many-to-one association to CaracteristicaUsuario
	//@OneToMany(mappedBy="caracteristica")
	//private List<CaracteristicaUsuario> caracteristicaUsuarios;

	//bi-directional many-to-one association to Existencia
	//@OneToMany(mappedBy="caracteristica")
	//private List<Existencia> existencias;

	public Caracteristica() {
	}


	public int getIdCaracteristica() {
		return idCaracteristica;
	}


	public void setIdCaracteristica(int idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}


	public String getDescrCr() {
		return this.descrCr;
	}

	public void setDescrCr(String descrCr) {
		this.descrCr = descrCr;
	}

	public String getNombreCr() {
		return this.nombreCr;
	}

	public void setNombreCr(String nombreCr) {
		this.nombreCr = nombreCr;
	}

/*	public List<CaracteristicaUsuario> getCaracteristicaUsuarios() {
		return this.caracteristicaUsuarios;
	}

	public void setCaracteristicaUsuarios(List<CaracteristicaUsuario> caracteristicaUsuarios) {
		this.caracteristicaUsuarios = caracteristicaUsuarios;
	}
*/
/*	public CaracteristicaUsuario addCaracteristicaUsuario(CaracteristicaUsuario caracteristicaUsuario) {
		getCaracteristicaUsuarios().add(caracteristicaUsuario);
		caracteristicaUsuario.setCaracteristica(this);

		return caracteristicaUsuario;
	}

	public CaracteristicaUsuario removeCaracteristicaUsuario(CaracteristicaUsuario caracteristicaUsuario) {
		getCaracteristicaUsuarios().remove(caracteristicaUsuario);
		caracteristicaUsuario.setCaracteristica(null);

		return caracteristicaUsuario;
	}*/

	/*public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}*/

	/*public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setCaracteristica(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setCaracteristica(null);

		return existencia;
	}*/

}