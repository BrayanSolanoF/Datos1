package Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 *Clase StartPoint
 * Los puntos de inicio son los unicos componentes con un valor default
 * Otros componentes solo almacenan valores en sus entradas o salidas
 * */


public class StartPoint extends Component {

    StartPoint(int ID, int x, int y) {
        super(ID, "Start", x, y);
        type = "Start";
        value = 0;;//Los puntos de inicio son los unicos componenentes con un valor
        this.setText(Integer.toString(value));
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        Output bye = new Output(Main.currentConnectorID, this, getWidth(), getHeight() /2);
        Input hi = new Input(Main.currentConnectorID, this, 0, getHeight() /2);
        hi.hasValue = true;//hasValue solo obtiene true si hay una conexion en la compuerta
        hi.maxConnections = 0;

    }
    boolean isAvailable() {
        return false;
    }
    public boolean operation(Lista<Boolean> args) {

        return outputs.get(0).value;
    }
    /**
     * Este metodo se encarga de pasar o hacer un "switch" en los valores del StartPoint
     * */


    public void toggle() {
        System.out.println("toggling");
        value +=1;
        value %= 2;
        if (value == 0) {
            outputs.get(0).value = false;//Puntos de entrada tiene valores enteros pero el valor de salida es booleano
        }
        else {
            outputs.get(0).value = true;
        }

        this.setText(Integer.toString(value));

    }
}