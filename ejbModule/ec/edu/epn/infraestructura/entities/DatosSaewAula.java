package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the datos_saew_aulas database table.
 * 
 */
@Entity
@Table(name = "datos_saew_aulas", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class DatosSaewAula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_datos_saewaulas")
	private Integer idDatosSaewaulas;

	@Column(name = "cupo")
	private Integer cupos;

	@Column(name = "id_carrera")
	private Integer idCarrera;

	@Column(name = "id_curso_paralelo")
	private String idCursoParalelo;

	@Column(name = "nombre_materia")
	private String nombreMateria;

	@Column(name = "nombre_carrera")
	private String nombreCarrera;

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	@Column(name = "id_materia")
	private String idMateria;

	@Column(name = "id_nivel")
	private Integer idNivel;

	@Column(name = "id_pensum")
	private String idPensum;

	@Column(name = "id_prerrequisito")
	private String idPrerrequisito;

	@Column(name = "id_profesor")
	private String idProfesor;

	@Column(name = "id_codmat_compartida")
	private String codmateriaCompartida;

	@Column(name = "id_carrera_compartida")
	private String codcarreraCompartida;

	@Column(name = "id_facultad")
	private String codFacultad;

	public String getCodmateriaCompartida() {
		return codmateriaCompartida;
	}

	public void setCodmateriaCompartida(String codmateriaCompartida) {
		this.codmateriaCompartida = codmateriaCompartida;
	}

	public String getCodcarreraCompartida() {
		return codcarreraCompartida;
	}

	public void setCodcarreraCompartida(String codcarreraCompartida) {
		this.codcarreraCompartida = codcarreraCompartida;
	}

	public String getCodFacultad() {
		return codFacultad;
	}

	public void setCodFacultad(String codFacultad) {
		this.codFacultad = codFacultad;
	}

	// bi-directional many-to-one association to Sesione
	@OneToMany(mappedBy = "datosSaewAula")
	private List<Sesione> sesiones;

	public DatosSaewAula() {
	}

	public Integer getIdDatosSaewaulas() {
		return this.idDatosSaewaulas;
	}

	public void setIdDatosSaewaulas(Integer idDatosSaewaulas) {
		this.idDatosSaewaulas = idDatosSaewaulas;
	}

	public Integer getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getIdCursoParalelo() {
		return this.idCursoParalelo;
	}

	public void setIdCursoParalelo(String idCursoParalelo) {
		this.idCursoParalelo = idCursoParalelo;
	}

	public String getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdNivel() {
		return this.idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(String idPensum) {
		this.idPensum = idPensum;
	}

	public String getIdPrerrequisito() {
		return this.idPrerrequisito;
	}

	public void setIdPrerrequisito(String idPrerrequisito) {
		this.idPrerrequisito = idPrerrequisito;
	}

	public String getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public List<Sesione> getSesiones() {
		return this.sesiones;
	}

	public void setSesiones(List<Sesione> sesiones) {
		this.sesiones = sesiones;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	public Sesione addSesione(Sesione sesione) {
		getSesiones().add(sesione);
		sesione.setDatosSaewAula(this);

		return sesione;
	}

	public Sesione removeSesione(Sesione sesione) {
		getSesiones().remove(sesione);
		sesione.setDatosSaewAula(null);

		return sesione;
	}

}