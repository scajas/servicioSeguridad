package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the familiares database table.
 * 
 */
@Entity
@Table(name = "familiares", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Familiare.findAll", query="SELECT f FROM Familiare f")
public class Familiare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_familiar")
	private Integer idFamiliar;

	@Column(name="apel_fam")
	private String apelFam;

	private String discapacidad;

	private String enfermedades;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	private Date fechaNac;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="nom_familiar")
	private String nomFamiliar;

	private String nrocarnetdis;

	private String nrodocumento;

	@Column(name="otros_rel")
	private String otrosRel;

	@Column(name="porc_dis")
	private Integer porcDis;

	private Integer porcentajedis;

	private String relacion;

	private String tdocumento;

	private String tipodis;

	@Column(name="usuario_log")
	private String usuarioLog;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced_emp")
	private Emp emp;

	//bi-directional many-to-one association to Instruccion
	@ManyToOne
	@JoinColumn(name="id_instruccion")
	private Instruccion instruccion;

	public Familiare() {
	}

	public Integer getIdFamiliar() {
		return this.idFamiliar;
	}

	public void setIdFamiliar(Integer idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public String getApelFam() {
		return this.apelFam;
	}

	public void setApelFam(String apelFam) {
		this.apelFam = apelFam;
	}

	public String getDiscapacidad() {
		return this.discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public String getEnfermedades() {
		return this.enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getNomFamiliar() {
		return this.nomFamiliar;
	}

	public void setNomFamiliar(String nomFamiliar) {
		this.nomFamiliar = nomFamiliar;
	}

	public String getNrocarnetdis() {
		return this.nrocarnetdis;
	}

	public void setNrocarnetdis(String nrocarnetdis) {
		this.nrocarnetdis = nrocarnetdis;
	}

	public String getNrodocumento() {
		return this.nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getOtrosRel() {
		return this.otrosRel;
	}

	public void setOtrosRel(String otrosRel) {
		this.otrosRel = otrosRel;
	}

	public Integer getPorcDis() {
		return this.porcDis;
	}

	public void setPorcDis(Integer porcDis) {
		this.porcDis = porcDis;
	}

	public Integer getPorcentajedis() {
		return this.porcentajedis;
	}

	public void setPorcentajedis(Integer porcentajedis) {
		this.porcentajedis = porcentajedis;
	}

	public String getRelacion() {
		return this.relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getTdocumento() {
		return this.tdocumento;
	}

	public void setTdocumento(String tdocumento) {
		this.tdocumento = tdocumento;
	}

	public String getTipodis() {
		return this.tipodis;
	}

	public void setTipodis(String tipodis) {
		this.tipodis = tipodis;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Instruccion getInstruccion() {
		return this.instruccion;
	}

	public void setInstruccion(Instruccion instruccion) {
		this.instruccion = instruccion;
	}

}