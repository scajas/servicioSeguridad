package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the historia_estado database table.
 * 
 */
@Entity
@Table(name="historia_estado", catalog = "bddcorpepn", schema = "`Rrhh`")
public class HistoriaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_he")
	private Integer idHe;

    @Temporal( TemporalType.DATE)
	@Column(name="ffin_he")
	private Date ffinHe;

    @Temporal( TemporalType.DATE)
	@Column(name="finicio_he")
	private Date finicioHe;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="justificacion_he")
	private String justificacionHe;
	private String activo;
	
	@ManyToOne
	@JoinColumn(name = "cod_est")
	private Estemp estemp;
	
	@ManyToOne
	@JoinColumn(name = "nced")
	private Emp emp;

    public HistoriaEstado() {
    }

	public Integer getIdHe() {
		return this.idHe;
	}

	public void setIdHe(Integer idHe) {
		this.idHe = idHe;
	}

	

	public Date getFfinHe() {
		return this.ffinHe;
	}

	public void setFfinHe(Date ffinHe) {
		this.ffinHe = ffinHe;
	}

	public Date getFinicioHe() {
		return this.finicioHe;
	}

	public void setFinicioHe(Date finicioHe) {
		this.finicioHe = finicioHe;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getJustificacionHe() {
		return this.justificacionHe;
	}

	public void setJustificacionHe(String justificacionHe) {
		this.justificacionHe = justificacionHe;
	}

	public Estemp getEstemp() {
		return estemp;
	}

	public void setEstemp(Estemp estemp) {
		this.estemp = estemp;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}