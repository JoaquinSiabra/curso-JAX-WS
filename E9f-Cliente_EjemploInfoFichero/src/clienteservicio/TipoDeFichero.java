
package clienteservicio;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoDeFichero.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoDeFichero">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="HTM"/>
 *     &lt;enumeration value="RTF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoDeFichero")
@XmlEnum
public enum TipoDeFichero {

    PDF,
    HTM,
    RTF;

    public String value() {
        return name();
    }

    public static TipoDeFichero fromValue(String v) {
        return valueOf(v);
    }

}
