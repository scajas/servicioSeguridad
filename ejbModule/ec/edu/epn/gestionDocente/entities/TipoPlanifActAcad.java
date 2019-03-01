package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the actividad_docencia database table.
 * 
 */
@Entity

@Table(name="tipo_planif_act_acad",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class TipoPlanifActAcad implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id_tipo_planif_act_acad")	
	@SequenceGenerator(name = "sec_tipo_planif_act_acad", sequenceName = "sec_tipo_planif_act_acad", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_tipo_planif_act_acad")
	private Integer idTipoPlanifActAcad;
    
	@Column(name="nombre_tipo")
	private String nombreTipo;

	private String detalle;

	/**
	 * @return the idTipoPlanifActAcad
	 */
	public Integer getIdTipoPlanifActAcad() {
		return idTipoPlanifActAcad;
	}

	/**
	 * @return the nombreTipo
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param idTipoPlanifActAcad the idTipoPlanifActAcad to set
	 */
	public void setIdTipoPlanifActAcad(Integer idTipoPlanifActAcad) {
		this.idTipoPlanifActAcad = idTipoPlanifActAcad;
	}

	/**
	 * @param nombreTipo the nombreTipo to set
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}		
}