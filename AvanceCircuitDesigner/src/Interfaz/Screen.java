package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Esta clase funciona como un canvas para realizar acciones sobre ella
 **/


public class Screen extends JPanel {
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {// Haciendo click en la plantilla o screen se hacen diferentes cosas dependiendo del modo
                //Se implementa patron de diseño FACTORY
                if (Main.modo.equals("addingAnd")) {//Agrega compuerta AND en la plantilla
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.modo.equals("addingOr")) {//Agrega compuerta OR en la plantilla
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.modo.equals("addingNot")) {//Agrega compuerta NOT en la plantilla
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.modo.equals("addingNand")) {//Agrega compuerta NAND en la plantilla
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.modo.equals("addingNor")) {//Agrega compuerta NOR en la plantilla
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.modo.equals("addingXor")) {//Agrega compuerta XOR en la plantilla
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.modo.equals("addingXnor")) {//Agrega compuerta XNOR en la plantilla
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.modo.equals("addingStart")) {//Agrega compuerta START en la plantilla
                    Component c = new StartPoint(Main.currentComponentID, e.getX(), e.getY());

                } else if (Main.modo.equals("addingEnd")) {//Agrega compuerta END en la plantilla
                    Component c = new EndPoint(Main.currentComponentID, e.getX(), e.getY());
                }
                Main.modo = "";

                Main.drawPanel.repaint();
            }
        });
    }

    /**
     * Este metodo permite llamar al drawPanel.repaint
     * */


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Pinta el drawPanel y asocia componentes

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(Main.lineas.size());
        for (Connection line : Main.lineas) {//pinta todas las lineas en la aplicacion
            line.paintConnection(g2d);
        }
    }
}