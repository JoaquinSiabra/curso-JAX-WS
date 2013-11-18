package principal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ServicioWebError")
public class ErrorBean {
  
  private String m_sMensaje;
  
  public ErrorBean() {
  }

  ErrorBean(String sMensaje) {
    this();
    m_sMensaje = sMensaje;
  }

  @XmlElement(name = "Mensaje", required = true)
  public String getMensaje() {
    return m_sMensaje;
  }
  
  public void setMensaje(String sMensaje) {
    m_sMensaje = sMensaje;
  }
  
}