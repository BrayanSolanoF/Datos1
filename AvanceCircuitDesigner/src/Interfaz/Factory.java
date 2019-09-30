package Interfaz;

import Logica.*;
import java.awt.event.MouseEvent;

/**
 * Esta clase es un factory de la clase componente
 */

 public class Factory {

  /**
   * Metodo static que selecciona e instancia cada clase, segun el componente.
   * @return instancia de la clase componente.
   * */

 public static Component ComponentFactory(TypeComponent type, MouseEvent e) {
    if (type == TypeComponent.AND) {
        return new And(Main.currentComponentID, e.getX(), e.getY());
 }
    if (type == TypeComponent.OR) {
        return new Or(Main.currentComponentID, e.getX(), e.getY());
 }
    if (type == TypeComponent.NAND) {
        return new Nand(Main.currentComponentID, e.getX(), e.getY());
 }
    if (type == TypeComponent.NOR) {
        return new Nor(Main.currentComponentID, e.getX(), e.getY());
 }
    if (type == TypeComponent.NOT) {
        return new Not(Main.currentComponentID, e.getX(), e.getY());
 }
    if (type == TypeComponent.XNOR) {
        return new Xnor(Main.currentComponentID, e.getX(), e.getY());
 } else {
        return new Xor(Main.currentComponentID, e.getX(), e.getY());
      }
   }
 }