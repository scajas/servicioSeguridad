package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.seguridad.vo.Usuario;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name = "Secuenciales", catalog = "`bddcorpepn`", schema = "`Contratos`")
@NamedQuery(name = "Secuenciales.findAll", query = "SELECT p FROM Secuenciales p")
public class Secuenciales implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_secuencial")
	private Integer idSecuencial;

	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "contrato")
	private Integer contrato;
	
	@Column(name = "convenio")
	private Integer convenio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Pensum pensum;

	@ManyToOne
	@JoinColumn(name = "id_facultad")
	private FacultadCatalogos facultad;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Integer getIdSecuencial() {
		return idSecuencial;
	}

	public void setIdSecuencial(Integer idSecuencial) {
		this.idSecuencial = idSecuencial;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer contrato) {
		this.contrato = contrato;
	}

	public Integer getConvenio() {
		return convenio;
	}

	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Pensum getPensum() {
		return pensum;
	}

	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

	public FacultadCatalogos getFacultad() {
		return facultad;
	}

	public void setFacultad(FacultadCatalogos facultad) {
		this.facultad = facultad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	

}