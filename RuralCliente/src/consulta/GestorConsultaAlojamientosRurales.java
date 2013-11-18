package consulta;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class GestorConsultaAlojamientosRurales {
	@WebMethod
	public Integer obtenerPrecioPorPersona() {
		return 50;
	}
}

