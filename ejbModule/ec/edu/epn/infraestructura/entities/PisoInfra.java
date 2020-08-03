package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the piso database table.
 * 
 */
@Entity
@Table(name="piso" , catalog = "bddcorpepn", schema = "`Infraestructura`")

public class PisoInfra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_piso")
	private Integer idPiso;

	@Column(name="nom_piso")
	private String nomPiso;

	//bi-directional many-to-one association to LugarEspacio
	@OneToMany(mappedBy="piso")
	private Set<LugarEspacio> lugarEspacios;

	//bi-directional many-to-one association to Edificio
    @ManyToOne
	@JoinColumn(name="id_edificio")
	private EdificioInfra edificio;

	//bi-directional many-to-one association to Plano
    @ManyToOne
	@JoinColumn(name="id_plano")
	private Plano plano;

    public PisoInfra() {
    }

	public Integer getIdPiso() {
		return this.idPiso;
	}

	public void setIdPiso(Integer idPiso) {
		this.idPiso = idPiso;
	}

	public String getNomPiso() {
		return this.nomPiso;
	}

	public void setNomPiso(String nomPiso) {
		this.nomPiso = nomPiso;
	}

	public Set<LugarEspacio> getLugarEspacios() {
		return this.lugarEspacios;
	}

	public void setLugarEspacios(Set<LugarEspacio> lugarEspacios) {
		this.lugarEspacios = lugarEspacios;
	}
	
	public EdificioInfra getEdificio() {
		return this.edificio;
	}

	public void setEdificio(EdificioInfra edificio) {
		this.edificio = edificio;
	}
	
	public Plano getPlano() {
		return this.plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
}