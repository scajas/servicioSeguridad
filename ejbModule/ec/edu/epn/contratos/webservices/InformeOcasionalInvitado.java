
package ec.edu.epn.contratos.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para informeOcasionalInvitado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="informeOcasionalInvitado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pedido" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="actividades" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="carga" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "informeOcasionalInvitado", propOrder = {
    "pedido",
    "actividades",
    "carga"
})
public class InformeOcasionalInvitado {

    @XmlElementRef(name = "pedido", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> pedido;
    @XmlElementRef(name = "actividades", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> actividades;
    @XmlElementRef(name = "carga", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> carga;

    /**
     * Obtiene el valor de la propiedad pedido.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getPedido() {
        return pedido;
    }

    /**
     * Define el valor de la propiedad pedido.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setPedido(JAXBElement<byte[]> value) {
        this.pedido = value;
    }

    /**
     * Obtiene el valor de la propiedad actividades.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getActividades() {
        return actividades;
    }

    /**
     * Define el valor de la propiedad actividades.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setActividades(JAXBElement<byte[]> value) {
        this.actividades = value;
    }

    /**
     * Obtiene el valor de la propiedad carga.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getCarga() {
        return carga;
    }

    /**
     * Define el valor de la propiedad carga.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setCarga(JAXBElement<byte[]> value) {
        this.carga = value;
    }

}
