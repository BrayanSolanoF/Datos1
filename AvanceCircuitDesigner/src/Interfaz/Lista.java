package Interfaz;

import java.util.Iterator;


/**
 * Esta es mi clase es una Lista, la cual es una lista Generica para maneja diferentes tipos de datos
 *
 * */
//Se inicia el proyecto con ArrayLists entonces se debe usar un iterator para poder mantener los ciclos for each al conbertir los
// en una lista propia
public class Lista <T> implements Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
    }
/**
 * Metodo para agregar a mi lista
 * */
    public void add(T value){
        Nodo<T> nodo = new Nodo<>(value);
        if (cabeza == null)
            cola = cabeza = nodo;
        else{
            cola.setNext(nodo);
            cola = nodo;
        }
    }
/**
 * Metodo para remover de mi lista
 * */
    public void remove(T connections){
        throw new UnsupportedOperationException();

    }

    public void remove(Lista<T> connections){
        throw new UnsupportedOperationException();

    }



    class CustomIterator<T> implements Iterator<T>{

        Nodo<T> current = null;

        public CustomIterator(Lista<T> lista){
            current = lista.cabeza;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.component;
            current = current.siguiente;
            return data;
        }

    }


        private Nodo<T> cabeza = null;
        private Nodo<T> cola = null;

        private int longitud = 0;



        /**
         * Este valor obtiene un valor en un index "n" de la lista.
         * @param n - Numero de posicion a obtener
         * @return null
         *
         * */
        public T get(int n){
            if (cabeza == null){
                return null;
            }else{
                Nodo<T> puntero = cabeza;
                int contador = 0;
                while(contador < n && puntero.siguiente != null){
                    puntero = puntero.siguiente;
                    contador++;
                }
                if (contador!= n){
                    return null;
                }else{
                    return puntero.component;
                }

            }
        }

        /**
         * Este metodo  retorna el tamano de la lista
         * @return variable longitud de la clase lista
         *
         * */
        public int size(){
            return longitud;
        }



    }
