package principal;

import java.io.Serializable;
import javax.xml.ws.WebFault;

@WebFault(name= "ErrorServicioWeb", faultBean = "ErrorBean")

public class InfoFicheroException extends Exception implements Serializable {

  private ErrorBean m_oInfoError;
  
  InfoFicheroException(String sMsg, ErrorBean oInfoError) {
    super(sMsg);
    m_oInfoError = oInfoError;
  }

  InfoFicheroException(String sMsg, ErrorBean oInfoError, Throwable cause) {
    super(sMsg, cause);
    m_oInfoError = oInfoError;
  }

  public ErrorBean getFaultInfo() {
    return m_oInfoError;
  }
  
}
