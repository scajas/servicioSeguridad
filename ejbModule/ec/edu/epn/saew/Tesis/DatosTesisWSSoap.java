package ec.edu.epn.saew.Tesis;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-06-21T08:10:11.550-05:00
 * Generated source version: 2.7.14.redhat-1
 * 
 */
@WebService(targetNamespace = "https://saew.epn.edu.ec/saewstesis/", name = "DatosTesisWSSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface DatosTesisWSSoap {

    @WebResult(name = "DatosTesisWSResult", targetNamespace = "https://saew.epn.edu.ec/saewstesis/")
    @RequestWrapper(localName = "DatosTesisWS", targetNamespace = "https://saew.epn.edu.ec/saewstesis/", className = "ec.edu.epn.saew.Tesis.DatosTesisWS")
    @WebMethod(operationName = "DatosTesisWS", action = "https://saew.epn.edu.ec/saewstesis/DatosTesisWS")
    @ResponseWrapper(localName = "DatosTesisWSResponse", targetNamespace = "https://saew.epn.edu.ec/saewstesis/", className = "ec.edu.epn.saew.Tesis.DatosTesisWSResponse")
    public java.lang.String datosTesisWS(
        @WebParam(name = "codprf", targetNamespace = "https://saew.epn.edu.ec/saewstesis/")
        java.lang.String codprf
    );
}
