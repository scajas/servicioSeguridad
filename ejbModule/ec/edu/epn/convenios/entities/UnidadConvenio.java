package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the unidad database table.
 * 
 */

@Entity(name = "UnidadConvenio")
@Table(name="unidad", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class UnidadConvenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="ext_u")
	private String extU;

	@Column(name="nombre_u")
	private String nombreU;

	@Column(name="telef_u")
	private String telefU;
	
	
	
	@OneToMany(mappedBy="unidad")
	private List<Convenio> convenios;
	

    public UnidadConvenio() {
    }

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getExtU() {
		return this.extU;
	}

	public void setExtU(String extU) {
		this.extU = extU;
	}

	public String getNombreU() {
		return this.nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	public String getTelefU() {
		return this.telefU;
	}

	public void setTelefU(String telefU) {
		this.telefU = telefU;
	}

	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

}