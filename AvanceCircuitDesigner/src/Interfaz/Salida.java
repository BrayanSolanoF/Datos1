package Interfaz;

import java.awt.Color;
import java.awt.Polygon;


public class Salida extends Conector{

    Lista<Entrada> inputsReceivingThis = new Lista<Entrada>();

    public Salida(int ID, Componente owner, int x, int y) {
        super(ID, owner, x, y);
        isOutput = true;
        owner.addOutput(this);
        ConexionesMaximas = 100;

        Polygon p = new Polygon();
        p.addPoint(x - w, y - h / 2);
        p.addPoint(x, y - h/2);
        p.addPoint(x, y + h/2);
        p.addPoint(x - w, y + h / 2);

        shape = p;
        color = Color.red;
    }
}
