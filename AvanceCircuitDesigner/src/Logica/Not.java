package Logica;
import Interfaz.*;

import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa el componente NOT
 * */
public class Not extends Component {
    public Not(int ID, int x, int y) {
        super(ID, "NOT",  x, y);
        type = "Not";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        //Crea una entradas y una salida
        new Input(Main.currentConnectorID, this, 0, getHeight() / 2);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }
    /**
     * Este metodo establece la logica de la compuerta para obtener un salida
     * de acuerdo a su respectiva logica
     * */
    public boolean operation(Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean output = !input1;
        return output;
    }



}
