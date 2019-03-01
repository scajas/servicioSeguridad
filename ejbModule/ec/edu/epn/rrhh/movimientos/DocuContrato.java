package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docu_contrato database table.
 * 
 */
@Entity
@Table(name="docu_contrato", catalog = "bddcorpepn", schema="\"Rrhh\"")
@NamedQuery(name="DocuContrato.findAll", query="SELECT d FROM DocuContrato d")
public class DocuContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_docu")
	private Integer idDocu;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy="docuContrato")
	private List<HistoriaLaboral> historiaLaborals;

	public DocuContrato() {
	}

	public Integer getIdDocu() {
		return this.idDocu;
	}

	public void setIdDocu(Integer idDocu) {
		this.idDocu = idDocu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setDocuContrato(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setDocuContrato(null);

		return historiaLaboral;
	}

}