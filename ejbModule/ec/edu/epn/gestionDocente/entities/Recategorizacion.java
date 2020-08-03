package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the recategorizacion database table.
 * 
 */
@Entity
@Table(name = "recategorizacion", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "Recategorizacion.findAll", query = "SELECT r FROM Recategorizacion r")
public class Recategorizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@Column(name = "id_rec")
	private Integer idRec;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String grado;

	private String nced;

	private String tipo;

	private Integer anos;
	private String categoria;
	private String proceso;
	private String pathacta;

	private String estado;
	private String observacion;
	private Date fechae;

	// bi-directional many-to-one association to CategoriasD
	@ManyToOne
	@JoinColumn(name = "id_cat")
	private CategoriasD categoriasD;

	public Recategorizacion() {
	}

	public Integer getIdRec() {
		return this.idRec;
	}

	public void setIdRec(Integer idRec) {
		this.idRec = idRec;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public CategoriasD getCategoriasD() {
		return this.categoriasD;
	}

	public void setCategoriasD(CategoriasD categoriasD) {
		this.categoriasD = categoriasD;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getAnos() {
		return anos;
	}

	public void setAnos(Integer anos) {
		this.anos = anos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getPathacta() {
		return pathacta;
	}

	public void setPathacta(String pathacta) {
		this.pathacta = pathacta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechae() {
		return fechae;
	}

	public void setFechae(Date fechae) {
		this.fechae = fechae;
	}

}