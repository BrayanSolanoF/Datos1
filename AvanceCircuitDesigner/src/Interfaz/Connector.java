package Interfaz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 * La clase Conector es una clase general para las entradas y salidas
 * Las entradas y salidas son los cuadrados rojos y azules en las compuertas
 * */

public class Connector {
    boolean value; //Entrada y salida tienen valores, no compuertas
    boolean hasValue = false;//No tiene un valor hasta que se le da uno
    boolean isInput;//Son usados booleanos en vez de strings
    boolean isOutput;//Son usados booleanos en vez de strings
    int id;
    Component component;
    Lista<Connection> connections = new Lista<Connection>();
    int maxConnections;

    int x, y;
    int w = 10, h = 10;
    Shape shape;//Define la forma de como los conectores aparecen
    Color color;
    Connector(int ID, Component c, int x, int y) {

        id = ID;
        Main.currentComponentID++;

        this.component = c;
        this.x = x;
        this.y = y;
    }
    boolean isAvailable() {
        if (component.type.equals("Start") && this.isInput) {

            return false;
        }
        else {//Se asegura que el numero de conexiones es menor que la cantidad maxima posible
            return (connections.size() < maxConnections);
        }

    }
    void addConnection(Connection con) {
        if (isAvailable()) connections.add(con);
    }
    public int getX() {
        return component.getX() + x;

    }
    public int getY() {
        return component.getY() + y;
    }
    public boolean contains(Point p) { //used to see if a mouse click is on the Connector (input or output)
        return shape.contains(p);
    }
    public void paintConnector(Graphics2D g2d) {//Dibuja el conector
        if (isAvailable()) {
            g2d.setColor(color);
        }
        else if (component.type.equals("Start")) {//Cambia el color al momento de conectar un a entrada a color rosa
            g2d.setColor(Color.pink);

        }
        else {
            g2d.setColor(Color.lightGray);
        }
        g2d.fill(shape);
    }

}
