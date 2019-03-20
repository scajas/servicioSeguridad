package ec.edu.epn.laboratorios.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoproducto database table.
 * 
 */
@Entity
@Table(name = "`tipoproducto`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Tipoproducto.findAll", query="SELECT t FROM Tipoproducto t")
public class Tipoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPROVEEDOR_IDTIPOPROD_GENERATOR", sequenceName="secuencia_tipo_proveedor",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPROVEEDOR_IDTIPOPROD_GENERATOR")
	@Column(name="id_tipoprod")
	private Integer idTipoprod;

	@Column(name="descr_tprod")
	private String descrTprod;

	@Column(name="nombre_tprod")
	private String nombreTprod;

	

	public Tipoproducto() {
	}	

	public Integer getIdTipoprod() {
		return this.idTipoprod;
	}

	public void setIdTipoprod(Integer idTipoprod) {
		this.idTipoprod = idTipoprod;
	}

	public String getDescrTprod() {
		return this.descrTprod;
	}

	public void setDescrTprod(String descrTprod) {
		this.descrTprod = descrTprod;
	}

	public String getNombreTprod() {
		return this.nombreTprod;
	}

	public void setNombreTprod(String nombreTprod) {
		this.nombreTprod = nombreTprod;
	}

	

}