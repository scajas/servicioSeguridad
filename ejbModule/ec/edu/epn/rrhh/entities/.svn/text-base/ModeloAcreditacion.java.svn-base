package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modelo_acreditacion database table.
 * 
 */
@Entity
@Table(name="modelo_acreditacion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="ModeloAcreditacion.findAll", query="SELECT m FROM ModeloAcreditacion m")
public class ModeloAcreditacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String criterio;

	private String evidencias;

	@Column(name="id_pefil_valida_firma")
	private Integer idPefilValidaFirma;

	@Column(name="id_perfil_encargado")
	private Integer idPerfilEncargado;

	@Column(name="id_perfil_verifica")
	private Integer idPerfilVerifica;

	private String indicador1;

	private String indicador2;

	private String inidcador3;

	private String subcriterio;

	//bi-directional many-to-one association to Evidencia
	@OneToMany(fetch = FetchType.EAGER,mappedBy="modeloAcreditacion", cascade = CascadeType.ALL )
	private List<Evidencia> evidenciasSet;

	public ModeloAcreditacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCriterio() {
		return this.criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public String getEvidencias() {
		return this.evidencias;
	}

	public void setEvidencias(String evidencias) {
		this.evidencias = evidencias;
	}

	public Integer getIdPefilValidaFirma() {
		return this.idPefilValidaFirma;
	}

	public void setIdPefilValidaFirma(Integer idPefilValidaFirma) {
		this.idPefilValidaFirma = idPefilValidaFirma;
	}

	public Integer getIdPerfilEncargado() {
		return this.idPerfilEncargado;
	}

	public void setIdPerfilEncargado(Integer idPerfilEncargado) {
		this.idPerfilEncargado = idPerfilEncargado;
	}

	public Integer getIdPerfilVerifica() {
		return this.idPerfilVerifica;
	}

	public void setIdPerfilVerifica(Integer idPerfilVerifica) {
		this.idPerfilVerifica = idPerfilVerifica;
	}

	public String getIndicador1() {
		return this.indicador1;
	}

	public void setIndicador1(String indicador1) {
		this.indicador1 = indicador1;
	}

	public String getIndicador2() {
		return this.indicador2;
	}

	public void setIndicador2(String indicador2) {
		this.indicador2 = indicador2;
	}

	public String getInidcador3() {
		return this.inidcador3;
	}

	public void setInidcador3(String inidcador3) {
		this.inidcador3 = inidcador3;
	}

	public String getSubcriterio() {
		return this.subcriterio;
	}

	public void setSubcriterio(String subcriterio) {
		this.subcriterio = subcriterio;
	}

	public List<Evidencia> getEvidenciasSet() {
		return this.evidenciasSet;
	}

	public void setEvidenciasSet(List<Evidencia> evidenciasSet) {
		this.evidenciasSet = evidenciasSet;
	}

	public Evidencia addEvidenciasSet(Evidencia evidenciasSet) {
		getEvidenciasSet().add(evidenciasSet);
		evidenciasSet.setModeloAcreditacion(this);

		return evidenciasSet;
	}

	public Evidencia removeEvidenciasSet(Evidencia evidenciasSet) {
		getEvidenciasSet().remove(evidenciasSet);
		evidenciasSet.setModeloAcreditacion(null);

		return evidenciasSet;
	}

}