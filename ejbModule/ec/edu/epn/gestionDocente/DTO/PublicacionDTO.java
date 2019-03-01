package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;
import java.util.Date;


public class PublicacionDTO implements Serializable{
	

	
	private static final long serialVersionUID = -251376989003256444L;
	
	private String idPublic;
	private String sitioPublic;
	private String idPeriodo;
	private String periodo;
	private String nCed;
	private String idClasePublic;
	private String temaPublic;
	private String medioPublic;
	private Date fechaPublic;
	private String descripPublic;
	private int horasDedic;
	private String tipoPublicClase;
	private String paisPublic;
	private String tipoIndex;
	private String path;

	// articulo Tecnico
	private String revista;
	private String editorial;
	private int paginas;
	private String autores;
	private String ISBN;
	private String ponenteMem;
	private String apoyoInstMem;
	private String invitadoMem;

	// Estado de Pub AC
	private String estadoAC;

	// Revision por Pares Libro
	private String revisionPares;

	private String auxFecPub;
	private String nomAutor;
	private String apelAutor;
	private String idPais;
	private String materiaMD;

	// estado y validacion
	private String estado;
	private String imagen;
	private String validacion;

	private String sucesos = " ";
	private String catalogo;

	// style del mensaje success
	private String style;
	private String styleSuccess = "COLOR: #0000FF;";
	private String styleError = "COLOR: #fc5868;";

	private String urlPublica;
	private String valida;
	
	private String validadgip;
	
	private String visible;

	public PublicacionDTO() {
		super();
	}

	public PublicacionDTO(String idPublic, String sitioPublic, String idPeriodo,
			String periodo, String nCed, String idClasePublic,
			String temaPublic, String medioPublic, Date fechaPublic,
			String descripPublic, int horasDedic, String tipoPublicClase,
			String paisPublic, String tipoIndex, String revista,
			String editorial, int paginas, String autores, String ISBN,
			String auxFecPub, String nomAutor, String apelAutor,
			String ponenteMem, String apoyoInstMem, String invitadoMem,
			String estado, String imagen, String idPais, String materiaMD,
			String validacion, String estadoAC, String revisionPares,
			String path, String catalogo, String urlPublica, String visible) {
		super();
		this.idPublic = idPublic;
		this.sitioPublic = sitioPublic;
		this.idPeriodo = idPeriodo;
		this.periodo = periodo;
		this.nCed = nCed;
		this.idClasePublic = idClasePublic;
		this.temaPublic = temaPublic;
		this.medioPublic = medioPublic;
		this.fechaPublic = fechaPublic;
		this.descripPublic = descripPublic;
		this.horasDedic = horasDedic;
		this.tipoPublicClase = tipoPublicClase;
		this.paisPublic = paisPublic;
		this.tipoIndex = tipoIndex;
		this.revista = revista;
		this.editorial = editorial;
		this.paginas = paginas;
		this.autores = autores;
		this.ISBN = ISBN;
		this.auxFecPub = auxFecPub;
		this.nomAutor = nomAutor;
		this.apelAutor = apelAutor;
		this.ponenteMem = ponenteMem;
		this.apoyoInstMem = apoyoInstMem;
		this.invitadoMem = invitadoMem;
		this.estado = estado;
		this.imagen = imagen;
		this.idPais = idPais;
		this.materiaMD = materiaMD;
		this.validacion = validacion;
		this.estadoAC = estadoAC;
		this.revisionPares = revisionPares;
		this.path = path;
		this.catalogo = catalogo;
		this.urlPublica = urlPublica;
		this.visible = visible;

	}
	
	
	/**GETTER AND SETTER*/	

	public String getIdPublic() {
		return idPublic;
	}

	public void setIdPublic(String idPublic) {
		this.idPublic = idPublic;
	}

	public String getSitioPublic() {
		return sitioPublic;
	}

	public void setSitioPublic(String sitioPublic) {
		this.sitioPublic = sitioPublic;
	}

	public String getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getnCed() {
		return nCed;
	}

	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	public String getIdClasePublic() {
		return idClasePublic;
	}

	public void setIdClasePublic(String idClasePublic) {
		this.idClasePublic = idClasePublic;
	}

	public String getTemaPublic() {
		return temaPublic;
	}

	public void setTemaPublic(String temaPublic) {
		this.temaPublic = temaPublic;
	}

	public String getMedioPublic() {
		return medioPublic;
	}

	public void setMedioPublic(String medioPublic) {
		this.medioPublic = medioPublic;
	}

	public Date getFechaPublic() {
		return fechaPublic;
	}

	public void setFechaPublic(Date fechaPublic) {
		this.fechaPublic = fechaPublic;
	}

	public String getDescripPublic() {
		return descripPublic;
	}

	public void setDescripPublic(String descripPublic) {
		this.descripPublic = descripPublic;
	}

	public int getHorasDedic() {
		return horasDedic;
	}

	public void setHorasDedic(int horasDedic) {
		this.horasDedic = horasDedic;
	}

	public String getTipoPublicClase() {
		return tipoPublicClase;
	}

	public void setTipoPublicClase(String tipoPublicClase) {
		this.tipoPublicClase = tipoPublicClase;
	}

	public String getPaisPublic() {
		return paisPublic;
	}

	public void setPaisPublic(String paisPublic) {
		this.paisPublic = paisPublic;
	}

	public String getTipoIndex() {
		return tipoIndex;
	}

	public void setTipoIndex(String tipoIndex) {
		this.tipoIndex = tipoIndex;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRevista() {
		return revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPonenteMem() {
		return ponenteMem;
	}

	public void setPonenteMem(String ponenteMem) {
		this.ponenteMem = ponenteMem;
	}

	public String getApoyoInstMem() {
		return apoyoInstMem;
	}

	public void setApoyoInstMem(String apoyoInstMem) {
		this.apoyoInstMem = apoyoInstMem;
	}

	public String getInvitadoMem() {
		return invitadoMem;
	}

	public void setInvitadoMem(String invitadoMem) {
		this.invitadoMem = invitadoMem;
	}

	public String getEstadoAC() {
		return estadoAC;
	}

	public void setEstadoAC(String estadoAC) {
		this.estadoAC = estadoAC;
	}

	public String getRevisionPares() {
		return revisionPares;
	}

	public void setRevisionPares(String revisionPares) {
		this.revisionPares = revisionPares;
	}

	public String getAuxFecPub() {
		return auxFecPub;
	}

	public void setAuxFecPub(String auxFecPub) {
		this.auxFecPub = auxFecPub;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	public String getApelAutor() {
		return apelAutor;
	}

	public void setApelAutor(String apelAutor) {
		this.apelAutor = apelAutor;
	}

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getMateriaMD() {
		return materiaMD;
	}

	public void setMateriaMD(String materiaMD) {
		this.materiaMD = materiaMD;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getSucesos() {
		return sucesos;
	}

	public void setSucesos(String sucesos) {
		this.sucesos = sucesos;
	}

	public String getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleSuccess() {
		return styleSuccess;
	}

	public void setStyleSuccess(String styleSuccess) {
		this.styleSuccess = styleSuccess;
	}

	public String getStyleError() {
		return styleError;
	}

	public void setStyleError(String styleError) {
		this.styleError = styleError;
	}

	public String getUrlPublica() {
		return urlPublica;
	}

	public void setUrlPublica(String urlPublica) {
		this.urlPublica = urlPublica;
	}

	public String getValida() {
		return valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public String getValidadgip() {
		return validadgip;
	}

	public void setValidadgip(String validadgip) {
		this.validadgip = validadgip;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}
	
	

}
