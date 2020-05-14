package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author plupy
 */
public class CSV {
    boolean cargadoCorrectamente=false;
    
    public void readCSV(String ruta, ListaSimpleLigada destino) throws IOException{
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
                Egresado newEgresado = new Egresado(nombre, profesion, promedio);
                //se inserta en la lista
                Nodo newNodo = new Nodo(newEgresado);
                destino.insertarFin(newNodo);
                
                //volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
            bufferLectura.close();
            System.out.println("Datos cargados\n");
            JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
            cargadoCorrectamente = true;
        }
        catch(IOException e){
            System.out.println("No se pudieron cargar los datos\n");
            cargadoCorrectamente = false;
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los archivos, revisa la ruta");
        }
    }
    
    public boolean confirmacionDatosCargados(){
        return cargadoCorrectamente;
    }
}
