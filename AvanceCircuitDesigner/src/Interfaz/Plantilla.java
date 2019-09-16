package Interfaz;

import javax.swing.*;
import java.awt.event.*;

public class Plantilla extends JPanel {
    //Constructor de la plantilla
    //Basicamente es un canvas
    Plantilla(){
        //clase para recibir eventos del mouse
        addMouseListener(new MouseAdapter() {
            @Override
            //Se invoca cunaod el mouse hace click sobre un componente
            public void mouseClicked(MouseEvent e) {


            }
        });



    }


}
