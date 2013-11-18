/*
 * ClienteServicioHoraAsyncPoll.java
 */
package serviciohora;

import clienteserviciohoraasync.GetHoraResponse;
import clienteserviciohoraasync.ImplementacionServicioHora;
import clienteserviciohoraasync.ImplementacionServicioHoraService;

public class ClienteServicioHoraAsyncPoll {
   public static void main(String[] args) {
        ClienteServicioHoraAsyncPoll oCliente=new ClienteServicioHoraAsyncPoll();
        oCliente.doTest();
    }
   public void doTest(){
        try { 
            ImplementacionServicioHoraService oImServHoraService=new ImplementacionServicioHoraService();
            ImplementacionServicioHora oImpServHora=oImServHoraService.getImplementacionServicioHoraPort();
            javax.xml.ws.Response<clienteserviciohoraasync.GetHoraResponse> oResp = oImpServHora.getHoraAsync();
            while(!oResp.isDone()) {
                Thread.sleep(100);
            }
            GetHoraResponse oRespuestaGetHora=oResp.get();
            System.out.println("Resultado = "+ oRespuestaGetHora.getReturn());
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
