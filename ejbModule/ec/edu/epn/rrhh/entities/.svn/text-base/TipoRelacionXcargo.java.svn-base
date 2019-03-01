package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.movimientos.Cargosm;
import ec.edu.epn.rrhh.movimientos.TipoRelacion;


/**
 * The persistent class for the tipo_relacion_xcargo database table.
 * 
 */
@Entity
@Table(name="tipo_relacion_xcargo",catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="TipoRelacionXcargo.findAll", query="SELECT t FROM TipoRelacionXcargo t")
public class TipoRelacionXcargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_x_cargo")
	private Integer idTipoXCargo;

	//bi-directional many-to-one association to Cargosm
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargosm cargosm;

	//bi-directional many-to-one association to TipoRelacion
	@ManyToOne
	@JoinColumn(name="id_tr")
	private TipoRelacion tipoRelacion;

	public TipoRelacionXcargo() {
	}

	public Integer getIdTipoXCargo() {
		return this.idTipoXCargo;
	}

	public void setIdTipoXCargo(Integer idTipoXCargo) {
		this.idTipoXCargo = idTipoXCargo;
	}

	public Cargosm getCargosm() {
		return this.cargosm;
	}

	public void setCargosm(Cargosm cargosm) {
		this.cargosm = cargosm;
	}

	public TipoRelacion getTipoRelacion() {
		return this.tipoRelacion;
	}

	public void setTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

}