package aplicacion;

import controller.Controller;
import java.io.IOException;
import vista.FrMenu;

/**
 *
 * @author plupy
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception {
        Controller controlador = new Controller();
        FrMenu menuPrincipal = new FrMenu(controlador);
        menuPrincipal.setVisible(true);
    }
    
}
