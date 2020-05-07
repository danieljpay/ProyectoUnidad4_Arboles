package aplicacion;

import java.util.ArrayList;
import modelo.CSV;

/**
 *
 * @author plupy
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("comencemos leyendo el csv: ");
        String ruta = "Egresados.csv";
        CSV datos = new CSV();
        datos.readCSV(ruta);
    }
    
}
