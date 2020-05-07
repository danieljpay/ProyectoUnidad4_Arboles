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
        
        System.out.println("Esto debería imprimir a Alex: ");
        System.out.println(totalEgresados.get(2).toString());
        System.out.println("Esto debería imprimir a Daniel: ");
        System.out.println(totalEgresados.get(0).toString());
        System.out.println("Esto debería imprimir a Jimmy: ");
        System.out.println(totalEgresados.get(1).toString());
    }
    
}
