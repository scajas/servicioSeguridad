package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the premios database table.
 * 
 */
@Entity
@Table(name="premios",catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="Premio.findAll", query="SELECT p FROM Premio p order by p.anioPremio")
public class Premio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PREMIO_IDPUBLIC_GENERATOR", sequenceName="premios_id_prem_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREMIO_IDPUBLIC_GENERATOR")
	@Column(name="id_premios")
	private Integer idPremios;

	@Column(name="anio_premio")
	private Integer anioPremio;

	private String estado;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="institucion_premio")
	private String institucionPremio;

	private String nced;

	@Column(name="nombre_premio")
	private String nombrePremio;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;
	
	private String path;

	public Premio() {
	}

	public Integer getIdPremios() {
		return this.idPremios;
	}

	public void setIdPremios(Integer idPremios) {
		this.idPremios = idPremios;
	}

	public Integer getAnioPremio() {
		return this.anioPremio;
	}

	public void setAnioPremio(Integer anioPremio) {
		this.anioPremio = anioPremio;
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

	public String getInstitucionPremio() {
		return this.institucionPremio;
	}

	public void setInstitucionPremio(String institucionPremio) {
		this.institucionPremio = institucionPremio;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombrePremio() {
		return this.nombrePremio;
	}

	public void setNombrePremio(String nombrePremio) {
		this.nombrePremio = nombrePremio;
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

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}