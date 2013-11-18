/*
 * ClienteServicioHoraAsyncPoll.java
 */
package serviciohora;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import clienteserviciohoraasync.GetHoraResponse;
import clienteserviciohoraasync.ImplementacionServicioHora;
import clienteserviciohoraasync.ImplementacionServicioHoraService;

public class ClienteServicioHoraAsyncCallBack {
   public static void main(String[] args) {
        ClienteServicioHoraAsyncCallBack oCliente=new ClienteServicioHoraAsyncCallBack();
        oCliente.doTest();
    }
   public void doTest(){
        try { 
            ImplementacionServicioHoraService oImServHoraService=new ImplementacionServicioHoraService();
            ImplementacionServicioHora oImpServHora=oImServHoraService.getImplementacionServicioHoraPort();
            RespuestaServicioHoraHandler oRespServHoraHandler = new RespuestaServicioHoraHandler();
            Future<?> oResult = oImpServHora.getHoraAsync(oRespServHoraHandler);
            while(!oResult.isDone()) {
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    private class RespuestaServicioHoraHandler implements AsyncHandler<GetHoraResponse>{
       public void handleResponse(Response<GetHoraResponse> oResp) {
           try {
               GetHoraResponse oRespuestaGetHora=oResp.get();
               System.out.println("Resultado = "+ oRespuestaGetHora.getReturn());
           } catch(Exception ex) {
               ex.printStackTrace(System.err);
           }
        }
    }
}

