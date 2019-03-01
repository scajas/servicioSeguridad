package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_personal_proy database table.
 * 
 */
@Entity
@Table(name="tipo_personal_proy")
@NamedQuery(name="TipoPersonalProy.findAll", query="SELECT t FROM TipoPersonalProy t")
public class TipoPersonalProy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_pers_proy")
	private String idTipoPersProy;

	@Column(name="tipo_pers_proy")
	private String tipoPersProy;

	public TipoPersonalProy() {
	}

	public String getIdTipoPersProy() {
		return this.idTipoPersProy;
	}

	public void setIdTipoPersProy(String idTipoPersProy) {
		this.idTipoPersProy = idTipoPersProy;
	}

	public String getTipoPersProy() {
		return this.tipoPersProy;
	}

	public void setTipoPersProy(String tipoPersProy) {
		this.tipoPersProy = tipoPersProy;
	}

}