package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.gestionDocente.entities.Carre;


/**
 * The persistent class for the evidencia database table.
 * 
 */
@Entity
@Table(name="evidencia", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Evidencia.findAll", query="SELECT e FROM Evidencia e")
public class Evidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="enviada_alfresco")
	private String enviadaAlfresco;

	private String path;

	@Column(name="responsable_valida")
	private String responsableValida;

	@Column(name="responsable_verifica")
	private String responsableVerifica;
	private String observalida; 
	private String  observerifica; 
	private String  estado;

	//bi-directional many-to-one association to ModeloAcreditacion
	@ManyToOne
	@JoinColumn(name="id_modelo_evaluacion")
	private ModeloAcreditacion modeloAcreditacion;
	
	//bi-directional many-to-one association to ModeloAcreditacion
	@ManyToOne
	@JoinColumn(name="id_carrera")
	private Carre carrera;
	
	
	private String firma;
	private String nombre;
	
	public Evidencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnviadaAlfresco() {
		return this.enviadaAlfresco;
	}

	public void setEnviadaAlfresco(String enviadaAlfresco) {
		this.enviadaAlfresco = enviadaAlfresco;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResponsableValida() {
		return this.responsableValida;
	}

	public void setResponsableValida(String responsableValida) {
		this.responsableValida = responsableValida;
	}

	public String getResponsableVerifica() {
		return this.responsableVerifica;
	}

	public void setResponsableVerifica(String responsableVerifica) {
		this.responsableVerifica = responsableVerifica;
	}

	public ModeloAcreditacion getModeloAcreditacion() {
		return this.modeloAcreditacion;
	}

	public void setModeloAcreditacion(ModeloAcreditacion modeloAcreditacion) {
		this.modeloAcreditacion = modeloAcreditacion;
	}

	public Carre getCarrera() {
		return carrera;
	}

	public void setCarrera(Carre carrera) {
		this.carrera = carrera;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getObservalida() {
		return observalida;
	}

	public void setObservalida(String observalida) {
		this.observalida = observalida;
	}

	public String getObserverifica() {
		return observerifica;
	}

	public void setObserverifica(String observerifica) {
		this.observerifica = observerifica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}