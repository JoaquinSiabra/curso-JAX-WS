//Transformacion.java
package servicio;
import javax.xml.parsers.*; 
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

import javax.activation.DataHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Transformacion {
    static Document oDocument; 
    public static DataHandler transforma(DataHandler oFicheroXML, DataHandler oFicheroXSL)
    {
        DocumentBuilderFactory oFactory = DocumentBuilderFactory.newInstance();
        try {
        	
           TransformerFactory oTFactory = preparaFactoriaTransformer(oFactory,oFicheroXML);
           Transformer oTransformer = crearTransformer(oFicheroXSL,oTFactory);
           
           // Establecemos las propiedades de salida de la transformación, si fuera necesario, por ejemplo:
           //oTransformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "ISO-8859-1");
           DOMSource oSource = new DOMSource(oDocument);
           File oFicheroTemporal = new File("C:\\Cursos\\ServiciosWeb\\Ejercicios\\ClienteEjercicio11\\Temp.html");
           StreamResult oResult = new StreamResult(oFicheroTemporal);
           oTransformer.transform(oSource, oResult); 
           DataHandler oDataHandler = new DataHandler(new FicheroComoDataSource("text/html", oFicheroTemporal));
        
           return oDataHandler;
       
        } catch (Exception oEx) {
            System.out.println(oEx.getMessage());
        }
        return null;
    } 
    
    private static TransformerFactory preparaFactoriaTransformer(DocumentBuilderFactory oFactory, DataHandler oFicheroXML) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilder oBuilder = oFactory.newDocumentBuilder();
        oDocument = oBuilder.parse( oFicheroXML.getInputStream() );
        return TransformerFactory.newInstance();
    }
    
    private static Transformer crearTransformer(DataHandler oFicheroXSL, TransformerFactory oTFactory) throws TransformerConfigurationException, IOException {
        StreamSource oFuenteXSL= new StreamSource(oFicheroXSL.getInputStream());
        return oTFactory.newTransformer(oFuenteXSL);
        
	}

}
