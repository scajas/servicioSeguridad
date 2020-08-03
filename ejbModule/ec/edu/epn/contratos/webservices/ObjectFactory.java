
package ec.edu.epn.contratos.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.epn.contratos.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ContratosIH_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosIH");
    private final static QName _ContratosOcacional1TCResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosOcacional1TCResponse");
    private final static QName _ComponerIDPedido_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "componerIDPedido");
    private final static QName _ContratosInvitados_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosInvitados");
    private final static QName _EnviarActividades_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "enviarActividades");
    private final static QName _ContratosAyResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosAyResponse");
    private final static QName _ContratosTDPResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosTDPResponse");
    private final static QName _ContratosOcacional1TC_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosOcacional1TC");
    private final static QName _InformeTecnicoServiciosOcasionales_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeTecnicoServiciosOcasionales");
    private final static QName _EnviarCargaResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "enviarCargaResponse");
    private final static QName _ContratosPXResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosPXResponse");
    private final static QName _ContratosOcacional1TPResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosOcacional1TPResponse");
    private final static QName _ContratosInvitadosResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosInvitadosResponse");
    private final static QName _ContratosAy_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosAy");
    private final static QName _InformeOcasionalHonorarioResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeOcasionalHonorarioResponse");
    private final static QName _InformeTecnicoServiciosOcasionalesResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeTecnicoServiciosOcasionalesResponse");
    private final static QName _ContratosPNResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosPNResponse");
    private final static QName _ContratosIHResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosIHResponse");
    private final static QName _InformeOcasionalInvitadoResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeOcasionalInvitadoResponse");
    private final static QName _EnviarCarga_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "enviarCarga");
    private final static QName _ContratosOcacional1TP_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosOcacional1TP");
    private final static QName _ContratosGeneralResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosGeneralResponse");
    private final static QName _InformeOcasionalHonorario_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeOcasionalHonorario");
    private final static QName _ContratosPN_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosPN");
    private final static QName _InformeOcasionalInvitado_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "informeOcasionalInvitado");
    private final static QName _ComponerIDPedidoResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "componerIDPedidoResponse");
    private final static QName _ContratosGeneral_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosGeneral");
    private final static QName _ContratosPX_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosPX");
    private final static QName _EnviarActividadesResponse_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "enviarActividadesResponse");
    private final static QName _ContratosTDP_QNAME = new QName("http://entities.cpa.epn.edu.ec/", "contratosTDP");
    private final static QName _EnviarActividadesResponseReturn_QNAME = new QName("", "return");
    private final static QName _ContratosInvitadosPedido_QNAME = new QName("", "pedido");
    private final static QName _ContratosInvitadosActividades_QNAME = new QName("", "actividades");
    private final static QName _ContratosInvitadosCarga_QNAME = new QName("", "carga");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.epn.contratos.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InformeTecnicoServiciosOcasionalesResponse }
     * 
     */
    public InformeTecnicoServiciosOcasionalesResponse createInformeTecnicoServiciosOcasionalesResponse() {
        return new InformeTecnicoServiciosOcasionalesResponse();
    }

    /**
     * Create an instance of {@link InformeOcasionalHonorarioResponse }
     * 
     */
    public InformeOcasionalHonorarioResponse createInformeOcasionalHonorarioResponse() {
        return new InformeOcasionalHonorarioResponse();
    }

    /**
     * Create an instance of {@link ContratosAy }
     * 
     */
    public ContratosAy createContratosAy() {
        return new ContratosAy();
    }

    /**
     * Create an instance of {@link ContratosInvitadosResponse }
     * 
     */
    public ContratosInvitadosResponse createContratosInvitadosResponse() {
        return new ContratosInvitadosResponse();
    }

    /**
     * Create an instance of {@link ContratosOcacional1TPResponse }
     * 
     */
    public ContratosOcacional1TPResponse createContratosOcacional1TPResponse() {
        return new ContratosOcacional1TPResponse();
    }

    /**
     * Create an instance of {@link ContratosPXResponse }
     * 
     */
    public ContratosPXResponse createContratosPXResponse() {
        return new ContratosPXResponse();
    }

    /**
     * Create an instance of {@link EnviarCargaResponse }
     * 
     */
    public EnviarCargaResponse createEnviarCargaResponse() {
        return new EnviarCargaResponse();
    }

    /**
     * Create an instance of {@link InformeTecnicoServiciosOcasionales }
     * 
     */
    public InformeTecnicoServiciosOcasionales createInformeTecnicoServiciosOcasionales() {
        return new InformeTecnicoServiciosOcasionales();
    }

    /**
     * Create an instance of {@link ContratosOcacional1TC }
     * 
     */
    public ContratosOcacional1TC createContratosOcacional1TC() {
        return new ContratosOcacional1TC();
    }

    /**
     * Create an instance of {@link ContratosTDPResponse }
     * 
     */
    public ContratosTDPResponse createContratosTDPResponse() {
        return new ContratosTDPResponse();
    }

    /**
     * Create an instance of {@link ContratosAyResponse }
     * 
     */
    public ContratosAyResponse createContratosAyResponse() {
        return new ContratosAyResponse();
    }

    /**
     * Create an instance of {@link ContratosInvitados }
     * 
     */
    public ContratosInvitados createContratosInvitados() {
        return new ContratosInvitados();
    }

    /**
     * Create an instance of {@link EnviarActividades }
     * 
     */
    public EnviarActividades createEnviarActividades() {
        return new EnviarActividades();
    }

    /**
     * Create an instance of {@link ComponerIDPedido }
     * 
     */
    public ComponerIDPedido createComponerIDPedido() {
        return new ComponerIDPedido();
    }

    /**
     * Create an instance of {@link ContratosOcacional1TCResponse }
     * 
     */
    public ContratosOcacional1TCResponse createContratosOcacional1TCResponse() {
        return new ContratosOcacional1TCResponse();
    }

    /**
     * Create an instance of {@link ContratosIH }
     * 
     */
    public ContratosIH createContratosIH() {
        return new ContratosIH();
    }

    /**
     * Create an instance of {@link ContratosTDP }
     * 
     */
    public ContratosTDP createContratosTDP() {
        return new ContratosTDP();
    }

    /**
     * Create an instance of {@link EnviarActividadesResponse }
     * 
     */
    public EnviarActividadesResponse createEnviarActividadesResponse() {
        return new EnviarActividadesResponse();
    }

    /**
     * Create an instance of {@link ContratosPX }
     * 
     */
    public ContratosPX createContratosPX() {
        return new ContratosPX();
    }

    /**
     * Create an instance of {@link ContratosGeneral }
     * 
     */
    public ContratosGeneral createContratosGeneral() {
        return new ContratosGeneral();
    }

    /**
     * Create an instance of {@link ComponerIDPedidoResponse }
     * 
     */
    public ComponerIDPedidoResponse createComponerIDPedidoResponse() {
        return new ComponerIDPedidoResponse();
    }

    /**
     * Create an instance of {@link InformeOcasionalInvitado }
     * 
     */
    public InformeOcasionalInvitado createInformeOcasionalInvitado() {
        return new InformeOcasionalInvitado();
    }

    /**
     * Create an instance of {@link ContratosPN }
     * 
     */
    public ContratosPN createContratosPN() {
        return new ContratosPN();
    }

    /**
     * Create an instance of {@link InformeOcasionalHonorario }
     * 
     */
    public InformeOcasionalHonorario createInformeOcasionalHonorario() {
        return new InformeOcasionalHonorario();
    }

    /**
     * Create an instance of {@link ContratosGeneralResponse }
     * 
     */
    public ContratosGeneralResponse createContratosGeneralResponse() {
        return new ContratosGeneralResponse();
    }

    /**
     * Create an instance of {@link EnviarCarga }
     * 
     */
    public EnviarCarga createEnviarCarga() {
        return new EnviarCarga();
    }

    /**
     * Create an instance of {@link ContratosOcacional1TP }
     * 
     */
    public ContratosOcacional1TP createContratosOcacional1TP() {
        return new ContratosOcacional1TP();
    }

    /**
     * Create an instance of {@link ContratosPNResponse }
     * 
     */
    public ContratosPNResponse createContratosPNResponse() {
        return new ContratosPNResponse();
    }

    /**
     * Create an instance of {@link InformeOcasionalInvitadoResponse }
     * 
     */
    public InformeOcasionalInvitadoResponse createInformeOcasionalInvitadoResponse() {
        return new InformeOcasionalInvitadoResponse();
    }

    /**
     * Create an instance of {@link ContratosIHResponse }
     * 
     */
    public ContratosIHResponse createContratosIHResponse() {
        return new ContratosIHResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosIH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosIH")
    public JAXBElement<ContratosIH> createContratosIH(ContratosIH value) {
        return new JAXBElement<ContratosIH>(_ContratosIH_QNAME, ContratosIH.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosOcacional1TCResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosOcacional1TCResponse")
    public JAXBElement<ContratosOcacional1TCResponse> createContratosOcacional1TCResponse(ContratosOcacional1TCResponse value) {
        return new JAXBElement<ContratosOcacional1TCResponse>(_ContratosOcacional1TCResponse_QNAME, ContratosOcacional1TCResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponerIDPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "componerIDPedido")
    public JAXBElement<ComponerIDPedido> createComponerIDPedido(ComponerIDPedido value) {
        return new JAXBElement<ComponerIDPedido>(_ComponerIDPedido_QNAME, ComponerIDPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosInvitados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosInvitados")
    public JAXBElement<ContratosInvitados> createContratosInvitados(ContratosInvitados value) {
        return new JAXBElement<ContratosInvitados>(_ContratosInvitados_QNAME, ContratosInvitados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarActividades }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "enviarActividades")
    public JAXBElement<EnviarActividades> createEnviarActividades(EnviarActividades value) {
        return new JAXBElement<EnviarActividades>(_EnviarActividades_QNAME, EnviarActividades.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosAyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosAyResponse")
    public JAXBElement<ContratosAyResponse> createContratosAyResponse(ContratosAyResponse value) {
        return new JAXBElement<ContratosAyResponse>(_ContratosAyResponse_QNAME, ContratosAyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosTDPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosTDPResponse")
    public JAXBElement<ContratosTDPResponse> createContratosTDPResponse(ContratosTDPResponse value) {
        return new JAXBElement<ContratosTDPResponse>(_ContratosTDPResponse_QNAME, ContratosTDPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosOcacional1TC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosOcacional1TC")
    public JAXBElement<ContratosOcacional1TC> createContratosOcacional1TC(ContratosOcacional1TC value) {
        return new JAXBElement<ContratosOcacional1TC>(_ContratosOcacional1TC_QNAME, ContratosOcacional1TC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeTecnicoServiciosOcasionales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeTecnicoServiciosOcasionales")
    public JAXBElement<InformeTecnicoServiciosOcasionales> createInformeTecnicoServiciosOcasionales(InformeTecnicoServiciosOcasionales value) {
        return new JAXBElement<InformeTecnicoServiciosOcasionales>(_InformeTecnicoServiciosOcasionales_QNAME, InformeTecnicoServiciosOcasionales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarCargaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "enviarCargaResponse")
    public JAXBElement<EnviarCargaResponse> createEnviarCargaResponse(EnviarCargaResponse value) {
        return new JAXBElement<EnviarCargaResponse>(_EnviarCargaResponse_QNAME, EnviarCargaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosPXResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosPXResponse")
    public JAXBElement<ContratosPXResponse> createContratosPXResponse(ContratosPXResponse value) {
        return new JAXBElement<ContratosPXResponse>(_ContratosPXResponse_QNAME, ContratosPXResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosOcacional1TPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosOcacional1TPResponse")
    public JAXBElement<ContratosOcacional1TPResponse> createContratosOcacional1TPResponse(ContratosOcacional1TPResponse value) {
        return new JAXBElement<ContratosOcacional1TPResponse>(_ContratosOcacional1TPResponse_QNAME, ContratosOcacional1TPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosInvitadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosInvitadosResponse")
    public JAXBElement<ContratosInvitadosResponse> createContratosInvitadosResponse(ContratosInvitadosResponse value) {
        return new JAXBElement<ContratosInvitadosResponse>(_ContratosInvitadosResponse_QNAME, ContratosInvitadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosAy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosAy")
    public JAXBElement<ContratosAy> createContratosAy(ContratosAy value) {
        return new JAXBElement<ContratosAy>(_ContratosAy_QNAME, ContratosAy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeOcasionalHonorarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeOcasionalHonorarioResponse")
    public JAXBElement<InformeOcasionalHonorarioResponse> createInformeOcasionalHonorarioResponse(InformeOcasionalHonorarioResponse value) {
        return new JAXBElement<InformeOcasionalHonorarioResponse>(_InformeOcasionalHonorarioResponse_QNAME, InformeOcasionalHonorarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeTecnicoServiciosOcasionalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeTecnicoServiciosOcasionalesResponse")
    public JAXBElement<InformeTecnicoServiciosOcasionalesResponse> createInformeTecnicoServiciosOcasionalesResponse(InformeTecnicoServiciosOcasionalesResponse value) {
        return new JAXBElement<InformeTecnicoServiciosOcasionalesResponse>(_InformeTecnicoServiciosOcasionalesResponse_QNAME, InformeTecnicoServiciosOcasionalesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosPNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosPNResponse")
    public JAXBElement<ContratosPNResponse> createContratosPNResponse(ContratosPNResponse value) {
        return new JAXBElement<ContratosPNResponse>(_ContratosPNResponse_QNAME, ContratosPNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosIHResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosIHResponse")
    public JAXBElement<ContratosIHResponse> createContratosIHResponse(ContratosIHResponse value) {
        return new JAXBElement<ContratosIHResponse>(_ContratosIHResponse_QNAME, ContratosIHResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeOcasionalInvitadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeOcasionalInvitadoResponse")
    public JAXBElement<InformeOcasionalInvitadoResponse> createInformeOcasionalInvitadoResponse(InformeOcasionalInvitadoResponse value) {
        return new JAXBElement<InformeOcasionalInvitadoResponse>(_InformeOcasionalInvitadoResponse_QNAME, InformeOcasionalInvitadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarCarga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "enviarCarga")
    public JAXBElement<EnviarCarga> createEnviarCarga(EnviarCarga value) {
        return new JAXBElement<EnviarCarga>(_EnviarCarga_QNAME, EnviarCarga.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosOcacional1TP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosOcacional1TP")
    public JAXBElement<ContratosOcacional1TP> createContratosOcacional1TP(ContratosOcacional1TP value) {
        return new JAXBElement<ContratosOcacional1TP>(_ContratosOcacional1TP_QNAME, ContratosOcacional1TP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosGeneralResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosGeneralResponse")
    public JAXBElement<ContratosGeneralResponse> createContratosGeneralResponse(ContratosGeneralResponse value) {
        return new JAXBElement<ContratosGeneralResponse>(_ContratosGeneralResponse_QNAME, ContratosGeneralResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeOcasionalHonorario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeOcasionalHonorario")
    public JAXBElement<InformeOcasionalHonorario> createInformeOcasionalHonorario(InformeOcasionalHonorario value) {
        return new JAXBElement<InformeOcasionalHonorario>(_InformeOcasionalHonorario_QNAME, InformeOcasionalHonorario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosPN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosPN")
    public JAXBElement<ContratosPN> createContratosPN(ContratosPN value) {
        return new JAXBElement<ContratosPN>(_ContratosPN_QNAME, ContratosPN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformeOcasionalInvitado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "informeOcasionalInvitado")
    public JAXBElement<InformeOcasionalInvitado> createInformeOcasionalInvitado(InformeOcasionalInvitado value) {
        return new JAXBElement<InformeOcasionalInvitado>(_InformeOcasionalInvitado_QNAME, InformeOcasionalInvitado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponerIDPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "componerIDPedidoResponse")
    public JAXBElement<ComponerIDPedidoResponse> createComponerIDPedidoResponse(ComponerIDPedidoResponse value) {
        return new JAXBElement<ComponerIDPedidoResponse>(_ComponerIDPedidoResponse_QNAME, ComponerIDPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosGeneral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosGeneral")
    public JAXBElement<ContratosGeneral> createContratosGeneral(ContratosGeneral value) {
        return new JAXBElement<ContratosGeneral>(_ContratosGeneral_QNAME, ContratosGeneral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosPX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosPX")
    public JAXBElement<ContratosPX> createContratosPX(ContratosPX value) {
        return new JAXBElement<ContratosPX>(_ContratosPX_QNAME, ContratosPX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarActividadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "enviarActividadesResponse")
    public JAXBElement<EnviarActividadesResponse> createEnviarActividadesResponse(EnviarActividadesResponse value) {
        return new JAXBElement<EnviarActividadesResponse>(_EnviarActividadesResponse_QNAME, EnviarActividadesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContratosTDP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.cpa.epn.edu.ec/", name = "contratosTDP")
    public JAXBElement<ContratosTDP> createContratosTDP(ContratosTDP value) {
        return new JAXBElement<ContratosTDP>(_ContratosTDP_QNAME, ContratosTDP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = EnviarActividadesResponse.class)
    public JAXBElement<byte[]> createEnviarActividadesResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, EnviarActividadesResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosInvitados.class)
    public JAXBElement<byte[]> createContratosInvitadosPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosInvitados.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosInvitados.class)
    public JAXBElement<byte[]> createContratosInvitadosActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosInvitados.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosInvitados.class)
    public JAXBElement<byte[]> createContratosInvitadosCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosInvitados.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosGeneralResponse.class)
    public JAXBElement<byte[]> createContratosGeneralResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosGeneralResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosAy.class)
    public JAXBElement<byte[]> createContratosAyPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosAy.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosOcacional1TC.class)
    public JAXBElement<byte[]> createContratosOcacional1TCPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosOcacional1TC.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosOcacional1TC.class)
    public JAXBElement<byte[]> createContratosOcacional1TCActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosOcacional1TC.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosOcacional1TC.class)
    public JAXBElement<byte[]> createContratosOcacional1TCCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosOcacional1TC.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = InformeOcasionalInvitadoResponse.class)
    public JAXBElement<byte[]> createInformeOcasionalInvitadoResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, InformeOcasionalInvitadoResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosTDP.class)
    public JAXBElement<byte[]> createContratosTDPPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosTDP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosTDP.class)
    public JAXBElement<byte[]> createContratosTDPActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosTDP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosTDP.class)
    public JAXBElement<byte[]> createContratosTDPCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosTDP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosOcacional1TPResponse.class)
    public JAXBElement<byte[]> createContratosOcacional1TPResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosOcacional1TPResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosPN.class)
    public JAXBElement<byte[]> createContratosPNPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosPN.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosPN.class)
    public JAXBElement<byte[]> createContratosPNActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosPN.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosPN.class)
    public JAXBElement<byte[]> createContratosPNCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosPN.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosPX.class)
    public JAXBElement<byte[]> createContratosPXPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosPX.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosPX.class)
    public JAXBElement<byte[]> createContratosPXActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosPX.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosPX.class)
    public JAXBElement<byte[]> createContratosPXCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosPX.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = InformeOcasionalHonorario.class)
    public JAXBElement<byte[]> createInformeOcasionalHonorarioPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, InformeOcasionalHonorario.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = InformeOcasionalHonorario.class)
    public JAXBElement<byte[]> createInformeOcasionalHonorarioActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, InformeOcasionalHonorario.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = InformeOcasionalHonorario.class)
    public JAXBElement<byte[]> createInformeOcasionalHonorarioCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, InformeOcasionalHonorario.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosIHResponse.class)
    public JAXBElement<byte[]> createContratosIHResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosIHResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosPXResponse.class)
    public JAXBElement<byte[]> createContratosPXResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosPXResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = EnviarCargaResponse.class)
    public JAXBElement<byte[]> createEnviarCargaResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, EnviarCargaResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = EnviarCarga.class)
    public JAXBElement<byte[]> createEnviarCargaCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, EnviarCarga.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = InformeTecnicoServiciosOcasionalesResponse.class)
    public JAXBElement<byte[]> createInformeTecnicoServiciosOcasionalesResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, InformeTecnicoServiciosOcasionalesResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosInvitadosResponse.class)
    public JAXBElement<byte[]> createContratosInvitadosResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosInvitadosResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosTDPResponse.class)
    public JAXBElement<byte[]> createContratosTDPResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosTDPResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = InformeOcasionalHonorarioResponse.class)
    public JAXBElement<byte[]> createInformeOcasionalHonorarioResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, InformeOcasionalHonorarioResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosIH.class)
    public JAXBElement<byte[]> createContratosIHPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosIH.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosIH.class)
    public JAXBElement<byte[]> createContratosIHActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosIH.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosIH.class)
    public JAXBElement<byte[]> createContratosIHCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosIH.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = InformeOcasionalInvitado.class)
    public JAXBElement<byte[]> createInformeOcasionalInvitadoPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, InformeOcasionalInvitado.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = InformeOcasionalInvitado.class)
    public JAXBElement<byte[]> createInformeOcasionalInvitadoActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, InformeOcasionalInvitado.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = InformeOcasionalInvitado.class)
    public JAXBElement<byte[]> createInformeOcasionalInvitadoCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, InformeOcasionalInvitado.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosOcacional1TCResponse.class)
    public JAXBElement<byte[]> createContratosOcacional1TCResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosOcacional1TCResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosPNResponse.class)
    public JAXBElement<byte[]> createContratosPNResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosPNResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ContratosAyResponse.class)
    public JAXBElement<byte[]> createContratosAyResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarActividadesResponseReturn_QNAME, byte[].class, ContratosAyResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = EnviarActividades.class)
    public JAXBElement<byte[]> createEnviarActividadesCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, EnviarActividades.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosOcacional1TP.class)
    public JAXBElement<byte[]> createContratosOcacional1TPPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosOcacional1TP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosOcacional1TP.class)
    public JAXBElement<byte[]> createContratosOcacional1TPActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosOcacional1TP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosOcacional1TP.class)
    public JAXBElement<byte[]> createContratosOcacional1TPCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosOcacional1TP.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = InformeTecnicoServiciosOcasionales.class)
    public JAXBElement<byte[]> createInformeTecnicoServiciosOcasionalesPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, InformeTecnicoServiciosOcasionales.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = InformeTecnicoServiciosOcasionales.class)
    public JAXBElement<byte[]> createInformeTecnicoServiciosOcasionalesActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, InformeTecnicoServiciosOcasionales.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = InformeTecnicoServiciosOcasionales.class)
    public JAXBElement<byte[]> createInformeTecnicoServiciosOcasionalesCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, InformeTecnicoServiciosOcasionales.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido", scope = ContratosGeneral.class)
    public JAXBElement<byte[]> createContratosGeneralPedido(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosPedido_QNAME, byte[].class, ContratosGeneral.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "actividades", scope = ContratosGeneral.class)
    public JAXBElement<byte[]> createContratosGeneralActividades(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosActividades_QNAME, byte[].class, ContratosGeneral.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carga", scope = ContratosGeneral.class)
    public JAXBElement<byte[]> createContratosGeneralCarga(byte[] value) {
        return new JAXBElement<byte[]>(_ContratosInvitadosCarga_QNAME, byte[].class, ContratosGeneral.class, ((byte[]) value));
    }

}
