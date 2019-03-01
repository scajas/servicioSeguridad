package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the partidas generales database table.
 * 
 */
@Entity
@Table(name = "partida_general", catalog = "bddcorpepn", schema = "\"Rrhh\"")
public class PartidaGeneral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_part_gen")
	private Integer idPartidaGeneral;
	
	@Column(name ="numero_partida")
	private String numeroPartida;
	
	@Column(name ="nombre_partida")
	private String nombrePartida;
	
	@Column(name ="descripcion_partida")
	private String descripcionPartida;
	
	private String estado;

	public Integer getIdPartidaGeneral() {
		return idPartidaGeneral;
	}

	public void setIdPartidaGeneral(Integer idPartidaGeneral) {
		this.idPartidaGeneral = idPartidaGeneral;
	}

	public String getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public String getNombrePartida() {
		return nombrePartida;
	}

	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}

	public String getDescripcionPartida() {
		return descripcionPartida;
	}

	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	

}
