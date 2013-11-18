
package clienteserviciohora;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clienteserviciohora package. 
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

    private final static QName _ServicioHoraException_QNAME = new QName("http://serviciohora/", "ServicioHoraException");
    private final static QName _GetHora_QNAME = new QName("http://serviciohora/", "getHora");
    private final static QName _GetHoraResponse_QNAME = new QName("http://serviciohora/", "getHoraResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienteserviciohora
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHoraResponse }
     * 
     */
    public GetHoraResponse createGetHoraResponse() {
        return new GetHoraResponse();
    }

    /**
     * Create an instance of {@link ServicioHoraException }
     * 
     */
    public ServicioHoraException createServicioHoraException() {
        return new ServicioHoraException();
    }

    /**
     * Create an instance of {@link GetHora }
     * 
     */
    public GetHora createGetHora() {
        return new GetHora();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicioHoraException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciohora/", name = "ServicioHoraException")
    public JAXBElement<ServicioHoraException> createServicioHoraException(ServicioHoraException value) {
        return new JAXBElement<ServicioHoraException>(_ServicioHoraException_QNAME, ServicioHoraException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHora }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciohora/", name = "getHora")
    public JAXBElement<GetHora> createGetHora(GetHora value) {
        return new JAXBElement<GetHora>(_GetHora_QNAME, GetHora.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHoraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciohora/", name = "getHoraResponse")
    public JAXBElement<GetHoraResponse> createGetHoraResponse(GetHoraResponse value) {
        return new JAXBElement<GetHoraResponse>(_GetHoraResponse_QNAME, GetHoraResponse.class, null, value);
    }

}
