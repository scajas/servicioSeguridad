package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the detalleplan database table.
 * 
 */
@Entity
@Table(name = "evidencias_plan", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "EvidenciasPlan.findAll", query = "SELECT d FROM EvidenciasPlan d")
public class EvidenciasPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_evidencia")
	private Integer idEvidencia;

	@Column(name = "nombre_evidencia")
	private String nombreEvidencia;
	
	@Column(name = "path_evidencia")
	private String pathEvidencia;
	
	@ManyToOne
	@JoinColumn(name = "id_plan")
	private Plan plan;

	public Integer getIdEvidencia() {
		return idEvidencia;
	}

	public void setIdEvidencia(Integer idEvidencia) {
		this.idEvidencia = idEvidencia;
	}

	public String getNombreEvidencia() {
		return nombreEvidencia;
	}

	public void setNombreEvidencia(String nombreEvidencia) {
		this.nombreEvidencia = nombreEvidencia;
	}

	public String getPathEvidencia() {
		return pathEvidencia;
	}

	public void setPathEvidencia(String pathEvidencia) {
		this.pathEvidencia = pathEvidencia;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	

	}