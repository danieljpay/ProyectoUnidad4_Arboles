/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arboles.ArbolABB;
import arboles.ArbolAVL;
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
    
    //jTable
    public void imprimirEnTabla(DefaultTableModel modelito, String nombre, ArbolABB arbolito) throws Exception{
        modelito.setColumnCount(0);
        modelito.setRowCount(0);
        modelito.addColumn("Nombre");
        modelito.addColumn("Profesión");
        modelito.addColumn("Promedio");
        String[] flecha = new String[3];
        ArrayList tempArray = arbolito.buscar(nombre);
        for(int i=0; i<tempArray.size(); i++){
            flecha[0]=matriculados.obt((int) tempArray.get(i)).getEgresado().getNombre() ;
            flecha[1]=matriculados.obt((int) tempArray.get(i)).getEgresado().getProfesion();
            flecha[2]=matriculados.obt((int) tempArray.get(i)).getEgresado().getPromedio()+"";
            modelito.addRow(flecha);
        }
    }
    
    //arbolABB
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
    
    public void treeCreatedSearch(String nombre, ArbolABB arbolito) throws Exception{
        try{
            String cadena = "";
            ArrayList tempArray;
            tempArray = arbolito.buscar(nombre);
            for (int i = 0; i < tempArray.size(); i++) {
                cadena += tempArray.get(i) + " ";
            }
            System.out.println(cadena);
            for (int i = 0; i < tempArray.size(); i++) {
                System.out.println(matriculados.obt((int)tempArray.get(i)).getEgresado().getNombre() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getProfesion() + ", " + matriculados.obt((int)tempArray.get(i)).getEgresado().getPromedio());
            }
            System.out.println("");
        }
        catch(Exception e){
            System.out.println(nombre + " no fue encontrado");
        }   
    }
    
    //arbolAVL
    
    
}
