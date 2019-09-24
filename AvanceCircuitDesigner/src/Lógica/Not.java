package Lógica;
import Interfaz.Componente;
import Interfaz.Entrada;
import Interfaz.Main;
import Interfaz.Salida;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa el componente Not
 *
 * */
public class Not extends Componente {
    Not(int ID, int x, int y) {
        super(ID, "NOT",  x, y);
        type = "Not";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Entrada(Main.IDConector, this, 0, getHeight() / 2);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);
    }

}
