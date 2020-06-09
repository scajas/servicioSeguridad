package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@Table(name = "servicio", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="id_servicio")
	private String idServicio;

	private String acreditado;

	@Column(name="aux_id_servicio")
	private Integer auxIdServicio;

	@Column(name="descr_s")
	private String descrS;

	@Column(name="nombre_s")
	private String nombreS;
	
	@Column(name="estado_servicio")
	private String estadoServicio;

	@Column(name="precio_s")
	private float precioS;

	public String getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="servicio")
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to Metodo
	@OneToMany(mappedBy="servicio")
	private List<Metodo> metodos;

	//bi-directional many-to-one association to Laboratorio
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private LaboratorioLab laboratorio;

	//bi-directional many-to-one association to Tiposervicio
	@ManyToOne
	@JoinColumn(name="id_tiposerv")
	private Tiposervicio tiposervicio;

	public Servicio() {
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}



	public String getAcreditado() {
		return this.acreditado;
	}

	public void setAcreditado(String acreditado) {
		this.acreditado = acreditado;
	}

	public Integer getAuxIdServicio() {
		return this.auxIdServicio;
	}

	public void setAuxIdServicio(Integer auxIdServicio) {
		this.auxIdServicio = auxIdServicio;
	}

	public String getDescrS() {
		return this.descrS;
	}

	public void setDescrS(String descrS) {
		this.descrS = descrS;
	}

	public String getNombreS() {
		return this.nombreS;
	}

	public void setNombreS(String nombreS) {
		this.nombreS = nombreS;
	}

	public float getPrecioS() {
		return this.precioS;
	}

	public void setPrecioS(float precioS) {
		this.precioS = precioS;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setServicio(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setServicio(null);

		return detalleProforma;
	}

	public List<Metodo> getMetodos() {
		return this.metodos;
	}

	public void setMetodos(List<Metodo> metodos) {
		this.metodos = metodos;
	}

	public Metodo addMetodo(Metodo metodo) {
		getMetodos().add(metodo);
		metodo.setServicio(this);

		return metodo;
	}

	public Metodo removeMetodo(Metodo metodo) {
		getMetodos().remove(metodo);
		metodo.setServicio(null);

		return metodo;
	}

	public LaboratorioLab getLaboratorio() {
		return this.laboratorio;
	}

	public void setLaboratorio(LaboratorioLab laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Tiposervicio getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(Tiposervicio tiposervicio) {
		this.tiposervicio = tiposervicio;
	}


}