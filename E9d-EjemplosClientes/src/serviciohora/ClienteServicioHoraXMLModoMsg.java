/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serviciohora;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.ws.*;
import org.w3c.dom.*;

/**
 *
 * @author DEMO
 */
public class ClienteServicioHoraXMLModoMsg {
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
            Dispatch<SOAPMessage> oDispatch = oService.createDispatch(portQName,SOAPMessage.class, Service.Mode.MESSAGE);
            SOAPFactory oSoapFactory =SOAPFactory.newInstance();
            MessageFactory oMsgFactory =MessageFactory.newInstance();
            SOAPMessage oMessage = oMsgFactory.createMessage();
            // Elemento Body
            SOAPBody oBody = oMessage.getSOAPBody();
            Name oBodyName = oSoapFactory.createName(STR_NAMESPACE, "ns2", "getHora");
            oBody.addBodyElement(oBodyName);
            // Hacemos la invocación
            SOAPMessage oMessageRespuesta = oDispatch.invoke(oMessage);
            SOAPBody oSOAPBodyRespuesta = oMessageRespuesta.getSOAPBody();
            NodeList oLista=oSOAPBodyRespuesta.getElementsByTagName("return");
            SOAPElement oElemento=(SOAPElement) oLista.item(0);
            String sCadenaRetorno=oElemento.getValue();
            System.err.println("La hora es: " + sCadenaRetorno);
        }catch(Exception ex){
            ex.printStackTrace(System.err);
        }
    }
}
