package Interfaz;

import javax.swing.*;
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
        
        frame.setVisible(true);

        /*drawPanel.setLayout(null);
        frame.add(drawPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel buttonspanel = new JPanel();

         */



    }
    public static void main(String[] args){

        new Main();// Clase ejecutable
    }
}


