
package ec.edu.epn.contratos.webservices.saew;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfContrato complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfContrato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Contrato" type="{https://saew.epn.edu.ec/saewscont/}Contrato" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfContrato", propOrder = {
    "contrato"
})
@XmlRootElement(name = "ArrayOfContrato")
public class ArrayOfContrato {

    @XmlElement(name = "Contrato", nillable = true)
    protected List<Contrato> contrato;

    /**
     * Gets the value of the contrato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contrato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContrato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contrato }
     * 
     * 
     */
    public List<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new ArrayList<Contrato>();
        }
        return this.contrato;
    }

}