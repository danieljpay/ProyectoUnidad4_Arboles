package aplicacion;

import arboles.ArbolABB;
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
        Nodo NodoObtenido;
        int temp=0;
        int[] referencias;
        
        ListaSimpleLigada matriculados = new ListaSimpleLigada();
        System.out.println("comencemos leyendo el csv: ");
        datos.readCSV(ruta, matriculados);
        
        System.out.println(matriculados.toString());
        
        System.out.println("Obtengamos el nodo 5");
        
        NodoObtenido = matriculados.obt(5);
        System.out.println(NodoObtenido.getEgresado().toString());
        
        System.out.println("Comencemos a formar el árbol");
        ArbolABB arbolito = new ArbolABB(matriculados.obt(0).getEgresado().getNombre(), matriculados.obt(0).getIndex());
        for(int i=1; matriculados.obt(i).getEnlace()!= null; i++){
            arbolito.insertar(matriculados.obt(i).getEgresado().getNombre(), i);
            temp=i;
        }
        temp++;
        arbolito.insertar(matriculados.obt(temp).getEgresado().getNombre(), temp);
        arbolito.inOrden();
        
        System.out.println("Busquemos dentro del árbol a Jorge: ");
        referencias = arbolito.buscar("Jorge");
        
        for(int i : referencias){
            System.out.println(matriculados.obt(referencias[i]).getEgresado().toString() + ", " + matriculados.obt(referencias[i]).getEgresado().getProfesion() + ", " + matriculados.obt(referencias[i]).getEgresado().getPromedio());
        }
    }
    
}
