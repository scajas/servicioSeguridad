<<<<<<< ejbModule/ec/edu/epn/laboratorioBJ/entities/Bodega.java
package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the bodega database table.
 * 
 */
@Entity
@Table(name = "bodega", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Bodega.findAll", query="SELECT b FROM Bodega b")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BODEGA_IDBODEGA_GENERATOR", sequenceName="secuencia_bodega",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BODEGA_IDBODEGA_GENERATOR")
	@Column(name="id_bodega")
	private int idBodega;

	@Column(name="descr_bg")
	private String descrBg;

	@Column(name="habilitar_bd")
	private String habilitarBd;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="nombre_bg")
	private String nombreBg;

	@Column(name="ubicacion_bg")
	private String ubicacionBg;

	public Bodega() {
	}

	public int getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public String getDescrBg() {
		return this.descrBg;
	}

	public void setDescrBg(String descrBg) {
		this.descrBg = descrBg;
	}

	public String getHabilitarBd() {
		return this.habilitarBd;
	}

	public void setHabilitarBd(String habilitarBd) {
		this.habilitarBd = habilitarBd;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreBg() {
		return this.nombreBg;
	}

	public void setNombreBg(String nombreBg) {
		this.nombreBg = nombreBg;
	}

	public String getUbicacionBg() {
		return this.ubicacionBg;
	}

	public void setUbicacionBg(String ubicacionBg) {
		this.ubicacionBg = ubicacionBg;
	}

=======
package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the bodega database table.
 * 
 */
@Entity
@Table(name = "bodega", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Bodega.findAll", query="SELECT b FROM Bodega b")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BODEGA_IDBODEGA_GENERATOR", sequenceName="secuencia_bodega",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BODEGA_IDBODEGA_GENERATOR")
	@Column(name="id_bodega")
	private int idBodega;

	@Column(name="descr_bg")
	private String descrBg;

	@Column(name="habilitar_bd")
	private String habilitarBd;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="nombre_bg")
	private String nombreBg;

	@Column(name="ubicacion_bg")
	private String ubicacionBg;

	public Bodega() {
	}

	public int getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public String getDescrBg() {
		return this.descrBg;
	}

	public void setDescrBg(String descrBg) {
		this.descrBg = descrBg;
	}

	public String getHabilitarBd() {
		return this.habilitarBd;
	}

	public void setHabilitarBd(String habilitarBd) {
		this.habilitarBd = habilitarBd;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreBg() {
		return this.nombreBg;
	}

	public void setNombreBg(String nombreBg) {
		this.nombreBg = nombreBg;
	}

	public String getUbicacionBg() {
		return this.ubicacionBg;
	}

	public void setUbicacionBg(String ubicacionBg) {
		this.ubicacionBg = ubicacionBg;
	}

>>>>>>> ejbModule/ec/edu/epn/laboratorioBJ/entities/Bodega.java
}