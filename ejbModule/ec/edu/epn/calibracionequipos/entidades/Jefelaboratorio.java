package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jefelaboratorios database table.
 * 
 */
@Entity
@Table(name="jefelaboratorios", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Jefelaboratorio.findAll", query="SELECT j FROM Jefelaboratorio j")
public class Jefelaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jefelab")
	private Integer idJefelab;

	@Column(name="docdesignacion_jefelab")
	private String docdesignacionJefelab;

	@Column(name="email_jefelab")
	private String emailJefelab;

	@Column(name="nombre_jefelab")
	private String nombreJefelab;

	@Column(name="telefono_jefelab")
	private String telefonoJefelab;
	
	@Column(name="nced")
	private String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	//bi-directional many-to-one association to Laboratorioscalibracionequipo
	@OneToMany(mappedBy="jefelaboratorio")
	private List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos;

	public Jefelaboratorio() {
	}

	public Integer getIdJefelab() {
		return this.idJefelab;
	}

	public void setIdJefelab(Integer idJefelab) {
		this.idJefelab = idJefelab;
	}

	public String getDocdesignacionJefelab() {
		return this.docdesignacionJefelab;
	}

	public void setDocdesignacionJefelab(String docdesignacionJefelab) {
		this.docdesignacionJefelab = docdesignacionJefelab;
	}

	public String getEmailJefelab() {
		return this.emailJefelab;
	}

	public void setEmailJefelab(String emailJefelab) {
		this.emailJefelab = emailJefelab;
	}

	public String getNombreJefelab() {
		return this.nombreJefelab;
	}

	public void setNombreJefelab(String nombreJefelab) {
		this.nombreJefelab = nombreJefelab;
	}

	public String getTelefonoJefelab() {
		return this.telefonoJefelab;
	}

	public void setTelefonoJefelab(String telefonoJefelab) {
		this.telefonoJefelab = telefonoJefelab;
	}

	public List<Laboratorioscalibracionequipo> getLaboratorioscalibracionequipos() {
		return this.laboratorioscalibracionequipos;
	}

	public void setLaboratorioscalibracionequipos(List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos) {
		this.laboratorioscalibracionequipos = laboratorioscalibracionequipos;
	}

	public Laboratorioscalibracionequipo addLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		getLaboratorioscalibracionequipos().add(laboratorioscalibracionequipo);
		laboratorioscalibracionequipo.setJefelaboratorio(this);

		return laboratorioscalibracionequipo;
	}

	public Laboratorioscalibracionequipo removeLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		getLaboratorioscalibracionequipos().remove(laboratorioscalibracionequipo);
		laboratorioscalibracionequipo.setJefelaboratorio(null);

		return laboratorioscalibracionequipo;
	}

}