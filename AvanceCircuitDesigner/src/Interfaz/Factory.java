package Interfaz;



import java.awt.Component;
import java.awt.event.MouseEvent;

/**
 *
 * Esta clase es un factory de la clase Component
 */

public class Factory {

    /**
     * Metodo static que selecciona e instancia cada clase, segun el componente.
     * @return instancia de la clase Component.
     * */

    public static Component ComponentFactory(TypeComponent type, MouseEvent e) {
        if (type == TypeComponent.AND) {
            return new AND(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.OR) {
            return new OR(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NAND) {
            return new NAND(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOR) {
            return new NOR(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOT) {
            return new NOT(Main.currentComponentID, e.getX(), e.getY());
        }
        if (type == TypeComponent.XNOR) {
            return new XNOR(Main.currentComponentID, e.getX(), e.getY());
        } else {
            return new XOR(Main.currentComponentID, e.getX(), e.getY());
        }
    }
}