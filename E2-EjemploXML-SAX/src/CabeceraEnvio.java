import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public void aceptar(String etiqueta, String valor) throws Exception {
        if (etiqueta.equals("NumCOE"))
            this.setNumCOE(valor);
        if (etiqueta.equals("Anualidad"))
            this.setAnualidad(new Integer(valor).intValue());
        if (etiqueta.equals("FechaEnvio"))
            this.setFechaEnvio(new SimpleDateFormat("dd/MM/yyyy").parse(valor));
    }


	public String toString() {
		return "Cabecera del envío:" + "\nNumCOE: " + this.getNumCOE()
				+ "\nAnualidad: " + this.getAnualidad() + "\nFecha: "
				+ this.getFechaEnvio();
	}
}
