package Logica;
import Interfaz.*;

import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa el componente Not
 *
 * */
public class Not extends Componente {
    public Not(int ID, int x, int y) {
        super(ID, "NOT",  x, y);
        type = "Not";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Entrada(Main.IDConector, this, 0, getHeight() / 2);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);
    }

    public boolean operation(Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean output = !input1;
        return output;
    }



}
