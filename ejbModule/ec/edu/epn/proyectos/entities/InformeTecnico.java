package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the informe_tecnico database table.
 * 
 */
@Entity
@Table(name = "informe_tecnico", catalog = "bddcorpepn", schema = "`Proyectos`")

@NamedQuery(name="InformeTecnico.findAll", query="SELECT i FROM InformeTecnico i")
public class InformeTecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer anio;

	private String codigo;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fsis;

	private String pedido;

	private String usuario;

	//bi-directional many-to-one association to AnexoInforme
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="informeTecnico",fetch = FetchType.EAGER)
	private Set<AnexoInforme> anexoInformes;
	
	@ManyToOne
	@JoinColumn(name="idproy")
	private ProyectoP proyecto;

	public InformeTecnico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFsis() {
		return this.fsis;
	}

	public void setFsis(Date fsis) {
		this.fsis = fsis;
	}

	
	public String getPedido() {
		return this.pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<AnexoInforme> getAnexoInformes() {
		return anexoInformes;
	}

	public void setAnexoInformes(Set<AnexoInforme> anexoInformes) {
		this.anexoInformes = anexoInformes;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	
	

	

	

}