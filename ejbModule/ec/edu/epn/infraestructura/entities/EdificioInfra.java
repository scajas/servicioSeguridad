package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the edificio database table.
 * 
 */
@Entity
@Table(name = "edificio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class EdificioInfra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_edificio")
	private Integer idEdificio;

	@Column(name = "codigo_edificio")
	private String codigoEdificio;

	@Column(name = "nom_edificio")
	private String nomEdificio;

	@Column(name = "referencia_edificio")
	private String referenciaEdificio;

	// bi-directional many-to-one association to Piso
	@OneToMany(mappedBy = "edificio")
	private Set<PisoInfra> pisos;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoinfra")
	private TipoInfraestructura tipoInfraestructura;

	public TipoInfraestructura getTipoInfraestructura() {
		return tipoInfraestructura;
	}

	public void setTipoInfraestructura(TipoInfraestructura tipoInfraestructura) {
		this.tipoInfraestructura = tipoInfraestructura;
	}

	public EdificioInfra() {
	}

	public Integer getIdEdificio() {
		return this.idEdificio;
	}

	public void setIdEdificio(Integer idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getCodigoEdificio() {
		return this.codigoEdificio;
	}

	public void setCodigoEdificio(String codigoEdificio) {
		this.codigoEdificio = codigoEdificio;
	}

	public String getNomEdificio() {
		return this.nomEdificio;
	}

	public void setNomEdificio(String nomEdificio) {
		this.nomEdificio = nomEdificio;
	}

	public String getReferenciaEdificio() {
		return this.referenciaEdificio;
	}

	public void setReferenciaEdificio(String referenciaEdificio) {
		this.referenciaEdificio = referenciaEdificio;
	}

	public Set<PisoInfra> getPisos() {
		return this.pisos;
	}

	public void setPisos(Set<PisoInfra> pisos) {
		this.pisos = pisos;
	}

}