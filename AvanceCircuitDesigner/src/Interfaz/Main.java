package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

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



        JButton andbutton = new JButton();
        JButton orbutton = new JButton();
        JButton notbutton = new JButton();
        JButton nandbutton = new JButton();
        JButton norbutton = new JButton();
        JButton xorbutton = new JButton();
        JButton xnorbutton = new JButton();





    }
    public static void main(String[] args){

        new Main();// Clase ejecutable
    }
}


