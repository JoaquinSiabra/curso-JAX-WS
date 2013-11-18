
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author SGPF0060
 */
public class FormateadorEnvio {
    private String fichero;
    private String plantilla;
    private String ficheroSalida;

    public String getFichero() {
        return fichero;
    }
    
    public String getPlantilla() {
        return plantilla;
    }
    
    public String getFicheroSalida() {
        return ficheroSalida;
    }

    public FormateadorEnvio(String fichero, String plantilla, String ficheroSalida) {
        this.fichero = fichero;
        this.plantilla = plantilla;
        this.ficheroSalida = ficheroSalida;
    }

    public static void main(String[] args) {
        FormateadorEnvio formateadorEnvio = new FormateadorEnvio(Envio.class.getClassLoader().getResource("envio.xml").getFile(),
        		Envio.class.getClassLoader().getResource("envio.xsl").getFile(),
        		Envio.class.getClassLoader().getResource(".").getPath() + "salida.txt");
        try {
            formateadorEnvio.formatear();
        }
        catch (Exception e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }

    public void formatear() throws Exception {
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       dbf.setNamespaceAware(true);
       dbf.setValidating(true);
       dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
       DocumentBuilder db = dbf.newDocumentBuilder();
       db.setErrorHandler(new SimpleErrorHandler());
       Document doc = db.parse(this.getFichero());
       TransformerFactory tFactory = TransformerFactory.newInstance();
       Transformer transformer = tFactory.newTransformer(new StreamSource(this.getPlantilla()));
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
transformer.transform(new DOMSource(doc),
                    new StreamResult(new FileOutputStream(this.getFicheroSalida())));
}

}

