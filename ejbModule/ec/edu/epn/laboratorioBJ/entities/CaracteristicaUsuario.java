package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caracteristica_usuario database table.
 * 
 */
@Entity
@Table(name="caracteristica_usuario")
@NamedQuery(name="CaracteristicaUsuario.findAll", query="SELECT c FROM CaracteristicaUsuario c")
public class CaracteristicaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CaracteristicaUsuarioPK id;

	//bi-directional many-to-one association to Caracteristica
	@ManyToOne
	@JoinColumn(name="id_caracteristica",insertable=false, updatable=false)
	private Caracteristica caracteristica;

	public CaracteristicaUsuario() {
	}

	public CaracteristicaUsuarioPK getId() {
		return this.id;
	}

	public void setId(CaracteristicaUsuarioPK id) {
		this.id = id;
	}

	public Caracteristica getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

}