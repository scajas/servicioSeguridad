package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sillas_concejo database table.
 * 
 */
@Entity
@Table(name = "sillas_concejo", catalog = "`bddcorpepn`", schema = "`Votoe`")
public class SillasConcejo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_silla")
	private Integer idSilla;

	@Column(name="imagen_silla")
	private byte[] imagenSilla;

    public SillasConcejo() {
    }

	public Integer getIdSilla() {
		return this.idSilla;
	}

	public void setIdSilla(Integer idSilla) {
		this.idSilla = idSilla;
	}

	public byte[] getImagenSilla() {
		return this.imagenSilla;
	}

	public void setImagenSilla(byte[] imagenSilla) {
		this.imagenSilla = imagenSilla;
	}

}