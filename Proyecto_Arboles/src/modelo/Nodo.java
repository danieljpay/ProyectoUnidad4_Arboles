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
public class Nodo {
    int index;
    Egresado dato;
    Nodo enlace;
    
    //constructor
    public Nodo(Egresado dato) {
       this.index = 0;
       this.dato = dato;
       this.enlace = null;
    }
    
    //getters
    public int getIndex() {
        return index;
    }
    
    public Egresado getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }
    
    //setters
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setDato(Egresado dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
