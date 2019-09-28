package Interfaz;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Clase Punto final
 * Esta clase almacena el resultado al evaluar las entradas en su respectiva compuerta
 * */
public class PuntoFinal extends Componente {
    PuntoFinal(int ID, int x, int y) {
        super(ID, "End", x, y);
        type = "End";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Entrada(Main.IDConector, this, 0, getHeight() /2);

    }
}
