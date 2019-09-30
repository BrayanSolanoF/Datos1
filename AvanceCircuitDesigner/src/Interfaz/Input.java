package Interfaz;
import java.awt.*;
/**
 * Clase input (entrada)
 * Esta clase es un tipo de conector
 * */
public class Input extends Connector {
    public Input(int ID, Component owner, int x, int y) {
        super(ID,owner, x, y);
        isInput = true;
        owner.addInput(this);
        if (owner.type.equals("Start")) {
            owner.addtoToggles(this);
        }
        maxConnections = 1;


        Polygon p = new Polygon();
        p.addPoint(x, y - h / 2);
        p.addPoint(x+w, y-h/2);
        p.addPoint(x+ w, y + h / 2);
        p.addPoint(x, y + h/2);
        shape = p;
        color = Color.blue;
    }

    public void paintConector(Graphics2D g2d) {
    }
}
