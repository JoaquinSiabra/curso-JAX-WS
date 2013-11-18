/*
 * ClienteHoraServicio.java
 */
package serviciohora;

import clienteserviciohora.ImplementacionServicioHora;
import clienteserviciohora.ImplementacionServicioHoraService;

public class ClienteServicioHora {
    public static void main(String[] args) {
        ClienteServicioHora oCliente=new ClienteServicioHora();
        oCliente.doTest();
    }
    public void doTest(){
        try{
            ImplementacionServicioHoraService oImServHoraService=new ImplementacionServicioHoraService();
            ImplementacionServicioHora oImpServHora=oImServHoraService.getImplementacionServicioHoraPort();
            String sHora=oImpServHora.getHora();
            System.out.println("La hora del servidor es: " + sHora);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}