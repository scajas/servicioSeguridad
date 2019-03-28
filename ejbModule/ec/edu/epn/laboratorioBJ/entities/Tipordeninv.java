package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipordeninv database table.
 * 
 */
@Entity
@Table(name = "tipordeninv", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Tipordeninv.findAll", query="SELECT t FROM Tipordeninv t")
public class Tipordeninv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@SequenceGenerator(name="TIPORDENINV_IDTIPORDENINV_GENERATOR", sequenceName="secuencia_toi",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPORDENINV_IDTIPORDENINV_GENERATOR")
	
	@Column(name="id_tipordeninv")
	private int idTipordeninv;

	@Column(name="descr_toi")
	private String descrToi;

	@Column(name="nombre_toi")
	private String nombreToi;

	//bi-directional many-to-one association to Ordeninventario
	/*@OneToMany(mappedBy="tipordeninv")
	private List<Ordeninventario> ordeninventarios;
*/
	public Tipordeninv() {
	}


	public int getIdTipordeninv() {
		return idTipordeninv;
	}


	public void setIdTipordeninv(int idTipordeninv) {
		this.idTipordeninv = idTipordeninv;
	}


	public String getDescrToi() {
		return this.descrToi;
	}

	public void setDescrToi(String descrToi) {
		this.descrToi = descrToi;
	}

	public String getNombreToi() {
		return this.nombreToi;
	}

	public void setNombreToi(String nombreToi) {
		this.nombreToi = nombreToi;
	}

	/*public List<Ordeninventario> getOrdeninventarios() {
		return this.ordeninventarios;
	}

	public void setOrdeninventarios(List<Ordeninventario> ordeninventarios) {
		this.ordeninventarios = ordeninventarios;
	}

	public Ordeninventario addOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().add(ordeninventario);
		ordeninventario.setTipordeninv(this);

		return ordeninventario;
	}

	public Ordeninventario removeOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().remove(ordeninventario);
		ordeninventario.setTipordeninv(null);

		return ordeninventario;
	}*/

}