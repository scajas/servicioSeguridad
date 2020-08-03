package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the preguntas database table.
 * 
 */
@Entity
@Table(name="preguntas", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pregunta")
	private Integer idPregunta;

	private String estado;

	private String pregunta;

	//bi-directional many-to-one association to PreguntaRespuesta
	@OneToMany(mappedBy="pregunta", fetch=FetchType.EAGER)
	private List<PreguntaRespuesta> preguntaRespuestas;

	public Pregunta() {
	}

	public Integer getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<PreguntaRespuesta> getPreguntaRespuestas() {
		return this.preguntaRespuestas;
	}

	public void setPreguntaRespuestas(List<PreguntaRespuesta> preguntaRespuestas) {
		this.preguntaRespuestas = preguntaRespuestas;
	}

	public PreguntaRespuesta addPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		getPreguntaRespuestas().add(preguntaRespuesta);
		preguntaRespuesta.setPregunta(this);

		return preguntaRespuesta;
	}

	public PreguntaRespuesta removePreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		getPreguntaRespuestas().remove(preguntaRespuesta);
		preguntaRespuesta.setPregunta(null);

		return preguntaRespuesta;
	}

}