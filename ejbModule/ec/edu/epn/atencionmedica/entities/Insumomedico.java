package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;


import javax.persistence.*;

import ec.edu.epn.atencionmedica.util.util;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the insumomedico database table.
 * 
 */
@Entity
@Table(name="insumomedico", catalog="bddcorpepn", schema="`Medico`")
public class Insumomedico extends util implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4606033976241362044L;

	@Id	
	@Column(name="id_insumomed", unique=true, nullable=false)
	@SequenceGenerator (name="\"Medico\".insumomedico_id_insumomed_seq", sequenceName="\"Medico\".insumomedico_id_insumomed_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".insumomedico_id_insumomed_seq")
	private Integer idInsumomed;

	@Column(name="cantidadactual_ism", nullable=false)
	private Integer cantidadactualIsm;

	@Column(name="cantidadreorden_ism", nullable=false)
	private Integer cantidadreordenIsm;

	@Column(name="formafarmaceutica_ism", nullable=false)
	private String formafarmaceuticaIsm;

	@Column(name="nombre_ism", nullable=false, length=100)
	private String nombreIsm;
	
	@Column(name="esodont_ism")
	private Boolean esodontIns;
	
	@Temporal( TemporalType.DATE)
	@Column(name="fechacaducidad_ism")
	private Date fechacaducidadIsm;

	//bi-directional many-to-one association to Detallemovimiento
	@OneToMany(mappedBy="insumomedico")
	private List<Detallemovimiento> detallemovimientos;
	
	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="id_tipopresentacioninsumo")
	private Catalogo catalogoTipoPresentacion;

	public Insumomedico() {
	}

	public Integer getIdInsumomed() {
		return this.idInsumomed;
	}

	public void setIdInsumomed(Integer idInsumomed) {
		this.idInsumomed = idInsumomed;
	}

	public Integer getCantidadactualIsm() {
		return this.cantidadactualIsm;
	}

	public void setCantidadactualIsm(Integer cantidadactualIsm) {
		this.cantidadactualIsm = cantidadactualIsm;
	}

	public Integer getCantidadreordenIsm() {
		return this.cantidadreordenIsm;
	}

	public void setCantidadreordenIsm(Integer cantidadreordenIsm) {
		this.cantidadreordenIsm = cantidadreordenIsm;
	}

	public String getFormaFarmaceuticaIsm() {
		try {
			return this.formafarmaceuticaIsm.trim();
		} catch (Exception e) {
			return this.formafarmaceuticaIsm;
		}
	}

	public void setFormaFarmaceuticaIsm(String formaFarmaceuticaIsm) {
		this.formafarmaceuticaIsm = removerTildesYcaracteres(formaFarmaceuticaIsm.trim().toUpperCase());
	}

	public String getNombreIsm() {
		try {
			return this.nombreIsm.trim();
		} catch (Exception e) {
			return this.nombreIsm;
		}
	}

	public void setNombreIsm(String nombreIsm) {
		this.nombreIsm = removerTildesYcaracteres(nombreIsm.trim().toUpperCase());
	}

	public List<Detallemovimiento> getDetallemovimientos() {
		return this.detallemovimientos;
	}

	public void setDetallemovimientos(List<Detallemovimiento> detallemovimientos) {
		this.detallemovimientos = detallemovimientos;
	}


	public Catalogo getCatalogoTipoPresentacion() {
		return catalogoTipoPresentacion;
	}

	public void setCatalogoTipoPresentacion(Catalogo catalogoTipoPresentacion) {
		this.catalogoTipoPresentacion = catalogoTipoPresentacion;
	}

	public Boolean getEsodontIns() {
		return esodontIns;
	}

	public void setEsodontIns(Boolean esodontIns) {
		this.esodontIns = esodontIns;
	}

	public Date getFechacaducidadIsm() {
		return fechacaducidadIsm;
	}

	public void setFechacaducidadIsm(Date fechacaducidadIsm) {
		this.fechacaducidadIsm = fechacaducidadIsm;
	}

	
	

}