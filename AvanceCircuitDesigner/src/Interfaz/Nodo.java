package Interfaz;

/**
 * Esta clase funciona como Nodo de la clase Lista
 *
 * */

public class Nodo<T> {
    public T component;
    public Nodo<T> siguiente = null;

    /**
     * Constructor de la clase Nodo que le asigna un valor al nodo
     * @param component - valor del nodo
     * */

    public Nodo(T component){
        this.component = component;
    }


    public void setNext(Nodo<T> next)
    {
        this.siguiente = next;
    }

    public T getComponent() {
        return component;
    }
}
