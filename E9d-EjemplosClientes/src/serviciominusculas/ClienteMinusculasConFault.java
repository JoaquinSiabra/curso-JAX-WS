/*
 * ClienteMinusculasConFault.java
 */

package serviciominusculas;

import clienteserviciominusculas.ServicioMinusculas;
import clienteserviciominusculas.ServicioMinusculasException_Exception;
import clienteserviciominusculas.ServicioMinusculasService;

public class ClienteMinusculasConFault {
    public static void main(String[] args){
        new ClienteMinusculasConFault().doTest();
    }
    public void doTest(){
        try { 
            ServicioMinusculasService oService = new ServicioMinusculasService();
            ServicioMinusculas oPort = oService.getServicioMinusculasPort();
            String sResult = oPort.getMinusculas("ABCDE");
            System.out.println("Minúsculas = "+sResult);
        } catch (ServicioMinusculasException_Exception oExcepcionServicio) {
               System.out.println("Excepción mapeada:(ServicioMinusculasException_Exception)");
               System.out.println("ServicioMinusculasException_Exception.getMessage()=" + 
                            oExcepcionServicio.getMessage());
               System.out.println("ServicioMinusculasException_Exception.getFaultInfo().getMsg()" +
                            oExcepcionServicio.getFaultInfo().getMessage());
        }
  
    }
}
