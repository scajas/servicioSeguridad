package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the resultados_pruebas database table.
 * 
 */
@Entity
@Table(name = "resultados_pruebas", catalog = "`bddcorpepn`", schema = "`Desarrollo`")
@NamedQuery(name = "ResultadosPrueba.findAll", query = "SELECT r FROM ResultadosPrueba r")
public class ResultadosPrueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String estado;
	private String informacionutilizada;
	private Integer numero;
	@Column(name = "opciones_evaluar")
	private String opcionesEvaluar;
	@Column(name = "resultados_obtenidos")
	private String resultadosObtenidos;

	// bi-directional many-to-one association to Prueba
	@ManyToOne
	@JoinColumn(name = "id_pruebas")
	private Prueba prueba;

	public ResultadosPrueba() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInformacionutilizada() {
		return this.informacionutilizada;
	}

	public void setInformacionutilizada(String informacionutilizada) {
		this.informacionutilizada = informacionutilizada;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getOpcionesEvaluar() {
		return this.opcionesEvaluar;
	}

	public void setOpcionesEvaluar(String opcionesEvaluar) {
		this.opcionesEvaluar = opcionesEvaluar;
	}

	public String getResultadosObtenidos() {
		return this.resultadosObtenidos;
	}

	public void setResultadosObtenidos(String resultadosObtenidos) {
		this.resultadosObtenidos = resultadosObtenidos;
	}

	public Prueba getPrueba() {
		return this.prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

}