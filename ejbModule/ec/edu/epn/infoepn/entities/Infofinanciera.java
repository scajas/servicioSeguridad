package ec.edu.epn.infoepn.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the infofinanciera database table.
 * 
 */
@Entity

@Table(name="infofinanciera", catalog = "bddcorpepn", schema = "`Informacion Intitucional`")
public class Infofinanciera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer anio;

	private double gastoinvdes;

	private double masasalarial;

	private double presupuestoejecutado;

	@Column(name="total_ingresos_consultoria")
	private double totalIngresosConsultoria;
	
	
	private Integer iduser;
	private String nombreuser ;
	private Date  fechasis; 
	private String  motivo;
	private String  cambiomasa ;
	private String  cambiogasto ;
	private String  cambiopresupuesto;
	

    public Infofinanciera() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public double getGastoinvdes() {
		return this.gastoinvdes;
	}

	public void setGastoinvdes(double gastoinvdes) {
		this.gastoinvdes = gastoinvdes;
	}

	public double getMasasalarial() {
		return this.masasalarial;
	}

	public void setMasasalarial(double masasalarial) {
		this.masasalarial = masasalarial;
	}

	public double getPresupuestoejecutado() {
		return this.presupuestoejecutado;
	}

	public void setPresupuestoejecutado(double presupuestoejecutado) {
		this.presupuestoejecutado = presupuestoejecutado;
	}

	public double getTotalIngresosConsultoria() {
		return this.totalIngresosConsultoria;
	}

	public void setTotalIngresosConsultoria(double totalIngresosConsultoria) {
		this.totalIngresosConsultoria = totalIngresosConsultoria;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getNombreuser() {
		return nombreuser;
	}

	public void setNombreuser(String nombreuser) {
		this.nombreuser = nombreuser;
	}

	public Date getFechasis() {
		return fechasis;
	}

	public void setFechasis(Date fechasis) {
		this.fechasis = fechasis;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getCambiomasa() {
		return cambiomasa;
	}

	public void setCambiomasa(String cambiomasa) {
		this.cambiomasa = cambiomasa;
	}

	public String getCambiogasto() {
		return cambiogasto;
	}

	public void setCambiogasto(String cambiogasto) {
		this.cambiogasto = cambiogasto;
	}

	public String getCambiopresupuesto() {
		return cambiopresupuesto;
	}

	public void setCambiopresupuesto(String cambiopresupuesto) {
		this.cambiopresupuesto = cambiopresupuesto;
	}

}