package Interfaz;

import java.util.Iterator;
import java.util.ListIterator;

public class Lista <T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
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
            T data = current.componente;
            current = current.siguiente;
            return data;
        }

    }


        private Nodo<T> cabeza = null;

        private int longitud = 0;

        public  void add(int n, T componente){
            Nodo<T> nodo = new Nodo<>(componente);
            if (cabeza == null){
                cabeza = nodo;
            }else{
                Nodo<T> puntero = cabeza;
                int contador = 0;
                while(contador < n && puntero.siguiente != null){
                    puntero = puntero.siguiente;
                    contador++;
                }
                nodo.siguiente = puntero.siguiente;
                puntero.siguiente = nodo;
            }
            longitud++;
        }
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
                    return puntero.componente;
                }

            }
        }
        public int size(){
            return longitud;
        }

        public boolean isEmpty(){
            return cabeza == null;

        }

        public void remove(int n){
            if(cabeza != null){
                if(n==0) {
                    Nodo primer = cabeza;
                    cabeza = cabeza.siguiente;
                    primer.siguiente = null;
                    longitud--;

                }else if (n < longitud){
                    Nodo puntero = cabeza;
                    int contador = 0;
                    while (contador < (n - 1)) {
                        puntero = puntero.siguiente;
                        contador++;
                    }
                    Nodo temp = puntero.siguiente;
                    puntero.siguiente = temp.siguiente;
                    temp.siguiente = null;
                    longitud--;
                }
            }

        }

    }
