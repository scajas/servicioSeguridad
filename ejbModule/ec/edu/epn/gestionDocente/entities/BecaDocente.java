package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the beca_docentes database table.
 * 
 */
@Entity
@Table(name="beca_docentes")
@NamedQuery(name="BecaDocente.findAll", query="SELECT b FROM BecaDocente b")
public class BecaDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_becas_doc")
	private String idBecasDoc;

	@Column(name="duracion_beca")
	private String duracionBeca;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Column(name="id_area_con")
	private String idAreaCon;

	@Column(name="id_titulo")
	private String idTitulo;

	@Column(name="id_universid")
	private String idUniversid;

	private String nced;

	public BecaDocente() {
	}

	public String getIdBecasDoc() {
		return this.idBecasDoc;
	}

	public void setIdBecasDoc(String idBecasDoc) {
		this.idBecasDoc = idBecasDoc;
	}

	public String getDuracionBeca() {
		return this.duracionBeca;
	}

	public void setDuracionBeca(String duracionBeca) {
		this.duracionBeca = duracionBeca;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getIdAreaCon() {
		return this.idAreaCon;
	}

	public void setIdAreaCon(String idAreaCon) {
		this.idAreaCon = idAreaCon;
	}

	public String getIdTitulo() {
		return this.idTitulo;
	}

	public void setIdTitulo(String idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getIdUniversid() {
		return this.idUniversid;
	}

	public void setIdUniversid(String idUniversid) {
		this.idUniversid = idUniversid;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

}