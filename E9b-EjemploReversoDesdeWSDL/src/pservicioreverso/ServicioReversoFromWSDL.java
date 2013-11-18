package pservicioreverso;

import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public class ServicioReversoFromWSDL implements ServicioReversoFromJava{
  
  public String getReverso(String sCadena) {
    String sCadRetorno="";
    if (sCadena!=null && !sCadena.equals("")){
        for (int i=sCadena.length();i>0;i--){
            sCadRetorno=sCadRetorno+sCadena.charAt(i-1);
        }
    }
    return sCadRetorno;
  }

}

