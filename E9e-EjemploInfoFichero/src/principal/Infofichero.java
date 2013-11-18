package principal;

import java.io.Serializable;
import java.util.List;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlType(name = "InfoFichero", propOrder = { "nombre", "descripciones", "nombreCompleto", "tamanio"})
public class Infofichero implements Serializable {
  private String m_sNombre;
  private long m_nTamanio;
  private String m_sNombrePadre;
  private String m_sPathAbsoluto;
  
  public Infofichero (){
    
  }
  public Infofichero (String sNombre, long nTamanio, String sPathAbsoluto, String sNombrePadre) {
    m_sNombre = sNombre;
    m_nTamanio = nTamanio;
    m_sNombrePadre = sNombrePadre;
    m_sPathAbsoluto = sPathAbsoluto;
  }
  
  @XmlElementWrapper(name = "Descripciones")
  @XmlElement(name="Cadena")
  public List<String> getDescripciones(){
    return Arrays.asList(new String[]{m_sNombre,m_sNombrePadre,m_sPathAbsoluto});  
  }
  
  @XmlElement(name = "NombreCorto", required = true)
  public String getNombre(){
    return m_sNombre;
  }
  
  public void setNombre(String sNombre){
    m_sNombre = sNombre;
  }
  
  @XmlElement(name = "Tamanio", required = true) 
  public long getTamanio(){
    return m_nTamanio;
  }
  public void setTamanio(long nTamanio){
    m_nTamanio = nTamanio;
  }
  
  @XmlElement(name = "NombreCompleto", required = true)
  public String getNombreCompleto(){
    return m_sPathAbsoluto;
  }
  
}
