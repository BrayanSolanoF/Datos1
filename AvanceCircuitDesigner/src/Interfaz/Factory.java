package Interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Factory {

    public static Component ComponentFactory(TypeComponent type, MouseEvent e){
        if (type == TypeComponent.AND) {
            return new AndGate(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.OR) {
            return new OrGate(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NAND) {
            return new NandGate(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOR) {
            return new NorGate(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOT) {
            return new NotGate(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.XNOR) {
            return new XnorGate(Main.currentComponentID, e.getX(), e.getY());
        } else {
            return new XorGate(Main.currentComponentID, e.getX(), e.getY());
        }

    }
}
