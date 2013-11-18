package domain;

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

	public String toString() {
		return "Modificacion:" + "\nServicio: " + this.getServicio()
				+ "\nPor programa: " + this.getPorPrograma() + "\nEconomica: "
				+ this.getEconomica() + "\nCódigo modificación: "
				+ this.getCodModificacion() + "\nImporte: " + this.getImporte();
	}

}
