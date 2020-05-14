/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;
 
import java.util.*;

/**
 * Write a description of class Raiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ArbolB
{
    public static int grado;
    public Nodo primerNodo;
    public static boolean esRaiz;
    public static int nivel = 1;
    public static int imprimir = 1;
    public static String arbol = "";
    public ArrayList<String> ingresados = new ArrayList<String>();
    public ArrayList<ArrayList> referencias = new ArrayList<ArrayList>();
    
    public ArbolB(int grado){
        this.grado = grado;
        primerNodo = new Nodo ();
        esRaiz = true;
    }
    
    public void insertar (String valor, int n) {
        ArrayList tempArray = new ArrayList();
        boolean adentro = false;
        for (int i = 0; i < ingresados.size(); i++) {
            if(valor.compareTo(ingresados.get(i)) == 0){
                tempArray = referencias.get(i);
                tempArray.add(n);
                referencias.set(i, tempArray);
                adentro=true;
            }
        }
        if (!adentro) {
            if (primerNodo.tengoHijos==false) {
                int j = 0;
                for (int i = 0; i<primerNodo.valores.length; i++) {
                    if (primerNodo.valores[i] == null) {
                       primerNodo.valores[i] = valor;
                       ingresados.add(valor);
                       tempArray.add(n);
                       referencias.add(tempArray);    //aqui esta el error que no me deja crear el arbol
                       j = i;
                       ordenar(primerNodo.valores,6);
                       break;
                    }
                }
                if (j == 2*grado) {
                    split(primerNodo);
                }
            } else {
                setTengoHijos(primerNodo);
                ingresarEnHijos(primerNodo, valor, n);
            }   
        }
    }
    
    public void ordenar(String arr[], int longitud){
        longitud = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
               longitud++;
            }
            else{
                break;
            }
        }
        for(int ord = 0; ord < longitud; ord++){
            for(int ord1 = 0; ord1 < longitud - 1 ; ord1++){
                if(arr[ord1].compareTo( arr[ord1 + 1] ) < 0){
                    String tmp = arr[ord1];
                    arr[ord1] = arr[ord1+1];
                    arr[ord1+1] = tmp;
                }
            }
        }
    }
    
    public void setTengoHijos (Nodo nodo) {
        if (nodo == primerNodo) {
            if (primerNodo.nodo[0]!= null) {
                primerNodo.tengoHijos = true;
            } 
        }
        for (int i = 0; i<nodo.nodo.length; i++) {
            if (nodo.nodo[i] != null) {
                nodo.tengoHijos = true;
                setTengoHijos(nodo.nodo[i]);
            }
        }
    }
    
    public void ingresarEnHijos(Nodo conHijos, String valor, int n) {
        boolean entro = false;
        if(conHijos != null && !conHijos.tengoHijos){
            ubicarValorEnArreglo(conHijos, valor, n);
            entro = true;
        }
        for(int i = 0; conHijos != null && i < 2*grado + 1  && !entro; i++){
            entro = true;
            ingresarEnHijos(conHijos.nodo[i], valor, n);
            i = 2*grado;
        } 
    }
    
    public void ubicarValorEnArreglo(Nodo nodoA, String valor, int n){
        int cont = 0;
        ArrayList tempArray = new ArrayList();
        while(cont <= 2*grado){
            if (nodoA.valores[cont] == null) { 
                nodoA.valores[cont]=valor;
                ordenar(nodoA.valores, 5);
                ingresados.add(valor);
                tempArray.add(n);
                referencias.add(tempArray);
                if (cont == 2*grado) {
                    split(nodoA);
                }
                break;
            }
            cont++;
        }
    }
    
    public void ordenarNodos(Nodo aOrdenar){
       int i,j;
       i = 0;
       Nodo tmp;
       
       while(i < 2 * grado + 3 && aOrdenar.nodo[i] != null){
           j = 0;
           while(j < 2 * grado +2  && aOrdenar.nodo[j] != null && aOrdenar.nodo[j+1] != null){
               if(aOrdenar.nodo[j].valores[0].compareTo( aOrdenar.nodo[j+1].valores[0] ) < 0){
                   tmp = aOrdenar.nodo[j];
                   aOrdenar.nodo[j] = aOrdenar.nodo[j+1];
                   aOrdenar.nodo[j+1] = tmp;
                }
                j++;
            }
            i++;
        }   
    }
    
    public void split (Nodo nodo) {
       
        Nodo hijoIzq = new Nodo();
        Nodo hijoDer = new Nodo();
        
        //split general 
        if (nodo.nodo[0]!=null) { //si tiene hijos antes de hacer el split entonces
            for (int i = 0; i <grado+1; i++) { // los separa los hijos del nodo en hijoIzq e hijoDer
                hijoIzq.nodo[i] = nodo.nodo[i];
                hijoIzq.nodo[i].padre = hijoIzq;
                nodo.nodo[i] = null;
                hijoDer.nodo[i] = nodo.nodo[grado+1+i];
                hijoDer.nodo[i].padre = hijoDer;
                nodo.nodo[grado+1+i] = null;
            }
        }

        for (int i =0; i<grado; i++){ //guarda los valores en hijoIzq e hijoDer
            hijoIzq.valores[i] = nodo.valores[i];
            nodo.valores[i] = null;
            hijoDer.valores[i] = nodo.valores[grado+1+i];
            nodo.valores[grado+1+i] = null;
        }
        nodo.valores[0] = nodo.valores[grado];
        nodo.valores[grado] = null; //queda en nodo solo el valor que "subio"
        
        nodo.nodo[0] = hijoIzq; //asigna a nodo el nuevo hijo izquierdo (hijoIzq)
        nodo.nodo[0].padre = nodo; // se hizo en primer ciclo
        nodo.nodo[1] = hijoDer; // asigna a nodo el nuevo hijo derecho (hijoDer)
        nodo.nodo[1].padre = nodo; // se hizo en el primer ciclo        
        setTengoHijos(primerNodo);
        ordenarNodos(nodo);
        

        if (nodo.padre!=null) { // luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al padre
            boolean subido = false;
            for (int i = 0; i<nodo.padre.valores.length && subido==false; i++) {
                if (nodo.padre.valores[i] == null){
                    nodo.padre.valores[i] = nodo.valores[0];
                    subido = true;
                    nodo.valores[0] = null;
                    ordenar(nodo.padre.valores, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i<2*grado+3 ; i++) {
                if (nodo.padre.nodo[i]!=null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            nodo.padre.nodo[posHijos] = nodo.nodo[0];
            nodo.padre.nodo[posHijos+1] = nodo.nodo[1];
            nodo.padre.nodo[posHijos].padre = nodo.padre;
            nodo.padre.nodo[posHijos+1].padre = nodo.padre;
            int aqui = 0;
            
            Nodo papa = nodo.padre;
            nodo = null;
            int j = aqui;
            while (j<2*grado+2 && papa.nodo[j]!=null && papa.nodo[j+1]!=null) {
                papa.nodo[j] = papa.nodo[j+1];
                j++;
            }
            papa.nodo[j] = null;
            ordenar(papa.valores,5);
            ordenarNodos(papa);
            if (papa.valores[2*grado] != null) {
                split(papa);
            }
        }
    }
      
    public ArrayList buscar(String valor){
        ArrayList encontrados = null;
        boolean esta = false;
        for(int i = 0; i < ingresados.size(); i++){
            if(ingresados.get(i).compareTo(valor) == 0){
                esta = true;
                System.out.println("El elemento buscado sí se encuentra en el arbol B");
                encontrados = referencias.get(i);
                return encontrados;
            }
        }
        System.out.println("El elemento buscado no se encuentra en el arbol B");
        return encontrados;
    }
    
    public String recorrer(Nodo nodo) {
        String raiz = "raiz [ ";
        for(int i = 0; i < primerNodo.valores.length; i++){
            if(primerNodo.valores[i] != null){
                raiz += primerNodo.valores[i] + ", ";
            }
        }
        raiz += " ]\n";
        System.out.println(raiz);
        
         arbol += "\n";
        for (int i =0; i<2*grado+1; i++) {
            if (nodo.nodo[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {
                    imprimir ++;
                }
                recorrer(nodo.nodo[i]);
            }
            arbol += "[ ";
            for (int j = 0; nodo.nodo[i]!=null && j<nodo.nodo[i].valores.length; j++) {
                if (nodo.nodo[i].valores[j] != null) {
                    arbol += nodo.nodo[i].valores[j] + ", ";
                }
            }
            arbol += " ]";
        }
        if (arbol.length() > (2*grado+3)*4) {
            System.out.println (arbol);
            return arbol;
        }
        return arbol;
    }
    public String llamarRecorrer() {
        String mostrar = recorrer(primerNodo);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }
    
    public boolean esNumero(String s){
    try{
       Integer.parseInt(s);
       return true;
    }catch(NumberFormatException e){
        return false;
    }
    }
}
