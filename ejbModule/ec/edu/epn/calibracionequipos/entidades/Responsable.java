package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the responsable database table.
 * 
 */
@Entity
@Table(name = "responsable", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r")
public class Responsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_responsable")
	private Integer idResponsable;

	@Column(name = "email_responsable")
	private String emailResponsable;

	@Column(name = "nombre_responsable")
	private String nombreResponsable;

	@Column(name = "telefonoext_responsable")
	private String telefonoextResponsable;

	@Column(name = "cedula_responsable")
	private String cedulaResponsable;

	// bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy = "responsable")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	public Responsable() {
	}

	public Integer getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getEmailResponsable() {
		return this.emailResponsable;
	}

	public void setEmailResponsable(String emailResponsable) {
		this.emailResponsable = emailResponsable;
	}

	public String getNombreResponsable() {
		return this.nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public String getTelefonoextResponsable() {
		return this.telefonoextResponsable;
	}

	public void setTelefonoextResponsable(String telefonoextResponsable) {
		this.telefonoextResponsable = telefonoextResponsable;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public String getCedulaResponsable() {
		return cedulaResponsable;
	}

	public void setCedulaResponsable(String cedulaResponsable) {
		this.cedulaResponsable = cedulaResponsable;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setResponsable(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setResponsable(null);

		return equiposcalibracionequipo;
	}

}