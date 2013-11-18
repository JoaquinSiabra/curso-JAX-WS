package lector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import domain.CabeceraDocumentoContable;
import domain.CabeceraEnvio;
import domain.CuerpoDocumentoContable;
import domain.DocumentoContable;
import domain.Envio;
import domain.Modificacion;

public class LectorTextoPlano {

	private String fichero;

	public LectorTextoPlano(String fichero) {
		this.fichero = fichero;
	}
	
	public String getFichero() {
		return fichero;
	}

		
	public Envio leerEnvio() throws Exception {
		
		Envio envio = new Envio();
		
		DocumentoContable documentoContable = envio.getDocumentoContable();
		CabeceraDocumentoContable cabeceraDocumentoContable = documentoContable.getCabeceraDocumentoContable();
		CuerpoDocumentoContable cuerpoDocumentoContable = documentoContable.getCuerpoDocumentoContable();
		
		FileReader fr = new FileReader(getFichero());
		BufferedReader br = new BufferedReader(fr);
		
		envio.setCabeceraEnvio(leerCabeceraEnvio(br));
		
		//Lectura de la cabecera del documento
		//No podemos refactorizarlo en una funcion, porque el dato "numero de aplicaciones",
		//que se necesita para construir el cuerpo del documento,
		//esta incrustado en medio de los datos de la cabecera
		//ESTAMOS CONDICIONADOS POR LA ESTRUCTURA DEL TEXTO
		String linea = br.readLine();
		cabeceraDocumentoContable.setNumCOE(linea.substring(0, 7));
		cabeceraDocumentoContable.setNumIdTelCon(linea.substring(7, 20));
		cabeceraDocumentoContable.setCodigoMC(linea.substring(32, 35));
		cabeceraDocumentoContable.setDigitoSigno(new Integer(linea.substring(
				36, 37)).intValue());
		linea = br.readLine();
		cabeceraDocumentoContable.setNumOficina(linea.substring(27, 32));
		br.readLine();
		linea = br.readLine();
		cuerpoDocumentoContable.setNumExpediente(linea.substring(24, 29));
		linea = br.readLine();
		int numeroAplicaciones = new Integer(linea.substring(24, 28).trim())
				.intValue(); 
		linea = br.readLine();
		cabeceraDocumentoContable.setEjercicio(new Integer(linea.substring(27,
				31)).intValue());
		br.readLine();
		
		//lectura del cuerpo del documento
		linea = br.readLine();
		cuerpoDocumentoContable.setSeccion(linea.substring(27, 29));
		linea = br.readLine();
		cuerpoDocumentoContable.setImporteTotal(new BigDecimal(linea.substring(
				27, linea.indexOf("#")).replace(',', '.')));
		for (int i = 1; i <= numeroAplicaciones; i++) {  
			Modificacion modificacion = new Modificacion();
			linea = br.readLine();
			modificacion.setServicio(linea.substring(27, 30));
			linea = br.readLine();
			modificacion.setPorPrograma(linea.substring(27, 31));
			linea = br.readLine();
			modificacion.setEconomica(linea.substring(27, linea.indexOf("#")));
			linea = br.readLine();
			modificacion.setCodModificacion(linea.substring(27, 29));
			linea = br.readLine();
			modificacion.setImporte(new BigDecimal(linea.substring(27,
					linea.indexOf("#")).replace(',', '.')));
			cuerpoDocumentoContable.addModificacion(modificacion);
		}
		
		return envio;
	}
	
	private CabeceraEnvio leerCabeceraEnvio(BufferedReader br) throws IOException, ParseException{
		
		CabeceraEnvio cabeceraEnvio = new CabeceraEnvio();
		
		br.readLine(); // la primera línea no tiene información útil
		String linea = br.readLine(); // la segunda contiene el numCOE
		cabeceraEnvio.setNumCOE(linea);
		br.readLine(); // la tercera no tiene información útil
		linea = br.readLine(); // la cuarta contiene la anualidad
		cabeceraEnvio.setAnualidad(new Integer(linea.substring(0,
				linea.indexOf("/"))).intValue());
		linea = br.readLine(); // la quinta contiene la fecha
		cabeceraEnvio.setFechaEnvio(new SimpleDateFormat("dd/MM/yyyy").parse(linea));
		br.readLine();
		br.readLine();
		br.readLine();
				
		return cabeceraEnvio;
	}
}
