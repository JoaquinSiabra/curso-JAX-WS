import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import pclase.Alumno;
import pclase.Clase;

public class ServletJAXB extends HttpServlet {
	
	private static final long serialVersionUID = 7940800567775683490L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGetPost(request, response);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	
	public void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			
			creaPaginaHTML(response);

		} catch (Exception ex) {
			ex.printStackTrace(response.getWriter());
		}
	}
	
	
	private void creaPaginaHTML(HttpServletResponse response) throws IOException, JAXBException{
		
		JAXBContext oContextoJava = JAXBContext.newInstance("pclase");	
		escribirDocumentoHTML(leerObjetosDesdeXML(oContextoJava), response);
	}
	
	
	private Clase leerObjetosDesdeXML(JAXBContext oContextoJava) throws JAXBException {
		
		String sPathDespliegue = getServletContext().getRealPath("/");
		Unmarshaller oUnmarshaller = oContextoJava.createUnmarshaller();	

		return (Clase) oUnmarshaller.unmarshal(new File(sPathDespliegue + "fichero.xml"));
	}
	
	
	private void escribirDocumentoHTML(Clase oRaiz, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Ejercicio</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Clase</h1>");

		escribirAlumnosHTML(oRaiz, out);

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	
	private void escribirAlumnosHTML(Clase oRaiz, PrintWriter out) {

		Iterator<Alumno> oIteraAlumnos = oRaiz.getAlumno().iterator();
		while (oIteraAlumnos.hasNext()) {
			Alumno oAlumno = oIteraAlumnos.next();
			out.println("<br>Nombre: " + oAlumno.getNombre() + "</br>");
			out.println("<br>Provincia: " + oAlumno.getProvincia() + "</br>");
		}
	}
	
}