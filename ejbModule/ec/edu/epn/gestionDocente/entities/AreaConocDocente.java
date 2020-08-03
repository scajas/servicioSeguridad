package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the area_conoc_docente database table.
 * 
 */
@Entity
@Table(name="area_conoc_docente", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="AreaConocDocente.findAll", query="SELECT a FROM AreaConocDocente a")
public class AreaConocDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "AREA_IDPUBLIC_GENERATOR", sequenceName="area_conoc_doc_id_acd_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_IDPUBLIC_GENERATOR")

	@Column(name="id_area_conoc_doc")
	private Integer idAreaConocDoc;

	private String estado;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	private String nced;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;

	//bi-directional many-to-one association to AreaConocimiento
	@ManyToOne
	@JoinColumn(name="id_area_con")
	private AreaConocimiento areaConocimiento;

	public AreaConocDocente() {
	}

	public Integer getIdAreaConocDoc() {
		return this.idAreaConocDoc;
	}

	public void setIdAreaConocDoc(Integer idAreaConocDoc) {
		this.idAreaConocDoc = idAreaConocDoc;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public AreaConocimiento getAreaConocimiento() {
		return this.areaConocimiento;
	}

	public void setAreaConocimiento(AreaConocimiento areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

}