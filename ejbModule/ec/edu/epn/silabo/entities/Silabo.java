package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the silabo database table.
 * 
 */
@Entity
@Table(name = "silabo", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name = "Silabo.findAll", query = "SELECT s FROM Silabo s")
public class Silabo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_silabo")
	private Integer idSilabo;

	private String asignatura;

	private String carrera;

	@Column(name = "categoria_materia")
	private String categoriaMateria;

	private String cedula;

	@Column(name = "co_req_codigo")
	private String coReqCodigo;

	@Column(name = "co_req_nombre")
	private String coReqNombre;

	private String codigo;

	private String creditos;

	private String facultad;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_silabo")
	private Date fechaSilabo;

	@Column(name = "hor_sem_prac")
	private Double horSemPrac;

	@Column(name = "hor_sem_teoria")
	private Double horSemTeoria;

	@Column(name = "id_pensum")
	private Integer idPensum;

	@Column(name = "logros_academicos")
	private String logrosAcademicos;

	@Column(name = "logros_profesionales")
	private String logrosProfesionales;

	private String paralelo;

	private String path;

	@Column(name = "pre_req_codigo")
	private String preReqCodigo;

	@Column(name = "pre_req_nombre")
	private String preReqNombre;

	@Column(name = "tipo_materia")
	private String tipoMateria;

	@Column(name = "toatl_hor_sem_pract")
	private Double toatlHorSemPract;

	@Column(name = "total_hor_sema")
	private Double totalHorSema;

	private Double horassemacti;
	private Double totalhorasacti;
	
	private String eje;
	
	private Date finisem;
	private Date ffinsem;
	private String anio;
	 private String codcarrera; 
	 private String estado;
	 private String copiado;
	 
	 
	

	// bi-directional many-to-one association to ActividadesVinculacion
	@OneToMany(mappedBy = "silabo")
	private List<ActividadesVinculacion> actividadesVinculacions;

	// bi-directional many-to-one association to Bibliografia
	@OneToMany(mappedBy = "silabo")
	private List<Bibliografia> bibliografias;

	// bi-directional many-to-one association to Capitulo
	@OneToMany(mappedBy = "silabo")
	private List<Capitulo> capitulos;

	// bi-directional many-to-one association to CronogramaDesarrollo
	@OneToMany(mappedBy = "silabo")
	private List<CronogramaDesarrollo> cronogramaDesarrollos;

	// bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy = "silabo")
	private List<Evaluacion> evaluacions;

	// bi-directional many-to-one association to MetodologiaDeEnsenanza
	@OneToMany(mappedBy = "silabo")
	private List<MetodologiaDeEnsenanza> metodologiaDeEnsenanzas;

	// bi-directional many-to-one association to PiliticasDesarrollo
	@OneToMany(mappedBy = "silabo")
	private List<PiliticasDesarrollo> piliticasDesarrollos;

	// bi-directional many-to-one association to PracticasLaboratorio
	@OneToMany(mappedBy = "silabo")
	private List<PracticasLaboratorio> practicasLaboratorios;

	// bi-directional many-to-one association to Resultado
	@OneToMany(mappedBy = "silabo")
	private List<Resultado> resultados;

	// bi-directional many-to-one association to UbicacionHorario
	@OneToMany(mappedBy = "silabo")
	private List<UbicacionHorario> ubicacionHorarios;

	public Silabo() {
	}

	public Integer getIdSilabo() {
		return this.idSilabo;
	}

	public void setIdSilabo(Integer idSilabo) {
		this.idSilabo = idSilabo;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCategoriaMateria() {
		return this.categoriaMateria;
	}

	public void setCategoriaMateria(String categoriaMateria) {
		this.categoriaMateria = categoriaMateria;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCoReqCodigo() {
		return this.coReqCodigo;
	}

	public void setCoReqCodigo(String coReqCodigo) {
		this.coReqCodigo = coReqCodigo;
	}

	public String getCoReqNombre() {
		return this.coReqNombre;
	}

	public void setCoReqNombre(String coReqNombre) {
		this.coReqNombre = coReqNombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return this.creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getFacultad() {
		return this.facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public Date getFechaSilabo() {
		return this.fechaSilabo;
	}

	public void setFechaSilabo(Date fechaSilabo) {
		this.fechaSilabo = fechaSilabo;
	}

	

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public String getLogrosAcademicos() {
		return this.logrosAcademicos;
	}

	public void setLogrosAcademicos(String logrosAcademicos) {
		this.logrosAcademicos = logrosAcademicos;
	}

	public String getLogrosProfesionales() {
		return this.logrosProfesionales;
	}

	public void setLogrosProfesionales(String logrosProfesionales) {
		this.logrosProfesionales = logrosProfesionales;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPreReqCodigo() {
		return this.preReqCodigo;
	}

	public void setPreReqCodigo(String preReqCodigo) {
		this.preReqCodigo = preReqCodigo;
	}

	public String getPreReqNombre() {
		return this.preReqNombre;
	}

	public void setPreReqNombre(String preReqNombre) {
		this.preReqNombre = preReqNombre;
	}

	public String getTipoMateria() {
		return this.tipoMateria;
	}

	public void setTipoMateria(String tipoMateria) {
		this.tipoMateria = tipoMateria;
	}

	

	public List<ActividadesVinculacion> getActividadesVinculacions() {
		return this.actividadesVinculacions;
	}

	public void setActividadesVinculacions(List<ActividadesVinculacion> actividadesVinculacions) {
		this.actividadesVinculacions = actividadesVinculacions;
	}

	public ActividadesVinculacion addActividadesVinculacion(ActividadesVinculacion actividadesVinculacion) {
		getActividadesVinculacions().add(actividadesVinculacion);
		actividadesVinculacion.setSilabo(this);

		return actividadesVinculacion;
	}

	public ActividadesVinculacion removeActividadesVinculacion(ActividadesVinculacion actividadesVinculacion) {
		getActividadesVinculacions().remove(actividadesVinculacion);
		actividadesVinculacion.setSilabo(null);

		return actividadesVinculacion;
	}

	public List<Bibliografia> getBibliografias() {
		return this.bibliografias;
	}

	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	public Bibliografia addBibliografia(Bibliografia bibliografia) {
		getBibliografias().add(bibliografia);
		bibliografia.setSilabo(this);

		return bibliografia;
	}

	public Bibliografia removeBibliografia(Bibliografia bibliografia) {
		getBibliografias().remove(bibliografia);
		bibliografia.setSilabo(null);

		return bibliografia;
	}

	public List<Capitulo> getCapitulos() {
		return this.capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	public Capitulo addCapitulo(Capitulo capitulo) {
		getCapitulos().add(capitulo);
		capitulo.setSilabo(this);

		return capitulo;
	}

	public Capitulo removeCapitulo(Capitulo capitulo) {
		getCapitulos().remove(capitulo);
		capitulo.setSilabo(null);

		return capitulo;
	}

	public List<CronogramaDesarrollo> getCronogramaDesarrollos() {
		return this.cronogramaDesarrollos;
	}

	public void setCronogramaDesarrollos(List<CronogramaDesarrollo> cronogramaDesarrollos) {
		this.cronogramaDesarrollos = cronogramaDesarrollos;
	}

	public CronogramaDesarrollo addCronogramaDesarrollo(CronogramaDesarrollo cronogramaDesarrollo) {
		getCronogramaDesarrollos().add(cronogramaDesarrollo);
		cronogramaDesarrollo.setSilabo(this);

		return cronogramaDesarrollo;
	}

	public CronogramaDesarrollo removeCronogramaDesarrollo(CronogramaDesarrollo cronogramaDesarrollo) {
		getCronogramaDesarrollos().remove(cronogramaDesarrollo);
		cronogramaDesarrollo.setSilabo(null);

		return cronogramaDesarrollo;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setSilabo(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setSilabo(null);

		return evaluacion;
	}

	public List<MetodologiaDeEnsenanza> getMetodologiaDeEnsenanzas() {
		return this.metodologiaDeEnsenanzas;
	}

	public void setMetodologiaDeEnsenanzas(List<MetodologiaDeEnsenanza> metodologiaDeEnsenanzas) {
		this.metodologiaDeEnsenanzas = metodologiaDeEnsenanzas;
	}

	public MetodologiaDeEnsenanza addMetodologiaDeEnsenanza(MetodologiaDeEnsenanza metodologiaDeEnsenanza) {
		getMetodologiaDeEnsenanzas().add(metodologiaDeEnsenanza);
		metodologiaDeEnsenanza.setSilabo(this);

		return metodologiaDeEnsenanza;
	}

	public MetodologiaDeEnsenanza removeMetodologiaDeEnsenanza(MetodologiaDeEnsenanza metodologiaDeEnsenanza) {
		getMetodologiaDeEnsenanzas().remove(metodologiaDeEnsenanza);
		metodologiaDeEnsenanza.setSilabo(null);

		return metodologiaDeEnsenanza;
	}

	public List<PiliticasDesarrollo> getPiliticasDesarrollos() {
		return this.piliticasDesarrollos;
	}

	public void setPiliticasDesarrollos(List<PiliticasDesarrollo> piliticasDesarrollos) {
		this.piliticasDesarrollos = piliticasDesarrollos;
	}

	public PiliticasDesarrollo addPiliticasDesarrollo(PiliticasDesarrollo piliticasDesarrollo) {
		getPiliticasDesarrollos().add(piliticasDesarrollo);
		piliticasDesarrollo.setSilabo(this);

		return piliticasDesarrollo;
	}

	public PiliticasDesarrollo removePiliticasDesarrollo(PiliticasDesarrollo piliticasDesarrollo) {
		getPiliticasDesarrollos().remove(piliticasDesarrollo);
		piliticasDesarrollo.setSilabo(null);

		return piliticasDesarrollo;
	}

	public List<PracticasLaboratorio> getPracticasLaboratorios() {
		return this.practicasLaboratorios;
	}

	public void setPracticasLaboratorios(List<PracticasLaboratorio> practicasLaboratorios) {
		this.practicasLaboratorios = practicasLaboratorios;
	}

	public PracticasLaboratorio addPracticasLaboratorio(PracticasLaboratorio practicasLaboratorio) {
		getPracticasLaboratorios().add(practicasLaboratorio);
		practicasLaboratorio.setSilabo(this);

		return practicasLaboratorio;
	}

	public PracticasLaboratorio removePracticasLaboratorio(PracticasLaboratorio practicasLaboratorio) {
		getPracticasLaboratorios().remove(practicasLaboratorio);
		practicasLaboratorio.setSilabo(null);

		return practicasLaboratorio;
	}

	public List<Resultado> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Resultado addResultado(Resultado resultado) {
		getResultados().add(resultado);
		resultado.setSilabo(this);

		return resultado;
	}

	public Resultado removeResultado(Resultado resultado) {
		getResultados().remove(resultado);
		resultado.setSilabo(null);

		return resultado;
	}

	public List<UbicacionHorario> getUbicacionHorarios() {
		return this.ubicacionHorarios;
	}

	public void setUbicacionHorarios(List<UbicacionHorario> ubicacionHorarios) {
		this.ubicacionHorarios = ubicacionHorarios;
	}

	public UbicacionHorario addUbicacionHorario(UbicacionHorario ubicacionHorario) {
		getUbicacionHorarios().add(ubicacionHorario);
		ubicacionHorario.setSilabo(this);

		return ubicacionHorario;
	}

	public UbicacionHorario removeUbicacionHorario(UbicacionHorario ubicacionHorario) {
		getUbicacionHorarios().remove(ubicacionHorario);
		ubicacionHorario.setSilabo(null);

		return ubicacionHorario;
	}

	

	public String getEje() {
		return eje;
	}

	public void setEje(String eje) {
		this.eje = eje;
	}

	public Date getFinisem() {
		return finisem;
	}

	public void setFinisem(Date finisem) {
		this.finisem = finisem;
	}

	public Date getFfinsem() {
		return ffinsem;
	}

	public void setFfinsem(Date ffinsem) {
		this.ffinsem = ffinsem;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCodcarrera() {
		return codcarrera;
	}

	public void setCodcarrera(String codcarrera) {
		this.codcarrera = codcarrera;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCopiado() {
		return copiado;
	}

	public void setCopiado(String copiado) {
		this.copiado = copiado;
	}

	public Double getHorassemacti() {
		return horassemacti;
	}

	public void setHorassemacti(Double horassemacti) {
		this.horassemacti = horassemacti;
	}

	public Double getTotalhorasacti() {
		return totalhorasacti;
	}

	public void setTotalhorasacti(Double totalhorasacti) {
		this.totalhorasacti = totalhorasacti;
	}

	public Double getHorSemPrac() {
		return horSemPrac;
	}

	public void setHorSemPrac(Double horSemPrac) {
		this.horSemPrac = horSemPrac;
	}

	public Double getHorSemTeoria() {
		return horSemTeoria;
	}

	public void setHorSemTeoria(Double horSemTeoria) {
		this.horSemTeoria = horSemTeoria;
	}

	public Double getToatlHorSemPract() {
		return toatlHorSemPract;
	}

	public void setToatlHorSemPract(Double toatlHorSemPract) {
		this.toatlHorSemPract = toatlHorSemPract;
	}

	public Double getTotalHorSema() {
		return totalHorSema;
	}

	public void setTotalHorSema(Double totalHorSema) {
		this.totalHorSema = totalHorSema;
	}
	

}