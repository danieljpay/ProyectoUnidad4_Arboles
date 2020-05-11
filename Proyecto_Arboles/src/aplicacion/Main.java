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
<<<<<<< HEAD
        ArrayList tempArray = new ArrayList();
=======
        int[] referencias;
>>>>>>> refs/remotes/origin/master
        
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
        
<<<<<<< HEAD
        tempArray = arbolito.buscar("Jorge");
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(tempArray.get(i));
        }
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
        }
        
        tempArray = arbolito.buscar("Daniel");
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(tempArray.get(i));
        }
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
        }
        
        tempArray = arbolito.buscar("Karen");
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(tempArray.get(i));
        }
        for (int i = 0; i < tempArray.size(); i++) {
            System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
=======
        System.out.println("Busquemos dentro del árbol a Jorge: ");
        referencias = arbolito.buscar("Jorge");
        
        for(int i : referencias){
            System.out.println(matriculados.obt(referencias[i]).getEgresado().toString() + ", " + matriculados.obt(referencias[i]).getEgresado().getProfesion() + ", " + matriculados.obt(referencias[i]).getEgresado().getPromedio());
>>>>>>> refs/remotes/origin/master
        }
    }
    
}
