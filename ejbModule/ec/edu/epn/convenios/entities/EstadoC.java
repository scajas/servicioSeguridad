package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the estado_c database table.
 * 
 */
@Entity

@Table(name="estado_c", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class EstadoC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadoc")
	private Integer idEstadoc;

	@Column(name="descr_ec")
	private String descrEc;

	@Column(name="nombre_ec")
	private String nombreEc;

	//bi-directional many-to-one association to RegistroEstado
	@OneToMany(mappedBy="estadoC")
	private List<RegistroEstado> registroEstados;

    public EstadoC() {
    }

	public Integer getIdEstadoc() {
		return this.idEstadoc;
	}

	public void setIdEstadoc(Integer idEstadoc) {
		this.idEstadoc = idEstadoc;
	}

	public String getDescrEc() {
		return this.descrEc;
	}

	public void setDescrEc(String descrEc) {
		this.descrEc = descrEc;
	}

	public String getNombreEc() {
		return this.nombreEc;
	}

	public void setNombreEc(String nombreEc) {
		this.nombreEc = nombreEc;
	}

	public List<RegistroEstado> getRegistroEstados() {
		return this.registroEstados;
	}

	public void setRegistroEstados(List<RegistroEstado> registroEstados) {
		this.registroEstados = registroEstados;
	}
	
}