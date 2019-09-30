package Interfaz;

import java.awt.Color;
import java.awt.Polygon;
/**
 * Clase Output (Salida)
 *Esta clase es un tipo de conector
 * */

public class Output extends Connector {

    Lista<Input> inputsReceivingThis = new Lista<Input>();

    public Output(int ID, Component owner, int x, int y) {
        super(ID, owner, x, y);
        isOutput = true;
        owner.addOutput(this);
       maxConnections = 100;
        //Define como se ven las salidas
        Polygon p = new Polygon();
        p.addPoint(x - w, y - h / 2);
        p.addPoint(x, y - h/2);
        p.addPoint(x, y + h/2);
        p.addPoint(x - w, y + h / 2);

        shape = p;
        color = Color.red;
    }
}