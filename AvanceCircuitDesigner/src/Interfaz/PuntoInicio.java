package Interfaz;


import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PuntoInicio extends  Componente{

    PuntoInicio(int ID, int x, int y) {
        super(ID, "Start", x, y);
        type = "Start";


        value = 0;
        this.setText(Integer.toString(value));

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        Salida bye = new Salida(Main.IDConector, this, getWidth(), getHeight() /2);
        Entrada hi = new Entrada(Main.IDConector, this, 0, getHeight() /2);
        hi.hasValue = true;


        hi.ConexionesMaximas = 0;


    }
    boolean isAvailable() {

        return false;
    }
    public boolean operation(ArrayList<Boolean> args) {

        return salidas.get(0).value;
    }
    public void toggle() {
        System.out.println("notificando");
        value +=1;
        value %= 2;
        if (value == 0) {
            salidas.get(0).value = false;
        }
        else {
            salidas.get(0).value = true;
        }


        this.setText(Integer.toString(value));

    }

}