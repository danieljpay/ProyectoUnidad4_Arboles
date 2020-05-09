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
    public static void main(String[] args) throws IOException {
        CSV datos = new CSV();
        String ruta = "Egresados.csv";
        
        ListaSimpleLigada matriculados = new ListaSimpleLigada();
        System.out.println("comencemos leyendo el csv: ");
        datos.readCSV(ruta, matriculados);
        
        /*String tempNombre = "Oswaldo";
        String tempProfesion = "arquitecto";
        float tempPromedio = (float) 9.3;
        Egresado tempEgresado = new Egresado(tempNombre, tempProfesion, tempPromedio);
        Nodo tempNodo = new Nodo(tempEgresado);
        matriculados.insertarInicio(tempNodo);*/
        
        
        System.out.println(matriculados.toString());
        
    }
    
}
