package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cronogramaavance database table.
 * 
 */
@Entity
@Table(name = "cronogramaavance", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name = "Cronogramaavance.findAll", query = "SELECT c FROM Cronogramaavance c")
public class Cronogramaavance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer idpensum;
	private String m1112;
	private String m12;
	private String m34;
	private String m56;
	private String m78;
	private String m910;
	private String meses;
	private String tipo,justificacion;
	private double total;

	@ManyToOne
	@JoinColumn(name = "id_cronograma")
	private Cronograma cronograma;

	public Cronogramaavance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdpensum() {
		return this.idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	public String getM1112() {
		return this.m1112;
	}

	public void setM1112(String m1112) {
		this.m1112 = m1112;
	}

	public String getM12() {
		return this.m12;
	}

	public void setM12(String m12) {
		this.m12 = m12;
	}

	public String getM34() {
		return this.m34;
	}

	public void setM34(String m34) {
		this.m34 = m34;
	}

	public String getM56() {
		return this.m56;
	}

	public void setM56(String m56) {
		this.m56 = m56;
	}

	public String getM78() {
		return this.m78;
	}

	public void setM78(String m78) {
		this.m78 = m78;
	}

	public String getM910() {
		return this.m910;
	}

	public void setM910(String m910) {
		this.m910 = m910;
	}

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

}