
package clienteserviciominusculas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clienteserviciominusculas package. 
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

    private final static QName _ServicioMinusculasException_QNAME = new QName("http://serviciominusculas/", "ServicioMinusculasException");
    private final static QName _GetMinusculas_QNAME = new QName("http://serviciominusculas/", "getMinusculas");
    private final static QName _GetMinusculasResponse_QNAME = new QName("http://serviciominusculas/", "getMinusculasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienteserviciominusculas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMinusculas }
     * 
     */
    public GetMinusculas createGetMinusculas() {
        return new GetMinusculas();
    }

    /**
     * Create an instance of {@link GetMinusculasResponse }
     * 
     */
    public GetMinusculasResponse createGetMinusculasResponse() {
        return new GetMinusculasResponse();
    }

    /**
     * Create an instance of {@link ServicioMinusculasException }
     * 
     */
    public ServicioMinusculasException createServicioMinusculasException() {
        return new ServicioMinusculasException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicioMinusculasException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciominusculas/", name = "ServicioMinusculasException")
    public JAXBElement<ServicioMinusculasException> createServicioMinusculasException(ServicioMinusculasException value) {
        return new JAXBElement<ServicioMinusculasException>(_ServicioMinusculasException_QNAME, ServicioMinusculasException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMinusculas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciominusculas/", name = "getMinusculas")
    public JAXBElement<GetMinusculas> createGetMinusculas(GetMinusculas value) {
        return new JAXBElement<GetMinusculas>(_GetMinusculas_QNAME, GetMinusculas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMinusculasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciominusculas/", name = "getMinusculasResponse")
    public JAXBElement<GetMinusculasResponse> createGetMinusculasResponse(GetMinusculasResponse value) {
        return new JAXBElement<GetMinusculasResponse>(_GetMinusculasResponse_QNAME, GetMinusculasResponse.class, null, value);
    }

}
