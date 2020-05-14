/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.*;

public class Lista
{
    // instance variables - replace the example below with your own
    public ArrayList<String> ingresados = new ArrayList<String>();
    public ArrayList<ArrayList<String>> referencias = new ArrayList<ArrayList<String>>();


    public Lista(){
       ingresados = new ArrayList<String>();
    }
    
    /*public boolean buscar(String valor){
        boolean esta = false;
        for (int i = 0; i < ingresados.size() && !esta; i++){
            if (ingresados.get(i).compareTo(valor) == 0){
                esta = true;
            }
        }
        return esta;
        
    }*/
}