
package clienteserviciohoraasync;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ImplementacionServicioHora", targetNamespace = "http://serviciohora/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ImplementacionServicioHora {


    /**
     * 
     * @return
     *     returns javax.xml.ws.Response<clienteserviciohoraasync.GetHoraResponse>
     */
    @WebMethod(operationName = "getHora")
    @RequestWrapper(localName = "getHora", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHora")
    @ResponseWrapper(localName = "getHoraResponse", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHoraResponse")
    public Response<GetHoraResponse> getHoraAsync();

    /**
     * 
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "getHora")
    @RequestWrapper(localName = "getHora", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHora")
    @ResponseWrapper(localName = "getHoraResponse", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHoraResponse")
    public Future<?> getHoraAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetHoraResponse> asyncHandler);

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws ServicioHoraException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHora", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHora")
    @ResponseWrapper(localName = "getHoraResponse", targetNamespace = "http://serviciohora/", className = "clienteserviciohoraasync.GetHoraResponse")
    public String getHora()
        throws ServicioHoraException_Exception
    ;

}