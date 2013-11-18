
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author SGPF0060
 */
public class LectorXMLdom {
    private String fichero;

    public String getFichero() {
        return fichero;
    }

    public LectorXMLdom(String fichero) {
        this.fichero = fichero;
    }

    public static void main(String[] args) {
        LectorXMLdom lectorXMLdom = new LectorXMLdom(Envio.class.getClassLoader().getResource("envio.xml").getFile());
        try {
            Envio envio = lectorXMLdom.leerEnvio();
            System.out.println(envio);
        }
        catch (Exception e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }
 
    public Envio leerEnvio() throws Exception {
        Envio envio = new Envio();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(fichero);
        envio.aceptar(doc);
        return envio;
    }
}
