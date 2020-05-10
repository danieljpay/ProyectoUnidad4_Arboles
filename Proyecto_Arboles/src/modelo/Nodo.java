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
    Egresado egresado;
    Nodo enlace;
    
    //constructor
    public Nodo(Egresado dato) {
       this.index = 0;
       this.egresado = dato;
       this.enlace = null;
    }
    
    //getters
    public int getIndex() {
        return index;
    }
    
    public Egresado getEgresado() {
        return egresado;
    }

    public Nodo getEnlace() {
        return enlace;
    }
    
    //setters
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setEgresado(Egresado dato) {
        this.egresado = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
