package Interfaz;

public class Nodo<T> {
    public T componente;
    public Nodo<T> siguiente = null;

    public Nodo(T componente){
        this.componente = componente;
    }

    public T getComponente() {
        return componente;
    }
}
