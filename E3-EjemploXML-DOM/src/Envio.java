import org.w3c.dom.Document;

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
	
    public void aceptar(Document documento) throws Exception {
        this.getCabeceraEnvio().aceptar(documento);
        this.getDocumentoContable().aceptar(documento);
    }

	public String toString() {
		return "Envio TELCON\n" + this.getCabeceraEnvio() + "\n"
				+ this.getDocumentoContable();
	}
}
