package domain;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Vector;


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
