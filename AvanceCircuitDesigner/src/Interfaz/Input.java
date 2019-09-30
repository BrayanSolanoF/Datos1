package Interfaz;

import java.awt.*;

/**
 * Clase input (entrada)
 * Esta clase es un tipo de conector
 * */

public class Input extends Connector {

    Input(int ID, Component owner, int x, int y) {
        super(ID,owner, x, y);
        isInput = true;
        owner.addInput(this);
        if (owner.type.equals("Start")) {
            owner.addtoToggles(this);//Si es una entrada en una compuerta , deberia ser tratada como switch
        }
        maxConnections = 1;//Solo una conexion puede ir hacia una entrada

        //Define como se ve la entrada
        Polygon p = new Polygon();
        p.addPoint(x, y - h / 2);
        p.addPoint(x+w, y-h/2);
        p.addPoint(x+ w, y + h / 2);
        p.addPoint(x, y + h/2);
        shape = p;
        color = Color.blue;
    }
}