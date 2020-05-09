package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author plupy
 */
public class ListaSimpleLigada {
    private Nodo head = null;
    
    //constructor
    public ListaSimpleLigada(Nodo head) {
        this.head = head;
    }
    
    //Insertar nodo al incio
    public void insertarInicio(Nodo unNodo){
        unNodo.setEnlace(this.head);
        Nodo aux = this.head;
        this.head = unNodo;
        unNodo = aux;
    }
    
    //Insertar nodo al final
    public void insertarFin(Nodo unNodo){
        Nodo nodoAhora = this.head;     
        
        if(nodoAhora.getEnlace() == null){
            nodoAhora.setEnlace(unNodo);
        }
        else{
            while(nodoAhora.getEnlace() != null){     
                nodoAhora = nodoAhora.getEnlace();   
            }   
            nodoAhora.setEnlace(unNodo);
        }  
    }
    
    //imprimir los nodos en la lista
    public String toString() {
        Nodo nodoAhora = this.head;
        String cadenita = " ";
        if(nodoAhora == null){
            return cadenita;
        }
        else{
            while(nodoAhora.getEnlace() != null){
                cadenita += nodoAhora.getDato() + " -> ";
                nodoAhora = nodoAhora.getEnlace();
            } 
            cadenita += nodoAhora.getDato();
            return cadenita;
        }
        
    }
}
