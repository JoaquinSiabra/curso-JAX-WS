package rural;

import javax.jws.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import javax.xml.registry.*;
import javax.xml.registry.infomodel.*;

import java.io.*;
import java.net.*;


@WebService
public class GestorRegistroAlojamientosRurales {
	private static final long serialVersionUID = 1L;
    private static String m_sUsername = "admin";
    private static String m_sPassword = "administrador1";

	@WebMethod
	public String registrar(String organizacion, String contacto, String telefono, String WSurl) {
		BusinessLifeCycleManager oBlm = obtenerGestorCicloVida();
		if (oBlm == null)
				return "No se ha obtenido el gestor de ciclo de vida";
		Organization oOrg = obtenerOrganizacion(oBlm, organizacion, contacto, telefono, WSurl);
		if (oOrg == null)
			return "No se ha podido obtener la organizacion";
		ArrayList oOrgs = new ArrayList();
		oOrgs.add(oOrg);
		try {
			BulkResponse oBr = oBlm.saveOrganizations(oOrgs);
			if (oBr.getStatus() == JAXRResponse.STATUS_SUCCESS) 
				return "Elementos registrados";
		    else {
		          String error = "Error en la operación de grabacion:";
		          Collection oExceptions = oBr.getExceptions();
		          Iterator oIter = oExceptions.iterator();
		          while (oIter.hasNext()) {
		            Exception oE = (Exception) oIter.next();
		            error = error + "\n" + oE.toString();
		          }
		          return error;
		    }
		} catch (JAXRException e) {
			e.printStackTrace();
			return "No se ha podido grabar la organizacion";
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
	
	private BusinessLifeCycleManager obtenerGestorCicloVida() {
	    try {
			ConnectionFactory oFactory = ConnectionFactory.newInstance();
			oFactory.setProperties(obtenerPropiedadesConexion());
			Connection oConn = oFactory.createConnection();
			oConn.setCredentials(obtenerCredenciales());
			RegistryService oRs = oConn.getRegistryService();
			return oRs.getBusinessLifeCycleManager();
		} catch (JAXRException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Organization obtenerOrganizacion(BusinessLifeCycleManager oBlm, String organizacion, String contacto, String telefono, String WSurl) {
		try {
			Organization oOrg = oBlm.createOrganization(organizacion);
			oOrg.setDescription(oBlm.createInternationalString(organizacion));
			oOrg.setPrimaryContact(obtenerContacto(oBlm, contacto, telefono));
			oOrg.addService(obtenerServicio(oBlm, organizacion, WSurl));
			return oOrg;
		} catch (JAXRException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private User obtenerContacto(BusinessLifeCycleManager oBlm, String contacto, String telefono) throws JAXRException {
        User oUser = oBlm.createUser();
        oUser.setPersonName(oBlm.createPersonName(contacto));
        
        // dirección
/*        PostalAddress oDireccionPostal = oBlm.createPostalAddress("50", "María de Molina", "Madrid", "Madrid", "España", "28006", "");
        Collection oDireccionesPostales = new ArrayList();
        oDireccionesPostales.add(oDireccionPostal);
        oUser.setPostalAddresses(oDireccionesPostales);*/
        
        // teléfono
        TelephoneNumber oNumTelefono = oBlm.createTelephoneNumber();
        oNumTelefono.setNumber(telefono);
        oNumTelefono.setType(null);
        Collection oNumeros = new ArrayList();
        oNumeros.add(oNumTelefono);
        oUser.setTelephoneNumbers(oNumeros);

        // email
  /*      EmailAddress oDireccionEmail = oBlm.createEmailAddress("pgalvez@igae.minhap.es");
        Collection oDireccionesEmail = new ArrayList();
        oDireccionesEmail.add(oDireccionEmail);
        oUser.setEmailAddresses(oDireccionesEmail); */
      
        return oUser;
	}
	
	private Service obtenerServicio(BusinessLifeCycleManager oBlm, String organizacion, String WSurl) throws JAXRException {
        Service oServicio = oBlm.createService(oBlm.createInternationalString("InformacionAlojamientoRural" + organizacion));
        oServicio.setDescription(oBlm.createInternationalString("Informacion sobre el alojamiento rural: " + organizacion));
        // binding
        ServiceBinding oServicioBinding=oBlm.createServiceBinding();
        oServicioBinding.setAccessURI(WSurl);
        oServicioBinding.setDescription(oBlm.createInternationalString("URL de acceso al servicio de informacion sobre el alojamiento rural: " + organizacion));
        oServicio.addServiceBinding(oServicioBinding);

        return oServicio;
	}
}
