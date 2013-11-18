
package clienteservicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInfoFichero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInfoFichero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PathCompletoFichero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfoFichero", propOrder = {
    "pathCompletoFichero"
})
public class GetInfoFichero {

    @XmlElement(name = "PathCompletoFichero")
    protected String pathCompletoFichero;

    /**
     * Gets the value of the pathCompletoFichero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathCompletoFichero() {
        return pathCompletoFichero;
    }

    /**
     * Sets the value of the pathCompletoFichero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathCompletoFichero(String value) {
        this.pathCompletoFichero = value;
    }

}
