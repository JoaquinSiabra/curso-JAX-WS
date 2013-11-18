
package clienteservicio;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFicheroConInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFicheroConInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NombreFichero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoFichero" type="{http://prueba.inap.minhap.gob.es}TipoDeFichero" minOccurs="0"/>
 *         &lt;element name="Fichero" type="{http://ws-i.org/profiles/basic/1.1/xsd}swaRef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFicheroConInfo", propOrder = {
    "nombreFichero",
    "tipoFichero",
    "fichero"
})
public class GetFicheroConInfo {

    @XmlElement(name = "NombreFichero")
    protected String nombreFichero;
    @XmlElement(name = "TipoFichero")
    protected TipoDeFichero tipoFichero;
    @XmlElement(name = "Fichero", type = String.class)
    @XmlAttachmentRef
    protected DataHandler fichero;

    /**
     * Gets the value of the nombreFichero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFichero() {
        return nombreFichero;
    }

    /**
     * Sets the value of the nombreFichero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFichero(String value) {
        this.nombreFichero = value;
    }

    /**
     * Gets the value of the tipoFichero property.
     * 
     * @return
     *     possible object is
     *     {@link TipoDeFichero }
     *     
     */
    public TipoDeFichero getTipoFichero() {
        return tipoFichero;
    }

    /**
     * Sets the value of the tipoFichero property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDeFichero }
     *     
     */
    public void setTipoFichero(TipoDeFichero value) {
        this.tipoFichero = value;
    }

    /**
     * Gets the value of the fichero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DataHandler getFichero() {
        return fichero;
    }

    /**
     * Sets the value of the fichero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFichero(DataHandler value) {
        this.fichero = value;
    }

}
