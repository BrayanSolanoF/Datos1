package Interfaz;
/**
 * Esta clase funciona como Nodo de la clase Lista
 *
 * */
public class Nodo<T> {
    public T componente;
    public Nodo<T> siguiente = null;

    /**
     * Constructor de la clase Nodo que le asigna un valor al nodo
     * @param componente - valor del nodo
     * */

    public Nodo(T componente){
        this.componente = componente;
    }

    public void setNext(Nodo<T> next)
    {
        this.siguiente = next;
    }

    public T getComponente() {
        return componente;
    }
}
