package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.Idioma;

import java.sql.Timestamp;


/**
 * The persistent class for the idiomas_docente database table.
 * 
 */
@Entity
@Table(name="idiomas_docente", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="IdiomasDocente.findAll", query="SELECT i FROM IdiomasDocente i")
public class IdiomasDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	
	@SequenceGenerator(name = "IDIOMA_IDPUBLIC_GENERATOR", sequenceName="idioma_id_idiom_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDIOMA_IDPUBLIC_GENERATOR")
	@Column(name="id_idiomas_docente")
	private Integer idIdiomasDocente;

	private String estado;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;
	
	@ManyToOne
	@JoinColumn(name = "id_idioma")
	private Idioma idioma;
	

	private String nced;

	private String nivel;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;
	
	
	private String path;

	public IdiomasDocente() {
	}

	public Integer getIdIdiomasDocente() {
		return this.idIdiomasDocente;
	}

	public void setIdIdiomasDocente(Integer idIdiomasDocente) {
		this.idIdiomasDocente = idIdiomasDocente;
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

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
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

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
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