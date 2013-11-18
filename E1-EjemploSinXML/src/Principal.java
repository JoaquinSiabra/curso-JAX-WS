
import lector.*;
import domain.Envio;

public class Principal {
		
	public static void main(String[] args) {
		
		LectorTextoPlano lectorTextoPlano = new LectorTextoPlano(
				Principal.class.getClassLoader().getResource("envio.txt").getFile());
		
		try {
			Envio envio = lectorTextoPlano.leerEnvio();
			System.out.println(envio);		
		} catch (Exception e) {
			System.out.println("No se ha podido leer el fichero.");
		}
		
	}
	
}
