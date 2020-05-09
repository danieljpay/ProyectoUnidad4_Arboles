package aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import modelo.CSV;
import modelo.Egresado;
import modelo.ListaSimpleLigada;
import modelo.Nodo;

/**
 *
 * @author plupy
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception {
        CSV datos = new CSV();
        String ruta = "Egresados.csv";
        
        ListaSimpleLigada matriculados = new ListaSimpleLigada();
        System.out.println("comencemos leyendo el csv: ");
        datos.readCSV(ruta, matriculados);
        
        System.out.println(matriculados.toString());
        
        System.out.println("Obtengamos el nodo 2");
        
        Nodo obtenido;
        obtenido = matriculados.obt(4);
        System.out.println(obtenido.getDato().toString());
        
    }
    
}
