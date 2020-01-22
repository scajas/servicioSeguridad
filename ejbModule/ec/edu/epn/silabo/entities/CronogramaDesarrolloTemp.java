package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cronograma_desarrollo_temp database table.
 * 
 */
@Entity
@Table(name="cronograma_desarrollo_temp", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="CronogramaDesarrolloTemp.findAll", query="SELECT c FROM CronogramaDesarrolloTemp c")
public class CronogramaDesarrolloTemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cronograma")
	private Integer idCronograma;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_crono")
	private Date fechaCrono;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_old")
	private Date fechaOld;

	private String hora1;

	private String hora2;

	private Integer horas;

	@Column(name="id_silabo")
	private Integer idSilabo;

	private Integer idsubcapitulo;

	private Integer indice;

	@Column(name="num_cronograma")
	private Integer numCronograma;

	private String reemplazado;

	public CronogramaDesarrolloTemp() {
	}

	public Integer getIdCronograma() {
		return this.idCronograma;
	}

	public void setIdCronograma(Integer idCronograma) {
		this.idCronograma = idCronograma;
	}

	public Date getFechaCrono() {
		return this.fechaCrono;
	}

	public void setFechaCrono(Date fechaCrono) {
		this.fechaCrono = fechaCrono;
	}

	public Date getFechaOld() {
		return this.fechaOld;
	}

	public void setFechaOld(Date fechaOld) {
		this.fechaOld = fechaOld;
	}

	public String getHora1() {
		return this.hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getHora2() {
		return this.hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public Integer getHoras() {
		return this.horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getIdSilabo() {
		return this.idSilabo;
	}

	public void setIdSilabo(Integer idSilabo) {
		this.idSilabo = idSilabo;
	}

	public Integer getIdsubcapitulo() {
		return this.idsubcapitulo;
	}

	public void setIdsubcapitulo(Integer idsubcapitulo) {
		this.idsubcapitulo = idsubcapitulo;
	}

	public Integer getIndice() {
		return this.indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Integer getNumCronograma() {
		return this.numCronograma;
	}

	public void setNumCronograma(Integer numCronograma) {
		this.numCronograma = numCronograma;
	}

	public String getReemplazado() {
		return this.reemplazado;
	}

	public void setReemplazado(String reemplazado) {
		this.reemplazado = reemplazado;
	}

}