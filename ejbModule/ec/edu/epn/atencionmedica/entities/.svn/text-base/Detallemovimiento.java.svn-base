package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallemovimiento database table.
 * 
 */
@Entity
@Table(name="detallemovimiento", catalog="bddcorpepn", schema="`Medico`")
public class Detallemovimiento implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5897017336763401756L;

	@Id	
	@Column(name="id_detallemov", unique=true, nullable=false)
	@SequenceGenerator (name="\"Medico\".detallemovimiento_id_detallemov_seq", sequenceName="\"Medico\".detallemovimiento_id_detallemov_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".detallemovimiento_id_detallemov_seq")
	private Integer idDetallemov;

	@Column(name="cantidad_det", nullable=false)
	private Integer cantidadDet;

	//bi-directional many-to-one association to Insumomedico
	@ManyToOne
	@JoinColumn(name="id_insumomed", nullable=false)
	private Insumomedico insumomedico;

	//bi-directional many-to-one association to Movimientoinventario
	@ManyToOne
	@JoinColumn(name="id_movimientoinv")
	private Movimientoinventario movimientoinventario;

	public Detallemovimiento() {
	}

	public Integer getIdDetallemov() {
		return this.idDetallemov;
	}

	public void setIdDetallemov(Integer idDetallemov) {
		this.idDetallemov = idDetallemov;
	}

	public Integer getCantidadDet() {
		return this.cantidadDet;
	}

	public void setCantidadDet(Integer cantidadDet) {
		this.cantidadDet = cantidadDet;
	}

	public Insumomedico getInsumomedico() {
		return this.insumomedico;
	}

	public void setInsumomedico(Insumomedico insumomedico) {
		this.insumomedico = insumomedico;
	}

	public Movimientoinventario getMovimientoinventario() {
		return this.movimientoinventario;
	}

	public void setMovimientoinventario(Movimientoinventario movimientoinventario) {
		this.movimientoinventario = movimientoinventario;
	}
	
////////////////////////////////////////adicionales
	@Transient
	private Integer cantidadComprometida;

	public Integer getCantidadComprometida() {
		return cantidadComprometida;
	}

	public void setCantidadComprometida(Integer cantidadComprometida) {
		this.cantidadComprometida = cantidadComprometida;
	}

}