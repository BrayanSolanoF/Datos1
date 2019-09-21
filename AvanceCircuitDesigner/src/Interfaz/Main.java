package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Esta clase funciona como ventana principal de la aplicacion.
 * En ella se:
 * Define lo relacionado con interfaz de usuario
 * Establece botones en la paleta como imagenes
 *
 * */

public class Main   {

    //Titulo Ventana
    static JFrame frame = new JFrame("Circuit Designer");
    //Pantilla para compuertas
    static Plantilla drawPanel = new Plantilla();
    //Construtor
    Main(){

        //Cuando se cierre la ventana nuestro programa debe acabar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //.....
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Hace visible la ventana
        frame.setVisible(true);

        drawPanel.setLayout(null);
        frame.add(drawPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel buttonspanel = new JPanel();
        //Split donde se encuentras los botones
        splitPane.setTopComponent(buttonspanel);
        frame.add(splitPane, BorderLayout.EAST);

        //Botones como Jbuttons patra implementarlos a JPanel
        JButton andbutton = new JButton();
        //Se busca funcion para utilizar los botones con imagenes de cada componente
        try {
            Image img = ImageIO.read(getClass().getResource("./and.png"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./or.png"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./not.png"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nand.png"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nor.png"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xor.png"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xnor.png"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton newConnectionButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./Thread.png"));
            newConnectionButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton startButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./start.png"));
            startButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton endButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./end.png"));
            endButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton simulateButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./simulate.png"));
            simulateButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton eraseButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./erase.png"));
            eraseButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        
        //Agregar botones a la paleta
        buttonspanel.add(andbutton);
        buttonspanel.add(orbutton);
        buttonspanel.add(notbutton);
        buttonspanel.add(nandbutton);
        buttonspanel.add(norbutton);
        buttonspanel.add(xnorbutton);
        buttonspanel.add(xorbutton);
        buttonspanel.add(newConnectionButton);
        buttonspanel.add(startButton);
        buttonspanel.add(endButton);
        buttonspanel.add(simulateButton);
        buttonspanel.add(eraseButton);





    }
    /**
     * Este metodo inicia la aplicacion.
     * @param args - argumentos a ejecutar de la pantalla principal
     *
     * */
    public static void main(String[] args){

        new Main();
    }
}


