package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the laboratorio_usuario database table.
 * 
 */
@Entity
@Table(name = "laboratorio_usuario", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="LaboratorioUsuario.findAll", query="SELECT l FROM LaboratorioUsuario l")
public class LaboratorioUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LaboratorioUsuarioPK id;

	public LaboratorioUsuario() {
	}

	public LaboratorioUsuarioPK getId() {
		return this.id;
	}

	public void setId(LaboratorioUsuarioPK id) {
		this.id = id;
	}

}