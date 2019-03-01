package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the actividad_proyecto database table.
 * 
 */
@Entity
@Table(name="actividad_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ActividadProyectoP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_act_pr")
	private Integer idActPr;

	private double costoextra;

	private double costorealact;

	private double costosemana;

	private double costototal;

	private Integer dias;

	private String entregables;

	private String estado;

	private String estadopresupuesto;
	
	private String valida;

    @Temporal( TemporalType.DATE)
	@Column(name="ff_act")
	private Date ffAct;

    @Temporal( TemporalType.DATE)
	@Column(name="fi_act")
	private Date fiAct;

    @Temporal( TemporalType.DATE)
	private Date frealfin;

	private double horas;

	@Column(name="nom_actividad")
	private String nomActividad;

	private String observacioncierre;

	private String participacion;

	private double semanas;
	
	private String validainfo;
	
	private Double peso;
	private Double mes1;
	private Double mes2;
	private Double mes3;
	private Double mes4;
	private Double mes5;
	private Double mes6;
	private Double mes7;
	private Double mes8;
	private Double mes9;
	private Double mes10;
	private Double mes11;
	private Double mes12;
	private Double mes13;
	private Double mes14;
	private Double mes15;
	private Double mes16;
	private Double mes17;
	private Double mes18;
	private Integer serial;
	private Integer clase;
	private Double avanceacu;
	

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	//bi-directional many-to-one association to RecursohPr
    @ManyToOne
	@JoinColumn(name="id_rh_pr")
	private RecursohPr recursohPr;

	//bi-directional many-to-one association to TipoActividad
    @ManyToOne
	@JoinColumn(name="id_tipo_act")
	private TipoActividad tipoActividad;

	

    public ActividadProyectoP() {
    }

	public Integer getIdActPr() {
		return this.idActPr;
	}

	public void setIdActPr(Integer idActPr) {
		this.idActPr = idActPr;
	}

	public double getCostoextra() {
		return this.costoextra;
	}

	public void setCostoextra(double costoextra) {
		this.costoextra = costoextra;
	}

	public double getCostorealact() {
		return this.costorealact;
	}

	public void setCostorealact(double costorealact) {
		this.costorealact = costorealact;
	}

	public double getCostosemana() {
		return this.costosemana;
	}

	public void setCostosemana(double costosemana) {
		this.costosemana = costosemana;
	}

	public double getCostototal() {
		return this.costototal;
	}

	public void setCostototal(double costototal) {
		this.costototal = costototal;
	}

	public Integer getDias() {
		return this.dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public String getEntregables() {
		return this.entregables;
	}

	public void setEntregables(String entregables) {
		this.entregables = entregables;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadopresupuesto() {
		return this.estadopresupuesto;
	}

	public void setEstadopresupuesto(String estadopresupuesto) {
		this.estadopresupuesto = estadopresupuesto;
	}

	public Date getFfAct() {
		return this.ffAct;
	}

	public void setFfAct(Date ffAct) {
		this.ffAct = ffAct;
	}

	public Date getFiAct() {
		return this.fiAct;
	}

	public void setFiAct(Date fiAct) {
		this.fiAct = fiAct;
	}

	public Date getFrealfin() {
		return this.frealfin;
	}

	public void setFrealfin(Date frealfin) {
		this.frealfin = frealfin;
	}

	public double getHoras() {
		return this.horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public String getNomActividad() {
		return this.nomActividad;
	}

	public void setNomActividad(String nomActividad) {
		this.nomActividad = nomActividad;
	}

	public String getObservacioncierre() {
		return this.observacioncierre;
	}

	public void setObservacioncierre(String observacioncierre) {
		this.observacioncierre = observacioncierre;
	}

	public String getParticipacion() {
		return this.participacion;
	}

	public void setParticipacion(String participacion) {
		this.participacion = participacion;
	}

	public double getSemanas() {
		return this.semanas;
	}

	public void setSemanas(double semanas) {
		this.semanas = semanas;
	}

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	public RecursohPr getRecursohPr() {
		return this.recursohPr;
	}

	public void setRecursohPr(RecursohPr recursohPr) {
		this.recursohPr = recursohPr;
	}
	
	public TipoActividad getTipoActividad() {
		return this.tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
	

	public String getValida() {
		return valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public String getValidainfo() {
		return validainfo;
	}

	public void setValidainfo(String validainfo) {
		this.validainfo = validainfo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getMes1() {
		return mes1;
	}

	public void setMes1(Double mes1) {
		this.mes1 = mes1;
	}

	public Double getMes2() {
		return mes2;
	}

	public void setMes2(Double mes2) {
		this.mes2 = mes2;
	}

	public Double getMes3() {
		return mes3;
	}

	public void setMes3(Double mes3) {
		this.mes3 = mes3;
	}

	public Double getMes4() {
		return mes4;
	}

	public void setMes4(Double mes4) {
		this.mes4 = mes4;
	}

	public Double getMes5() {
		return mes5;
	}

	public void setMes5(Double mes5) {
		this.mes5 = mes5;
	}

	public Double getMes6() {
		return mes6;
	}

	public void setMes6(Double mes6) {
		this.mes6 = mes6;
	}

	public Double getMes7() {
		return mes7;
	}

	public void setMes7(Double mes7) {
		this.mes7 = mes7;
	}

	public Double getMes8() {
		return mes8;
	}

	public void setMes8(Double mes8) {
		this.mes8 = mes8;
	}

	public Double getMes9() {
		return mes9;
	}

	public void setMes9(Double mes9) {
		this.mes9 = mes9;
	}

	public Double getMes10() {
		return mes10;
	}

	public void setMes10(Double mes10) {
		this.mes10 = mes10;
	}

	public Double getMes11() {
		return mes11;
	}

	public void setMes11(Double mes11) {
		this.mes11 = mes11;
	}

	public Double getMes12() {
		return mes12;
	}

	public void setMes12(Double mes12) {
		this.mes12 = mes12;
	}

	public Double getMes13() {
		return mes13;
	}

	public void setMes13(Double mes13) {
		this.mes13 = mes13;
	}

	public Double getMes14() {
		return mes14;
	}

	public void setMes14(Double mes14) {
		this.mes14 = mes14;
	}

	public Double getMes15() {
		return mes15;
	}

	public void setMes15(Double mes15) {
		this.mes15 = mes15;
	}

	public Double getMes16() {
		return mes16;
	}

	public void setMes16(Double mes16) {
		this.mes16 = mes16;
	}

	public Double getMes17() {
		return mes17;
	}

	public void setMes17(Double mes17) {
		this.mes17 = mes17;
	}

	public Double getMes18() {
		return mes18;
	}

	public void setMes18(Double mes18) {
		this.mes18 = mes18;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Integer getClase() {
		return clase;
	}

	public void setClase(Integer clase) {
		this.clase = clase;
	}

	public Double getAvanceacu() {
		return avanceacu;
	}

	public void setAvanceacu(Double avanceacu) {
		this.avanceacu = avanceacu;
	}
	
}