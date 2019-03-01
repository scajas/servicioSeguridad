package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anexo_informe database table.
 * 
 */
@Entity
@Table(name = "anexo_informe", catalog = "bddcorpepn", schema = "`Proyectos`")


@NamedQuery(name="AnexoInforme.findAll", query="SELECT a FROM AnexoInforme a")
public class AnexoInforme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cargado;

	@Temporal(TemporalType.DATE)
	private Date fsis;

	private Integer orden;

	private String path;

	private String usuario,nombre;

	//bi-directional many-to-one association to InformeTecnico
	@ManyToOne
	@JoinColumn(name="idinfor")
	private InformeTecnico informeTecnico;

	public AnexoInforme() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargado() {
		return this.cargado;
	}

	public void setCargado(String cargado) {
		this.cargado = cargado;
	}

	public Date getFsis() {
		return this.fsis;
	}

	public void setFsis(Date fsis) {
		this.fsis = fsis;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public InformeTecnico getInformeTecnico() {
		return this.informeTecnico;
	}

	public void setInformeTecnico(InformeTecnico informeTecnico) {
		this.informeTecnico = informeTecnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}