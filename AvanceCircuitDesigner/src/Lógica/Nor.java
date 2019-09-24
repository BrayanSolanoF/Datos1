package Lógica;
import Interfaz.Componente;
import Interfaz.Entrada;
import Interfaz.Main;
import Interfaz.Salida;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Nor extends Componente {
    Nor(int ID, int x, int y) {
        super(ID, "NOR",  x, y); //adding to the component constructor, not replacing it
        type = "Nor";
        //formatting:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        //Below: creates two inputs, one output
        new Entrada(Main.IDConector, this, 0, 6);
        new Entrada(Main.IDConector, this, 0, getHeight() - 6);
        new Salida(Main.IDConector, this, getWidth(), getHeight() / 2);
    }
    public boolean operation(ArrayList<Boolean> args) { // "ors" the two inputs
        boolean entrada1 = args.get(0);
        boolean entrada2 = args.get(1);//need to relate these with the physical inputs
        return !(entrada1||entrada2);
    }
}