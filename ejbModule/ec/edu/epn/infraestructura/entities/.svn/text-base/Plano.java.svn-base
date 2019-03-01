package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the planos database table.
 * 
 */
@Entity
@Table(name="planos" , catalog = "bddcorpepn", schema = "`Infraestructura`")

public class Plano implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plano")
	private Integer idPlano;

	@Column(name="descripcion_plano")
	private String descripcionPlano;

	private String estado;

	@Column(name="nombre_plano")
	private String nombrePlano;

	private byte[] plano;

	//bi-directional many-to-one association to Piso
	@OneToMany(mappedBy="plano")
	private Set<PisoInfra> pisos;

    public Plano() {
    }

	public Integer getIdPlano() {
		return this.idPlano;
	}

	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}

	public String getDescripcionPlano() {
		return this.descripcionPlano;
	}

	public void setDescripcionPlano(String descripcionPlano) {
		this.descripcionPlano = descripcionPlano;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombrePlano() {
		return this.nombrePlano;
	}

	public void setNombrePlano(String nombrePlano) {
		this.nombrePlano = nombrePlano;
	}

	public byte[] getPlano() {
		return this.plano;
	}

	public void setPlano(byte[] plano) {
		this.plano = plano;
	}

	public Set<PisoInfra> getPisos() {
		return this.pisos;
	}

	public void setPisos(Set<PisoInfra> pisos) {
		this.pisos = pisos;
	}
	
}