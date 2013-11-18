package consultas;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.BulkResponse;
import javax.xml.registry.BusinessQueryManager;
import javax.xml.registry.Connection;
import javax.xml.registry.ConnectionFactory;
import javax.xml.registry.FindQualifier;
import javax.xml.registry.JAXRException;
import javax.xml.registry.RegistryService;
import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.PersonName;
import javax.xml.registry.infomodel.Service;
import javax.xml.registry.infomodel.ServiceBinding;
import javax.xml.registry.infomodel.User;

import javax.xml.namespace.QName;
import javax.servlet.http.*;

import consulta.GestorConsultaAlojamientosRurales;
import consulta.GestorConsultaAlojamientosRuralesService;


public class ConsultarAlojamientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String m_sUsername = "admin";
    private static String m_sPassword = "administrador1";
      

    public ConsultarAlojamientos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter pw = response.getWriter();
		  pw.println("<html>");
		  pw.println("<head><title>Servlet de prueba</title></title>");
		  pw.println("<body>");
		  pw.println("<h1>" + getConsultaAlojamientos() + "</h1>");
		  pw.println("</body></html>");	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String getConsultaAlojamientos() {
		BusinessQueryManager oBqm = obtenerGestorConsultas();
		if (oBqm == null)
				return "No se ha obtenido el gestor de ciclo de vida";
        try {
			// Definimos los cualificadores y el patrón de búsqueda
			Collection oCualificadoresBusqueda = new ArrayList();
			oCualificadoresBusqueda.add(FindQualifier.SORT_BY_NAME_DESC);
			Collection aPatrones= new ArrayList();
			aPatrones.add("%");
			//
			BulkResponse oBResponse =oBqm.findOrganizations(oCualificadoresBusqueda,aPatrones, null, null, null, null);
			Collection oOrganizaciones= oBResponse.getCollection();
            Iterator oIterOrga = oOrganizaciones.iterator();
            if (!(oIterOrga.hasNext())) 
                return "No se han encontrado organizaciones";
            else {
            	String resultado = "";
            	while (oIterOrga.hasNext()) {
            		Organization oOrganizacion = (Organization) oIterOrga.next();
            		try{
            			resultado = resultado + "<br/>" + "Organización : " + oOrganizacion.getName().getValue();
            		}catch(Exception ex){}
            		
            		resultado = resultado + obtenerNombrePersonacontacto(oOrganizacion);
            		resultado = resultado + obtenerDatosServicio(oOrganizacion);
            	}            	
                return resultado;
           }
		} catch (Exception e) {
			e.printStackTrace();
			return "Fallo al recuperar los datos";
		}
    }
	
	private String obtenerDatosServicio(Organization oOrganizacion) throws JAXRException{

		String resultado="";
        Collection oColServices = oOrganizacion.getServices();
        Iterator oIter = oColServices.iterator();
        while (oIter.hasNext()) {
            Service oServicio = (Service) oIter.next();
            try{
            	resultado = resultado + "<br/>Servicio: " + oServicio.getName().getValue();
            }catch(Exception ex){}
            Collection oServiceBindings = oServicio.getServiceBindings();
            Iterator oIterSB = oServiceBindings.iterator();
            while (oIterSB.hasNext()) {
                ServiceBinding oSB = (ServiceBinding)oIterSB.next();
                try{
                	resultado = resultado + "<br/>Enlace: " + oSB.getDescription().getValue();
                }catch(Exception ex){}
                resultado = resultado + "<br/>URI: " + oSB.getAccessURI();
                resultado = resultado + "<br/>precio: " + getPrecio(oSB.getAccessURI());
            }
        }
        
        return resultado;		
	}
	
	private String obtenerNombrePersonacontacto(Organization oOrganizacion) throws JAXRException{

		String nombreContacto="";
		User oUser = oOrganizacion.getPrimaryContact();
		if (oUser != null) {
			PersonName oNombre = oUser.getPersonName();
			try{
				nombreContacto = nombreContacto + "<br/>Persona de contacto: " + oNombre.getFullName();
			}catch(Exception ex){}
		}
		
		return nombreContacto;
	}
	
	
	private BusinessQueryManager obtenerGestorConsultas() {
	    try {
			ConnectionFactory oFactory = ConnectionFactory.newInstance();
			oFactory.setProperties(obtenerPropiedadesConexion());
			Connection oConn = oFactory.createConnection();
			oConn.setCredentials(obtenerCredenciales());
			RegistryService oRs = oConn.getRegistryService();
			return oRs.getBusinessQueryManager();
		} catch (JAXRException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Properties obtenerPropiedadesConexion() {
		Properties m_oConnProps = new Properties();	
		m_oConnProps.setProperty("javax.xml.registry.queryManagerURL", "http://localhost:7001/uddi/uddilistener");
		m_oConnProps.setProperty("javax.xml.registry.lifeCycleManagerURL","http://localhost:7001/uddi/uddilistener");
		m_oConnProps.setProperty("javax.xml.registry.factoryClass", "com.sun.xml.registry.uddi.ConnectionFactoryImpl");
		m_oConnProps.setProperty("com.sun.xml.registry.http.proxyHost", "");
		m_oConnProps.setProperty("com.sun.xml.registry.http.proxyPort", "");
		m_oConnProps.setProperty("com.sun.xml.registry.https.proxyHost", "");
		m_oConnProps.setProperty("com.sun.xml.registry.https.proxyPort", ""); 
		return m_oConnProps;
	}
	
	private HashSet obtenerCredenciales() {
        PasswordAuthentication passwdAuth = new PasswordAuthentication(m_sUsername, m_sPassword.toCharArray());
        Set oCreds = new HashSet();
        oCreds.add(passwdAuth);
        return (HashSet)oCreds;
	}
	
	private String getPrecio(String uri) {
		try {
			String nombreServicio = "GestorConsultaAlojamientosRuralesService";
			String espacioNombres = "http://consulta/";
			QName nombreCualificado = new QName(espacioNombres, nombreServicio);
			String ubicacionWsdl = uri;
			URL urlWsdl = new URL(ubicacionWsdl);
			GestorConsultaAlojamientosRuralesService servicio = new GestorConsultaAlojamientosRuralesService(urlWsdl, nombreCualificado);
			GestorConsultaAlojamientosRurales puerto = servicio.getGestorConsultaAlojamientosRuralesPort();
			return puerto.obtenerPrecioPorPersona().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "NO SE HA LOGRADO CONTACTAR CON EL SERVIDOR";
		}
	}
	
}
