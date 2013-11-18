import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Document;

/**
 * 
 * @author SGPF0060
 */
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
	
    public void aceptar(Document documento) throws Exception {
        this.setNumCOE(documento.getElementsByTagName("NumCOE").item(0).getTextContent());
        this.setAnualidad(new Integer(documento.getElementsByTagName("Anualidad").item(0).getTextContent()).intValue());
        this.setFechaEnvio(new SimpleDateFormat("dd/MM/yyyy").parse(documento.getElementsByTagName("FechaEnvio").item(0).getTextContent()));
    }



	public String toString() {
		return "Cabecera del envío:" + "\nNumCOE: " + this.getNumCOE()
				+ "\nAnualidad: " + this.getAnualidad() + "\nFecha: "
				+ this.getFechaEnvio();
	}
}
