package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author plupy
 */
public class ListaSimpleLigada {
    private Nodo head;
    private int indice=0;
    
    //constructor
    public ListaSimpleLigada() {
        this.head = null;
    }
    
    //Insertar nodo al incio
    public void insertarInicio(Nodo unNodo){
        Nodo nodoAhora;
        int enumeracion=0;
        
        if(this.head == null){
            head = unNodo;
        }
        else{
            unNodo.setEnlace(this.head);
            Nodo aux = this.head;
            this.head = unNodo;
            unNodo = aux;
            
            nodoAhora = this.head;
            while (nodoAhora.getEnlace() != null) {
                nodoAhora.setIndex(enumeracion);
                enumeracion++;
                nodoAhora = nodoAhora.getEnlace();
            }
            nodoAhora.setIndex(enumeracion);
            this.indice = enumeracion;
        }
        
    }
    
    //Insertar nodo al final
    public void insertarFin(Nodo unNodo){
        Nodo nodoAhora = this.head;
        
        if(nodoAhora == null){
            this.head = unNodo;
        }
        else{
            indice++;
            unNodo.setIndex(indice);
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
    }
    
    //obtener nodo N
    public Nodo obt(int number) throws Exception {
        Nodo nodoAhora = this.head;
        Nodo encontrado = null; //poner en función recibidora que si recibe null es que no existe el nodo
        
        if( number == this.head.getIndex() ){
            encontrado = this.head;
            return encontrado;
        } else {
            while(nodoAhora.getEnlace() != null){
                nodoAhora = nodoAhora.getEnlace();
                if(number == nodoAhora.getIndex()){
                    encontrado = nodoAhora;
                    return encontrado;
                }
            }
        }

        if (encontrado == null) {
            throw new Exception("no existe ese nodo");
        }
        return encontrado;
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
                cadenita += nodoAhora.getIndex() +  " " + nodoAhora.getDato() + " -> ";
                nodoAhora = nodoAhora.getEnlace();
            } 
            cadenita += nodoAhora.getIndex() + " " + nodoAhora.getDato();
            return cadenita;
        }
        
    }
}
