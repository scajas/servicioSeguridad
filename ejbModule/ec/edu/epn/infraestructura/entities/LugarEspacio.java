package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

/**
 * The persistent class for the lugar_espacio database table.
 * 
 */
@Entity
@Table(name = "lugar_espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class LugarEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_lugar_espacio")
	private Integer idLugarEspacio;

	private Integer capacidad;

	@Column(name = "coordenada_x1")
	private Integer coordenadaX1;
	@Column(name = "area")
	private String area;

	@Column(name = "coordenada_x2")
	private Integer coordenadaX2;

	@Column(name = "coordenada_y1")
	private Integer coordenadaY1;

	@Column(name = "coordenada_y2")
	private Integer coordenadaY2;

	@Column(name = "ancho")
	private double ancho;

	@Column(name = "largo")
	private double largo;

	@Column(name = "alto")
	private double alto;

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	@Column(name = "costo_diario_esp")
	private double costoDiarioEsp;

	// bi-directional many-to-one association to Espacio
	@OneToMany(mappedBy = "lugarEspacio")
	private Set<Espacio> espacios;

	// bi-directional many-to-one association to Piso
	@ManyToOne
	@JoinColumn(name = "id_piso")
	private PisoInfra piso;

	public LugarEspacio() {
	}

	public Integer getIdLugarEspacio() {
		return this.idLugarEspacio;
	}

	public void setIdLugarEspacio(Integer idLugarEspacio) {
		this.idLugarEspacio = idLugarEspacio;
	}

	public Integer getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getCoordenadaX1() {
		return this.coordenadaX1;
	}

	public void setCoordenadaX1(Integer coordenadaX1) {
		this.coordenadaX1 = coordenadaX1;
	}

	public Integer getCoordenadaX2() {
		return this.coordenadaX2;
	}

	public void setCoordenadaX2(Integer coordenadaX2) {
		this.coordenadaX2 = coordenadaX2;
	}

	public Integer getCoordenadaY1() {
		return this.coordenadaY1;
	}

	public void setCoordenadaY1(Integer coordenadaY1) {
		this.coordenadaY1 = coordenadaY1;
	}

	public Integer getCoordenadaY2() {
		return this.coordenadaY2;
	}

	public void setCoordenadaY2(Integer coordenadaY2) {
		this.coordenadaY2 = coordenadaY2;
	}

	public double getCostoDiarioEsp() {
		return this.costoDiarioEsp;
	}

	public void setCostoDiarioEsp(double costoDiarioEsp) {
		this.costoDiarioEsp = costoDiarioEsp;
	}

	public Set<Espacio> getEspacios() {
		return this.espacios;
	}

	public void setEspacios(Set<Espacio> espacios) {
		this.espacios = espacios;
	}

	public PisoInfra getPiso() {
		return this.piso;
	}

	public void setPiso(PisoInfra piso) {
		this.piso = piso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}