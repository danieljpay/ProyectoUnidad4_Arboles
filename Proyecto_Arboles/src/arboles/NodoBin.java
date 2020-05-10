/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author jorge.reyes
 */
public class NodoBin {
    protected String dato;
    protected int[] referencia = new int[20];
    protected NodoBin izq;
    protected NodoBin der;

    public NodoBin(String dato, NodoBin izq, NodoBin der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public NodoBin(String dato, int number){
       this(dato,null,null);
       this.referencia[0] = number;
    }
    
    public NodoBin(){
        this.dato = null;
        this.izq = null;
        this.der = null;
        this.referencia = null;
    }
    
    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    public void posOrden(){
       if(izq!=null)
           izq.posOrden();     
       if(der!=null)
           der.posOrden();
       System.out.println(dato);//Raiz
    }
    
    public void preOrden(){
        System.out.println(dato);//Raiz    
        if(izq!=null)
           izq.preOrden();     
        if(der!=null)
           der.preOrden();
       
    }
    
    public void inOrden(){ //IRD
       if(izq!=null)
           izq.inOrden();
     System.out.println(dato + "[" + referencia[0] + "]");//Raiz
       if(der!=null)
           der.inOrden();
    }
    
    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public NodoBin getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoBin izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoBin getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoBin der) {
        this.der = der;
    }

    /**
     * @return the array
     */
    public int[] getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(int[] referencia) {
        this.referencia = referencia;
    }
    
        
    
}

