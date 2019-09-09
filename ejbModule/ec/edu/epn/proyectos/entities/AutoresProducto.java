package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the autores_producto database table.
 * 
 */
@Entity

@Table(name = "autores_producto", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "AutoresProducto.findAll", query = "SELECT a FROM AutoresProducto a")
public class AutoresProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String nced;
	private String nombres;
	private String tipoi,idinst ,
	  idscopus;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	public AutoresProducto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTipoi() {
		return this.tipoi;
	}

	public void setTipoi(String tipoi) {
		this.tipoi = tipoi;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getIdinst() {
		return idinst;
	}

	public void setIdinst(String idinst) {
		this.idinst = idinst;
	}

	public String getIdscopus() {
		return idscopus;
	}

	public void setIdscopus(String idscopus) {
		this.idscopus = idscopus;
	}

}