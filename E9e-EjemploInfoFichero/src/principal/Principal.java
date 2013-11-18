package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

//import com.sun.xml.ws.developer.SchemaValidation;
import javax.xml.bind.annotation.XmlAttachmentRef;

/**
 * El frontal del servicio 
 */
@WebService(serviceName = "wsPrueba",
            name = "PruebaServicio",
            portName="PruebaPort", 
            targetNamespace = "http://prueba.inap.minhap.gob.es"
//            , wsdlLocation = "wsdl/xxx.wsdl"
           )
//@SchemaValidation desde JAX-WS 2.1.3
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, 
             use = SOAPBinding.Use.LITERAL,
             parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Principal{
  
  @WebMethod(operationName = "getInfoFichero")
  @WebResult(name = "Resultado")
  public Infofichero getInformacionFichero(
                        @WebParam(name = "PathCompletoFichero")
                        String sFichero
                      ) throws FileNotFoundException{
    File oFile = new File(sFichero);
    return new Infofichero (oFile.getName(),oFile.length(), oFile.getAbsolutePath(), oFile.getParent());
  }

  @WebMethod(operationName = "getFicheroConInfo")                 //NO FUNCIONA, NO SE HA PROBADO EN CLASE ------------
  @WebResult(name = "Resultado")
  public Infofichero enviarFichero(
                        @WebParam(name = "NombreFichero")
                        String sNombreFichero,
                        @WebParam(name = "TipoFichero")
                        TipoDeFichero sTipoDeFichero,
                        @WebParam(name = "Fichero")
                        @XmlAttachmentRef
                        DataHandler oDataHandler
                      ) throws FileNotFoundException, InfoFicheroException{
    File oFile = new File(sNombreFichero);
    FileOutputStream oFileOutput = new FileOutputStream(oFile);
    
    try {
      // El tipo de fichero no se usa
      copiarStream(oDataHandler.getInputStream(), oFileOutput, true, true);
    } catch (IOException e) {
      throw new InfoFicheroException("ERR01", new ErrorBean(e.getMessage()));
    }
    return new Infofichero (oFile.getName(),oFile.length(), oFile.getAbsolutePath(), oFile.getParent());
  }
  
  private static final void copiarStream(InputStream oIn, OutputStream oOut, boolean bCerrarEntrada, boolean bCerrarSalida) throws IOException {
    try {
      byte buffer[] = new byte[8000];
      int nBuff = 0;
      while((nBuff = oIn.read(buffer)) != -1)
        oOut.write(buffer, 0, nBuff);
      oOut.flush();
    } catch (IOException ie) {
      throw ie;
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    } finally {
      if (bCerrarEntrada && (oIn != null)) {
        try {
          oIn.close();
          oIn = null;
        } catch (Exception e2) {}
      }
      if (bCerrarSalida && (oOut != null)) {
        try {
          oOut.close();
          oOut = null;
        } catch (Exception e2) {}
      }
    }
  }


}
