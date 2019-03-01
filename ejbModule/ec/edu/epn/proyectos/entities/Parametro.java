package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity

@Table(name="parametro", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer serial;

	private String texto;

    public Parametro() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSerial() {
		return this.serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}