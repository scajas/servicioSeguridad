package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auspiciante_proyecto database table.
 * 
 */
@Entity
@Table(name="auspiciante_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`" )
public class AuspicianteProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aus_pry")
	private Integer idAusPry;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_firma_proy")
	private Date fechaFirmaProy;

	//bi-directional many-to-one association to Auspiciante
    @ManyToOne
	@JoinColumn(name="id_auspiciante")
	private Auspiciante auspiciante;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

    public AuspicianteProyecto() {
    }

	public Integer getIdAusPry() {
		return this.idAusPry;
	}

	public void setIdAusPry(Integer idAusPry) {
		this.idAusPry = idAusPry;
	}

	public Date getFechaFirmaProy() {
		return this.fechaFirmaProy;
	}

	public void setFechaFirmaProy(Date fechaFirmaProy) {
		this.fechaFirmaProy = fechaFirmaProy;
	}

	public Auspiciante getAuspiciante() {
		return this.auspiciante;
	}

	public void setAuspiciante(Auspiciante auspiciante) {
		this.auspiciante = auspiciante;
	}
	
	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
}