package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the titulos_docente database table.
 * 
 */
@Entity
@Table(name = "titulos_docente", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class TitulosDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_titulodocente")
	private Integer id_tituloDocente;

	@Column(name = "registro_secesc_docente")
	private String registroSecescDocente;

	@Column(name = "titulo_docente")
	private String tituloDocente;

	@Column(name = "cedula_docente")
	private String cedulaDocente;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "universidad")
	private String universidad;
	
	@Column(name = "nivel_titulo")
	private String nivelTitulo;


	public String getCedulaDocente() {
		return cedulaDocente;
	}

	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}

	// bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public TitulosDocente() {
	}

	public Integer getId_tituloDocente() {
		return this.id_tituloDocente;
	}

	public void setId_tituloDocente(Integer id_tituloDocente) {
		this.id_tituloDocente = id_tituloDocente;
	}

	public String getRegistroSecescDocente() {
		return this.registroSecescDocente;
	}

	public void setRegistroSecescDocente(String registroSecescDocente) {
		this.registroSecescDocente = registroSecescDocente;
	}

	public String getTituloDocente() {
		return this.tituloDocente;
	}

	public void setTituloDocente(String tituloDocente) {
		this.tituloDocente = tituloDocente;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getNivelTitulo() {
		return nivelTitulo;
	}

	public void setNivelTitulo(String nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

}