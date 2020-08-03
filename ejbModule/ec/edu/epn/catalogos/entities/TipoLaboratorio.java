package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_laboratorio database table.
 * 
 */
@Entity
@Table(name="tiposlaboratorios")
@NamedQuery(name="TipoLaboratorio.findAll", query="SELECT t FROM TipoLaboratorio t")
public class TipoLaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipolab")
	private Integer idTipolab;

	@Column(name="descr_tipolab")
	private String descrTipolab;

	@Column(name="nombre_tipolab")
	private String nombreTipolab;

	public TipoLaboratorio() {
	}

	public Integer getIdTipolab() {
		return this.idTipolab;
	}

	public void setIdTipolab(Integer idTipolab) {
		this.idTipolab = idTipolab;
	}

	public String getDescrTipolab() {
		return this.descrTipolab;
	}

	public void setDescrTipolab(String descrTipolab) {
		this.descrTipolab = descrTipolab;
	}

	public String getNombreTipolab() {
		return this.nombreTipolab;
	}

	public void setNombreTipolab(String nombreTipolab) {
		this.nombreTipolab = nombreTipolab;
	}

}