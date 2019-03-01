package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * The persistent class for the Auditoria Pedido database table.
 * 
 */
@Entity
@Table(name = "auditoria_pedido", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class AuditoriaPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuencia_audit_pedido", sequenceName = "secuencia_audit_pedido", allocationSize = 1, catalog = "bddcorpepn", schema = "`Contratos`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_audit_pedido")
	@Column(name = "id_auditoria_pedido")
	private Integer idAuditoriaPedido;

	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "id_facultad")
	private Integer idFacultad;

	@Column(name = "nced_docente")
	private String ncedDocente;
	
	@Column(name = "nombre_docente")
	private String nombreDocente;
	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_eliminacion")
	private Timestamp fechaEliminacion;

	/**
	 * @return the idAuditoriaPedido
	 */
	public Integer getIdAuditoriaPedido() {
		return idAuditoriaPedido;
	}

	/**
	 * @param idAuditoriaPedido the idAuditoriaPedido to set
	 */
	public void setIdAuditoriaPedido(Integer idAuditoriaPedido) {
		this.idAuditoriaPedido = idAuditoriaPedido;
	}

	/**
	 * @return the idPedido
	 */
	public Integer getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the idFacultad
	 */
	public Integer getIdFacultad() {
		return idFacultad;
	}

	/**
	 * @param idFacultad the idFacultad to set
	 */
	public void setIdFacultad(Integer idFacultad) {
		this.idFacultad = idFacultad;
	}

	/**
	 * @return the ncedDocente
	 */
	public String getNcedDocente() {
		return ncedDocente;
	}

	/**
	 * @param ncedDocente the ncedDocente to set
	 */
	public void setNcedDocente(String ncedDocente) {
		this.ncedDocente = ncedDocente;
	}

	/**
	 * @return the nombreDocente
	 */
	public String getNombreDocente() {
		return nombreDocente;
	}

	/**
	 * @param nombreDocente the nombreDocente to set
	 */
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaEliminacion
	 */
	public Timestamp getFechaEliminacion() {
		return fechaEliminacion;
	}

	/**
	 * @param fechaEliminacion the fechaEliminacion to set
	 */
	public void setFechaEliminacion(Timestamp fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}	 
	 
}