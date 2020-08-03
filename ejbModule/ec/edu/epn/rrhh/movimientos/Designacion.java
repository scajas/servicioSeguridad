package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the designacion database table.
 * 
 */
@Entity
@Table(name = "designacion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name = "Designacion.findAll", query = "SELECT d FROM Designacion d")
public class Designacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_designacion")
	private Integer idDesignacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_real_fin")
	private Date fechaRealFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "tipo_designacion")
	private String tipoDesignacion;

	@Column(name = "estado")
	private String estado;
	
	

	

	// bi-directional many-to-one association to DesignacionCatalogo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_designacion")
	private DesignacionCatalogo designacionCatalogo;

	// bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_dep")
	private Dependencia dependencia;

	// bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy = "designacion")
	private List<HistoriaLaboral> historiaLaborals;

	public Designacion() {
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdDesignacion() {
		return this.idDesignacion;
	}

	public void setIdDesignacion(Integer idDesignacion) {
		this.idDesignacion = idDesignacion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTipoDesignacion() {
		return this.tipoDesignacion;
	}

	public void setTipoDesignacion(String tipoDesignacion) {
		this.tipoDesignacion = tipoDesignacion;
	}

	public DesignacionCatalogo getDesignacionCatalogo() {
		return this.designacionCatalogo;
	}

	public void setDesignacionCatalogo(DesignacionCatalogo designacionCatalogo) {
		this.designacionCatalogo = designacionCatalogo;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public Date getFechaRealFin() {
		return fechaRealFin;
	}

	public void setFechaRealFin(Date fechaRealFin) {
		this.fechaRealFin = fechaRealFin;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setDesignacion(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setDesignacion(null);

		return historiaLaboral;
	}
	
	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	
	

	

}