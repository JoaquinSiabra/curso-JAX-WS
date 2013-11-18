package servicio;


import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlAttachmentRef;

/**
 * El frontal del servicio 
 */
@WebService(serviceName = "wsTransformacion",
            name = "Transformacion",
            portName="TransformacionPort", 
            targetNamespace = "http://prueba.inap.minhap.gob.es"
//            , wsdlLocation = "wsdl/xxx.wsdl"
           )

//@SchemaValidation desde JAX-WS 2.1.3
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, 
             use = SOAPBinding.Use.LITERAL,
             parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class FrontalServicio {

  @WebMethod(operationName = "transformaXMLtoHTML")
  @WebResult(name = "HTML")
  @XmlAttachmentRef
  public DataHandler getFicheroTransformado(
                        @WebParam(name = "FicheroXML")
                        @XmlAttachmentRef
                        DataHandler oFicheroXML,
                        @WebParam(name = "FicheroXSL")
                        @XmlAttachmentRef
                        DataHandler oFicheroXSL
                      ) {
    
    return Transformacion.transforma(oFicheroXML,oFicheroXSL);
  }
 

}
