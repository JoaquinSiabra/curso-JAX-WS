
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 *
 * @author SGPF0060
 */
public class ComprobadorValidezXML {
    private String fichero;
    private String esquema;

    public String getFichero() {
        return fichero;
    }
    
    public ComprobadorValidezXML(String fichero) {
        this.fichero = fichero;
    }

    public static void main(String[] args) {
        ComprobadorValidezXML comprobadorValidezXML = new ComprobadorValidezXML(Envio.class.getClassLoader().getResource("envio.xml").getFile());
        try {
            comprobadorValidezXML.comprobarFicheroXML();
        }
        catch (Exception e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }

    public void comprobarFicheroXML() throws Exception {
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       dbf.setNamespaceAware(true);
       dbf.setValidating(true);
       dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
       DocumentBuilder db = dbf.newDocumentBuilder();
       db.setErrorHandler(new SimpleErrorHandler());
       Document doc = db.parse(this.getFichero());
       Node raiz = doc.getFirstChild();
       System.out.println("Raíz: "+ raiz.getNodeName());
   }

}

class SimpleErrorHandler implements ErrorHandler {      
     public void error(SAXParseException exception) {
         System.out.println("error: "+ exception.getMessage());
     }
          
     public void fatalError(SAXParseException exception) {
         System.out.println("fatalError: "+ exception.getMessage());
     }
          
     public void warning(SAXParseException exception) {
         System.out.println("warning: "+ exception.getMessage());
     }
 }
