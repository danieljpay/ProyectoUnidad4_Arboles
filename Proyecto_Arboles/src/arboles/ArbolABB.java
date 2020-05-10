/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author jorge.reyes
 */
public class ArbolABB {
  protected NodoBin raiz;
  
    public ArbolABB(String o, int n){
        raiz = new NodoBin(o, n);
    }
  
    public void inOrden(){
        if(raiz!=null){
            raiz.inOrden();
        }    
    }
  
  public void posOrden(){
    if(raiz!=null)
        raiz.posOrden();
  }
  
  public void preOrden(){
    if(raiz!=null)
        raiz.preOrden();        
  }
  
  public void insertar(String o, int n){
    insertarOrdenado(raiz,o, n);
  }
  
  public void borrar(String o){
    borrar(raiz,o);
  }
  
  private NodoBin borrar(NodoBin n, String o) throws ItemNotFoundException{
    if (n==null)
        throw new ItemNotFoundException("Elemento no encontrado");
    else{
      if (o.compareTo( n.getDato() ) < 0)
        n.setDer(borrar(n.getDer(),o));
      else
         if(o.compareTo( n.getDato() ) > 0)
            n.setIzq(borrar(n.getIzq(),o));
         else{//Ya encontré el elemento a eliminar!!
           if (n.getDer()!=null && n.getIzq()!=null)//Aquí aplicamos los criterios cuando hay 2 hijos      
           //Aplicamos el criterio del hijo más izquierdo del lado derecho
           {
           NodoBin minimo = buscarMin(n.getDer());    
           n.setDato(minimo.getDato());
           n.setDer(borrarMin(n.getDer()));
           }
           else //Los criterios cuando se tienen 1 de los 2 hijos o es hoja
             n = (n.getIzq()!= null)? n.getIzq() : n.getDer();               
         }
    } 
   return n;     
  }
  
  private NodoBin buscarMin(NodoBin n){
     while(n.getIzq()!=null)
         n = n.getIzq();
     return n;
  }
  
  private NodoBin borrarMin(NodoBin n){
    if (n.getIzq()!= null){
      n.setIzq(borrarMin(n.getIzq()));
      return n;
    }
    else 
       return n.getDer();
  }
  
    private void insertarOrdenado(NodoBin n, String o, int b){
        if(o.compareTo( n.getDato() ) == 0){
            n.addReferencia(b);
        }
        if (o.compareTo( n.getDato() ) > 0 ){
            if (n.getIzq()==null)
                n.setIzq(new NodoBin(o, b));
            else{
                insertarOrdenado(n.getIzq(),o, b);
            }  
        }
        else{
            if( o.compareTo( n.getDato() ) < 0 ){
                if (n.getDer()==null){
                    n.setDer(new NodoBin(o, b));
                }
                else{
                    insertarOrdenado(n.getDer(),o, b);
                }
            }  
        }
    }
  
    public int[] buscar(String o){
        int[] referenciasEnLista;
        referenciasEnLista = buscar(raiz,o);
        return referenciasEnLista;
    }
  
    private int[] buscar(NodoBin n, String o) throws ItemNotFoundException{
        int[] referencias = null;
        
        if(o.compareTo( n.getDato() ) == 0){
            referencias = n.getReferencia();
        }
        if (o.compareTo( n.getDato() ) > 0 ){
            if (n.getIzq()==null){
                throw new ItemNotFoundException("No está el dato :(");
            }
            else{
                buscar(n.getIzq(),o);
            }
        }
        else{
            if( o.compareTo( n.getDato() ) < 0 ){
                if (n.getDer()==null){
                    throw new ItemNotFoundException("No está el dato :(");
                } 
                else{
                    buscar(n.getDer(),o);     
                }  
            }
            else{
                System.out.println("El dato si está en el árbol");
                referencias = n.getReferencia();
            }
        }
        return referencias;
    }
    /**
     * @return the raiz
     */
    public NodoBin getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoBin raiz) {
        this.raiz = raiz;
    }
  
    /*public static void main(String[] args) {
      ArbolABB arbol = new ArbolABB("Daniel", 1);
      arbol.insertar("Hola", 2);
      arbol.insertar("Como", 3);
      arbol.insertar("Estas", 4);
      arbol.insertar("Por", 5);
      arbol.insertar("que", 7);
      arbol.insertar("no", 8);
      arbol.insertar("te", 9);
      arbol.insertar("vas", 10);
      arbol.insertar("a", 11);
      arbol.insertar("la", 12);
      arbol.insertar("verga", 13);
      System.out.println("RECORRIDO EN INORDEN");
      arbol.inOrden();      
      
      System.out.println("RECORRIDO EN PREORDEN");
      arbol.preOrden();      
      System.out.println("RECORRIDO EN POSORDEN");
      arbol.posOrden();      
      System.out.println("Buscando datos...");
      try{
         arbol.buscar("verga");         
        }
      catch(ItemNotFoundException e){
          System.out.println("Error: " + e.getMessage());
      }
      String eliminado = "que";
      System.out.println("Eliminando el elemento: " + eliminado);
      try{
         arbol.borrar(eliminado);
         arbol.inOrden();
      }
      catch (ItemNotFoundException e){
          System.out.println("Error: " + e.getMessage());
      }
    }*/
}