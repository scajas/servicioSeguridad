
package ec.edu.epn.contratos.DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tituloRegistradoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tituloRegistradoDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="escalafonDocente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaGrado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iesExtranjeraColegioProfesional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listadoPertenece" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreClasificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreDetalleCampo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreTitulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reconocidoPor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subarea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subareaCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoExtranjeroColegio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoNivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoTitulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tituloRegistradoDTO", propOrder = {
    "area",
    "areaCodigo",
    "codigo",
    "escalafonDocente",
    "estado",
    "fechaGrado",
    "fechaRegistro",
    "ies",
    "iesExtranjeraColegioProfesional",
    "listadoPertenece",
    "nacionalidad",
    "nivel",
    "nombreClasificacion",
    "nombreDetalleCampo",
    "nombreTitulo",
    "nombres",
    "numeroIdentificacion",
    "numeroRegistro",
    "observacion",
    "reconocidoPor",
    "sexo",
    "subarea",
    "subareaCodigo",
    "tipoExtranjeroColegio",
    "tipoNivel",
    "tipoTitulo"
})
public class TituloRegistradoDTO {

    protected String area;
    protected String areaCodigo;
    protected String codigo;
    protected String escalafonDocente;
    protected String estado;
    protected String fechaGrado;
    protected String fechaRegistro;
    protected String ies;
    protected String iesExtranjeraColegioProfesional;
    protected String listadoPertenece;
    protected String nacionalidad;
    protected String nivel;
    protected String nombreClasificacion;
    protected String nombreDetalleCampo;
    protected String nombreTitulo;
    protected String nombres;
    protected String numeroIdentificacion;
    protected String numeroRegistro;
    protected String observacion;
    protected String reconocidoPor;
    protected String sexo;
    protected String subarea;
    protected String subareaCodigo;
    protected String tipoExtranjeroColegio;
    protected String tipoNivel;
    protected String tipoTitulo;

    /**
     * Obtiene el valor de la propiedad area.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArea() {
        return area;
    }

    /**
     * Define el valor de la propiedad area.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArea(String value) {
        this.area = value;
    }

    /**
     * Obtiene el valor de la propiedad areaCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCodigo() {
        return areaCodigo;
    }

    /**
     * Define el valor de la propiedad areaCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCodigo(String value) {
        this.areaCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad escalafonDocente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscalafonDocente() {
        return escalafonDocente;
    }

    /**
     * Define el valor de la propiedad escalafonDocente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscalafonDocente(String value) {
        this.escalafonDocente = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaGrado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaGrado() {
        return fechaGrado;
    }

    /**
     * Define el valor de la propiedad fechaGrado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaGrado(String value) {
        this.fechaGrado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Define el valor de la propiedad fechaRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRegistro(String value) {
        this.fechaRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad ies.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIes() {
        return ies;
    }

    /**
     * Define el valor de la propiedad ies.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIes(String value) {
        this.ies = value;
    }

    /**
     * Obtiene el valor de la propiedad iesExtranjeraColegioProfesional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIesExtranjeraColegioProfesional() {
        return iesExtranjeraColegioProfesional;
    }

    /**
     * Define el valor de la propiedad iesExtranjeraColegioProfesional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIesExtranjeraColegioProfesional(String value) {
        this.iesExtranjeraColegioProfesional = value;
    }

    /**
     * Obtiene el valor de la propiedad listadoPertenece.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListadoPertenece() {
        return listadoPertenece;
    }

    /**
     * Define el valor de la propiedad listadoPertenece.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListadoPertenece(String value) {
        this.listadoPertenece = value;
    }

    /**
     * Obtiene el valor de la propiedad nacionalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Define el valor de la propiedad nacionalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Define el valor de la propiedad nivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivel(String value) {
        this.nivel = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreClasificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreClasificacion() {
        return nombreClasificacion;
    }

    /**
     * Define el valor de la propiedad nombreClasificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreClasificacion(String value) {
        this.nombreClasificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDetalleCampo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDetalleCampo() {
        return nombreDetalleCampo;
    }

    /**
     * Define el valor de la propiedad nombreDetalleCampo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDetalleCampo(String value) {
        this.nombreDetalleCampo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTitulo() {
        return nombreTitulo;
    }

    /**
     * Define el valor de la propiedad nombreTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTitulo(String value) {
        this.nombreTitulo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Define el valor de la propiedad numeroIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    /**
     * Define el valor de la propiedad numeroRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRegistro(String value) {
        this.numeroRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad observacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Define el valor de la propiedad observacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

    /**
     * Obtiene el valor de la propiedad reconocidoPor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReconocidoPor() {
        return reconocidoPor;
    }

    /**
     * Define el valor de la propiedad reconocidoPor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReconocidoPor(String value) {
        this.reconocidoPor = value;
    }

    /**
     * Obtiene el valor de la propiedad sexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Define el valor de la propiedad sexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Obtiene el valor de la propiedad subarea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubarea() {
        return subarea;
    }

    /**
     * Define el valor de la propiedad subarea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubarea(String value) {
        this.subarea = value;
    }

    /**
     * Obtiene el valor de la propiedad subareaCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubareaCodigo() {
        return subareaCodigo;
    }

    /**
     * Define el valor de la propiedad subareaCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubareaCodigo(String value) {
        this.subareaCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoExtranjeroColegio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoExtranjeroColegio() {
        return tipoExtranjeroColegio;
    }

    /**
     * Define el valor de la propiedad tipoExtranjeroColegio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoExtranjeroColegio(String value) {
        this.tipoExtranjeroColegio = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoNivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoNivel() {
        return tipoNivel;
    }

    /**
     * Define el valor de la propiedad tipoNivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoNivel(String value) {
        this.tipoNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTitulo() {
        return tipoTitulo;
    }

    /**
     * Define el valor de la propiedad tipoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTitulo(String value) {
        this.tipoTitulo = value;
    }

}
