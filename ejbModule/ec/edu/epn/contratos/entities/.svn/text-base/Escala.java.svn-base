package ec.edu.epn.contratos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the escala database table.
 * 
 */
@Entity
@Table(name = "escala", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class Escala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_escala")
	private Integer idEscala;

	@Column(name = "grado")
	private Integer grado;

	@Column(name = "nivel")
	private Integer nivel;

	@Column(name = "remuneracion")
	private double remuneracion;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "horas_mes")
	private Integer horasMes;
	
	@Column(name = "param1")
	private Integer param1;
	
	@Column(name = "semanas_mes")
	private Integer semanasMes;

	// bi-directional many-to-one association to Pedido
//	@ManyToOne
//	@JoinColumn(name = "id_cat")
//	private Categoria categoria;

	public Escala() {
	}

	public Integer getIdEscala() {
		return this.idEscala;
	}

	public void setIdEscala(Integer idEscala) {
		this.idEscala = idEscala;
	}

	public Integer getGrado() {
		return this.grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public double getRemuneracion() {
		return this.remuneracion;
	}

	public void setRemuneracion(double remuneracion) {
		this.remuneracion = remuneracion;
	}

//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getHorasMes() {
		return horasMes;
	}

	public void setHorasMes(Integer horasMes) {
		this.horasMes = horasMes;
	}

	public Integer getParam1() {
		return param1;
	}

	public void setParam1(Integer param1) {
		this.param1 = param1;
	}

	public Integer getSemanasMes() {
		return semanasMes;
	}

	public void setSemanasMes(Integer semanasMes) {
		this.semanasMes = semanasMes;
	}

}