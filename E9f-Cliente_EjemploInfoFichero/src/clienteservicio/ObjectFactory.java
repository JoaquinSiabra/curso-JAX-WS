
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

    private final static QName _GetInfoFicheroResponse_QNAME = new QName("http://prueba.inap.minhap.gob.es", "getInfoFicheroResponse");
    private final static QName _GetFicheroConInfoResponse_QNAME = new QName("http://prueba.inap.minhap.gob.es", "getFicheroConInfoResponse");
    private final static QName _GetFicheroConInfo_QNAME = new QName("http://prueba.inap.minhap.gob.es", "getFicheroConInfo");
    private final static QName _FileNotFoundException_QNAME = new QName("http://prueba.inap.minhap.gob.es", "FileNotFoundException");
    private final static QName _GetInfoFichero_QNAME = new QName("http://prueba.inap.minhap.gob.es", "getInfoFichero");
    private final static QName _ErrorServicioWeb_QNAME = new QName("http://prueba.inap.minhap.gob.es", "ErrorServicioWeb");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienteservicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFicheroConInfoResponse }
     * 
     */
    public GetFicheroConInfoResponse createGetFicheroConInfoResponse() {
        return new GetFicheroConInfoResponse();
    }

    /**
     * Create an instance of {@link InfoFichero.Descripciones }
     * 
     */
    public InfoFichero.Descripciones createInfoFicheroDescripciones() {
        return new InfoFichero.Descripciones();
    }

    /**
     * Create an instance of {@link GetInfoFichero }
     * 
     */
    public GetInfoFichero createGetInfoFichero() {
        return new GetInfoFichero();
    }

    /**
     * Create an instance of {@link InfoFichero }
     * 
     */
    public InfoFichero createInfoFichero() {
        return new InfoFichero();
    }

    /**
     * Create an instance of {@link ServicioWebError }
     * 
     */
    public ServicioWebError createServicioWebError() {
        return new ServicioWebError();
    }

    /**
     * Create an instance of {@link GetFicheroConInfo }
     * 
     */
    public GetFicheroConInfo createGetFicheroConInfo() {
        return new GetFicheroConInfo();
    }

    /**
     * Create an instance of {@link GetInfoFicheroResponse }
     * 
     */
    public GetInfoFicheroResponse createGetInfoFicheroResponse() {
        return new GetInfoFicheroResponse();
    }

    /**
     * Create an instance of {@link FileNotFoundException }
     * 
     */
    public FileNotFoundException createFileNotFoundException() {
        return new FileNotFoundException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoFicheroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "getInfoFicheroResponse")
    public JAXBElement<GetInfoFicheroResponse> createGetInfoFicheroResponse(GetInfoFicheroResponse value) {
        return new JAXBElement<GetInfoFicheroResponse>(_GetInfoFicheroResponse_QNAME, GetInfoFicheroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFicheroConInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "getFicheroConInfoResponse")
    public JAXBElement<GetFicheroConInfoResponse> createGetFicheroConInfoResponse(GetFicheroConInfoResponse value) {
        return new JAXBElement<GetFicheroConInfoResponse>(_GetFicheroConInfoResponse_QNAME, GetFicheroConInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFicheroConInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "getFicheroConInfo")
    public JAXBElement<GetFicheroConInfo> createGetFicheroConInfo(GetFicheroConInfo value) {
        return new JAXBElement<GetFicheroConInfo>(_GetFicheroConInfo_QNAME, GetFicheroConInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "FileNotFoundException")
    public JAXBElement<FileNotFoundException> createFileNotFoundException(FileNotFoundException value) {
        return new JAXBElement<FileNotFoundException>(_FileNotFoundException_QNAME, FileNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoFichero }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "getInfoFichero")
    public JAXBElement<GetInfoFichero> createGetInfoFichero(GetInfoFichero value) {
        return new JAXBElement<GetInfoFichero>(_GetInfoFichero_QNAME, GetInfoFichero.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicioWebError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prueba.inap.minhap.gob.es", name = "ErrorServicioWeb")
    public JAXBElement<ServicioWebError> createErrorServicioWeb(ServicioWebError value) {
        return new JAXBElement<ServicioWebError>(_ErrorServicioWeb_QNAME, ServicioWebError.class, null, value);
    }

}
