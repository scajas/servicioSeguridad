package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cronosubcapitulo database table.
 * 
 */
@Entity
@Table(name="cronosubcapitulo", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name="Cronosubcapitulo.findAll", query="SELECT c FROM Cronosubcapitulo c")
public class Cronosubcapitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="idsubcapitulo")
	private Subcapitulo subcapitulo;
	
	@ManyToOne
	@JoinColumn(name="idcronograma")
	private CronogramaDesarrollo cronograma;

	public Cronosubcapitulo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subcapitulo getSubcapitulo() {
		return subcapitulo;
	}

	public void setSubcapitulo(Subcapitulo subcapitulo) {
		this.subcapitulo = subcapitulo;
	}

	public CronogramaDesarrollo getCronograma() {
		return cronograma;
	}

	public void setCronograma(CronogramaDesarrollo cronograma) {
		this.cronograma = cronograma;
	}

	

}