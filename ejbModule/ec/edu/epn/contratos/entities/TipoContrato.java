package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipo_contrato database table.
 * 
 */
@Entity
@Table(name = "tipo_contrato", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class TipoContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tcont")
	private Integer idTcont;

	@Column(name="descr_tcont")
	private String descrTcont;

	@Column(name="nombre_tcont")
	private String nombreTcont;

	//bi-directional many-to-one association to RelacionActual
	@OneToMany(mappedBy="tipoContrato")
	private List<RelacionActual> relacionActuals;

	@OneToMany(mappedBy="tipoContrato")
	private List<Pedido> pedidos;
	
    public TipoContrato() {
    }

	public Integer getIdTcont() {
		return this.idTcont;
	}

	public void setIdTcont(Integer idTcont) {
		this.idTcont = idTcont;
	}

	public String getDescrTcont() {
		return this.descrTcont;
	}

	public void setDescrTcont(String descrTcont) {
		this.descrTcont = descrTcont;
	}

	public String getNombreTcont() {
		return this.nombreTcont;
	}

	public void setNombreTcont(String nombreTcont) {
		this.nombreTcont = nombreTcont;
	}

	public List<RelacionActual> getRelacionActuals() {
		return this.relacionActuals;
	}

	public void setRelacionActuals(List<RelacionActual> relacionActuals) {
		this.relacionActuals = relacionActuals;
	}
	
}