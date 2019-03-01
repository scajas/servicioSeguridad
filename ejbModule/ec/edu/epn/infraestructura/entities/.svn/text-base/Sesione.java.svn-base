package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sesiones database table.
 * 
 */
@Entity
@Table(name = "sesiones")
@NamedQuery(name = "Sesione.findAll", query = "SELECT s FROM Sesione s")
public class Sesione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_sesiones")
	private Integer idSesiones;

	private Integer duracion;

	@ManyToOne
	@JoinColumn(name = "id_dia")
	private Diaslaborable dias;

	@ManyToOne
	@JoinColumn(name = "id_espacio")
	private Espacio espacio;

	@ManyToOne
	@JoinColumn(name = "id_hora")
	private Horario hora;

	@ManyToOne
	@JoinColumn(name = "id_tipo_espacio")
	private TipoEspacio tipoEspacio;

	@ManyToOne
	@JoinColumn(name = "id_datossaewaulas")
	private DatosSaewAula datosSaewAula;

	public Sesione() {
	}

	public Integer getIdSesiones() {
		return this.idSesiones;
	}

	public void setIdSesiones(Integer idSesiones) {
		this.idSesiones = idSesiones;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public DatosSaewAula getDatosSaewAula() {
		return this.datosSaewAula;
	}

	public void setDatosSaewAula(DatosSaewAula datosSaewAula) {
		this.datosSaewAula = datosSaewAula;
	}

	public Diaslaborable getDias() {
		return dias;
	}

	public void setDias(Diaslaborable dias) {
		this.dias = dias;
	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public Horario getHora() {
		return hora;
	}

	public void setHora(Horario hora) {
		this.hora = hora;
	}

	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}

	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}

}