
package clienteservicio;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transformaXMLtoHTML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transformaXMLtoHTML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FicheroXML" type="{http://ws-i.org/profiles/basic/1.1/xsd}swaRef" minOccurs="0"/>
 *         &lt;element name="FicheroXSL" type="{http://ws-i.org/profiles/basic/1.1/xsd}swaRef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transformaXMLtoHTML", propOrder = {
    "ficheroXML",
    "ficheroXSL"
})
public class TransformaXMLtoHTML {

    @XmlElement(name = "FicheroXML", type = String.class)
    @XmlAttachmentRef
    protected DataHandler ficheroXML;
    @XmlElement(name = "FicheroXSL", type = String.class)
    @XmlAttachmentRef
    protected DataHandler ficheroXSL;

    /**
     * Gets the value of the ficheroXML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DataHandler getFicheroXML() {
        return ficheroXML;
    }

    /**
     * Sets the value of the ficheroXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFicheroXML(DataHandler value) {
        this.ficheroXML = value;
    }

    /**
     * Gets the value of the ficheroXSL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DataHandler getFicheroXSL() {
        return ficheroXSL;
    }

    /**
     * Sets the value of the ficheroXSL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFicheroXSL(DataHandler value) {
        this.ficheroXSL = value;
    }

}
