

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
                if (Main.modo.equals("addingAnd")) {
                    Componente c = new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.modo.equals("addingOr")) {
                    Componente c = new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.modo.equals("addingNot")) {
                    Componente c= new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.modo.equals("addingNand")) {
                    Componente c= new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.modo.equals("addingNor")) {
                    Componente c= new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.modo.equals("addingXor")) {
                    Componente c= new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.modo.equals("addingXnor")) {
                    Componente c= new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.modo.equals("addingStart")) {
                    Componente c = new PuntoInicio(Main.IDComponente, e.getX(), e.getY());

                } else if (Main.modo.equals("addingEnd")) {
                    Componente c = new PuntoFinal(Main.IDComponente, e.getX(), e.getY());
                }
                Main.modo = "";
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
        System.out.println(Main.lineas.size());
        for (Conexion line: Main.lineas){
            line.paintConnection(g2d);
        }

    }

}
