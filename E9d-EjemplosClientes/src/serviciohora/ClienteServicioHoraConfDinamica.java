/*
 * ClienteServicioHoraConfDinamica.java
 */
package serviciohora;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import clienteserviciohora.ImplementacionServicioHora;
public class ClienteServicioHoraConfDinamica {
    private static final String STR_URL="http://localhost:7001/EjemploServicioHoraFromJava/ImplementacionServicioHoraService?WSDL";
    private static final String STR_NAMESPACE="http://serviciohora/";
    private static final String STR_SERVICENAME="ImplementacionServicioHoraService";
    private static final String STR_PORTNAME="ImplementacionServicioHoraPort";
    public static void main(String[] args) {
        ClienteServicioHora oCliente=new ClienteServicioHora();
        oCliente.doTest();
    }
    public void doTest(){
        try{ 
            URL oURL= new URL(STR_URL);
            QName oQNameServicio= new QName (STR_NAMESPACE,STR_SERVICENAME);
            QName oQNamePort= new QName (STR_NAMESPACE,STR_PORTNAME);
            Service oServicio=Service.create(oURL,oQNameServicio);
            ImplementacionServicioHora oImplementacionSrvHora= 
                    (ImplementacionServicioHora)oServicio.getPort(oQNamePort, 
                                                                  ImplementacionServicioHora.class);
            String sHora=oImplementacionSrvHora.getHora();
            System.out.println("La hora del servidor es: " + sHora);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}