package Interfaz;

import Lógica.*;
import java.awt.event.MouseEvent;

/**
 *
 * Esta clase es un factory de las clases componente
 */

 public class Factory {

 public static Componente ComponentFactory(TypeComponent type, MouseEvent e) {
 if (type == TypeComponent.AND) {
 return new And(Main.IDComponente, e.getX(), e.getY());
 }
 if (type == TypeComponent.OR) {
 return new Or(Main.IDComponente, e.getX(), e.getY());
 }
 if (type == TypeComponent.NAND) {
 return new Nand(Main.IDComponente, e.getX(), e.getY());
 }
 if (type == TypeComponent.NOR) {
 return new Nor(Main.IDComponente, e.getX(), e.getY());
 }
 if (type == TypeComponent.NOT) {
 return new Not(Main.IDComponente, e.getX(), e.getY());
 }
 if (type == TypeComponent.XNOR) {
 return new Xnor(Main.IDComponente, e.getX(), e.getY());
 } else {
 return new Xor(Main.IDComponente, e.getX(), e.getY());
 }
 }
 }