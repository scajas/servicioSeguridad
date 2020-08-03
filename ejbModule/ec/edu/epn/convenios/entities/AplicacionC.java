package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aplicacion_c database table.
 * 
 */
@Entity

@Table(name="aplicacion_c", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class AplicacionC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aplic")
	private Integer idAplic;

	@Column(name="descr_ac")
	private String descrAc;

	@Column(name="nombre_ac")
	private String nombreAc;

    public AplicacionC() {
    }

	public Integer getIdAplic() {
		return this.idAplic;
	}

	public void setIdAplic(Integer idAplic) {
		this.idAplic = idAplic;
	}

	public String getDescrAc() {
		return this.descrAc;
	}

	public void setDescrAc(String descrAc) {
		this.descrAc = descrAc;
	}

	public String getNombreAc() {
		return this.nombreAc;
	}

	public void setNombreAc(String nombreAc) {
		this.nombreAc = nombreAc;
	}

}