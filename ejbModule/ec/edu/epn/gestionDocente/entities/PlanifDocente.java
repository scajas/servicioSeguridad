package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.edu.epn.catalogos.entities.ActividadesAcademica;

/**
 * The persistent class for the planif_docente database table.
 * 
 */
@Entity
@Table(name = "planif_docente", catalog = "bddcorpepn", schema = "`GestionDocente`")
public class PlanifDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pd")
	private Integer idPd;

	@Column(name = "horas_cclase")
	private Integer horasCclase;

	@Column(name = "horas_sclase")
	private Integer horasSclase;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "horas_cclase_ejec")
	private Integer horasCclaseEjec;

	@Column(name = "horas_sclase_ejec")
	private Integer horasSclaseEjec;

	@Column(name = "total_ejec")
	private Integer totalEjec;

	@ManyToOne
	@JoinColumn(name = "id_actividad")
	private ActividadesAcademica actividadAcademica;

	public ActividadesAcademica getActividadAcademica() {
		return actividadAcademica;
	}

	public void setActividadAcademica(ActividadesAcademica actividadAcademica) {
		this.actividadAcademica = actividadAcademica;
	}

	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Periodo periodo;

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	private String nced;

	private Integer total;

	public PlanifDocente() {
	}

	public Integer getIdPd() {
		return this.idPd;
	}

	public void setIdPd(Integer idPd) {
		this.idPd = idPd;
	}

	public Integer getHorasCclase() {
		return this.horasCclase;
	}

	public void setHorasCclase(Integer horasCclase) {
		this.horasCclase = horasCclase;
	}

	public Integer getHorasSclase() {
		return this.horasSclase;
	}

	public void setHorasSclase(Integer horasSclase) {
		this.horasSclase = horasSclase;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getHorasCclaseEjec() {
		return horasCclaseEjec;
	}

	public void setHorasCclaseEjec(Integer horasCclaseEjec) {
		this.horasCclaseEjec = horasCclaseEjec;
	}

	public Integer getHorasSclaseEjec() {
		return horasSclaseEjec;
	}

	public void setHorasSclaseEjec(Integer horasSclaseEjec) {
		this.horasSclaseEjec = horasSclaseEjec;
	}

	public Integer getTotalEjec() {
		return totalEjec;
	}

	public void setTotalEjec(Integer totalEjec) {
		this.totalEjec = totalEjec;
	}

}