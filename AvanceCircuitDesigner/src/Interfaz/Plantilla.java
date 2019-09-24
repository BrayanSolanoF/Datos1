/*package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

/**
 * Esta clase funciona como un canvas para realizar acciones sobre ella
 *
 * */
public class Plantilla extends JPanel {

    Plantilla(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Main.modo.equals("addingAnd")) { //adds and gate at click point
                    Component c = new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.modo.equals("addingOr")) {// adds or gate at click point
                    Component c = new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.modo.equals("addingNot")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.modo.equals("addingNand")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.modo.equals("addingNor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.modo.equals("addingXor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.modo.equals("addingXnor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.modo.equals("addingStart")) {//adds start gate at click point
                    Component c = new PuntoInicio(Main.IDComponente, e.getX(), e.getY());

                } else if (Main.modo.equals("addingEnd")) { //adds end gate at click point
                    Component c = new PuntoFinal(Main.IDComponente, e.getX(), e.getY());
                }
                Main.modo = "";
                Main.drawPanel.repaint();

            }
        });
    }
    /**
     * Este metodo permite llamar al drawPanel.repaint
     *
     *
     * */
    public void paintComponent(Graphics g){
        //Pinta el drawPanel y asocia componentes
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(Main.lines.size());
        for (Connection line: Main.lines){
            line.paintConnection(g2d);
        }

    }

}
