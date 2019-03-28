package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the norma database table.
 * 
 */
@Entity
@Table(name = "`norma`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Norma.findAll", query="SELECT n FROM Norma n")
public class Norma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NORMA_IDNORMA_GENERATOR", sequenceName="secuencia_norma",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NORMA_IDNORMA_GENERATOR")
	@Column(name="id_norma")
	private int idNorma;

	@Column(name="descripcion_n")
	private String descripcionN;

	@Column(name="nombre_n")
	private String nombreN;

	public Norma() {
	}

	public int getIdNorma() {
		return this.idNorma;
	}

	public void setIdNorma(int idNorma) {
		this.idNorma = idNorma;
	}

	public String getDescripcionN() {
		return this.descripcionN;
	}

	public void setDescripcionN(String descripcionN) {
		this.descripcionN = descripcionN;
	}

	public String getNombreN() {
		return this.nombreN;
	}

	public void setNombreN(String nombreN) {
		this.nombreN = nombreN;
	}

}