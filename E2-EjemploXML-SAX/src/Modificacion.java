import java.math.BigDecimal;


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
	
    public void aceptar(String etiqueta, String valor) throws Exception {
        if (etiqueta.equals("Servicio"))
            this.setServicio(valor);
        if (etiqueta.equals("PorPrograma"))
            this.setPorPrograma(valor);
        if (etiqueta.equals("Economica"))
            this.setEconomica(valor);
        if (etiqueta.equals("CodModificacion"))
            this.setCodModificacion(valor);
        if (etiqueta.equals("Importe"))
            this.setImporte(new BigDecimal(valor.replace(',', '.')));
    }


	public String toString() {
		return "Modificacion:" + "\nServicio: " + this.getServicio()
				+ "\nPor programa: " + this.getPorPrograma() + "\nEconomica: "
				+ this.getEconomica() + "\nCódigo modificación: "
				+ this.getCodModificacion() + "\nImporte: " + this.getImporte();
	}

}
