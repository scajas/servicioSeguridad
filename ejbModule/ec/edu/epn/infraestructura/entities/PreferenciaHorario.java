package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.edu.epn.seguridad.vo.Usuario;



/**
 * The persistent class for the preferencia_horario database table.
 * 
 */
@Entity
@Table(name = "preferencia_horario", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class PreferenciaHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_preferencia")
	private Integer idPreferencia;

	// bi-directional many-to-one association to ValoresPreferencia
	@ManyToOne
	@JoinColumn(name = "id_valor")
	private ValoresPreferencia valoresPreferencia;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_hora ")
	private Horario hora;

	@ManyToOne
	@JoinColumn(name = "id_dia")
	private Diaslaborable dias;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Horario getHora() {
		return hora;
	}

	public void setHora(Horario hora) {
		this.hora = hora;
	}

	public Diaslaborable getDias() {
		return dias;
	}

	public void setDias(Diaslaborable dias) {
		this.dias = dias;
	}

	public PreferenciaHorario() {
	}

	public Integer getIdPreferencia() {
		return this.idPreferencia;
	}

	public void setIdPreferencia(Integer idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public ValoresPreferencia getValoresPreferencia() {
		return this.valoresPreferencia;
	}

	public void setValoresPreferencia(ValoresPreferencia valoresPreferencia) {
		this.valoresPreferencia = valoresPreferencia;
	}

}