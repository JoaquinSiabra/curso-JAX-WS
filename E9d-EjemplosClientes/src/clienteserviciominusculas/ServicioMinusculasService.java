
package clienteserviciominusculas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ServicioMinusculasService", targetNamespace = "http://serviciominusculas/", wsdlLocation = "http://localhost:7001/EjemploServicioMinusculas/ServicioMinusculasService?wsdl")
public class ServicioMinusculasService
    extends Service
{

    private final static URL SERVICIOMINUSCULASSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(clienteserviciominusculas.ServicioMinusculasService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = clienteserviciominusculas.ServicioMinusculasService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:7001/EjemploServicioMinusculas/ServicioMinusculasService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:7001/EjemploServicioMinusculas/ServicioMinusculasService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICIOMINUSCULASSERVICE_WSDL_LOCATION = url;
    }

    public ServicioMinusculasService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioMinusculasService() {
        super(SERVICIOMINUSCULASSERVICE_WSDL_LOCATION, new QName("http://serviciominusculas/", "ServicioMinusculasService"));
    }

    /**
     * 
     * @return
     *     returns ServicioMinusculas
     */
    @WebEndpoint(name = "ServicioMinusculasPort")
    public ServicioMinusculas getServicioMinusculasPort() {
        return super.getPort(new QName("http://serviciominusculas/", "ServicioMinusculasPort"), ServicioMinusculas.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioMinusculas
     */
    @WebEndpoint(name = "ServicioMinusculasPort")
    public ServicioMinusculas getServicioMinusculasPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviciominusculas/", "ServicioMinusculasPort"), ServicioMinusculas.class, features);
    }

}
