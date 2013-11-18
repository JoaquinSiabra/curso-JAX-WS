/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteejercicio11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataHandler;

import clienteservicio.Transformacion;
import clienteservicio.WsTransformacion;

/**
 *
 * @author aad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try { // Call Web Service Operation
            WsTransformacion service = new WsTransformacion();
            Transformacion port = service.getTransformacionPort();
            File oFileXML = new File("C:\\Cursos\\ServiciosWeb\\Ejercicios\\ClienteEjercicio11\\Clase.xml");
            File oFileXSL = new File("C:\\Cursos\\ServiciosWeb\\Ejercicios\\ClienteEjercicio11\\TransformaClase.xsl");
            // TODO initialize WS operation arguments here
            javax.activation.DataHandler oFicheroXML = new DataHandler(new FicheroComoDataSource("text/xml", oFileXML));
            javax.activation.DataHandler oFicheroXSL = new DataHandler(new FicheroComoDataSource("text/xsl", oFileXSL));
            // TODO process result here
            javax.activation.DataHandler oResultado = port.transformaXMLtoHTML(oFicheroXML, oFicheroXSL);
            FileOutputStream oFicheroTemporal = new FileOutputStream("C:\\Cursos\\ServiciosWeb\\Ejercicios\\ClienteEjercicio11\\Salida.html");
            copiarStream(oResultado.getInputStream(),oFicheroTemporal,true,true);
            System.err.println("Se ha escrito el fichero C:\\Cursos\\ServiciosWeb\\Ejercicios\\ClienteEjercicio11\\Salida.html");
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            System.err.println(ex.getMessage());
        }
    }
    
   /* private static void pEscribirFichero(InputStream oInputStream, FileOutputStream oFileOutput) throws IOException{
      byte oBuf[]=new byte[1024];
      int nLen;
      while((nLen=oInputStream.read(oBuf))>0)
        oFileOutput.write(oBuf,0,nLen);
      oFileOutput.close();
      oInputStream.close();
    }*/
    
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
