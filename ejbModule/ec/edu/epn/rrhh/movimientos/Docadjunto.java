package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the docadjuntos database table.
 * 
 */
@Entity

@Table(name = "docadjuntos", catalog = "bddcorpepn", schema = "\"Rrhh\"")

@NamedQuery(name="Docadjunto.findAll", query="SELECT d FROM Docadjunto d")
public class Docadjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_doc")
	private Integer idDoc;

	private String xpath;
	
	@Column(name="documentos")
	private String documentos;

	//bi-directional many-to-one association to HistoriaLaboral
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="estado", referencedColumnName="estado"),
		@JoinColumn(name="fecha_i", referencedColumnName="fecha_i"),
		@JoinColumn(name="id_hist", referencedColumnName="id_hist")
		})
	private HistoriaLaboral historiaLaboral;

	public Docadjunto() {
	}

	public Integer getIdDoc() {
		return this.idDoc;
	}

	public void setIdDoc(Integer idDoc) {
		this.idDoc = idDoc;
	}

	public String getXpath() {
		return this.xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public HistoriaLaboral getHistoriaLaboral() {
		return this.historiaLaboral;
	}

	public void setHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		this.historiaLaboral = historiaLaboral;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}
	
	

}