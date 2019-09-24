package Interfaz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Conexion extends JComponent {

    Salida salida;
    Entrada entrada;
    int id;
    public Conexion(int ID, Salida LaSalida, Entrada LaEntrada) {
        setDoubleBuffered(true);
        id = ID;
        Main.IDConexion++;

        this.salida = LaSalida;
        this.entrada = LaEntrada;
        if (entrada.isAvailable()) salida.conexiones.add(this);
        if (entrada.isAvailable()) salida.conexiones.add(this);
    }
    public void paintConnection(Graphics2D g2d) {

        Line2D.Double line = new Line2D.Double(salida.getX(), salida.getY(), entrada.getX(), entrada.getY());
        g2d.draw(line);
        salida.inputsReceivingThis.add(entrada);
        if (Main.modo.equals("choosingInput")) {
            entrada.componente.numberConnected +=1;

        }
    }
}