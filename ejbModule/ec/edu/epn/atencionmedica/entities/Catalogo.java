package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.atencionmedica.util.util;

import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@Table(name="catalogo", catalog="bddcorpepn", schema="`Medico`")
public class Catalogo extends util implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7247175764712262056L;

	@Id	
	@Column(name="id_catalogo", unique=true, nullable=false)
	@SequenceGenerator (name="\"Medico\".catalogo_id_catalogo_seq", sequenceName="\"Medico\".catalogo_id_catalogo_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".catalogo_id_catalogo_seq")
	private Integer idCatalogo;

	@Column(name="activo_cat", nullable=false)
	private Boolean activoCat;

	@Column(name="descripcion_cat", nullable=false, length=50)
	private String descripcionCat;

	@Column(name="operacion_cat", length=20)
	private String operacionCat;

	//bi-directional many-to-one association to Atencionmedica
	@OneToMany(mappedBy="catalogo")
	private List<Atencionmedica> atencionmedicas;

	//bi-directional many-to-one association to Catalogotipo
	@ManyToOne
	@JoinColumn(name="id_catalogotipo", nullable=false)
	private Catalogotipo catalogotipo;
	

	//bi-directional many-to-one association to Movimientoinventario
	@OneToMany(mappedBy="catalogotipomovinventario")
	private List<Movimientoinventario> tipomovimientoinventarios;

	//bi-directional many-to-one association to Movimientoinventario
	@OneToMany(mappedBy="catalogotipoestadomov")
	private List<Movimientoinventario> estadomovimientoinventarios;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="catalogo")
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="catalogo1")
	private List<PersonalAtencion> personals1;
	

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="catalogo2")
	private List<PersonalAtencion> personals2;

	public Catalogo() {
	}

	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public Boolean getActivoCat() {
		return this.activoCat;
	}

	public void setActivoCat(Boolean activoCat) {
		this.activoCat = activoCat;
	}

	public String getDescripcionCat() {
		try {
			return this.descripcionCat.trim().toUpperCase();
		} catch (Exception e) {
			return this.descripcionCat;
		}
	}

	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = removerTildesYcaracteres(descripcionCat.toUpperCase().trim());
	}

	public String getOperacionCat() {
		try {
			return this.operacionCat.trim();
		} catch (Exception e) {
			return this.operacionCat;
		}
	}

	public void setOperacionCat(String operacionCat) {
		this.operacionCat = operacionCat;
	}

	public List<Atencionmedica> getAtencionmedicas() {
		return this.atencionmedicas;
	}

	public void setAtencionmedicas(List<Atencionmedica> atencionmedicas) {
		this.atencionmedicas = atencionmedicas;
	}

	
	public Catalogotipo getCatalogotipo() {
		return this.catalogotipo;
	}

	public void setCatalogotipo(Catalogotipo catalogotipo) {
		this.catalogotipo = catalogotipo;
	}
			

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<PersonalAtencion> getPersonals1() {
		return personals1;
	}

	public void setPersonals1(List<PersonalAtencion> personals1) {
		this.personals1 = personals1;
	}

	public List<PersonalAtencion> getPersonals2() {
		return personals2;
	}

	public void setPersonals2(List<PersonalAtencion> personals2) {
		this.personals2 = personals2;
	}

	
	public List<Movimientoinventario> getTipomovimientoinventarios() {
		return tipomovimientoinventarios;
	}

	public void setTipomovimientoinventarios(List<Movimientoinventario> tipomovimientoinventarios) {
		this.tipomovimientoinventarios = tipomovimientoinventarios;
	}

	public List<Movimientoinventario> getMovimientoinventarios2() {
		return this.estadomovimientoinventarios;
	}

	public void setMovimientoinventarios2(List<Movimientoinventario> estadomovimientoinventarios) {
		this.estadomovimientoinventarios = estadomovimientoinventarios;
	}
	
	

}