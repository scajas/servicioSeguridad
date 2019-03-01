package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the acta database table.
 * 
 */
@Entity
@Table(name="acta" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Acta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_acta")
	private Integer idActa;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_acta")
	private Date fechaActa;

	@Column(name="url_documento")
	private String urlDocumento;

	//bi-directional many-to-one association to Sesion
    @ManyToOne
	@JoinColumn(name="id_sesion")
	private Sesion sesion;

    public Acta() {
    }

	public Integer getIdActa() {
		return this.idActa;
	}

	public void setIdActa(Integer idActa) {
		this.idActa = idActa;
	}

	public Date getFechaActa() {
		return this.fechaActa;
	}

	public void setFechaActa(Date fechaActa) {
		this.fechaActa = fechaActa;
	}

	public String getUrlDocumento() {
		return this.urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}

	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	
}