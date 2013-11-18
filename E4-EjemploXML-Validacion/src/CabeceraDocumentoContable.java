import org.w3c.dom.Document;



/**
 * 
 * @author SGPF0060
 */
public class CabeceraDocumentoContable {
	private String numOficina;
	private String numCOE;
	private int ejercicio;
	private String numIdTelCon;
	private String codigoMC;
	private int digitoSigno;

	public String getNumOficina() {
		return numOficina;
	}

	public void setNumOficina(String numOficina) {
		this.numOficina = numOficina;
	}

	public String getNumCOE() {
		return numCOE;
	}

	public void setNumCOE(String numCOE) {
		this.numCOE = numCOE;
	}

	public int getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getNumIdTelCon() {
		return numIdTelCon;
	}

	public void setNumIdTelCon(String numIdTelCon) {
		this.numIdTelCon = numIdTelCon;
	}

	public String getCodigoMC() {
		return codigoMC;
	}

	public void setCodigoMC(String codigoMC) {
		this.codigoMC = codigoMC;
	}

	public int getDigitoSigno() {
		return digitoSigno;
	}

	public void setDigitoSigno(int digitoSigno) {
		this.digitoSigno = digitoSigno;
	}
	
	public void aceptar(Document documento) throws Exception {
        this.setNumOficina(documento.getElementsByTagName("NumOficinaContable").item(0).getTextContent());
        this.setNumCOE(documento.getElementsByTagName("NumCOE").item(0).getTextContent());
        this.setEjercicio(new Integer(documento.getElementsByTagName("Ejercicio").item(0).getTextContent()).intValue());
        this.setNumIdTelCon(documento.getElementsByTagName("NumIdTelcon").item(0).getTextContent());
        this.setCodigoMC(documento.getElementsByTagName("CodigoMC").item(0).getTextContent());
        this.setDigitoSigno(new Integer(documento.getElementsByTagName("DigitoSigno").item(0).getTextContent()).intValue());
   }



	public String toString() {
		return "Cabecera del documento contable: " + "\n Numero de oficina: "
				+ this.getNumOficina() + "\n Num COE: " + this.getNumCOE()
				+ "\n Ejercicio: " + this.getEjercicio() + "\n Num Id TelCon: "
				+ this.getNumIdTelCon() + "\n Codigo MC: " + this.getCodigoMC()
				+ "\n Dígito signo: " + this.getDigitoSigno();
	}
}
