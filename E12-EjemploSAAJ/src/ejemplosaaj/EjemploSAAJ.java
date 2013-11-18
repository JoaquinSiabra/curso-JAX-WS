package ejemplosaaj;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.soap.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.w3c.dom.NodeList;

public class EjemploSAAJ {
  
  private static final String sURLRSS="http://ep00.epimg.net/rss/elpais/portada.xml";
  
  public static void main(String[] args)  {
    try {

      SOAPConnection oConnection = crearConexion();      
      SOAPMessage oMessage = crearMensaje();
      URL oURLEndPoint = prepararElBodySegunWSDL(oMessage.getSOAPBody());     
     
      SOAPBody oSoapBody = realizarPeticion(oConnection, oMessage, oURLEndPoint); 
      
      tratarLaRespuesta(oSoapBody);
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    
  }
  
  private static SOAPBody realizarPeticion(SOAPConnection oConnection, SOAPMessage oMessage, URL oURLEndPoint) throws Exception{
	  
	  SOAPMessage oResponse = oConnection.call(oMessage, oURLEndPoint);
      oConnection.close();
      
      SOAPBody oSoapBody = oResponse.getSOAPBody();
      if (oSoapBody.hasFault()){    	  
    	  tratarElError(oSoapBody);          
          throw new Exception("Problema en la conexion con el servicio");
      }
      
      return oSoapBody;
      
  }
  
  private static URL prepararElBodySegunWSDL(SOAPBody oBody) throws SOAPException, MalformedURLException{
     
	  SOAPFactory oSoapFactory = SOAPFactory.newInstance();   
	  
	  Name oBodyName = oSoapFactory.createName("GetHTML","","http://www.webserviceX.NET");
      SOAPBodyElement oBodyElement = oBody.addBodyElement(oBodyName);
      
      Name oName = oSoapFactory.createName("RSSURL");
      SOAPElement oElmRSURL = oBodyElement.addChildElement(oName);
      oElmRSURL.addTextNode(sURLRSS);
      
      return new URL("http://www.webservicex.net/RssToHTML.asmx");
  }
  
  private static  SOAPMessage  crearMensaje() throws SOAPException{
	  
      MessageFactory oFactory = MessageFactory.newInstance(); 
      SOAPMessage oMessage = oFactory.createMessage();  //Este es el ENVELOPE
      
      //Insertamos la cabecera HTTP exigida por el servicio que invocaremos 
      //Ese servicio convierte el RSS que indiquemos (el de elpais.com) en HTML 
      oMessage.getMimeHeaders().addHeader("SOAPAction","http://www.webserviceX.NET/GetHTML");
	      
      return oMessage;
      
      // OTROS EJEMPLOS:
      // - Como leer elemento Cabecera SOAP
      //       SOAPHeader oHeader = oMessage.getSOAPHeader();
      // - Eliminar cabecera SOAP
      //       oHeader.detachNode();
  }

  private static SOAPConnection crearConexion() throws SOAPException{    
	  
	  System.setProperty("http.proxyHost", "proxy-inap.seap.minhap.es");
	  System.setProperty("http.proxyPort", "8080");
	  SOAPConnectionFactory oSoapConnectionFactory =SOAPConnectionFactory.newInstance();
	  
	  return oSoapConnectionFactory.createConnection();
   }
	  
  private static void tratarElError(SOAPBody oSoapBody){
	  
      SOAPFault oFault= oSoapBody.getFault();
      String sCodigo = oFault.getFaultCodeAsName().getQualifiedName();
      String sExplicacion = oFault.getFaultString();
      String sActor = oFault.getFaultActor(); 
      
      System.out.println("Error: " +sCodigo+sExplicacion+sActor);
  }
  
  private static void tratarLaRespuesta(SOAPBody oSoapBody) throws IOException{
	  
      NodeList oLista = oSoapBody.getElementsByTagName("GetHTMLResult");
      SOAPElement oElemento=(SOAPElement) oLista.item(0);
      String sCadenaRetorno=oElemento.getValue();
     
      FileWriter oFile=new FileWriter("C:\\CursoWS\\workspace\\E12-EjemploSAAJ\\salida.htm");
      oFile.write(sCadenaRetorno);
      oFile.flush();
      oFile.close();
  }
  
} 
