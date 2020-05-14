/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.ArrayList;

public class Nodo
{
    public String []valores;
    public Nodo []nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public Nodo padre;
    
    public Nodo(){
       nodo = new Nodo [ArbolB.grado * 2 + 3];
       valores = new String [ArbolB.grado * 2 + 1];
    }
    
}