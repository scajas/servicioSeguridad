package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serviciotecnico database table.
 * 
 */
@Entity
@Table(name="serviciotecnico", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Serviciotecnico.findAll", query="SELECT s FROM Serviciotecnico s")
public class Serviciotecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_serviciotecnico")
	private Integer idServiciotecnico;

	@Column(name="direccion_serviciotecnico")
	private String direccionServiciotecnico;

	@Column(name="email_serviciotecnico")
	private String emailServiciotecnico;

	@Column(name="nombrecontacto_serviciotecnico")
	private String nombrecontactoServiciotecnico;

	@Column(name="telefono_serviciotecnico")
	private String telefonoServiciotecnico;

	//bi-directional many-to-one association to Detalleplan
	@OneToMany(mappedBy="serviciotecnico")
	private List<Detalleplan> detalleplans;

	public Serviciotecnico() {
	}

	public Integer getIdServiciotecnico() {
		return this.idServiciotecnico;
	}

	public void setIdServiciotecnico(Integer idServiciotecnico) {
		this.idServiciotecnico = idServiciotecnico;
	}

	public String getDireccionServiciotecnico() {
		return this.direccionServiciotecnico;
	}

	public void setDireccionServiciotecnico(String direccionServiciotecnico) {
		this.direccionServiciotecnico = direccionServiciotecnico;
	}

	public String getEmailServiciotecnico() {
		return this.emailServiciotecnico;
	}

	public void setEmailServiciotecnico(String emailServiciotecnico) {
		this.emailServiciotecnico = emailServiciotecnico;
	}

	public String getNombrecontactoServiciotecnico() {
		return this.nombrecontactoServiciotecnico;
	}

	public void setNombrecontactoServiciotecnico(String nombrecontactoServiciotecnico) {
		this.nombrecontactoServiciotecnico = nombrecontactoServiciotecnico;
	}

	public String getTelefonoServiciotecnico() {
		return this.telefonoServiciotecnico;
	}

	public void setTelefonoServiciotecnico(String telefonoServiciotecnico) {
		this.telefonoServiciotecnico = telefonoServiciotecnico;
	}

	public List<Detalleplan> getDetalleplans() {
		return this.detalleplans;
	}

	public void setDetalleplans(List<Detalleplan> detalleplans) {
		this.detalleplans = detalleplans;
	}

	public Detalleplan addDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().add(detalleplan);
		detalleplan.setServiciotecnico(this);

		return detalleplan;
	}

	public Detalleplan removeDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().remove(detalleplan);
		detalleplan.setServiciotecnico(null);

		return detalleplan;
	}

}