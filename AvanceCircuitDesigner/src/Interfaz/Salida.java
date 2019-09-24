package Interfaz;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Salida extends Conector{

    ArrayList<Entrada> inputsReceivingThis = new ArrayList<Entrada>();

    Salida(int ID, Componente owner, int x, int y) {
        super(ID, owner, x, y);
        isOutput = true;
        owner.addOutput(this);
        ConexionesMaximas = 100; // outputs can go to lots of places, but if you're over 100, I mean, come on...
        //defines look of outputs:
        Polygon p = new Polygon();
        p.addPoint(x - w, y - h / 2);
        p.addPoint(x, y - h/2);
        p.addPoint(x, y + h/2);
        p.addPoint(x - w, y + h / 2);

        shape = p;
        color = Color.red;
    }
}
