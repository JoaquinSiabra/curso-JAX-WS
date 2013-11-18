public class Envio {
	private CabeceraEnvio cabeceraEnvio;
	private DocumentoContable documentoContable;

	public CabeceraEnvio getCabeceraEnvio() {
		return cabeceraEnvio;
	}

	public void setCabeceraEnvio(CabeceraEnvio cabeceraEnvio) {
		this.cabeceraEnvio = cabeceraEnvio;
	}

	public DocumentoContable getDocumentoContable() {
		return documentoContable;
	}

	public void setDocumentoContable(DocumentoContable documentoContable) {
		this.documentoContable = documentoContable;
	}

	public Envio() {
		this.setCabeceraEnvio(new CabeceraEnvio());
		this.setDocumentoContable(new DocumentoContable());
	}
	
    public void aceptar(String etiqueta, String valor) throws Exception {
        this.getCabeceraEnvio().aceptar(etiqueta, valor);
        this.getDocumentoContable().aceptar(etiqueta, valor);
    }


	public String toString() {
		return "Envio TELCON\n" + this.getCabeceraEnvio() + "\n"
				+ this.getDocumentoContable();
	}
}
