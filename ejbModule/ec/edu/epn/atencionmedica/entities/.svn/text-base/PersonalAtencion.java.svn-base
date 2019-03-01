package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.atencionmedica.util.util;

import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name="personal", catalog="bddcorpepn", schema="`Medico`")
public class PersonalAtencion extends util implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853092914688442288L;

	@Id	
	@Column(name="id_personal", unique = true, nullable = true)
	@SequenceGenerator (name="\"Medico\".personal_id_personal_seq", sequenceName="\"Medico\".personal_id_personal_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".personal_id_personal_seq")
	private Integer idPersonal;

	@Column(name="apellido1_prs", nullable=false, length=30)
	private String apellido1Prs;

	@Column(name="apellido2_prs", length=30)
	private String apellido2Prs;

	@Column(name="codigomsp_prs", nullable=false, length=20)
	private String codigomspPrs;

	@Column(name="direccion_prs", nullable=false, length=100)
	private String direccionPrs;

	@Column(name="disponibilidad_prs", nullable=false, length=10)
	private String disponibilidadPrs;

	@Column(name="identificacion_prs", nullable=false, length=13)
	private String identificacionPrs;

	@Column(name="nacionalidad_prs", length=30)
	private String nacionalidadPrs;

	@Column(name="nombre1_prs", length=30)
	private String nombre1Prs;

	@Column(name="nombre2_prs", length=30)
	private String nombre2Prs;

	@Column(name="telefonos_prs", nullable=false, length=50)
	private String telefonosPrs;
	
	
	@Column(name="estado")
	private String estado;
	

	//bi-directional many-to-one association to Atencionmedica
	@OneToMany(mappedBy="personal")
	private List<Atencionmedica> atencionmedicas;

	//bi-directional many-to-one association to Movimientoinventario
	@OneToMany(mappedBy="personal")
	private List<Movimientoinventario> movimientoinventarios;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="id_tipopersonalmedico")
	private Catalogo catalogo1;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="id_tipoespecialidad", nullable=false)
	private Catalogo catalogo2;

	public PersonalAtencion() {
	}

	public Integer getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getApellido1Prs() {
		try{
			return this.apellido1Prs.trim();
		}
		catch(Exception e) {
			return this.apellido1Prs;
		}
		
	}

	public void setApellido1Prs(String apellido1Prs) {
		this.apellido1Prs = removerTildesYcaracteres(apellido1Prs.trim().toUpperCase()) ;
	}

	public String getApellido2Prs() {		
		try{
			return this.apellido2Prs.trim();
		}
		catch(Exception e) {
			return this.apellido2Prs;
		}
	}

	public void setApellido2Prs(String apellido2Prs) {
		this.apellido1Prs = removerTildesYcaracteres(apellido1Prs.trim().toUpperCase());
	}

	public String getCodigomspPrs() {
		try {
			return this.codigomspPrs.trim();
		} catch (Exception e) {
			return this.codigomspPrs;
		}
	}

	public void setCodigomspPrs(String codigomspPrs) {
		this.codigomspPrs = removerTildesYcaracteres(codigomspPrs.trim().toUpperCase());
	}

	public String getDireccionPrs() {
		try {
			return this.direccionPrs.trim();
		} catch (Exception e) {
			return this.direccionPrs;
		}
	}

	public void setDireccionPrs(String direccionPrs) {
		this.direccionPrs = removerTildesYcaracteres(direccionPrs.trim().toUpperCase());
	}

	public String getDisponibilidadPrs() {
		try {
			return this.disponibilidadPrs.trim();
		} catch (Exception e) {
			return this.disponibilidadPrs;
		}
	}

	public void setDisponibilidadPrs(String disponibilidadPrs) {
		this.disponibilidadPrs = removerTildesYcaracteres(disponibilidadPrs.trim().toUpperCase());
	}

	public String getIdentificacionPrs() {
		return this.identificacionPrs;
	}

	public void setIdentificacionPrs(String identificacionPrs) {
		this.identificacionPrs = identificacionPrs;
	}

	public String getNacionalidadPrs() {
		try {
			return this.nacionalidadPrs.trim();
		} catch (Exception e) {
			return this.nacionalidadPrs;
		}
	}

	public void setNacionalidadPrs(String nacionalidadPrs) {
		this.nacionalidadPrs = removerTildesYcaracteres(nacionalidadPrs.trim().toUpperCase());
	}

	public String getNombre1Prs() {
		try {
			return this.nombre1Prs.trim();
		} catch (Exception e) {
			return this.nombre1Prs;
		}
	}

	public void setNombre1Prs(String nombre1Prs) {
		this.nombre1Prs = removerTildesYcaracteres(nombre1Prs.trim().toUpperCase()); 
	}

	public String getNombre2Prs() {
		try {
			return this.nombre2Prs.trim();
		} catch (Exception e) {
			return this.nombre2Prs;
		}
	}

	public void setNombre2Prs(String nombre2Prs) {
		this.nombre2Prs = removerTildesYcaracteres(nombre2Prs.trim().toUpperCase());
	}

	public String getTelefonosPrs() {
		try {
			return this.telefonosPrs.trim();
		} catch (Exception e) {
			return this.telefonosPrs;
		}
	}

	public void setTelefonosPrs(String telefonosPrs) {
		this.telefonosPrs = removerTildesYcaracteres(telefonosPrs.trim().toUpperCase());
	}

	public List<Atencionmedica> getAtencionmedicas() {
		return this.atencionmedicas;
	}

	public void setAtencionmedicas(List<Atencionmedica> atencionmedicas) {
		this.atencionmedicas = atencionmedicas;
	}
	

	public List<Movimientoinventario> getMovimientoinventarios() {
		return this.movimientoinventarios;
	}

	public void setMovimientoinventarios(List<Movimientoinventario> movimientoinventarios) {
		this.movimientoinventarios = movimientoinventarios;
	}


	public Catalogo getCatalogo1() {
		return this.catalogo1;
	}

	public void setCatalogo1(Catalogo catalogo1) {
		this.catalogo1 = catalogo1;
	}

	public Catalogo getCatalogo2() {
		return this.catalogo2;
	}

	public void setCatalogo2(Catalogo catalogo2) {
		this.catalogo2 = catalogo2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}