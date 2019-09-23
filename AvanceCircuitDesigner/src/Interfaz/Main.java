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
    /**
     *Los siguientes "fields" son usados para dar un # de ID a los objetos
     *
     * */
    static int IDComponente = 0;
    static int IDConector = 0;
    static int IDConexion = 0;
    static String modo = ""; //Preguntar
    static boolean mostrarEntradas = true, mostrarSalidas = true;
    static Salida SalidaSelecionada= null;

    //Titulo Ventana
    static JFrame frame = new JFrame("Circuit Designer");
    //Pantilla para compuertas
    //static Plantilla drawPanel = new Plantilla();
    //Construtor
    Main(){

        //Cuando se cierre la ventana nuestro programa debe acabar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //.....
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Hace visible la ventana
        frame.setVisible(true);

        //drawPanel.setLayout(null);
        //frame.add(drawPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel buttonspanel = new JPanel();
        //Split donde se encuentras los botones
        splitPane.setTopComponent(buttonspanel);
        frame.add(splitPane, BorderLayout.WEST);

        //Botones como Jbuttons patra implementarlos a JPanel
        JButton andbutton = new JButton();
        //Se busca funcion para utilizar los botones con imagenes de cada componente
        try {
            Image img = ImageIO.read(getClass().getResource("./images/and.png"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/or.png"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/not.png"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/nand.png"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/nor.png"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/xor.png"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/xnor.png"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton newConnectionButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/Thread.png"));
            newConnectionButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton startButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/start.png"));
            startButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton endButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/end.png"));
            endButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton simulateButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/simulate.png"));
            simulateButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton eraseButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/erase.png"));
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


