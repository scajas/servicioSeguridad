package ec.edu.epn.gestionDocente.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the descanso_obligatorio database table.
 * 
 */
@Entity
@Table(name="descanso_obligatorio",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="DescansoObligatorio.findAll", query="SELECT p FROM DescansoObligatorio p")
public class DescansoObligatorio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_descanso_obl")
	private Integer idDescansoObl;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_descanso")
	private Date fechaDescanso;

	@Column(name="descripcion_descanso")
	private String descripcionDescanso;

	/**
	 * @return the idDescansoObl
	 */
	public Integer getIdDescansoObl() {
		return idDescansoObl;
	}

	/**
	 * @return the fechaDescanso
	 */
	public Date getFechaDescanso() {
		return fechaDescanso;
	}

	/**
	 * @return the descripcionDescanso
	 */
	public String getDescripcionDescanso() {
		return descripcionDescanso;
	}

	/**
	 * @param idDescansoObl the idDescansoObl to set
	 */
	public void setIdDescansoObl(Integer idDescansoObl) {
		this.idDescansoObl = idDescansoObl;
	}

	/**
	 * @param fechaDescanso the fechaDescanso to set
	 */
	public void setFechaDescanso(Date fechaDescanso) {
		this.fechaDescanso = fechaDescanso;
	}

	/**
	 * @param descripcionDescanso the descripcionDescanso to set
	 */
	public void setDescripcionDescanso(String descripcionDescanso) {
		this.descripcionDescanso = descripcionDescanso;
	}

	
}