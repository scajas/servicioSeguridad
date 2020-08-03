package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pregunta_respuesta database table.
 * 
 */
@Entity
@Table(name="pregunta_respuesta", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="PreguntaRespuesta.findAll", query="SELECT p FROM PreguntaRespuesta p")
public class PreguntaRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pregunta_respuesta")
	private String idPreguntaRespuesta;


	private Boolean respuesta;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne
	@JoinColumn(name="id_solicitud")
	private SolicitudAutorizacion solicitud;

	public PreguntaRespuesta() {
	}

	public String getIdPreguntaRespuesta() {
		return this.idPreguntaRespuesta;
	}

	public void setIdPreguntaRespuesta(String idPreguntaRespuesta) {
		this.idPreguntaRespuesta = idPreguntaRespuesta;
	}

	public Boolean getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public SolicitudAutorizacion getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(SolicitudAutorizacion solicitud) {
		this.solicitud = solicitud;
	}

}