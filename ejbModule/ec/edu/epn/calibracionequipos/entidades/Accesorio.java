package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accesorios database table.
 * 
 */
@Entity
@Table(name="accesorios", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Accesorio.findAll", query="SELECT a FROM Accesorio a")
public class Accesorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_accesorio")
	private Integer idAccesorio;

	@Column(name="descripcion_asccesorio")
	private String descripcionAsccesorio;

	@Column(name="nombre_accesorio")
	private String nombreAccesorio;

	//bi-directional many-to-many association to Equiposcalibracionequipo
	//@ManyToMany(mappedBy="accesorios")
	//private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	
	public Accesorio() {
	}

	public Integer getIdAccesorio() {
		return this.idAccesorio;
	}

	public void setIdAccesorio(Integer idAccesorio) {
		this.idAccesorio = idAccesorio;
	}

	public String getDescripcionAsccesorio() {
		return this.descripcionAsccesorio;
	}

	public void setDescripcionAsccesorio(String descripcionAsccesorio) {
		this.descripcionAsccesorio = descripcionAsccesorio;
	}

	public String getNombreAccesorio() {
		return this.nombreAccesorio;
	}

	public void setNombreAccesorio(String nombreAccesorio) {
		this.nombreAccesorio = nombreAccesorio;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipos(Equiposcalibracionequipo equiposcalibracionequipos) {
		this.equiposcalibracionequipo = equiposcalibracionequipos;
	}

}