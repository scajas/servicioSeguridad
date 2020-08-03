package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experticia_docente database table.
 * 
 */
@Entity
@Table(name="experticia_docente")
@NamedQuery(name="ExperticiaDocente.findAll", query="SELECT e FROM ExperticiaDocente e")
public class ExperticiaDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_experticia")
	private String idExperticia;

	@Column(name="descripcion_experticia")
	private String descripcionExperticia;

	@Column(name="detalle_experticia")
	private String detalleExperticia;

	private String estado;

	@Column(name="id_area_con")
	private String idAreaCon;

	private String nced;

	@Column(name="tipo_experticia")
	private String tipoExperticia;

	public ExperticiaDocente() {
	}

	public String getIdExperticia() {
		return this.idExperticia;
	}

	public void setIdExperticia(String idExperticia) {
		this.idExperticia = idExperticia;
	}

	public String getDescripcionExperticia() {
		return this.descripcionExperticia;
	}

	public void setDescripcionExperticia(String descripcionExperticia) {
		this.descripcionExperticia = descripcionExperticia;
	}

	public String getDetalleExperticia() {
		return this.detalleExperticia;
	}

	public void setDetalleExperticia(String detalleExperticia) {
		this.detalleExperticia = detalleExperticia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdAreaCon() {
		return this.idAreaCon;
	}

	public void setIdAreaCon(String idAreaCon) {
		this.idAreaCon = idAreaCon;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getTipoExperticia() {
		return this.tipoExperticia;
	}

	public void setTipoExperticia(String tipoExperticia) {
		this.tipoExperticia = tipoExperticia;
	}

}