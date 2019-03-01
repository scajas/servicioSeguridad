package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the miembros database table.
 * 
 */
@Entity
@Table(name="miembros", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Miembro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mie")
	private Integer idMie;

	private String apellidos;

	private String email;

	private String nced;

	private String nombres;
	
	private Double calificacion;
	private String path;
	private String observaciones;
	private Date fecha;
	private String resulatdo;
	
	
	

	//bi-directional one-to-one association to Comision
	@OneToOne
	@JoinColumn(name="id_com")
	private Comision comision;

    public Miembro() {
    }

	public Integer getIdMie() {
		return this.idMie;
	}

	public void setIdMie(Integer idMie) {
		this.idMie = idMie;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Comision getComision() {
		return this.comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	/**
	 * @return the calificacion
	 */
	public Double getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
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

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the resulatdo
	 */
	public String getResulatdo() {
		return resulatdo;
	}

	/**
	 * @param resulatdo the resulatdo to set
	 */
	public void setResulatdo(String resulatdo) {
		this.resulatdo = resulatdo;
	}
	
}