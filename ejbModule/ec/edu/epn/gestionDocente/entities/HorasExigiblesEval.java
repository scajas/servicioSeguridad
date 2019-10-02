package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the horas_exigibles_eval database table.
 * 
 */
@Entity
@Table(name="horas_exigibles_eval",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="HorasExigiblesEval.findAll", query="SELECT h FROM HorasExigiblesEval h")
public class HorasExigiblesEval implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_horas_exigibles_eval")
	@SequenceGenerator(name = "\"GestionDocente\".sec_horas_exigibles_eval", sequenceName = "\"GestionDocente\".sec_horas_exigibles_eval", allocationSize = 1)	
	@Column(name="id_hrs_exigibles")
	private Integer idHrsExigibles;

	@Column(name="fecha_edit")
	private Timestamp fechaEdit;

	@Column(name="fecha_ing")
	private Timestamp fechaIng;

	@Column(name="id_pensum")
	private Integer idPensum;

	@Column(name="id_usuario_edit")
	private Integer idUsuarioEdit;

	@Column(name="id_usuario_ing")
	private Integer idUsuarioIng;

	@Column(name="total_horas_exigibles")
	private double totalHorasExigibles;
	
	@Column(name="total_horas_preplanif")
	private double totalHorasPreplanif;
	

	public HorasExigiblesEval() {
	}

	public Integer getIdHrsExigibles() {
		return this.idHrsExigibles;
	}

	public void setIdHrsExigibles(Integer idHrsExigibles) {
		this.idHrsExigibles = idHrsExigibles;
	}

	public Timestamp getFechaEdit() {
		return this.fechaEdit;
	}

	public void setFechaEdit(Timestamp fechaEdit) {
		this.fechaEdit = fechaEdit;
	}

	public Timestamp getFechaIng() {
		return this.fechaIng;
	}

	public void setFechaIng(Timestamp fechaIng) {
		this.fechaIng = fechaIng;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public Integer getIdUsuarioEdit() {
		return this.idUsuarioEdit;
	}

	public void setIdUsuarioEdit(Integer idUsuarioEdit) {
		this.idUsuarioEdit = idUsuarioEdit;
	}

	public Integer getIdUsuarioIng() {
		return this.idUsuarioIng;
	}

	public void setIdUsuarioIng(Integer idUsuarioIng) {
		this.idUsuarioIng = idUsuarioIng;
	}

	public double getTotalHorasExigibles() {
		return this.totalHorasExigibles;
	}

	public void setTotalHorasExigibles(double totalHorasExigibles) {
		this.totalHorasExigibles = totalHorasExigibles;
	}

	public double getTotalHorasPreplanif() {
		return totalHorasPreplanif;
	}

	public void setTotalHorasPreplanif(double totalHorasPreplanif) {
		this.totalHorasPreplanif = totalHorasPreplanif;
	}

}