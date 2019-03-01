package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the oportunidad_mejora_evaluacion database table.
 * 
 */
@Entity
@Table(name="oportunidad_mejora_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="OportunidadMejoraEvaluacion.findAll", query="SELECT o FROM OportunidadMejoraEvaluacion o")
public class OportunidadMejoraEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_mejora_eval")
	@SequenceGenerator(name = "\"GestionDocente\".sec_mejora_eval", sequenceName = "\"GestionDocente\".sec_mejora_eval", allocationSize = 1)
	@Column(name="id_mejora_eval")
	private Integer idMejoraEval;

	@Column(name="descripcion_mejora")
	private String descripcionMejora;

	@Column(name="id_eval_acad")
	private Integer idEvalAcad;
	
	
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	
	@Column(name="id_usuario_ingreso")
	private Integer id_usuario_ingreso;
	
	@Column(name="id_usuario_act")
	private Integer id_usuario_act;
	


	public OportunidadMejoraEvaluacion() {
	}

	public Integer getIdMejoraEval() {
		return this.idMejoraEval;
	}

	public void setIdMejoraEval(Integer idMejoraEval) {
		this.idMejoraEval = idMejoraEval;
	}

	public String getDescripcionMejora() {
		return this.descripcionMejora;
	}

	public void setDescripcionMejora(String descripcionMejora) {
		this.descripcionMejora = descripcionMejora;
	}

	public Integer getIdEvalAcad() {
		return this.idEvalAcad;
	}

	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	/**
	 * @return the fecha_ingreso
	 */
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	/**
	 * @return the id_usuario_ingreso
	 */
	public Integer getId_usuario_ingreso() {
		return id_usuario_ingreso;
	}

	/**
	 * @return the id_usuario_act
	 */
	public Integer getId_usuario_act() {
		return id_usuario_act;
	}

	/**
	 * @param fecha_ingreso the fecha_ingreso to set
	 */
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	/**
	 * @param id_usuario_ingreso the id_usuario_ingreso to set
	 */
	public void setId_usuario_ingreso(Integer id_usuario_ingreso) {
		this.id_usuario_ingreso = id_usuario_ingreso;
	}

	/**
	 * @param id_usuario_act the id_usuario_act to set
	 */
	public void setId_usuario_act(Integer id_usuario_act) {
		this.id_usuario_act = id_usuario_act;
	}

}