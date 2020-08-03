package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * The persistent class for the cronograma database table.
 * 
 */
@Entity

@Table(name = "cronograma", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Cronograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cronograma")
	private Integer idCronograma;

	private Integer anio;

	private String m1112;

	private String m12;

	private String m34;

	private String m56;

	private String m78;

	private String m910;

	private Double total;

	@Column(name = "nombre_cr")
	private String nombreCr;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_proy")
	private ProyectoP proyecto;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cronograma",fetch = FetchType.EAGER)
	private Set<Cronogramaavance> cronogramaAvance;

	public Cronograma() {
	}

	public Integer getIdCronograma() {
		return this.idCronograma;
	}

	public void setIdCronograma(Integer idCronograma) {
		this.idCronograma = idCronograma;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getM1112() {
		return this.m1112;
	}

	public void setM1112(String m1112) {
		this.m1112 = m1112;
	}

	public String getM12() {
		return this.m12;
	}

	public void setM12(String m12) {
		this.m12 = m12;
	}

	public String getM34() {
		return this.m34;
	}

	public void setM34(String m34) {
		this.m34 = m34;
	}

	public String getM56() {
		return this.m56;
	}

	public void setM56(String m56) {
		this.m56 = m56;
	}

	public String getM78() {
		return this.m78;
	}

	public void setM78(String m78) {
		this.m78 = m78;
	}

	public String getM910() {
		return this.m910;
	}

	public void setM910(String m910) {
		this.m910 = m910;
	}

	public String getNombreCr() {
		return this.nombreCr;
	}

	public void setNombreCr(String nombreCr) {
		this.nombreCr = nombreCr;
	}

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<Cronogramaavance> getCronogramaAvance() {
		return cronogramaAvance;
	}

	public void setCronogramaAvance(Set<Cronogramaavance> cronogramaAvance) {
		this.cronogramaAvance = cronogramaAvance;
	}
	
	

}