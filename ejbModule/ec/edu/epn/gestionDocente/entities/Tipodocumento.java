package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@Table(name="tipodocumento", catalog = "bddcorpepn", schema = "`GestionDocente`")

public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtipo;

	private String nombre;

	private String secuencia;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="tipodocumento")
	private List<DocumentoGD> documentos;

    public Tipodocumento() {
    }

	public Integer getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public List<DocumentoGD> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<DocumentoGD> documentos) {
		this.documentos = documentos;
	}
	
}