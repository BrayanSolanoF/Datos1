package Interfaz;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa la compuerta o componente XNOR
 * */

public class XNOR extends Component {
    public XNOR(int ID, int x, int y) {
        super(ID, "XNOR",  x, y);
        type = "Xnor";
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Input(Main.currentConnectorID, this, 0, 6);
        new Input(Main.currentConnectorID, this, 0, getHeight() - 6);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }

    /**
     * Este metodo establece la logica de la compuerta para obtener un salida
     * de acuerdo a su respectiva logica
     * */

    public boolean operation(Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean input2 = args.get(1);
        boolean output;
        boolean output2;
        if (input1 == input2){
            output = true;
        }else {
            output = false;
        }
        output2 = !output;
        return output2;
    }
}