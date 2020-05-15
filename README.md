# Proyecto Árboles (Estructura de datos, unidad 4)
Unidad4_Arboles > Proyecto

## Descripción
Se trata de un programa que es capaz de leer un CSV con nombre, promedio y profesion, al leerlo podrá generar un árbol (ABB, AVL o B) con los datos del CSV ingresado; el árbol deseado lo podrá elegir el usuario dentro del programa y podrá hacer búsquedas (multifiltro si se desea) dentro de el árbol seleccionado.

## La instalación del programa
Lo único que se necesita es tener instalado java dentro de tu PC (si no lo tiene instalado puede consultar la instalación
dentro de los archivos del repositorio, lo encuentra como manual de instalación.docx).

#### Si ya tienes instalado java
Solo tendrás que ejecutar el .jar que se encuentra en el repositorio (lo puedes buscar en Proyecto_Arboles > dist > Perez_Daniel_ProyectoArboles.jar).

## Manual de uso
-Ingresar la ruta del archivo CSV en el campo de búsqueda (El CSV deberá tener una linea de encabezados, es decir, Nombre del alumno, promedio y profesion, en la lineas debajo de los encabezados deberá contener los demás datos).
-Presionar el botón *Cargar datos*.
-Escoger el árbol deseado para acomodar los datos del CSV.
-Seleccionar el campo de búsqueda e ingresar su búsqueda.
-Presionar el botón *Buscar*.
-El programa le mostrará las coincidencias en la búsqueda en la tabla de la derecha.

## ¿Cómo contribuir?
El programa tiene un error el cual no se halló la forma de arreglar
Si se le comenta la siguiente línea que se encuentra en la clase CSV:
´´
//salta linea de titulos
            linea = bufferLectura.readLine();
´´

y se le descomentan las siguientes líneas pertenecientes a la misma clase:

´´
//Detecta si tiene encabezados el csv (version Beta)
            String[] titulos = linea.split(separator);
            if(titulos[0].compareTo("Nombre") == 0 || titulos[0].compareTo("Nombres") == 0 || titulos[0].compareTo("nombre") == 0 || titulos[0].compareTo("nombres") == 0 || titulos[1].compareTo("Profesion") == 0 || titulos[1].compareTo("Profesión") == 0 || titulos[1].compareTo("profesion") == 0 || titulos[1].compareTo("profesión") == 0 || titulos[2].compareTo("Promedio") == 0 || titulos[1].compareTo("promedio") == 0){
                linea = bufferLectura.readLine();
            }
´´

El programa es capaz de detectar si el CSV tiene encabezados y si los detecta se saltará esa linea para que comience a leer el contenido, es decir, los datos.
El problema está en que si se le ingresa un CSV que la primera linea **no** sea de encabezados (nombres, promedio, profesión) este hará la lectura correctamente del CSV, sin embargo, tendrá un problema con el primer dato ingresado; el programa sí hará búsquedas pero tendrá conflicto con el primer dato como por ejemplo que no lo muestre si se le busca o si se repite en algún en el CSV este lo detectará como si fuera distinto, cuando no debería.
Si se selecciona el árbol ABB y debuggeas en la función:
´´
    private void insertarOrdenado(NodoBin n, String o, int b){
        if(o.compareTo( n.getDato() ) == 0){
            n.referencia.add(b);
        }
´´
haciendo búsqueda de nombre, por ejemplo "Daniel"
al comparar el dato Raiz (es decir el nombre "Daniel" del primer dato del CSV) y la repetición del mismo nombre "Daniel", apesar de ser el mismo string, este no detectará que es el mismo y creará otro nodo dentro del árbol con el mismo nombre, es esto lo que causa conflictos en la búsqueda.

**_Esto solo pasa cuando le activas la detección de encabezados y le ingresas un CSV sin encabezados._**

### License
MIT License
