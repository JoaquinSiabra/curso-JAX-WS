/*
 * ImplementacionServicioHora.java
 * 
 */

package serviciohora;

import java.util.*;
import java.text.*;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class ImplementacionServicioHora {
    @WebMethod
    public String getHora() throws ServicioHoraException{
        SimpleDateFormat oSDF = new SimpleDateFormat("HH:mm:ss");
        Date oDate=new Date();
        return oSDF.format(oDate);
    }
    
}
