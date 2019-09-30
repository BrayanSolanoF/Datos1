

package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Esta clase funciona como un canvas para realizar acciones sobre ella
 **/
public class Plantilla extends JPanel {

    Plantilla(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // Haciendo click en la plantilla o screen se hacen diferentes cosas dependiendo del modo
                super.mouseClicked(e);
                switch (Main.mode) {
                    case "addingAnd": {//Agrega compuerta And en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.AND, e);
                        break;
                    }
                    case "addingOr": {//Agrega compuerta Or en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.OR, e);
                        break;
                    }
                    case "addingNot": {//Agrega compuerta Not en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.NOT, e);
                        break;
                    }
                    case "addingNand": {//Agrega compuerta Nand en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.NAND, e);
                        break;
                    }
                    case "addingNor": {//Agrega compuerta Nor en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.NOR, e);
                        break;
                    }
                    case "addingXor": {//Agrega compuerta Xor en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.XOR, e);
                        ;
                        break;
                    }
                    case "addingXnor": {//Agrega compuerta Xnor en la plantilla
                        new Factory();
                        Component c = Factory.ComponentFactory(TypeComponent.XNOR, e);

                        break;
                    }
                    case "addingStart": {//Agrega compuerta start en la plantilla
                        Component c = new PuntoInicio(Main.currentComponentID, e.getX(), e.getY());

                        break;
                    }
                    case "addingEnd": {//Agrega compuerta end en la plantilla
                        Component c = new PuntoFinal(Main.currentComponentID, e.getX(), e.getY());
                        break;
                    }
                }
                Main.mode = "";
                Main.drawPanel.repaint();

            }
        });
    }
    /**
     * Este metodo permite llamar al drawPanel.repaint
     * */
    public void paintComponent(Graphics g){
        //Pinta el drawPanel y asocia componentes
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(Main.lines.size());
        for (Connection line: Main.lines){//pinta todas las lineas en la aplicacion
            line.paintConnection(g2d);
        }

    }

}
