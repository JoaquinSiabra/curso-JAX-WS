
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author SGPF0060
 */
public class LectorXMLsax {
    private String fichero;

    public String getFichero() {
        return fichero;
    }

    public LectorXMLsax(String fichero) {
        this.fichero = fichero;
    }

    public static void main(String[] args) {
        LectorXMLsax lectorXMLsax = new LectorXMLsax(Envio.class.getClassLoader().getResource("envio.xml").getFile());
        try {
            Envio envio = lectorXMLsax.leerEnvio();
            System.out.println(envio);
        }
        catch (Exception e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }
 
    public Envio leerEnvio() throws Exception {
        Envio envio = new Envio();
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse(new File(fichero), new HelperLecturaDocumento(envio));
        return envio;
    }
}

class HelperLecturaDocumento extends DefaultHandler {
    private Envio envio;
    private String contenido;
    
    public HelperLecturaDocumento(Envio envio) {
        this.envio = envio;
    }
    
    @Override
    public void startDocument() {
        System.out.println("hola");
    }

    @Override
    public void endDocument() {
        System.out.println("adios");
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("he encontrado una nueva etiqueta :" + qName);	
    }
    
    public void characters(char buf[], int offset, int len)
    {
            contenido = new String(buf, offset, len); 
    }

    public void endElement(String uri, String localName, String qName) {
            System.out.println("he leido la  etiqueta : " + qName + " y su contenido es : " + contenido);
            try {
                envio.aceptar(qName, contenido);
            } catch (Exception e) {
                System.out.println("No se ha podido procesar la etiqueta: " + qName + " con el contenido " + contenido);
            }
     }
}
