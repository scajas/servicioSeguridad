package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the convocatoria database table.
 * 
 */
@Entity(name = "ConvocatoriaVoto")
@Table(name="convocatoria" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class ConvocatoriaVoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_con")
	private Integer idCon;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_c")
	private Date fechaC;

	@Column(name="hora_c")
	private String horaC;

	@Column(name="url_convocatoria")
	private String urlConvocatoria;
	
	
	
	@Column(name="sesion_convo")
	private String sesion_conv;

	//bi-directional many-to-one association to Consejo
    @ManyToOne
	@JoinColumn(name="id_consejo")
	private Consejo consejo;

	//bi-directional many-to-one association to OrdenDia
	@OneToMany(mappedBy="convocatoria")
	private List<OrdenDia> ordenDias;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="convocatoria")
	private List<Sesion> sesions;

    public ConvocatoriaVoto() {
    }

	public Integer getIdCon() {
		return this.idCon;
	}

	public void setIdCon(Integer idCon) {
		this.idCon = idCon;
	}

	public Date getFechaC() {
		return this.fechaC;
	}

	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	

	public String getUrlConvocatoria() {
		return this.urlConvocatoria;
	}

	public void setUrlConvocatoria(String urlConvocatoria) {
		this.urlConvocatoria = urlConvocatoria;
	}

	public Consejo getConsejo() {
		return this.consejo;
	}

	public void setConsejo(Consejo consejo) {
		this.consejo = consejo;
	}
	
	public List<OrdenDia> getOrdenDias() {
		return this.ordenDias;
	}

	public void setOrdenDias(List<OrdenDia> ordenDias) {
		this.ordenDias = ordenDias;
	}
	
	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public String getHoraC() {
		return horaC;
	}

	public void setHoraC(String horaC) {
		this.horaC = horaC;
	}

	public String getSesion_conv() {
		return sesion_conv;
	}

	public void setSesion_conv(String sesion_conv) {
		this.sesion_conv = sesion_conv;
	}
	
}