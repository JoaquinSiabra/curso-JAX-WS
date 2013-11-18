import java.math.BigDecimal;

import org.w3c.dom.Node;


public class Modificacion {
	private String servicio;
	private String porPrograma;
	private String economica;
	private String codModificacion;
	private BigDecimal importe;

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getPorPrograma() {
		return porPrograma;
	}

	public void setPorPrograma(String porPrograma) {
		this.porPrograma = porPrograma;
	}

	public String getEconomica() {
		return economica;
	}

	public void setEconomica(String economica) {
		this.economica = economica;
	}

	public String getCodModificacion() {
		return codModificacion;
	}

	public void setCodModificacion(String codModificacion) {
		this.codModificacion = codModificacion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
    public void aceptar(Node nodo) throws Exception {
        for (int i = 0; i < nodo.getChildNodes().getLength(); i++) {
            Node subnodo = nodo.getChildNodes().item(i);
            if (subnodo.getNodeName().equals("Servicio"))
                this.setServicio(subnodo.getTextContent());
            if (subnodo.getNodeName().equals("PorPrograma"))
                this.setPorPrograma(subnodo.getTextContent());
            if (subnodo.getNodeName().equals("Economica"))
                this.setEconomica(subnodo.getTextContent());
            if (subnodo.getNodeName().equals("CodModificacion"))
                this.setCodModificacion(subnodo.getTextContent());
            if (subnodo.getNodeName().equals("Importe"))
                this.setImporte(new BigDecimal(subnodo.getTextContent().replace(',', '.')));
        }
    }


	public String toString() {
		return "Modificacion:" + "\nServicio: " + this.getServicio()
				+ "\nPor programa: " + this.getPorPrograma() + "\nEconomica: "
				+ this.getEconomica() + "\nCódigo modificación: "
				+ this.getCodModificacion() + "\nImporte: " + this.getImporte();
	}

}
