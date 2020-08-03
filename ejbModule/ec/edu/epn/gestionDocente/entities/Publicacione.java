package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Dep;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@Table(name="publicaciones", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="Publicacione.findAll", query="SELECT p FROM Publicacione p")
public class Publicacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PUBLICACION_IDPUBLIC_GENERATOR", sequenceName="publicaciones_idpub_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUBLICACION_IDPUBLIC_GENERATOR")
	@Column(name="id_public")
	private Integer idPublic;

	private Integer año;

	@Column(name="apoyo_inst_mem")
	private String apoyoInstMem;

	private String autores;

	@Column(name="autores_libro")
	private String autoresLibro;

	private String catalogo;

	private String categoria;

	@Column(name="cod_area_con")
	private String codAreaCon;

	@Column(name="descripcion_public")
	private String descripcionPublic;

	private String editorial;

	private String enlace;

	private String estado;

	@Column(name="estado_ac")
	private String estadoAc;

	@Column(name="fecha_public")
	private String fechaPublic;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="horas_dedic_public")
	private Integer horasDedicPublic;

	@Column(name="id_medio_public")
	private String idMedioPublic;

	@Column(name="id_pais")
	private String idPais;
	
	
	@Column(name="cuidad")
	private String ciudad;
	
	private String validarevalorazion ;
	private Date  fechavalidarevaloriacion;
	private String validarecategorza;
	private Date fechavalidarecategoriza;
	
	private String clase;
	
	private String pathobrarel;
	private String vips;
	@ManyToOne
	@JoinColumn(name = "id_area_con")
	private AreaConocimiento area;

	@ManyToOne
	@JoinColumn(name = "coddep")
	private Dep departamento;
	private String codigo;

	private String sjr;

	private String filiacion;

	

	private String coautores;

	private String compilador;

	private String coautoresexternos;
	private String indexacion;
	private Integer serial;
	private Integer anio;
	
	

	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo2;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_public")
	private TipoPublicacion tipoPublicacion;

	@Column(name="invitado_mem")
	private String invitadoMem;

	private String isbn;

	@Column(name="lugar_mem")
	private String lugarMem;

	@Column(name="materia_md")
	private String materiaMd;

	private String medio;

	private String nced;

	private Integer paginas;

	private String pais;

	private String path;

	@Column(name="ponente_mem")
	private String ponenteMem;

	@Column(name="revision_pares")
	private String revisionPares;

	private String revista;

	private String semestre;

	private String subindice;

	private String tipo;

	@Column(name="tipo_actividad")
	private String tipoActividad;

	@Column(name="tipo_mem")
	private String tipoMem;

	private String tipoindex;

	@Column(name="titulo_libro")
	private String tituloLibro;

	@Column(name="titulo_public")
	private String tituloPublic;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String valida;

	private String validacion;

	private String validadgip;

	private String visible;
	
	private String meses;
	private Integer idproy;
	private Integer idpensum;
	
	

	//bi-directional many-to-one association to Aval
	@OneToMany(mappedBy="publicacione")
	private List<Aval> avals;

	public Publicacione() {
	}

	public Integer getIdPublic() {
		return this.idPublic;
	}

	public void setIdPublic(Integer idPublic) {
		this.idPublic = idPublic;
	}

	public Integer getAño() {
		return this.año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public String getApoyoInstMem() {
		return this.apoyoInstMem;
	}

	public void setApoyoInstMem(String apoyoInstMem) {
		this.apoyoInstMem = apoyoInstMem;
	}

	public String getAutores() {
		return this.autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getAutoresLibro() {
		return this.autoresLibro;
	}

	public void setAutoresLibro(String autoresLibro) {
		this.autoresLibro = autoresLibro;
	}

	public String getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodAreaCon() {
		return this.codAreaCon;
	}

	public void setCodAreaCon(String codAreaCon) {
		this.codAreaCon = codAreaCon;
	}

	public String getDescripcionPublic() {
		return this.descripcionPublic;
	}

	public void setDescripcionPublic(String descripcionPublic) {
		this.descripcionPublic = descripcionPublic;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoAc() {
		return this.estadoAc;
	}

	public void setEstadoAc(String estadoAc) {
		this.estadoAc = estadoAc;
	}

	public String getFechaPublic() {
		return this.fechaPublic;
	}

	public void setFechaPublic(String fechaPublic) {
		this.fechaPublic = fechaPublic;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Integer getHorasDedicPublic() {
		return this.horasDedicPublic;
	}

	public void setHorasDedicPublic(Integer horasDedicPublic) {
		this.horasDedicPublic = horasDedicPublic;
	}

	public String getIdMedioPublic() {
		return this.idMedioPublic;
	}

	public void setIdMedioPublic(String idMedioPublic) {
		this.idMedioPublic = idMedioPublic;
	}

	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	

	public Periodo getPeriodo2() {
		return periodo2;
	}

	public void setPeriodo2(Periodo periodo2) {
		this.periodo2 = periodo2;
	}

	public TipoPublicacion getTipoPublicacion() {
		return tipoPublicacion;
	}

	public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public String getInvitadoMem() {
		return this.invitadoMem;
	}

	public void setInvitadoMem(String invitadoMem) {
		this.invitadoMem = invitadoMem;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLugarMem() {
		return this.lugarMem;
	}

	public void setLugarMem(String lugarMem) {
		this.lugarMem = lugarMem;
	}

	public String getMateriaMd() {
		return this.materiaMd;
	}

	public void setMateriaMd(String materiaMd) {
		this.materiaMd = materiaMd;
	}

	public String getMedio() {
		return this.medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public Integer getPaginas() {
		return this.paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPonenteMem() {
		return this.ponenteMem;
	}

	public void setPonenteMem(String ponenteMem) {
		this.ponenteMem = ponenteMem;
	}

	public String getRevisionPares() {
		return this.revisionPares;
	}

	public void setRevisionPares(String revisionPares) {
		this.revisionPares = revisionPares;
	}

	public String getRevista() {
		return this.revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSubindice() {
		return this.subindice;
	}

	public void setSubindice(String subindice) {
		this.subindice = subindice;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoActividad() {
		return this.tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getTipoMem() {
		return this.tipoMem;
	}

	public void setTipoMem(String tipoMem) {
		this.tipoMem = tipoMem;
	}

	public String getTipoindex() {
		return this.tipoindex;
	}

	public void setTipoindex(String tipoindex) {
		this.tipoindex = tipoindex;
	}

	public String getTituloLibro() {
		return this.tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getTituloPublic() {
		return this.tituloPublic;
	}

	public void setTituloPublic(String tituloPublic) {
		this.tituloPublic = tituloPublic;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getValida() {
		return this.valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getValidadgip() {
		return this.validadgip;
	}

	public void setValidadgip(String validadgip) {
		this.validadgip = validadgip;
	}

	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public List<Aval> getAvals() {
		return this.avals;
	}

	public void setAvals(List<Aval> avals) {
		this.avals = avals;
	}

	public Aval addAval(Aval aval) {
		getAvals().add(aval);
		aval.setPublicacione(this);

		return aval;
	}

	public Aval removeAval(Aval aval) {
		getAvals().remove(aval);
		aval.setPublicacione(null);

		return aval;
	}

	public String getValidarevalorazion() {
		return validarevalorazion;
	}

	public void setValidarevalorazion(String validarevalorazion) {
		this.validarevalorazion = validarevalorazion;
	}

	public Date getFechavalidarevaloriacion() {
		return fechavalidarevaloriacion;
	}

	public void setFechavalidarevaloriacion(Date fechavalidarevaloriacion) {
		this.fechavalidarevaloriacion = fechavalidarevaloriacion;
	}

	public String getValidarecategorza() {
		return validarecategorza;
	}

	public void setValidarecategorza(String validarecategorza) {
		this.validarecategorza = validarecategorza;
	}

	public Date getFechavalidarecategoriza() {
		return fechavalidarecategoriza;
	}

	public void setFechavalidarecategoriza(Date fechavalidarecategoriza) {
		this.fechavalidarecategoriza = fechavalidarecategoriza;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getPathobrarel() {
		return pathobrarel;
	}

	public void setPathobrarel(String pathobrarel) {
		this.pathobrarel = pathobrarel;
	}

	public String getVips() {
		return vips;
	}

	public void setVips(String vips) {
		this.vips = vips;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSjr() {
		return sjr;
	}

	public void setSjr(String sjr) {
		this.sjr = sjr;
	}

	public String getFiliacion() {
		return filiacion;
	}

	public void setFiliacion(String filiacion) {
		this.filiacion = filiacion;
	}

	

	public String getCoautores() {
		return coautores;
	}

	public void setCoautores(String coautores) {
		this.coautores = coautores;
	}

	public String getCompilador() {
		return compilador;
	}

	public void setCompilador(String compilador) {
		this.compilador = compilador;
	}

	public String getCoautoresexternos() {
		return coautoresexternos;
	}

	public void setCoautoresexternos(String coautoresexternos) {
		this.coautoresexternos = coautoresexternos;
	}

	public String getIndexacion() {
		return indexacion;
	}

	public void setIndexacion(String indexacion) {
		this.indexacion = indexacion;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public AreaConocimiento getArea() {
		return area;
	}

	public void setArea(AreaConocimiento area) {
		this.area = area;
	}

	public Dep getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Dep departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public Integer getIdproy() {
		return idproy;
	}

	public void setIdproy(Integer idproy) {
		this.idproy = idproy;
	}

	public Integer getIdpensum() {
		return idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	
	
	

}