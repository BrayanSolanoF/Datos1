package Logica;

import Interfaz.*;

import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa la compuerta o componente XNOR
 * */
public class Xnor extends Component {
    public Xnor(int ID, int x, int y) {
        super(ID, "XNOR", x, y);
        type = "Xnor";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        //Crea dos entradas y una salida
        new Input(Main.currentConnectorID, this, 0, 6);
        new Input(Main.currentConnectorID, this, 0, getHeight() - 6);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }
    /**
     * Este metodo establece la logica de la compuerta para obtener un salida
     * de acuerdo a su respectiva logica
     * */
    public boolean operation(Lista<Boolean> args) {
        boolean entrada1 = args.get(0);
        boolean entrada2 = args.get(1);
        boolean salida;
        boolean salida2;
        if (entrada1 == entrada2){
            salida = true;
        }else {
            salida = false;
        }
        salida2 = !salida;
        return salida2;
    }
}