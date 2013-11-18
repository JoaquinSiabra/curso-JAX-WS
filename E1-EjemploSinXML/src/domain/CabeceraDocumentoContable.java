package domain;

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

	public String toString() {
		return "Cabecera del documento contable: " + "\n Numero de oficina: "
				+ this.getNumOficina() + "\n Num COE: " + this.getNumCOE()
				+ "\n Ejercicio: " + this.getEjercicio() + "\n Num Id TelCon: "
				+ this.getNumIdTelCon() + "\n Codigo MC: " + this.getCodigoMC()
				+ "\n Dígito signo: " + this.getDigitoSigno();
	}
}
