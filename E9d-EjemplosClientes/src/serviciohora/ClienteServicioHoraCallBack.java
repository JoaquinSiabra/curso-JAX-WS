/*
 * ClienteServicioHoraXML.java
 */

package serviciohora;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.Future;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.ws.*;
import org.w3c.dom.*;

public class ClienteServicioHoraCallBack {
    
    private static final String STR_URL="http://localhost:7001/EjemploServicioHoraFromJava/ImplementacionServicioHoraService?WSDL";
    private static final String STR_NAMESPACE="http://serviciohora/";
    private static final String STR_SERVICENAME="ImplementacionServicioHoraService";
    private static final String STR_PORTNAME="ImplementacionServicioHoraPort";
    public static void main(String[] args){
        new ClienteServicioHoraCallBack().doTest();
    }
    public void doTest(){
        try{
            URL oWsdlURL = new URL(STR_URL);
            QName oServiceQName =new QName(STR_NAMESPACE, STR_SERVICENAME);
            Service oService = Service.create(oWsdlURL, oServiceQName);
            QName portQName = new QName(STR_NAMESPACE, STR_PORTNAME);
            Dispatch<Source> oDispatch = oService.createDispatch(portQName,Source.class, Service.Mode.PAYLOAD);
            DocumentBuilderFactory oDocBuldFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder oDocBuilder = oDocBuldFact.newDocumentBuilder();
            Document oReqDoc = oDocBuilder.newDocument();
            Element oReqElem = oReqDoc.createElementNS(STR_NAMESPACE, "getHora");
            oReqDoc.appendChild(oReqElem);
            Source oSourceReq =  new DOMSource(oReqDoc);
            RespuestaServicioHoraHandler oRespServHoraHandler = new RespuestaServicioHoraHandler();
            Future<?> oResult = oDispatch.invokeAsync(oSourceReq,oRespServHoraHandler);
            long nTiempoInicial = (new Date()).getTime();
            while (!oResult.isDone()) {
               Thread.sleep(10);
            }
            long nTiempoTranscurrido = (new Date()).getTime() - nTiempoInicial;
            System.out.println("Transcurridos " + nTiempoTranscurrido + " milisegundos.");
            
        }catch(Exception ex){
            ex.printStackTrace(System.err);
        }
    }
    private class RespuestaServicioHoraHandler implements AsyncHandler<Source>{
       public void handleResponse(Response<Source> oResp) {
           try {
               Source oSourceResp = oResp.get();
               Transformer oTransformer = TransformerFactory.newInstance().newTransformer();
               DocumentBuilderFactory oDocBuldFact = DocumentBuilderFactory.newInstance();
               DocumentBuilder oDocBuilder = oDocBuldFact.newDocumentBuilder();
               Document oRespuestaDoc = oDocBuilder.newDocument();
               oTransformer.transform(oSourceResp, new DOMResult(oRespuestaDoc));
               NodeList oNodeList= oRespuestaDoc.getElementsByTagName("return");
               if (oNodeList.getLength()>0){
                   Element oElementoRespuesta=(Element)oNodeList.item(0);
                   Node oNodoRespuesta=oElementoRespuesta.getFirstChild();
                   if (oNodoRespuesta!=null && oNodoRespuesta.getNodeType()==Node.TEXT_NODE){
                       Text oText= (Text)oNodoRespuesta;
                       System.err.println("La hora es: " + oText.getNodeValue());
                       return;
                   }
                }
                System.err.println("No se ha recibido la respuesta adecuada");
           } catch(Exception ex) {
               ex.printStackTrace(System.err);
           }
        }
    }
}

