package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity(name = "ParametroVoto")
@Table(name = "parametros", catalog = "`bddcorpepn`", schema = "`Votoe`")
public class ParametroVoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_param")
	private Integer idParam;

	@Column(name = "num_mayoria")
	private Integer numMayoria;

	@Column(name = "num_miembros")
	private Integer numMiembros;

	private Integer numresolucion;

	private String usuario;

	// bi-directional many-to-one association to Consejo
	@ManyToOne
	@JoinColumn(name = "id_consejo")
	private Consejo consejo;

	public ParametroVoto() {
	}

	public Integer getIdParam() {
		return this.idParam;
	}

	public void setIdParam(Integer idParam) {
		this.idParam = idParam;
	}

	public Integer getNumMayoria() {
		return this.numMayoria;
	}

	public void setNumMayoria(Integer numMayoria) {
		this.numMayoria = numMayoria;
	}

	public Integer getNumMiembros() {
		return this.numMiembros;
	}

	public void setNumMiembros(Integer numMiembros) {
		this.numMiembros = numMiembros;
	}

	public Integer getNumresolucion() {
		return this.numresolucion;
	}

	public void setNumresolucion(Integer numresolucion) {
		this.numresolucion = numresolucion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Consejo getConsejo() {
		return consejo;
	}

	public void setConsejo(Consejo consejo) {
		this.consejo = consejo;
	}

}