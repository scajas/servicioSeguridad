package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the entregable database table.
 * 
 */
@Entity

@Table(name = "entregable", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Entregable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_entregable")
	private Integer idEntregable;

	private String autores;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date fechaini;

	@Column(name = "horas_dedicadas")
	private Integer horasDedicadas;

	@Column(name = "medio_public")
	private String medioPublic;

	private String nompub;

	private String path;

	private String periodo;

	@Column(name = "resumen_pr")
	private String resumenPr;

	@Column(name = "tipo_pub")
	private String tipoPub;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_proy")
	private ProyectoP proyecto;

	public Entregable() {
	}

	public Integer getIdEntregable() {
		return this.idEntregable;
	}

	public void setIdEntregable(Integer idEntregable) {
		this.idEntregable = idEntregable;
	}

	public String getAutores() {
		return this.autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Integer getHorasDedicadas() {
		return this.horasDedicadas;
	}

	public void setHorasDedicadas(Integer horasDedicadas) {
		this.horasDedicadas = horasDedicadas;
	}

	public String getMedioPublic() {
		return this.medioPublic;
	}

	public void setMedioPublic(String medioPublic) {
		this.medioPublic = medioPublic;
	}

	public String getNompub() {
		return this.nompub;
	}

	public void setNompub(String nompub) {
		this.nompub = nompub;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getResumenPr() {
		return this.resumenPr;
	}

	public void setResumenPr(String resumenPr) {
		this.resumenPr = resumenPr;
	}

	public String getTipoPub() {
		return this.tipoPub;
	}

	public void setTipoPub(String tipoPub) {
		this.tipoPub = tipoPub;
	}

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

}