package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@Table(name = "grado", catalog = "`bddcorpepn`", schema = "Laboratorios")
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="GRADO_IDGRADO_GENERATOR", sequenceName="secuencia_grado",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADO_IDGRADO_GENERATOR")
	@Column(name="id_grado")
	private Integer idGrado;

	@Column(name="descr_gr")
	private String descrGr;

	@Column(name="nombre_gr")
	private String nombreGr;

	//bi-directional many-to-one association to Existencia
/*	@OneToMany(mappedBy="grado")
	private List<Existencia> existencias;
*/
	public Grado() {
	}

	public Integer getIdGrado() {
		return this.idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public String getDescrGr() {
		return this.descrGr;
	}

	public void setDescrGr(String descrGr) {
		this.descrGr = descrGr;
	}

	public String getNombreGr() {
		return this.nombreGr;
	}

	public void setNombreGr(String nombreGr) {
		this.nombreGr = nombreGr;
	}

/*	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setGrado(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setGrado(null);

		return existencia;
	}*/

}