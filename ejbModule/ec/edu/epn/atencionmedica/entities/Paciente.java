package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@Table(name="paciente", catalog="bddcorpepn", schema="`Medico`")
public class Paciente implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2701483387778970256L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paciente", unique=true, nullable=false)
	private Integer idPaciente;
	
	@SequenceGenerator (name="\"Medico\".paciente_numerohcl_pac_seq", sequenceName="\"Medico\".paciente_numerohcl_pac_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".paciente_numerohcl_pac_seq")	
	@Column(name="numerohcl_pac")
	private Integer numerohclPac;

	@Column(name="adicionales_pac", length=3000)
	private String adicionalesPac;

	@Column(name="antecedentesfam_pac", length=3000)
	private String antecedentesfamPac;

	@Column(name="antecedentesper_pac", length=3000)
	private String antecedentesperPac;
	
	@Column(name="antecedentesquir_pac", length=3000)
	private String antecedentesquirPac;
	
	@Column(name="antecedentesaler_pac", length=3000)
	private String antecedentesalerPac;
	
	@Column(name="antecedentesginobst_pac", length=3000)
	private String antecedentesginobstPac;

	@Column(name="apellido1_pac", nullable=false, length=30)
	private String apellido1Pac;

	@Column(name="apellido2_pac", length=30)
	private String apellido2Pac;

	@Column(name="estadoultimaactualizacion_pac", length=15)
	private String estadoultimaactualizacionPac;

	@Column(name="factorrh_pac", length=8)
	private String factorrhPac;

	@Column(name="fechaapertura_pac", nullable=false)
	private Timestamp fechaaperturaPac;

    @Temporal( TemporalType.DATE)
	@Column(name="fechanac_pac", nullable=false)
	private Date fechanacPac;

	@Column(name="fechaultimaactualizacion_pac")
	private Timestamp fechaultimaactualizacionPac;

	@Column(name="gruposanguineo_pac", length=2)
	private String gruposanguineoPac;

	@Column(name="habitosalcohol_pac", length=3000)
	private String habitosalcoholPac;

	@Column(name="habitosotros_pac", length=3000)
	private String habitosotrosPac;

	@Column(name="habitostabaco_pac", length=3000)
	private String habitostabacoPac;
	
	@Column(name="habitosactfis_pac", length=3000)
	private String habitosactfisPac;

	@Column(name="identificacion_pac", length=10)
	private String identificacionPac;

	@Column(name="nacionalidad_pac", nullable=false, length=30)
	private String nacionalidadPac;

	@Column(name="nombre1_pac", length=30)
	private String nombre1Pac;

	@Column(name="origendato_pac", length=10)
	private String origendatoPac;

	@Column(name="nombre2_pac", length=30)
	private String nombre2Pac;
	
	@Column(name="sexo_pac", nullable=false, length=10)
	private String sexoPac;
	
	private String psicologicos;
	private String psiquiatricos;
	
	@Column(name="antecedente_medicamento")
	private String antecedenteMedicamento;
	
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="telefono2")
	private String telefono2;	
	
	@Column(name="dep_car")
	private String depCar;
	
	
	
	

	//bi-directional many-to-one association to Atencionmedica
	@OneToMany(mappedBy="paciente")
	private List<Atencionmedica> atencionmedicas;

	//bi-directional many-to-one association to Catalogo
    @ManyToOne
	@JoinColumn(name="id_tipopaciente", nullable=false)
	private Catalogo catalogo;

    public Paciente() {
    }

	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public Integer getNumerohclPac() {
		return numerohclPac;
	}

	public void setNumerohclPac(Integer numerohclPac) {
		this.numerohclPac = numerohclPac;
	}

	public String getAdicionalesPac() {
		try {
			return this.adicionalesPac.trim();
		} catch (Exception e) {
			return this.adicionalesPac;
		}
	}

	public void setAdicionalesPac(String adicionalesPac) {
		this.adicionalesPac = adicionalesPac.trim();
	}

	public String getAntecedentesfamPac() {
		try {
			return this.antecedentesfamPac.trim();
		} catch (Exception e) {
			return this.antecedentesfamPac;
		}
	}

	public void setAntecedentesfamPac(String antecedentesfamPac) {
		this.antecedentesfamPac = antecedentesfamPac.trim();
	}

	public String getAntecedentesperPac() {
		try {
			return this.antecedentesperPac.trim();
		} catch (Exception e) {
			return this.antecedentesperPac;
		}
	}

	public void setAntecedentesperPac(String antecedentesperPac) {
		this.antecedentesperPac = antecedentesperPac.trim();
	}

	public String getApellido1Pac() {
		
		try {
			return this.apellido1Pac.trim();
		} catch (Exception e) {
			return this.apellido1Pac;
		}
	}

	public void setApellido1Pac(String apellido1Pac) {
		this.apellido1Pac = removerTildesYcaracteres(apellido1Pac.trim().toUpperCase());
	}

	public String getApellido2Pac() {
		try {
			return this.apellido2Pac.trim();
		} catch (Exception e) {
			return this.apellido2Pac;
		}
	}

	public void setApellido2Pac(String apellido2Pac) {
		this.apellido2Pac = removerTildesYcaracteres(apellido2Pac.trim().toUpperCase());
	}

	public String getEstadoultimaactualizacionPac() {
		return this.estadoultimaactualizacionPac;
	}

	public void setEstadoultimaactualizacionPac(String estadoultimaactualizacionPac) {
		this.estadoultimaactualizacionPac = estadoultimaactualizacionPac.trim();
	}

	public String getFactorrhPac() {
		return this.factorrhPac;
	}

	public void setFactorrhPac(String factorrhPac) {
		this.factorrhPac = factorrhPac.trim();
	}

	public Timestamp getFechaaperturaPac() {
		return this.fechaaperturaPac;
	}

	public void setFechaaperturaPac(Timestamp fechaaperturaPac) {
		this.fechaaperturaPac = fechaaperturaPac;
	}

	public Date getFechanacPac() {
		return this.fechanacPac;
	}

	public void setFechanacPac(Date fechanacPac) {
		this.fechanacPac = fechanacPac;
	}

	public Timestamp getFechaultimaactualizacionPac() {
		return this.fechaultimaactualizacionPac;
	}

	public void setFechaultimaactualizacionPac(Timestamp fechaultimaactualizacionPac) {
		this.fechaultimaactualizacionPac = fechaultimaactualizacionPac;
	}

	public String getGruposanguineoPac() {
		return this.gruposanguineoPac;
	}

	public void setGruposanguineoPac(String gruposanguineoPac) {
		this.gruposanguineoPac = gruposanguineoPac.trim();
	}

	public String getHabitosalcoholPac() {
		try {
			return this.habitosalcoholPac.trim();
		} catch (Exception e) {
			return this.habitosalcoholPac;
		}
	}

	public void setHabitosalcoholPac(String habitosalcoholPac) {
		this.habitosalcoholPac = habitosalcoholPac.trim();
	}

	public String getHabitosotrosPac() {
		try {
			return this.habitosotrosPac.trim();
		} catch (Exception e) {
			return this.habitosotrosPac;
		}
	}

	public void setHabitosotrosPac(String habitosotrosPac) {
		this.habitosotrosPac = habitosotrosPac.trim();
	}

	public String getHabitostabacoPac() {
		try {
			return this.habitostabacoPac.trim();
		} catch (Exception e) {
			return this.habitostabacoPac;
		}
	}

	public void setHabitostabacoPac(String habitostabacoPac) {
		this.habitostabacoPac = habitostabacoPac.trim();
	}

	public String getIdentificacionPac() {
		try {
			return this.identificacionPac.trim();
		} catch (Exception e) {
			e.getStackTrace();
			return this.identificacionPac;
		}
	}

	public void setIdentificacionPac(String identificacionPac) {
		this.identificacionPac = identificacionPac;
	}

	public String getNacionalidadPac() {
		return this.nacionalidadPac;
	}

	public void setNacionalidadPac(String nacionalidadPac) {
		this.nacionalidadPac = removerTildesYcaracteres(nacionalidadPac.trim().toUpperCase());
	}

	public String getNombre1Pac() {
		try {
			return this.nombre1Pac.trim();
		} catch (Exception e) {
			return this.nombre1Pac;
		}
	}

	public void setNombre1Pac(String nombre1Pac) {
		this.nombre1Pac = removerTildesYcaracteres(nombre1Pac.trim().toUpperCase());
	}

	public String getNombre2Pac() {
		try {
			return this.nombre2Pac.trim();
		} catch (Exception e) {
			return this.nombre2Pac;
		}
	}

	public void setNombre2Pac(String nombre2Pac) {
		this.nombre2Pac =removerTildesYcaracteres(nombre2Pac.trim().toUpperCase());
	}

	public String getSexoPac() {
		return this.sexoPac;
	}

	public void setSexoPac(String sexoPac) {
		this.sexoPac = sexoPac.trim();
	}

	public List<Atencionmedica> getAtencionmedicas() {
		return this.atencionmedicas;
	}

	public void setAtencionmedicas(List<Atencionmedica> atencionmedicas) {
		this.atencionmedicas = atencionmedicas;
	}
	
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	
	/**
	 * Función que elimina acentos y caracteres especiales de
	 * una cadena de texto.
	 * @param input
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public String removerTildesYcaracteres(String input) {
	    // Cadena de caracteres original a sustituir.
	    String original = "\\¨º-~#@|!,·$%&/()?¡¿[^`]+}{¨´>< ;,:.";
	    // Cadena de caracteres ASCII que reemplazarï¿½n los originales.
	    String    ascii = "                                     ";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }//for i
	    return output;
	}//reemplazarCaracteresRaros

	public String getOrigendatoPac() {
		try {
			return this.origendatoPac.trim();
		} catch (Exception e) {
			return this.origendatoPac;
		}
	}

	public void setOrigendatoPac(String origendatoPac) {
		this.origendatoPac = origendatoPac.toUpperCase().trim();
	}

	////////////////////////////////////////adicionales
	@Transient
	private String edad;

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getHabitosactfisPac() {		
		try {
			return this.habitosactfisPac.trim();
		} catch (Exception e) {
			return this.habitosactfisPac;
		}		
	}

	public void setHabitosactfisPac(String habitosactfisPac) {
		this.habitosactfisPac = habitosactfisPac;
	}

	public String getAntecedentesquirPac() {
		return antecedentesquirPac;
	}

	public void setAntecedentesquirPac(String antecedentesquirPac) {
		this.antecedentesquirPac = antecedentesquirPac;
	}

	public String getAntecedentesalerPac() {
		return antecedentesalerPac;
	}

	public void setAntecedentesalerPac(String antecedentesalerPac) {
		this.antecedentesalerPac = antecedentesalerPac;
	}

	public String getAntecedentesginobstPac() {
		return antecedentesginobstPac;
	}

	public void setAntecedentesginobstPac(String antecedentesginobstPac) {
		this.antecedentesginobstPac = antecedentesginobstPac;
	}

	public String getPsicologicos() {
		return psicologicos;
	}

	public void setPsicologicos(String psicologicos) {
		this.psicologicos = psicologicos;
	}

	public String getPsiquiatricos() {
		return psiquiatricos;
	}

	public void setPsiquiatricos(String psiquiatricos) {
		this.psiquiatricos = psiquiatricos;
	}

	public String getAntecedenteMedicamento() {
		return antecedenteMedicamento;
	}

	public void setAntecedenteMedicamento(String antecedenteMedicamento) {
		this.antecedenteMedicamento = antecedenteMedicamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getDepCar() {
		return depCar;
	}

	public void setDepCar(String depCar) {
		this.depCar = depCar;
	}

}