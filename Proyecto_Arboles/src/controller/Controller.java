/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arboles.ArbolABB;
import arboles.ArbolAVL;
import arboles.ArbolB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.CSV;
import modelo.ListaSimpleLigada;

/**
 *
 * @author plupy
 */
public class Controller {
    CSV datos = new CSV();
    ListaSimpleLigada matriculados = new ListaSimpleLigada();
    ArbolABB arbolitoABBNombres;
    ArbolABB arbolitoABBProfesion;
    ArbolABB arbolitoABBPromedio;
    
    ArbolAVL arbolitoAVLNombres;
    ArbolAVL arbolitoAVLProfesion;
    ArbolAVL arbolitoAVLPromedio;
    
    ArbolB arbolitoBNombres;
    ArbolB arbolitoBProfesion;
    ArbolB arbolitoBPromedio;
    
    //constructor
    public Controller() {
    }

    //getters
    public CSV getDatos() {
        return datos;
    }

    public ListaSimpleLigada getMatriculados() {
        return matriculados;
    }

    //setters
    public void setDatos(CSV datos) {
        this.datos = datos;
    }

    public void setMatriculados(ListaSimpleLigada matriculados) {
        this.matriculados = matriculados;
    }
    
    //comparacion de arraylist
    public ArrayList compareReference(ArrayList referenceOne, ArrayList referenceTwo){
        ArrayList coincidencias = new ArrayList();
        for (int i = 0; i < referenceOne.size(); i++) {  //recorrer el arraylist
            for (int j = 0; j < referenceTwo.size(); j++) {
                if (referenceOne.get(i)==referenceTwo.get(j)) {     //si son iguales
                   coincidencias.add(referenceTwo.get(j));//lo guardo en coincidencias
                }   
            }
        }
        return coincidencias;
    }
    
    //impresion en jTable
    public void imprimirEnTabla(DefaultTableModel modelito, ArrayList referencias) throws Exception{
        modelito.setColumnCount(0);
        modelito.setRowCount(0);
        modelito.addColumn("Nombre");
        modelito.addColumn("Profesión");
        modelito.addColumn("Promedio");
        String[] flecha = new String[3];
        ArrayList tempArray = referencias;
        for(int i=0; i<tempArray.size(); i++){
            flecha[0]=matriculados.obt((int) tempArray.get(i)).getEgresado().getNombre() ;
            flecha[1]=matriculados.obt((int) tempArray.get(i)).getEgresado().getProfesion();
            flecha[2]=matriculados.obt((int) tempArray.get(i)).getEgresado().getPromedio()+"";
            modelito.addRow(flecha);
        }
    }
    
    //*********************************arbol ABB********************************
    
    public void crearArbolesABB() throws Exception{
        int temp=0;
        arbolitoABBNombres = new ArbolABB(matriculados.obt(0).getEgresado().getNombre(), matriculados.obt(0).getIndex());
        arbolitoABBProfesion = new ArbolABB(matriculados.obt(0).getEgresado().getProfesion(), matriculados.obt(0).getIndex());
        arbolitoABBPromedio = new ArbolABB(matriculados.obt(0).getEgresado().getPromedio()+"", matriculados.obt(0).getIndex());
        for(int i=1; matriculados.obt(i).getEnlace()!= null; i++){
            arbolitoABBNombres.insertar(matriculados.obt(i).getEgresado().getNombre(), i);
            arbolitoABBProfesion.insertar(matriculados.obt(i).getEgresado().getProfesion(), i);
            arbolitoABBPromedio.insertar(matriculados.obt(i).getEgresado().getPromedio()+"", i);
            temp=i;
        }
        temp++;
        arbolitoABBNombres.insertar(matriculados.obt(temp).getEgresado().getNombre(), temp);
        arbolitoABBProfesion.insertar(matriculados.obt(temp).getEgresado().getProfesion(), temp);
        arbolitoABBPromedio.insertar(matriculados.obt(temp).getEgresado().getPromedio()+"", temp);
        
        arbolitoABBNombres.inOrden();
        System.out.println("------------------");
        arbolitoABBProfesion.inOrden();
        System.out.println("------------------");
        arbolitoABBPromedio.inOrden();
    }
    
    public ArbolABB getArbolABBNombres(){
        return arbolitoABBNombres;
    }
    
    public ArbolABB getArbolABBProfesion(){
        return arbolitoABBProfesion;
    }
    
    public ArbolABB getArbolABBPromedio(){
        return arbolitoABBPromedio;
    }
    
    public ArrayList treeABBCreatedSearch(String nombre, ArbolABB arbolito) throws Exception{
        ArrayList tempArray = null;
        try{
            String cadena = "";
            tempArray = arbolito.buscar(nombre);
            for (int i = 0; i < tempArray.size(); i++) {
                cadena += tempArray.get(i) + " ";
            }
            System.out.println(cadena);
            for (int i = 0; i < tempArray.size(); i++) {
                System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
            }
            System.out.println("");
            return tempArray;
        }
        catch(Exception e){
            System.out.println(nombre + " no fue encontrado");
        }   
        return tempArray;
    }
    
    //***********************************arbol AVL********************************************
    
    public void crearArbolesAVL() throws Exception{
        int temp=0;
        arbolitoAVLNombres = new ArbolAVL(matriculados.obt(0).getEgresado().getNombre(), matriculados.obt(0).getIndex());
        arbolitoAVLProfesion = new ArbolAVL(matriculados.obt(0).getEgresado().getProfesion(), matriculados.obt(0).getIndex());
        arbolitoAVLPromedio = new ArbolAVL(matriculados.obt(0).getEgresado().getPromedio()+"", matriculados.obt(0).getIndex());
        for(int i=1; matriculados.obt(i).getEnlace()!= null; i++){
            arbolitoAVLNombres.insertar(matriculados.obt(i).getEgresado().getNombre(), i);
            arbolitoAVLProfesion.insertar(matriculados.obt(i).getEgresado().getProfesion(), i);
            arbolitoAVLPromedio.insertar(matriculados.obt(i).getEgresado().getPromedio()+"", i);
            temp=i;
        }
        temp++;
        arbolitoAVLNombres.insertar(matriculados.obt(temp).getEgresado().getNombre(), temp);
        arbolitoAVLProfesion.insertar(matriculados.obt(temp).getEgresado().getProfesion(), temp);
        arbolitoAVLPromedio.insertar(matriculados.obt(temp).getEgresado().getPromedio()+"", temp);
        arbolitoAVLNombres.inOrden();
        System.out.println("------------------");
        arbolitoAVLProfesion.inOrden();
        System.out.println("------------------");
        arbolitoAVLPromedio.inOrden();
    }
    
    public ArbolAVL getArbolAVLNombres(){
        return arbolitoAVLNombres;
    }
    
    public ArbolAVL getArbolAVLProfesion(){
        return arbolitoAVLProfesion;
    }
    
    public ArbolAVL getArbolAVLPromedio(){
        return arbolitoAVLPromedio;
    }
    
    public ArrayList treeAVLCreatedSearch(String nombre, ArbolAVL arbolito) throws Exception{
        ArrayList tempArray = null;
        try{
            String cadena = "";
            tempArray = arbolito.buscar(nombre);
            for (int i = 0; i < tempArray.size(); i++) {
                cadena += tempArray.get(i) + " ";
            }
            System.out.println(cadena);
            for (int i = 0; i < tempArray.size(); i++) {
                System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
            }
            System.out.println("");
            return tempArray;
        }
        catch(Exception e){
            System.out.println(nombre + " no fue encontrado");
        }   
        return tempArray;
    }
    
    //***********************************arbol B********************************************
    public void crearArbolesB() throws Exception{
        int temp=0;
        arbolitoBNombres = new ArbolB(3);
        arbolitoBPromedio = new ArbolB(3);
        arbolitoBProfesion = new ArbolB(3);
        for(int i=1; matriculados.obt(i).getEnlace()!= null; i++){
            arbolitoBNombres.insertar(matriculados.obt(i).getEgresado().getNombre(), i);
            arbolitoBProfesion.insertar(matriculados.obt(i).getEgresado().getProfesion(), i);
            arbolitoBPromedio.insertar(matriculados.obt(i).getEgresado().getPromedio()+"", i);
            temp=i;
        }
        temp++;
        arbolitoBNombres.insertar(matriculados.obt(temp).getEgresado().getNombre(), temp);
        arbolitoBProfesion.insertar(matriculados.obt(temp).getEgresado().getProfesion(), temp);
        arbolitoBPromedio.insertar(matriculados.obt(temp).getEgresado().getPromedio()+"", temp);
        arbolitoBNombres.llamarRecorrer();
        System.out.println("------------------");
        arbolitoBProfesion.llamarRecorrer();
        System.out.println("------------------");
        arbolitoBPromedio.llamarRecorrer();
    }
    
    public ArbolB getArbolBNombres(){
        return arbolitoBNombres;
    }
    
    public ArbolB getArbolBProfesion(){
        return arbolitoBProfesion;
    }
    
    public ArbolB getArbolBPromedio(){
        return arbolitoBPromedio;
    }
    
    public ArrayList treeBCreatedSearch(String nombre, ArbolB arbolito) throws Exception{
        ArrayList tempArray = null;
        try{
            String cadena = "";
            tempArray = arbolito.buscar(nombre);
            //muestra indices del arraylist
            for (int i = 0; i < tempArray.size(); i++) {
                cadena += tempArray.get(i) + " ";
            }
            System.out.println(cadena);
            //imprime las referencias de la lista ligada con los arraylist
            for (int i = 0; i < tempArray.size(); i++) {
                System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
            }
            System.out.println("");
            return tempArray;
        }
        catch(Exception e){
            System.out.println(nombre + " no fue encontrado");
        }   
        return tempArray;
    }
}
