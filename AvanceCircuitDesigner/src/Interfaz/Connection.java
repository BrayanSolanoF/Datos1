package Interfaz;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

/**
 *  Clase conexion
 *  Esta clase conecta todos los componentes juntos por sus entradas y salidas (conectores)
 * */

public class Connection extends JComponent {

    Output output;// Conexiones sabe que la salida y la entrada estan conectadas
    Input input;//Conexiones sabe que la entrada y la salida estan conectadas
    int id;
    public Connection(int ID, Output theOutput, Input theInput) {
        setDoubleBuffered(true);//Parte de lo grafico
        id = ID;
        Main.currentConnectionID++;

        this.output = theOutput;
        this.input =  theInput;
        if (input.isAvailable()) output.connections.add(this);
        if (input.isAvailable()) output.connections.add(this);
    }
    /**
     * Este metodo dibuja las lineas para asociar las conexiones
     * */
    public void paintConnection(Graphics2D g2d) {

        Line2D.Double line = new Line2D.Double(output.getX(), output.getY(), input.getX(), input.getY());
        g2d.draw(line);
        output.inputsReceivingThis.add(input);
        if (Main.mode.equals("choosingInput")) {//Ahora la salida sabe hacia adonde va
            input.component.numberConnected +=1;

        }
    }
}