package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the horasm_prof database table.
 * 
 */
@Entity
@Table(name="horasm_prof")
@NamedQuery(name="HorasmProf.findAll", query="SELECT h FROM HorasmProf h")
public class HorasmProf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_horasmprof")
	private Integer codHorasmprof;

	private String anio;

	private String mes;

	private String nced;

	private Integer nhorasdic;

	@Column(name="upfsis_hmp")
	private Timestamp upfsisHmp;

	@Column(name="upusr_hmp")
	private String upusrHmp;

	public HorasmProf() {
	}

	public Integer getCodHorasmprof() {
		return this.codHorasmprof;
	}

	public void setCodHorasmprof(Integer codHorasmprof) {
		this.codHorasmprof = codHorasmprof;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getNhorasdic() {
		return this.nhorasdic;
	}

	public void setNhorasdic(Integer nhorasdic) {
		this.nhorasdic = nhorasdic;
	}

	public Timestamp getUpfsisHmp() {
		return this.upfsisHmp;
	}

	public void setUpfsisHmp(Timestamp upfsisHmp) {
		this.upfsisHmp = upfsisHmp;
	}

	public String getUpusrHmp() {
		return this.upusrHmp;
	}

	public void setUpusrHmp(String upusrHmp) {
		this.upusrHmp = upusrHmp;
	}

}