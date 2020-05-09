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
    public void readCSV(String ruta, ArrayList<Egresado> destino) throws IOException{
        /*  fuente:  thttp://www.programandoapasitos.com/2017/04/como-leer-fichero-csv-con-java.htmlhtp://www.programandoapasitos.com/2017/04/como-leer-fichero-csv-con-java.html */
        String separator = ",";
        String nombre;
        String profesion;
        float promedio;
        BufferedReader bufferLectura = null;
        try{
            //abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(ruta));
            
            //leer una linea del archivo
            String linea = bufferLectura.readLine();
            
            //se salta una linea para que no lea titulos
            linea = bufferLectura.readLine();
            
            while (linea != null) {
                //separar la linea leída con el separador definido previamente
                String[] campos = linea.split(separator);
                nombre = campos[0];
                profesion = campos[1];
                promedio = Float.parseFloat(campos[2]);
                destino.add(new Egresado(nombre, profesion, promedio));
                
                //volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
            
            bufferLectura.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
