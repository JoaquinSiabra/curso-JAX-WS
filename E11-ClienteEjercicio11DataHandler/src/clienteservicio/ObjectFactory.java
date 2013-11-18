
package clienteservicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clienteservicio package. 
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

    private final static QName _TransformaXMLtoHTML_QNAME = new QName("http://prueba.inap.minhap.gob.es", "transformaXMLtoHTML");
    private final static QName _TransformaXMLtoHTMLResponse_QNAME = new QName("http://prueba.inap.minhap.gob.es", "transformaXMLtoHTMLResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienteservicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransformaXMLtoHTMLResponse }
     * 
     */
    public TransformaXMLtoHTMLResponse createTransformaXMLtoHTMLResponse() {
        return new TransformaXMLtoHTMLResponse();
    }

    /**
     * Create an instance of {@link TransformaXMLtoHTML }
     * 
     */
    public TransformaXMLtoHTML createTransformaXMLtoHTML() {
        return new TransformaXMLtoHTML();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformaXMLtoHTML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "transformaXMLtoHTML")
    public JAXBElement<TransformaXMLtoHTML> createTransformaXMLtoHTML(TransformaXMLtoHTML value) {
        return new JAXBElement<TransformaXMLtoHTML>(_TransformaXMLtoHTML_QNAME, TransformaXMLtoHTML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformaXMLtoHTMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "transformaXMLtoHTMLResponse")
    public JAXBElement<TransformaXMLtoHTMLResponse> createTransformaXMLtoHTMLResponse(TransformaXMLtoHTMLResponse value) {
        return new JAXBElement<TransformaXMLtoHTMLResponse>(_TransformaXMLtoHTMLResponse_QNAME, TransformaXMLtoHTMLResponse.class, null, value);
    }

}
