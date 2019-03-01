package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@Table(name="documento", catalog = "bddcorpepn", schema = "`GestionDocente`")

public class DocumentoGD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddocumento;

	private Integer idevidencia;

	private String url;
	
	private String nombre;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne
	@JoinColumn(name="idtipodoc")
	private Tipodocumento tipodocumento;

    public DocumentoGD() {
    }

	public Integer getIddocumento() {
		return this.iddocumento;
	}

	public void setIddocumento(Integer iddocumento) {
		this.iddocumento = iddocumento;
	}

	public Integer getIdevidencia() {
		return this.idevidencia;
	}

	public void setIdevidencia(Integer idevidencia) {
		this.idevidencia = idevidencia;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}