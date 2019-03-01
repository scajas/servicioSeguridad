package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the partind database table.
 * 
 */
@Entity
@Table(name = "Partind", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name = "Partind.findAll", query = "SELECT p FROM Partind p")
public class Partind implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_pind")
	private String codPind;

	private String cargo;

	private String categoria;

	@Column(name = "cod_clase")
	private String codClase;

	private String dedicacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fsis_pind")
	private Date fsisPind;

	private String grado;

	@Column(name = "nsec_cargo")
	private Integer nsecCargo;

	private BigDecimal sueldob;

	@Column(name = "tipo_cargo")
	private String tipoCargo;

	@Column(name = "usr_pind")
	private String usrPind;

	// bi-directional many-to-one association to Escsal
	@OneToMany(mappedBy = "partind")
	private List<Escsal> escsals;

	public Partind() {
	}

	public String getCodPind() {
		return this.codPind;
	}

	public void setCodPind(String codPind) {
		this.codPind = codPind;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodClase() {
		return this.codClase;
	}

	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public Date getFsisPind() {
		return this.fsisPind;
	}

	public void setFsisPind(Date fsisPind) {
		this.fsisPind = fsisPind;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Integer getNsecCargo() {
		return this.nsecCargo;
	}

	public void setNsecCargo(Integer nsecCargo) {
		this.nsecCargo = nsecCargo;
	}

	public BigDecimal getSueldob() {
		return this.sueldob;
	}

	public void setSueldob(BigDecimal sueldob) {
		this.sueldob = sueldob;
	}

	public String getTipoCargo() {
		return this.tipoCargo;
	}

	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public String getUsrPind() {
		return this.usrPind;
	}

	public void setUsrPind(String usrPind) {
		this.usrPind = usrPind;
	}

	public List<Escsal> getEscsals() {
		return this.escsals;
	}

	public void setEscsals(List<Escsal> escsals) {
		this.escsals = escsals;
	}

	public Escsal addEscsal(Escsal escsal) {
		getEscsals().add(escsal);
		escsal.setPartind(this);

		return escsal;
	}

	public Escsal removeEscsal(Escsal escsal) {
		getEscsals().remove(escsal);
		escsal.setPartind(null);

		return escsal;
	}

}