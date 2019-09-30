package Interfaz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 * La clase Connector es una clase general para las entradas y salidas
 * Las entradas y salidas son los cuadrados rojos y azules en las compuertas
 * */

abstract class Connector {
    boolean value;
    boolean hasValue = false;
    boolean isInput;
    boolean isOutput;
    int id;
    Component component;
    Lista<Connection> connections = new Lista<Connection>();
    int maxConnections;

    int x, y;
    int w = 10, h = 10;
    Shape shape;
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
        else {
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
    public void paintConnector(Graphics2D g2d) {
        if (isAvailable()) {
            g2d.setColor(color);
        }
        else if (component.type.equals("Start")) {
            g2d.setColor(Color.pink);

        }
        else {
            g2d.setColor(Color.lightGray);
        }
        g2d.fill(shape);
    }

}
