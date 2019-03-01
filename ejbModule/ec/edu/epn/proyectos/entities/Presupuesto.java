package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presupuesto database table.
 * 
 */
@Entity

@Table(name="presupuesto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pres_pr")
	private Integer idPresPr;

	@Column(name="concepto_pr")
	private String conceptoPr;

	@Column(name="descr_pr")
	private String descrPr;

	@Column(name="fuente_pr")
	private String fuentePr;

	@Column(name="monto_pr")
	private Double montoPr;
	
	
	
	private Double montosiva;
	
	@Column(name="porcentaje")
	private Double procentaje;
	
	
	private Integer anio;

	//bi-directional many-to-one association to EjecucionPresupuestaria
	@OneToMany(mappedBy="presupuesto")
	private List<EjecucionPresupuestaria> ejecucionPresupuestarias;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;
    
    
    @ManyToOne
   	@JoinColumn(name="id_ip")
   	private ItemP item;

    public Presupuesto() {
    }

	public Integer getIdPresPr() {
		return this.idPresPr;
	}

	public void setIdPresPr(Integer idPresPr) {
		this.idPresPr = idPresPr;
	}

	public String getConceptoPr() {
		return this.conceptoPr;
	}

	public void setConceptoPr(String conceptoPr) {
		this.conceptoPr = conceptoPr;
	}

	public String getDescrPr() {
		return this.descrPr;
	}

	public void setDescrPr(String descrPr) {
		this.descrPr = descrPr;
	}

	public String getFuentePr() {
		return this.fuentePr;
	}

	public void setFuentePr(String fuentePr) {
		this.fuentePr = fuentePr;
	}

	public double getMontoPr() {
		return this.montoPr;
	}

	public void setMontoPr(double montoPr) {
		this.montoPr = montoPr;
	}

	public List<EjecucionPresupuestaria> getEjecucionPresupuestarias() {
		return this.ejecucionPresupuestarias;
	}

	public void setEjecucionPresupuestarias(List<EjecucionPresupuestaria> ejecucionPresupuestarias) {
		this.ejecucionPresupuestarias = ejecucionPresupuestarias;
	}
	
	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public ItemP getItem() {
		return item;
	}

	public void setItem(ItemP item) {
		this.item = item;
	}

	public Double getMontosiva() {
		return montosiva;
	}

	public void setMontosiva(Double montosiva) {
		this.montosiva = montosiva;
	}

	/**
	 * @return the procentaje
	 */
	public Double getProcentaje() {
		return procentaje;
	}

	/**
	 * @param procentaje the procentaje to set
	 */
	public void setProcentaje(Double procentaje) {
		this.procentaje = procentaje;
	}
	
}