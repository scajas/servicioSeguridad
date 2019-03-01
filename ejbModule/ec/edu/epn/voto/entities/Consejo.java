package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consejo database table.
 * 
 */
@Entity
@Table(name="consejo" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class Consejo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_consejo")
	private Integer idConsejo;

	private String competencia;

	private String estado;

	@Column(name="nombre_consejo")
	private String nombreConsejo;

	//bi-directional many-to-one association to ConvocatoriaVoto
	@OneToMany(mappedBy="consejo")
	private List<ConvocatoriaVoto> convocatorias;

	//bi-directional many-to-one association to MiembroVoto
	@OneToMany(mappedBy="consejo")
	private List<MiembroVoto> miembros;

    public Consejo() {
    }

	public Integer getIdConsejo() {
		return this.idConsejo;
	}

	public void setIdConsejo(Integer idConsejo) {
		this.idConsejo = idConsejo;
	}

	public String getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreConsejo() {
		return this.nombreConsejo;
	}

	public void setNombreConsejo(String nombreConsejo) {
		this.nombreConsejo = nombreConsejo;
	}

	public List<ConvocatoriaVoto> getConvocatorias() {
		return this.convocatorias;
	}

	public void setConvocatorias(List<ConvocatoriaVoto> convocatorias) {
		this.convocatorias = convocatorias;
	}
	
	public List<MiembroVoto> getMiembros() {
		return this.miembros;
	}

	public void setMiembros(List<MiembroVoto> miembros) {
		this.miembros = miembros;
	}
	
}