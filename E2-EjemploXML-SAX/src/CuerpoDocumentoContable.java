import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Vector;

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
	
    public void aceptar(String etiqueta, String valor) throws Exception {
        if (etiqueta.equals("NumExpediente"))
            this.setNumExpediente(valor);
         if (etiqueta.equals("Seccion"))
            this.setSeccion(valor);
         if (etiqueta.equals("ImporteTotal"))
            this.setImporteTotal(new BigDecimal(valor.replace(',', '.')));
        if (etiqueta.equals("NumAplicaciones")) {
            for (int i = 1; i <= new Integer(valor).intValue(); i++) {
                Modificacion modificacion = new Modificacion();
                this.addModificacion(modificacion);
            }
            modificacionActiva = (Modificacion)this.getModificaciones().firstElement();
        }
        if (etiqueta.equals("Modificacion") && this.getModificaciones().size() > 0)
            if ((this.getModificaciones().indexOf(modificacionActiva) + 1) == this.getModificaciones().size())
                modificacionActiva = null;
            else
                modificacionActiva = (Modificacion)this.getModificaciones().elementAt(this.getModificaciones().indexOf(modificacionActiva) + 1);
        if (modificacionActiva != null)
            modificacionActiva.aceptar(etiqueta, valor);
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
