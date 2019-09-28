package Interfaz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 * La clase Connector es una clase general para las entradas y salidas
 * Las entradas y salidas son los cuadrados rojos y azules en las compuertas
 * */

public class Conector {
    boolean value;
    boolean hasValue = false;
    boolean isInput;
    boolean isOutput;
    int id;
    Componente componente;
    Lista<Conexion> conexiones = new Lista<Conexion>();
    int ConexionesMaximas;

    int x, y;
    int w = 10, h = 10;
    Shape shape;
    Color color;
    Conector(int ID, Componente c, int x, int y) {

        id = ID;
        Main.IDComponente++;

        this.componente = c;
        this.x = x;
        this.y = y;
    }
    boolean isAvailable() {
        if (componente.type.equals("Start") && this.isInput) {

            return false;
        }
        else {
            return (conexiones.size() < ConexionesMaximas);
        }

    }
    void addConnection(Conexion con) {
        if (isAvailable()) conexiones.add(con);
    }
    public int getX() {
        return componente.getX() + x;

    }
    public int getY() {
        return componente.getY() + y;
    }
    public boolean contains(Point p) { //used to see if a mouse click is on the Connector (input or output)
        return shape.contains(p);
    }
    public void paintConnector(Graphics2D g2d) {
        if (isAvailable()) {
            g2d.setColor(color);
        }
        else if (componente.type.equals("Start")) {
            g2d.setColor(Color.pink);

        }
        else {
            g2d.setColor(Color.lightGray);
        }
        g2d.fill(shape);
    }

}
