package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author plupy
 */
public class CSV {
    public void readCSV(String ruta){
        String separator = ",";
        BufferedReader bufferLectura = null;
        try{
            //abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(ruta));
            
            //leer una linea del archivo
            String linea = bufferLectura.readLine();
            
            while(linea != null){
                //separar la linea leída con el separador definido previamente
                String[] campos = linea.split(separator);
                
                System.out.println(Arrays.toString(campos));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
