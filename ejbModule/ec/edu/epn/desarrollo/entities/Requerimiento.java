package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the requerimiento database table.
 * 
 */
@Entity
@Table(name = "requerimiento", catalog = "`bddcorpepn`", schema = "`Desarrollo`")
@NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r")
public class Requerimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String autorizaprod;

	@Temporal(TemporalType.DATE)
	private Date fentrega;

	@Temporal(TemporalType.DATE)
	private Date fleva;
	
	@Temporal(TemporalType.DATE)
	private Date fpasoprod;
	
	private String idestado;

	private String num,path;
	private Integer anio;

	private Integer idanio;

	

	private String reslevan,cambiobdd ,
	  tipobdd ,nombrebdd;

	// bi-directional many-to-one association to DetalleRequerimiento
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "requerimiento", cascade = CascadeType.ALL )
	@OrderBy("id")
	private List<DetalleRequerimiento> detalleRequerimientos;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_pr")
	private ProyectoD proyecto;

	public Requerimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutorizaprod() {
		return this.autorizaprod;
	}

	public void setAutorizaprod(String autorizaprod) {
		this.autorizaprod = autorizaprod;
	}

	public Date getFentrega() {
		return this.fentrega;
	}

	public void setFentrega(Date fentrega) {
		this.fentrega = fentrega;
	}

	public Date getFleva() {
		return this.fleva;
	}

	public void setFleva(Date fleva) {
		this.fleva = fleva;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getReslevan() {
		return this.reslevan;
	}

	public void setReslevan(String reslevan) {
		this.reslevan = reslevan;
	}

	public List<DetalleRequerimiento> getDetalleRequerimientos() {
		return this.detalleRequerimientos;
	}

	public void setDetalleRequerimientos(List<DetalleRequerimiento> detalleRequerimientos) {
		this.detalleRequerimientos = detalleRequerimientos;
	}

	public DetalleRequerimiento addDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento) {
		getDetalleRequerimientos().add(detalleRequerimiento);
		detalleRequerimiento.setRequerimiento(this);

		return detalleRequerimiento;
	}

	public DetalleRequerimiento removeDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento) {
		getDetalleRequerimientos().remove(detalleRequerimiento);
		detalleRequerimiento.setRequerimiento(null);

		return detalleRequerimiento;
	}

	public ProyectoD getProyecto() {
		return this.proyecto;
	}

	public void setProyectoD(ProyectoD proyecto) {
		this.proyecto = proyecto;
	}

	

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getIdanio() {
		return idanio;
	}

	public void setIdanio(Integer idanio) {
		this.idanio = idanio;
	}

	public Date getFpasoprod() {
		return fpasoprod;
	}

	public void setFpasoprod(Date fpasoprod) {
		this.fpasoprod = fpasoprod;
	}

	public String getCambiobdd() {
		return cambiobdd;
	}

	public void setCambiobdd(String cambiobdd) {
		this.cambiobdd = cambiobdd;
	}

	public String getNombrebdd() {
		return nombrebdd;
	}

	public void setNombrebdd(String nombrebdd) {
		this.nombrebdd = nombrebdd;
	}

	public String getTipobdd() {
		return tipobdd;
	}

	public void setTipobdd(String tipobdd) {
		this.tipobdd = tipobdd;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}