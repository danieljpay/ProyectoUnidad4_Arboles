/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author plupy
 */
public class Egresado {
    private String nombre;
    private String profesion;
    private float promedio;

    public Egresado(String nombre, String profesion, float promedio) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.promedio = promedio;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public float getPromedio() {
        return promedio;
    }
    
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Egresado {" + "nombre= " + nombre + ", profesion= " + profesion + ", promedio= " + promedio + '}';
    }
    
    
}


