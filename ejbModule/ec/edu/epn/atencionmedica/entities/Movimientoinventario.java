package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the movimientoinventario database table.
 * 
 */
@Entity
@Table(name="movimientoinventario", catalog="bddcorpepn", schema="`Medico`")
public class Movimientoinventario implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8898110174084128363L;

	@Id	
	@Column(name="id_movimientoinv", unique=true, nullable=false)
	@SequenceGenerator (name="\"Medico\".movimientoinventario_id_movimientoinv_seq", sequenceName="\"Medico\".movimientoinventario_id_movimientoinv_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "\"Medico\".movimientoinventario_id_movimientoinv_seq")
	private Integer idMovimientoinv;

	@Column(name="fechahora_mov", nullable=false)
	private Timestamp fechahoraMov;

	@Column(name="motivo_mov", length=1000)
	private String motivoMov;

	@Column(name="numerodocumento_mov", length=100)
	private String numerodocumentoMov;

	//bi-directional many-to-one association to Detallemovimiento
	@OneToMany(mappedBy="movimientoinventario", fetch = FetchType.EAGER)
	private List<Detallemovimiento> detallemovimientos;

	//bi-directional many-to-one association to Atencionmedica
	@ManyToOne
	@JoinColumn(name="id_atencionmed")
	private Atencionmedica atencionmedica;

	//bi-directional many-to-one association to Catalogo
    @ManyToOne
	@JoinColumn(name="id_tipomovinventario", nullable=false)
	private Catalogo catalogotipomovinventario;

	//bi-directional many-to-one association to Catalogo
    @ManyToOne
	@JoinColumn(name="id_tipoestadomov", nullable=false)
	private Catalogo catalogotipoestadomov;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private PersonalAtencion personal;
	

	public Movimientoinventario() {
	}

	public Integer getIdMovimientoinv() {
		return this.idMovimientoinv;
	}

	public void setIdMovimientoinv(Integer idMovimientoinv) {
		this.idMovimientoinv = idMovimientoinv;
	}

	public Timestamp getFechahoraMov() {
		return this.fechahoraMov;
	}

	public void setFechahoraMov(Timestamp fechahoraMov) {
		this.fechahoraMov = fechahoraMov;
	}

	public String getMotivoMov() {
		return this.motivoMov;
	}

	public void setMotivoMov(String motivoMov) {
		this.motivoMov = motivoMov;
	}

	public String getNumerodocumentoMov() {
		return this.numerodocumentoMov;
	}

	public void setNumerodocumentoMov(String numerodocumentoMov) {
		this.numerodocumentoMov = numerodocumentoMov;
	}

	public List<Detallemovimiento> getDetallemovimientos() {
		return this.detallemovimientos;
	}

	public void setDetallemovimientos(List<Detallemovimiento> detallemovimientos) {
		this.detallemovimientos = detallemovimientos;
	}	

	public Atencionmedica getAtencionmedica() {
		return this.atencionmedica;
	}

	public void setAtencionmedica(Atencionmedica atencionmedica) {
		this.atencionmedica = atencionmedica;
	}

	

	public PersonalAtencion getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalAtencion personal) {
		this.personal = personal;
	}

	public Catalogo getCatalogotipomovinventario() {
		return catalogotipomovinventario;
	}

	public void setCatalogotipomovinventario(Catalogo catalogotipomovinventario) {
		this.catalogotipomovinventario = catalogotipomovinventario;
	}

	public Catalogo getCatalogotipoestadomov() {
		return catalogotipoestadomov;
	}

	public void setCatalogotipoestadomov(Catalogo catalogotipoestadomov) {
		this.catalogotipoestadomov = catalogotipoestadomov;
	}

}