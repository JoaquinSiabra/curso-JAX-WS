package domain;


public class DocumentoContable {
	
	private CabeceraDocumentoContable cabecera;
	private CuerpoDocumentoContable cuerpo;

	public CabeceraDocumentoContable getCabeceraDocumentoContable() {
		return cabecera;
	}

	public void setCabeceraDocumentoContable(CabeceraDocumentoContable cabecera) {
		this.cabecera = cabecera;
	}

	public CuerpoDocumentoContable getCuerpoDocumentoContable() {
		return cuerpo;
	}

	public void setCuerpoDocumentoContable(CuerpoDocumentoContable cuerpo) {
		this.cuerpo = cuerpo;
	}

	public DocumentoContable() {
		this.setCabeceraDocumentoContable(new CabeceraDocumentoContable());
		this.setCuerpoDocumentoContable(new CuerpoDocumentoContable());
	}

	public String toString() {
		return "Documento contable\n" + this.getCabeceraDocumentoContable()
				+ "\n" + this.getCuerpoDocumentoContable();
	}
}
