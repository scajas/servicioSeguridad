package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoproducto database table.
 * 
 */
@Entity
@Table(name = "estadoproducto", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Estadoproducto.findAll", query="SELECT e FROM Estadoproducto e")
public class Estadoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@SequenceGenerator(name="ESTADOPRODUCTO_IDESTADOPROD_GENERATOR", sequenceName="secuencia_estadoproducto",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOPRODUCTO_IDESTADOPROD_GENERATOR")
	
	@Column(name="id_estadoprod")
	private int idEstadoprod;

	@Column(name="descr_estp")
	private String descrEstp;

	@Column(name="nombre_estp")
	private String nombreEstp;

	//bi-directional many-to-one association to Existencia
	//@OneToMany(mappedBy="estadoproducto")
	//private List<Existencia> existencias;

	public Estadoproducto() {
	}

	public int getIdEstadoprod() {
		return idEstadoprod;
	}

	public void setIdEstadoprod(int idEstadoprod) {
		this.idEstadoprod = idEstadoprod;
	}

	public String getDescrEstp() {
		return this.descrEstp;
	}

	public void setDescrEstp(String descrEstp) {
		this.descrEstp = descrEstp;
	}

	public String getNombreEstp() {
		return this.nombreEstp;
	}

	public void setNombreEstp(String nombreEstp) {
		this.nombreEstp = nombreEstp;
	}
/*
	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setEstadoproducto(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setEstadoproducto(null);

		return existencia;
	}*/

}