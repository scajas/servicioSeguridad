package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidadmedida database table.
 * 
 */
@Entity
@Table(name = "unidadmedida", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Unidadmedida.findAll", query="SELECT u FROM Unidadmedida u")
public class Unidadmedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@SequenceGenerator(name="UNIDADMEDIDA_IDUNIDADMEDIDA_GENERATOR", sequenceName="secuencia_unidadmedida",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADMEDIDA_IDUNIDADMEDIDA_GENERATOR")
	
	
	@Column(name="id_umedida")
	private int idUmedida;

	@Column(name="descr_um")
	private String descrUm;

	@Column(name="medida_um")
	private String medidaUm;

	@Column(name="sigla_um")
	private String siglaUm;

	//bi-directional many-to-one association to Existencia
/*	@OneToMany(mappedBy="unidadmedida")
	private List<Existencia> existencias;
*/
	public Unidadmedida() {
	}

	public int getIdUmedida() {
		return idUmedida;
	}

	public void setIdUmedida(int idUmedida) {
		this.idUmedida = idUmedida;
	}

	public String getDescrUm() {
		return this.descrUm;
	}

	public void setDescrUm(String descrUm) {
		this.descrUm = descrUm;
	}

	public String getMedidaUm() {
		return this.medidaUm;
	}

	public void setMedidaUm(String medidaUm) {
		this.medidaUm = medidaUm;
	}

	public String getSiglaUm() {
		return this.siglaUm;
	}

	public void setSiglaUm(String siglaUm) {
		this.siglaUm = siglaUm;
	}

	/*public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setUnidadmedida(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setUnidadmedida(null);

		return existencia;
	}*/

}