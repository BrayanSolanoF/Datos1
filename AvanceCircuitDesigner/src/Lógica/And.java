package Lógica;

import Interfaz.Entrada;
import Interfaz.Main;
import Interfaz.Componente;
import Interfaz.Salida;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;


/**
 * Esta clase representa el componente AND
 *
 * */


public class And extends Componente {
    And(int ID, int x, int y){
        super(ID, "AND",  x, y);
        type = "And";
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        //JLabel jLabelObject = new JLabel();
        //jLabelObject.setIcon(new ImageIcon("./images/ad"));
        setBorder(new LineBorder(Color.black, 1));
        new Entrada(Main.IDconector, this, 0, 6);
        new Entrada(Main.IDConector, this, 0, getHeight() - 6);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);

    }
    public boolean operation(ArrayList<Boolean> args) {
        boolean input1 = args.get(0);
        boolean input2 = args.get(1);
        return (input1&&input2);
    }



}
