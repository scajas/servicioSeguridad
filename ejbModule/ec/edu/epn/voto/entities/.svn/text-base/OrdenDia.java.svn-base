package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the orden_dia database table.
 * 
 */
@Entity
@Table(name = "orden_dia", catalog = "`bddcorpepn`", schema = "`Votoe`")
public class OrdenDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden")
	private Integer idOrden;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_orden")
	private Date fechaOrden;

	@Column(name = "novedad_punto")
	private String novedadPunto;

	@Column(name = "nro_punto")
	private Integer nroPunto;

	private String punto;

	private String tratado;

	@Column(name = "id_resolucion")
	private Integer idresol;

	private String resolucion;

	@Column(name = "tiene_mocion")
	private String tieneMocion;

	// bi-directional many-to-one association to Mocion
	@OneToMany(mappedBy = "ordenDia")
	private List<Mocion> mocions;

	// bi-directional many-to-one association to ConvocatoriaVoto
	@ManyToOne
	@JoinColumn(name = "id_con")
	private ConvocatoriaVoto convocatoria;

	public OrdenDia() {
	}

	public Integer getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Date getFechaOrden() {
		return this.fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public String getNovedadPunto() {
		return this.novedadPunto;
	}

	public void setNovedadPunto(String novedadPunto) {
		this.novedadPunto = novedadPunto;
	}

	public String getPunto() {
		return this.punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public String getTratado() {
		return this.tratado;
	}

	public void setTratado(String tratado) {
		this.tratado = tratado;
	}

	public List<Mocion> getMocions() {
		return this.mocions;
	}

	public void setMocions(List<Mocion> mocions) {
		this.mocions = mocions;
	}

	public ConvocatoriaVoto getConvocatoria() {
		return this.convocatoria;
	}

	public void setConvocatoria(ConvocatoriaVoto convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Integer getNroPunto() {
		return nroPunto;
	}

	public void setNroPunto(Integer nroPunto) {
		this.nroPunto = nroPunto;
	}

	public Integer getIdresol() {
		return idresol;
	}

	public void setIdresol(Integer idresol) {
		this.idresol = idresol;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getTieneMocion() {
		return tieneMocion;
	}

	public void setTieneMocion(String tieneMocion) {
		this.tieneMocion = tieneMocion;
	}

}