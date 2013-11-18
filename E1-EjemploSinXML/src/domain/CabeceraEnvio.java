package domain;

import java.util.Date;

public class CabeceraEnvio {
	
	private String numCOE;
	private int anualidad;
	private Date fechaEnvio;

	public String getNumCOE() {
		return numCOE;
	}

	public void setNumCOE(String numCOE) {
		this.numCOE = numCOE;
	}

	public int getAnualidad() {
		return anualidad;
	}

	public void setAnualidad(int anualidad) {
		this.anualidad = anualidad;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String toString() {
		return "Cabecera del envío:" + "\nNumCOE: " + this.getNumCOE()
				+ "\nAnualidad: " + this.getAnualidad() + "\nFecha: "
				+ this.getFechaEnvio();
	}
}
