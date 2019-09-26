package Logica;

import Interfaz.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;



/**
 * Esta clase representa el componente AND
 *
 * */


public class And extends Componente {
    public And(int ID, int x, int y){
        super(ID, "AND",  x, y);
        type = "And";
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        //JLabel jLabelObject = new JLabel();
        //jLabelObject.setIcon(new ImageIcon("./images/ad"));
        setBorder(new LineBorder(Color.black, 1));
        new Entrada(Main.IDConector, this, 0, 6);
        new Entrada(Main.IDConector, this, 0, getHeight() - 6);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);

    }
    public boolean operation(Lista<Boolean> args) {
        boolean entrada1 = args.get(0);
        boolean entrada2 = args.get(1);
        return (entrada1&&entrada2);
    }



}
