/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteinfoficherog;


import clienteservicio.InfoFichero.Descripciones;

import java.util.List;

/**
 *
 * @author aad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try { 
            clienteservicio.WsPrueba service = new clienteservicio.WsPrueba();
            clienteservicio.PruebaServicio port = service.getPruebaPort();
            java.lang.String pathCompletoFichero = "C:\\Cursos\\ServiciosWeb\\Ejercicios\\Instrucciones.txt";
            clienteservicio.InfoFichero oInfoFichero = port.getInfoFichero(pathCompletoFichero);
            Descripciones oDescripciones = oInfoFichero.getDescripciones();
            List<String> oLista = oDescripciones.getCadena();
            String sDescripcion1 = oLista.get(0);
            String sDescripcion2 = oLista.get(1);
            String sDescripcion3 = oLista.get(2);
            System.out.println("Nombre completo = "+oInfoFichero.getNombreCompleto()+ "\n"+
                               "Tamaño = "+oInfoFichero.getTamanio()+ " bytes\n"+
                               "Nombre = "+ sDescripcion1 + "\n" + 
                               "Nombre del padre = "+ sDescripcion2);
            // Otro
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            System.err.println(ex.getMessage());
        }

    }

}
