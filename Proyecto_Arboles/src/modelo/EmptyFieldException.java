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
public class EmptyFieldException extends Exception{

    public EmptyFieldException(String message) {
        super("Los campos seleccionados están vacíos");
    }
    
}
