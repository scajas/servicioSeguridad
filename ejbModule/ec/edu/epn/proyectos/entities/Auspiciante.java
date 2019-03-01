package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the auspiciante database table.
 * 
 */
@Entity

@Table(name="auspiciante", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Auspiciante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_auspiciante")
	private Integer idAuspiciante;

	@Column(name="cargo_auspiciante")
	private String cargoAuspiciante;

	private String email;

    

	@Column(name="id_proy")
	private Integer idProy;

	@Column(name="institucion_auspiciante")
	private String institucionAuspiciante;

	@Column(name="nombre_auspiciante")
	private String nombreAuspiciante;

	private String telefono;

	//bi-directional many-to-one association to AuspicianteProyecto
	@OneToMany(mappedBy="auspiciante")
	private List<AuspicianteProyecto> auspicianteProyectos;

    public Auspiciante() {
    }

	public Integer getIdAuspiciante() {
		return this.idAuspiciante;
	}

	public void setIdAuspiciante(Integer idAuspiciante) {
		this.idAuspiciante = idAuspiciante;
	}

	public String getCargoAuspiciante() {
		return this.cargoAuspiciante;
	}

	public void setCargoAuspiciante(String cargoAuspiciante) {
		this.cargoAuspiciante = cargoAuspiciante;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Integer getIdProy() {
		return this.idProy;
	}

	public void setIdProy(Integer idProy) {
		this.idProy = idProy;
	}

	public String getInstitucionAuspiciante() {
		return this.institucionAuspiciante;
	}

	public void setInstitucionAuspiciante(String institucionAuspiciante) {
		this.institucionAuspiciante = institucionAuspiciante;
	}

	public String getNombreAuspiciante() {
		return this.nombreAuspiciante;
	}

	public void setNombreAuspiciante(String nombreAuspiciante) {
		this.nombreAuspiciante = nombreAuspiciante;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<AuspicianteProyecto> getAuspicianteProyectos() {
		return this.auspicianteProyectos;
	}

	public void setAuspicianteProyectos(List<AuspicianteProyecto> auspicianteProyectos) {
		this.auspicianteProyectos = auspicianteProyectos;
	}
	
}