import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Vector;

import org.w3c.dom.Document;

/**
 * 
 * @author SGPF0060
 */
public class CuerpoDocumentoContable {
	private String numExpediente;
	private String seccion;
	private Vector modificaciones = new Vector();
	private BigDecimal importeTotal;
	private Modificacion modificacionActiva;

	public String getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Vector getModificaciones() {
		return modificaciones;
	}

	public void addModificacion(Modificacion modificacion) {
		this.getModificaciones().add(modificacion);
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	
    public void aceptar(Document documento) throws Exception {
        this.setNumExpediente(documento.getElementsByTagName("NumExpediente").item(0).getTextContent());    
        this.setSeccion(documento.getElementsByTagName("Seccion").item(0).getTextContent());    
        this.setImporteTotal(new BigDecimal(documento.getElementsByTagName("ImporteTotal").item(0).getTextContent().replace(',', '.')));
        int numeroModificaciones = new Integer(documento.getElementsByTagName("NumAplicaciones").item(0).getTextContent()).intValue();
        for (int i = 1; i <= numeroModificaciones; i++) {
            Modificacion modificacion = new Modificacion();
            this.addModificacion(modificacion);
            modificacion.aceptar(documento.getElementsByTagName("Modificacion").item(i - 1));
        }
    }



	public String toString() {
		String resultado = "Cuerpo del documento contable:"
				+ "\nNúmero expediente: " + this.getNumExpediente()
				+ "\nSección: " + this.getSeccion() + "\nImporte total: "
				+ this.getImporteTotal();
		for (Iterator i = this.getModificaciones().iterator(); i.hasNext();) {
			Modificacion modificacion = (Modificacion) i.next();
			resultado = resultado + "\n" + modificacion;
		}
		return resultado;
	}
}
