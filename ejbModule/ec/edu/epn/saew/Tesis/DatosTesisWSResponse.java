
package ec.edu.epn.saew.Tesis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosTesisWSResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datosTesisWSResult"
})
@XmlRootElement(name = "DatosTesisWSResponse")
public class DatosTesisWSResponse {

    @XmlElement(name = "DatosTesisWSResult")
    protected String datosTesisWSResult;

    /**
     * Obtiene el valor de la propiedad datosTesisWSResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosTesisWSResult() {
        return datosTesisWSResult;
    }

    /**
     * Define el valor de la propiedad datosTesisWSResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosTesisWSResult(String value) {
        this.datosTesisWSResult = value;
    }

}
