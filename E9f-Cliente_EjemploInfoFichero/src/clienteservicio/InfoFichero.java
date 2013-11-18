
package clienteservicio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfoFichero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoFichero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NombreCorto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Descripciones" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Cadena" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tamanio" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoFichero", propOrder = {
    "nombreCorto",
    "descripciones",
    "nombreCompleto",
    "tamanio"
})
public class InfoFichero {

    @XmlElement(name = "NombreCorto", required = true)
    protected String nombreCorto;
    @XmlElement(name = "Descripciones")
    protected InfoFichero.Descripciones descripciones;
    @XmlElement(name = "NombreCompleto", required = true)
    protected String nombreCompleto;
    @XmlElement(name = "Tamanio")
    protected long tamanio;

    /**
     * Gets the value of the nombreCorto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCorto() {
        return nombreCorto;
    }

    /**
     * Sets the value of the nombreCorto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCorto(String value) {
        this.nombreCorto = value;
    }

    /**
     * Gets the value of the descripciones property.
     * 
     * @return
     *     possible object is
     *     {@link InfoFichero.Descripciones }
     *     
     */
    public InfoFichero.Descripciones getDescripciones() {
        return descripciones;
    }

    /**
     * Sets the value of the descripciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoFichero.Descripciones }
     *     
     */
    public void setDescripciones(InfoFichero.Descripciones value) {
        this.descripciones = value;
    }

    /**
     * Gets the value of the nombreCompleto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the value of the nombreCompleto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCompleto(String value) {
        this.nombreCompleto = value;
    }

    /**
     * Gets the value of the tamanio property.
     * 
     */
    public long getTamanio() {
        return tamanio;
    }

    /**
     * Sets the value of the tamanio property.
     * 
     */
    public void setTamanio(long value) {
        this.tamanio = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Cadena" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cadena"
    })
    public static class Descripciones {

        @XmlElement(name = "Cadena")
        protected List<String> cadena;

        /**
         * Gets the value of the cadena property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cadena property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCadena().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCadena() {
            if (cadena == null) {
                cadena = new ArrayList<String>();
            }
            return this.cadena;
        }

    }

}
