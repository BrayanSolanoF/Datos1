package Logica;

import Interfaz.Componente;
import Interfaz.Entrada;
import Interfaz.Main;
import Interfaz.Salida;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 * Esta clase representa el componente Nand
 *
 * */
public class Nand extends Componente {
    public Nand(int ID, int x, int y) {
        super(ID, "NAND", x, y);
        type = "Nand";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Entrada(Main.IDConector, this, 0, 6);
        new Entrada(Main.IDConector, this, 0, getHeight() - 6);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);

    }
    public boolean operation(ArrayList<Boolean> args) {
        boolean entrada1 = args.get(0);
        boolean entrada2 = args.get(1);
        return !(entrada1&&entrada2);
    }
}
