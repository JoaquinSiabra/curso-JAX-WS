
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
	
    public void aceptar(String etiqueta, String valor) throws Exception {
        this.getCabeceraDocumentoContable().aceptar(etiqueta, valor);
        this.getCuerpoDocumentoContable().aceptar(etiqueta, valor);
    }


	public String toString() {
		return "Documento contable\n" + this.getCabeceraDocumentoContable()
				+ "\n" + this.getCuerpoDocumentoContable();
	}
}
