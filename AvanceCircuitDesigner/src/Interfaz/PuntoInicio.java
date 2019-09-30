package Interfaz;


import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 *Clase PuntoInicio
 * Los puntos de inicio son los unicos componentes con un valor default
 * Otros componentes solo almacenan valores en sus entradas o salidas
 * */
public class PuntoInicio extends Component {

    PuntoInicio(int ID, int x, int y) {
        super(ID, "Start", x, y);
        type = "Start";
        value = 0;
        this.setText(Integer.toString(value));

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        Output bye = new Output(Main.currentConnectorID, this, getWidth(), getHeight() /2);
        Input hi = new Input(Main.currentConnectorID, this, 0, getHeight() /2);
        hi.hasValue = true;


        hi.maxConnections = 0;


    }
    boolean isAvailable() {

        return false;
    }
    public boolean operation(Lista<Boolean> args) {

        return outputs.get(0).value;
    }
    /**
     * Este metodo se encarga de pasar o hacer un "switch" en los valores del puntoInicial
     * */
    public void toggle() {
        System.out.println("notificando");
        value +=1;
        value %= 2;
        if (value == 0) {
            outputs.get(0).value = false;
        }
        else {
            outputs.get(0).value = true;
        }


        this.setText(Integer.toString(value));

    }

}
