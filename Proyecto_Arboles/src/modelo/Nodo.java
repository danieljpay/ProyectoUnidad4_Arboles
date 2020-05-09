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
    Egresado dato;
    Nodo enlace;
    
    //constructor
    public Nodo(Egresado dato) {
       this.dato = dato;
       this.enlace = null;
    }
    
    //getters
    public Egresado getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }
    
    //setters
    public void setDato(Egresado dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
