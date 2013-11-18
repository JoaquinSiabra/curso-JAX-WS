package principal;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TipoDeFichero")
@XmlEnum(String.class)
public enum TipoDeFichero {

  @XmlEnumValue(TipoDeFichero.STR_PDF)
  PDF,
  @XmlEnumValue(TipoDeFichero.STR_HTM)
  HTM,
  @XmlEnumValue(TipoDeFichero.STR_RTF)
  RTF;

  // Los valores deben coincidir con los nombres de las constantes
  private static final String STR_PDF = "PDF",
                              STR_HTM = "HTM",
                              STR_RTF = "RTF";
}