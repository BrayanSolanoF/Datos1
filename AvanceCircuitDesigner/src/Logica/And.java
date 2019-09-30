package Logica;

import Interfaz.*;
import Interfaz.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;



/**
 * Esta clase representa la compuerta o componente AND
 * */


public class And extends Component {
    public And(int ID, int x, int y){
        super(ID, "AND",  x, y);
        type = "And";
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        //JLabel jLabelObject = new JLabel();
        //jLabelObject.setIcon(new ImageIcon("./images/ad"));
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
        boolean entrada1 = args.get(0);
        boolean entrada2 = args.get(1);
        return (entrada1&&entrada2);
    }



}
