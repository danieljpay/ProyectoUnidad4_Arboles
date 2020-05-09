package aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import modelo.CSV;
import modelo.Egresado;

/**
 *
 * @author plupy
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Egresado> totalEgresados = new ArrayList<Egresado>();
        System.out.println("comencemos leyendo el csv: ");
        String ruta = "Egresados.csv";
        CSV datos = new CSV();
        datos.readCSV(ruta, totalEgresados);
        
        for (int i = 0; i < totalEgresados.size(); i++) {
            System.out.println(totalEgresados.get(i).toString());
        }
    }
    
}
