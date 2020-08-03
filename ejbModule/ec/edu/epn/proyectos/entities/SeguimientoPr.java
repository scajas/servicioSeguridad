package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the seguimiento_pr database table.
 * 
 */
@Entity
@Table(name="seguimiento_pr", catalog = "bddcorpepn", schema = "`Proyectos`")
public class SeguimientoPr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_seg_pr")
	private Integer idSegPr;

	@Column(name="avance_act")
	private Integer avanceAct;

	private double costoadicional;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="horas_dedi")
	private Integer horasDedi;

	@Column(name="path_evidencia")
	private String pathEvidencia;

	@Column(name="resultados_act")
	private String resultadosAct;
	
	
	
	
	private Integer mes;
	private Double valor;

	

    public SeguimientoPr() {
    }

	public Integer getIdSegPr() {
		return this.idSegPr;
	}

	public void setIdSegPr(Integer idSegPr) {
		this.idSegPr = idSegPr;
	}

	public Integer getAvanceAct() {
		return this.avanceAct;
	}

	public void setAvanceAct(Integer avanceAct) {
		this.avanceAct = avanceAct;
	}

	public double getCostoadicional() {
		return this.costoadicional;
	}

	public void setCostoadicional(double costoadicional) {
		this.costoadicional = costoadicional;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getHorasDedi() {
		return this.horasDedi;
	}

	public void setHorasDedi(Integer horasDedi) {
		this.horasDedi = horasDedi;
	}

	public String getPathEvidencia() {
		return this.pathEvidencia;
	}

	public void setPathEvidencia(String pathEvidencia) {
		this.pathEvidencia = pathEvidencia;
	}

	public String getResultadosAct() {
		return this.resultadosAct;
	}

	public void setResultadosAct(String resultadosAct) {
		this.resultadosAct = resultadosAct;
	}

	

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}