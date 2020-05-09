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
        
        String tempNombree = "Victor";
        String tempProfesione = "arquitecto";
        float tempPromedioe = (float) 9.3;
        Egresado tempEgresadoe = new Egresado(tempNombree, tempProfesione, tempPromedioe);
        Nodo tempNodoe = new Nodo(tempEgresadoe);
        matriculados.insertarInicio(tempNodoe);
        
        String tempNombrex = "Alan";
        String tempProfesionx = "arquitecto";
        float tempPromediox = (float) 9.3;
        Egresado tempEgresadox = new Egresado(tempNombrex, tempProfesionx, tempPromediox);
        Nodo tempNodox = new Nodo(tempEgresadox);
        matriculados.insertarFin(tempNodox);
        
        String tempNombre = "Oswaldo";
        String tempProfesion = "arquitecto";
        float tempPromedio = (float) 9.3;
        Egresado tempEgresado = new Egresado(tempNombre, tempProfesion, tempPromedio);
        Nodo tempNodo = new Nodo(tempEgresado);
        matriculados.insertarInicio(tempNodo);
        
        String tempNombrea = "Gabo";
        String tempProfesiona = "arquitecto";
        float tempPromedioa = (float) 9.3;
        Egresado tempEgresadoa = new Egresado(tempNombrea, tempProfesiona, tempPromedioa);
        Nodo tempNodoa = new Nodo(tempEgresadoa);
        matriculados.insertarFin(tempNodoa);
        
        
        System.out.println(matriculados.toString());
        
    }
    
}
