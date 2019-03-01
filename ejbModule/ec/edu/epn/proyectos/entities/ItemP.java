package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the item_p database table.
 * 
 */
@Entity
@Table(name="item_p", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ItemP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ip")
	private Integer idIp;

	@Column(name="descr_ip")
	private String descrIp;

	@Column(name="nombre_ip")
	private String nombreIp;
	
	private String iva;
	
	
	
	@OneToMany(mappedBy="item")
	private List<Presupuesto> presupuesto;	
	
	

    public ItemP() {
    }

	public Integer getIdIp() {
		return this.idIp;
	}

	public void setIdIp(Integer idIp) {
		this.idIp = idIp;
	}

	public String getDescrIp() {
		return this.descrIp;
	}

	public void setDescrIp(String descrIp) {
		this.descrIp = descrIp;
	}

	public String getNombreIp() {
		return this.nombreIp;
	}

	public void setNombreIp(String nombreIp) {
		this.nombreIp = nombreIp;
	}

	public List<Presupuesto> getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(List<Presupuesto> presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

}