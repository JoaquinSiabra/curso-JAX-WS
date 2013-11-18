package administracion;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import javax.xml.namespace.QName;

import rural.GestorRegistroAlojamientosRurales;
import rural.GestorRegistroAlojamientosRuralesService;

import administracion.*;

/**
 * Servlet implementation class EditorTextos
 */
public class RegistrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter pw = response.getWriter();
		  pw.println("<html>");
		  pw.println("<head><title>Servlet de prueba</title></title>");
		  pw.println("<body>");
		  pw.println("<h1>" + getResultadoRegistro() + "</h1>");
		  pw.println("</body></html>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private String getResultadoRegistro() {
		try {
			String nombreServicio = "GestorRegistroAlojamientosRuralesService";
			String espacioNombres = "http://rural/";
			QName nombreCualificado = new QName(espacioNombres, nombreServicio);
			String ubicacionWsdl = "http://localhost:7001/RuralServidor/GestorRegistroAlojamientosRuralesService?WSDL";
			URL urlWsdl = new URL(ubicacionWsdl);
			GestorRegistroAlojamientosRuralesService servicio = new GestorRegistroAlojamientosRuralesService(urlWsdl, nombreCualificado);
			GestorRegistroAlojamientosRurales puerto = servicio.getGestorRegistroAlojamientosRuralesPort();
			return puerto.registrar("Casa Pepe", "Pepe", "555-55-55", "http://localhost:7001/RuralCliente/GestorConsultaAlojamientosRuralesService?WSDL");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
