

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
	
	public void aceptar(String etiqueta, String valor) throws Exception {
        if (etiqueta.equals("NumOficinaContable"))
           this.setNumOficina(valor);
        if (etiqueta.equals("NumCOE"))
            this.setNumCOE(valor);
        if (etiqueta.equals("Ejercicio"))
            this.setEjercicio(new Integer(valor).intValue());
        if (etiqueta.equals("NumIdTelcon"))
            this.setNumIdTelCon(valor);
        if (etiqueta.equals("CodigoMC"))
            this.setCodigoMC(valor);
        if (etiqueta.equals("DigitoSigno"))
            this.setDigitoSigno(new Integer(valor).intValue());
  }


	public String toString() {
		return "Cabecera del documento contable: " + "\n Numero de oficina: "
				+ this.getNumOficina() + "\n Num COE: " + this.getNumCOE()
				+ "\n Ejercicio: " + this.getEjercicio() + "\n Num Id TelCon: "
				+ this.getNumIdTelCon() + "\n Codigo MC: " + this.getCodigoMC()
				+ "\n Dígito signo: " + this.getDigitoSigno();
	}
}
