import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pclase.*;
import javax.xml.bind.Unmarshaller;

public class EjemploJAXB {
	public static final String STR_FICHEROXML = "C:\\CursoWS\\workspace\\E6-EjemploJAXB\\fichero.xml";
	public static final String STR_FICHEROXML_MODIF = "C:\\CursoWS\\workspace\\E6-EjemploJAXB\\ficheroModificado.xml";

	
	public static void main(String[] args) throws JAXBException, IOException {
		new EjemploJAXB().doTest();
	}

	
	public void doTest() throws JAXBException, IOException {

			JAXBContext oContextoJAXB = JAXBContext.newInstance("pclase");

			Clase oRaiz = leerObjetosDesdeXML(oContextoJAXB);
			oRaiz = modificaUnoDeLosObjetosLeidos(oRaiz);
			escribirObjetosEnXML(oContextoJAXB, oRaiz);	
	}
	

	private Clase leerObjetosDesdeXML(JAXBContext oContextoJava) throws JAXBException {
		
		Unmarshaller oUnmarshaller = oContextoJava.createUnmarshaller();
		return (Clase) oUnmarshaller.unmarshal(new File(STR_FICHEROXML));		
	}

	
	private void escribirObjetosEnXML(JAXBContext oContextoJava, Clase oRaiz)
			throws JAXBException, IOException {

		Marshaller oMarshaller = oContextoJava.createMarshaller();
		oMarshaller.setProperty("jaxb.encoding", "ISO-8859-15");

		FileOutputStream oFileModif = new FileOutputStream(STR_FICHEROXML_MODIF);
		oMarshaller.marshal(oRaiz, oFileModif);
		oFileModif.close();
	}
	

	private Clase modificaUnoDeLosObjetosLeidos(Clase oRaiz) {
		
		List<Alumno> oListaAlumnos = oRaiz.getAlumno();
		Alumno oAlumno = (Alumno) oListaAlumnos.get(0);
		oAlumno.setNombre("Alberto Rodríguez Rey");
		return oRaiz;
	}
}
