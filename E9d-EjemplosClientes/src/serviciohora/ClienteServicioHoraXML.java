/*
 * ClienteServicioHoraXML.java
 */

package serviciohora;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.ws.*;
import org.w3c.dom.*;

public class ClienteServicioHoraXML {
    
    private static final String STR_URL="http://localhost:7001/EjemploServicioHoraFromJava/ImplementacionServicioHoraService?WSDL";
    private static final String STR_NAMESPACE="http://serviciohora/";
    private static final String STR_SERVICENAME="ImplementacionServicioHoraService";
    private static final String STR_PORTNAME="ImplementacionServicioHoraPort";
    public static void main(String[] args){
        new ClienteServicioHoraXML().doTest();
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
            Element oReqElem = oReqDoc.createElementNS(STR_NAMESPACE, "ns2:getHora");
            oReqDoc.appendChild(oReqElem);
            Source oSourceReq =  new DOMSource(oReqDoc);
            Source oSourceResp = oDispatch.invoke(oSourceReq);
            Transformer oTransformer = TransformerFactory.newInstance().newTransformer();
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
        }catch(Exception ex){
            ex.printStackTrace(System.err);
        }
    }
}
