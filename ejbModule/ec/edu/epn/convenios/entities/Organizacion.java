package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the organizacion database table.
 * 
 */
@Entity
@Table(name="organizacion", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class Organizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_organizacion")
	private Integer idOrganizacion;

	@Column(name="cargo_s")
	private String cargoS;

	@Column(name="contacto_or")
	private String contactoOr;

	@Column(name="descr_or")
	private String descrOr;

	@Column(name="direccion_or")
	private String direccionOr;

	@Column(name="mail_s")
	private String mailS;

	@Column(name="nombre_or")
	private String nombreOr;

	@Column(name="nombre_s")
	private String nombreS;

	@Column(name="telef_s")
	private String telefS;
	
	
	private String tipo;
	
	
	
	
	@OneToMany(mappedBy="organizacion")
	private List<ConvOrganizacion> convorga ;
	

    public Organizacion() {
    }

	public Integer getIdOrganizacion() {
		return this.idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getCargoS() {
		return this.cargoS;
	}

	public void setCargoS(String cargoS) {
		this.cargoS = cargoS;
	}

	public String getContactoOr() {
		return this.contactoOr;
	}

	public void setContactoOr(String contactoOr) {
		this.contactoOr = contactoOr;
	}

	public String getDescrOr() {
		return this.descrOr;
	}

	public void setDescrOr(String descrOr) {
		this.descrOr = descrOr;
	}

	public String getDireccionOr() {
		return this.direccionOr;
	}

	public void setDireccionOr(String direccionOr) {
		this.direccionOr = direccionOr;
	}

	public String getMailS() {
		return this.mailS;
	}

	public void setMailS(String mailS) {
		this.mailS = mailS;
	}

	public String getNombreOr() {
		return this.nombreOr;
	}

	public void setNombreOr(String nombreOr) {
		this.nombreOr = nombreOr;
	}

	public String getNombreS() {
		return this.nombreS;
	}

	public void setNombreS(String nombreS) {
		this.nombreS = nombreS;
	}

	public String getTelefS() {
		return this.telefS;
	}

	public void setTelefS(String telefS) {
		this.telefS = telefS;
	}

	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ConvOrganizacion> getConvorga() {
		return convorga;
	}

	public void setConvorga(List<ConvOrganizacion> convorga) {
		this.convorga = convorga;
	}
	
	
	
}