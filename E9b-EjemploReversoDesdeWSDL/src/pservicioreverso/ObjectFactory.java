
package pservicioreverso;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pservicioreverso package. 
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

    private final static QName _GetReverso_QNAME = new QName("http://pservicioreverso/", "getReverso");
    private final static QName _GetReversoResponse_QNAME = new QName("http://pservicioreverso/", "getReversoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pservicioreverso
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetReversoResponse }
     * 
     */
    public GetReversoResponse createGetReversoResponse() {
        return new GetReversoResponse();
    }

    /**
     * Create an instance of {@link GetReverso }
     * 
     */
    public GetReverso createGetReverso() {
        return new GetReverso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReverso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pservicioreverso/", name = "getReverso")
    public JAXBElement<GetReverso> createGetReverso(GetReverso value) {
        return new JAXBElement<GetReverso>(_GetReverso_QNAME, GetReverso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReversoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pservicioreverso/", name = "getReversoResponse")
    public JAXBElement<GetReversoResponse> createGetReversoResponse(GetReversoResponse value) {
        return new JAXBElement<GetReversoResponse>(_GetReversoResponse_QNAME, GetReversoResponse.class, null, value);
    }

}
