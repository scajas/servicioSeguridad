package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cronograma_desarrollo database table.
 * 
 */
@Entity
@Table(name="cronograma_desarrollo", catalog = "`bddcorpepn`", schema = "`Silabo`" )

@NamedQuery(name="CronogramaDesarrollo.findAll", query="SELECT c FROM CronogramaDesarrollo c")
public class CronogramaDesarrollo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cronograma")
	private Integer idCronograma;

	@Column(name="capitulo_subcapitulo")
	private String capituloSubcapitulo;

	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_crono")
	private Date fechaCrono;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_old")
	private Date fechaOld;

	private String hora1;

	private String hora2,reemplazado;

	private Integer horas;

	@Column(name="num_cronograma")
	private Integer numCronograma;

	private String tema;
	
	private Integer idsubcapitulo, indice;

	//bi-directional many-to-one association to Silabo
	@ManyToOne
	@JoinColumn(name="id_silabo")
	private Silabo silabo;
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="cronograma", cascade = CascadeType.ALL )
	@OrderBy("id")
	private List<Cronosubcapitulo> cronoSubcapitulo;
	
	

	public CronogramaDesarrollo() {
	}

	public Integer getIdCronograma() {
		return this.idCronograma;
	}

	public void setIdCronograma(Integer idCronograma) {
		this.idCronograma = idCronograma;
	}

	public String getCapituloSubcapitulo() {
		return this.capituloSubcapitulo;
	}

	public void setCapituloSubcapitulo(String capituloSubcapitulo) {
		this.capituloSubcapitulo = capituloSubcapitulo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaCrono() {
		return this.fechaCrono;
	}

	public void setFechaCrono(Date fechaCrono) {
		this.fechaCrono = fechaCrono;
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

	public Integer getNumCronograma() {
		return this.numCronograma;
	}

	public void setNumCronograma(Integer numCronograma) {
		this.numCronograma = numCronograma;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Silabo getSilabo() {
		return this.silabo;
	}

	public void setSilabo(Silabo silabo) {
		this.silabo = silabo;
	}

	public Integer getIdsubcapitulo() {
		return idsubcapitulo;
	}

	public void setIdsubcapitulo(Integer idsubcapitulo) {
		this.idsubcapitulo = idsubcapitulo;
	}

	public List<Cronosubcapitulo> getCronoSubcapitulo() {
		return cronoSubcapitulo;
	}

	public void setCronoSubcapitulo(List<Cronosubcapitulo> cronoSubcapitulo) {
		this.cronoSubcapitulo = cronoSubcapitulo;
	}

	public Date getFechaOld() {
		return fechaOld;
	}

	public void setFechaOld(Date fechaOld) {
		this.fechaOld = fechaOld;
	}

	public String getReemplazado() {
		return reemplazado;
	}

	public void setReemplazado(String reemplazado) {
		this.reemplazado = reemplazado;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	
	
	
	

}