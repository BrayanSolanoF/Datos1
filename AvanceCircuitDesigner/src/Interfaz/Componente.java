package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

/**
 * Esta clase es la clase padre para todos los componentes
 *Maneja tanto eventos como metodos que se heredan a las compuertas, el metodo de simulacion, entradas y salidas.
 * */

public class Componente extends JLabel implements MouseListener, MouseMotionListener {
    /**
     * Necesarios para que funcione la aplicacion
     * */
    int numberConnected = 0;// Inicia sin nada conectado
    int id;//Parte de un IDfeature
    public String type; //Se establece de forma diferente dependiendo de la subclase
    /**
     * Este metodo sobreescribe solo el punto de inicio
     *
     * */
    public void toggle() {

    }
    public boolean operation(Lista<Boolean> args) { //overwritten by subclasses
        return false;
    }
    public Lista<Boolean> userOperation(Lista<Boolean> args) { //overwritten by subclasses
        return (new Lista<Boolean>());
    }
    int value = 0;
    Lista<Entrada> entradas = new Lista<Entrada>();
    Lista<Entrada> toggles = new Lista<Entrada>();
    Lista<Salida> salidas = new Lista<Salida>();
    public Componente(int ID, String text, int x, int y) {

        super(text);
        id = ID;
        Main.IDComponente++;

        Main.componentes.add(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        Main.drawPanel.add(this);
    }

    public void addOutput(Salida o) {
        salidas.add(o);
    }
    public void addInput(Entrada i) {
        entradas.add(i);
    }

    public void addtoToggles(Entrada i) {
        toggles.add(i);
    }

    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.mostrarEntradas) {
            for (Entrada in : entradas) {
                in.paintConnector(g2d);
            }
        }

        else {
            for (Entrada tog : toggles) {
                tog.paintConector(g2d);
            }
        }
        if (Main.mostrarSalidas) {
            for (Salida out : salidas) {
                if (out.isAvailable()) {
                    out.paintConnector(g2d);
                }

            }
        }
    }

    int startDragX, startDragY;
    boolean inDrag = false;

    @Override
    public void mouseEntered(MouseEvent e) {


    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(Main.modo);
        if (Main.modo.equals("erase")) {


            Main.drawPanel.remove(this);
            Main.componentes.remove(this);

            for (Entrada input : this.entradas) {

                for (Conexion connection : input.conexiones) {

                    Main.drawPanel.remove(connection);
                    Main.lineas.remove(connection);

                    connection.salida.conexiones.remove(connection);




                }
                input.conexiones.remove(input.conexiones);
            }
            for (Salida output : this.salidas) {
                for (Conexion connection : output.conexiones) {
                    Main.drawPanel.remove(connection);
                    Main.lineas.remove(connection);

                    connection.entrada.conexiones.remove(connection);
                }
                output.conexiones.remove(output.conexiones);
            }

            Main.drawPanel.repaint();
            Main.modo = "";

        }
        startDragX = e.getX();
        startDragY = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (inDrag) {
            inDrag = false;
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Entrada in : entradas) {
            if (in.componente.type.equals("Start") && in.contains(e.getPoint())){
                System.out.println("testtoggle");
                in.componente.toggle();

            }
        }
        if (Main.modo.equals("choosingInput")) {

            for (Entrada in : entradas) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lineas.add(new Conexion(Main.IDConexion, Main.SalidaSelecionada, in));

                    Main.drawPanel.repaint();
                    Main.modo = "";
                    Main.mostrarSalidas = true;

                }
            }
        }
        if (Main.modo.equals("choosingOutput")) {
            for (Salida out : salidas) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.SalidaSelecionada = out;
                    Main.mostrarSalidas = false;
                    Main.modo = "choosingInput";
                    Main.mostrarEntradas = true;

                    Main.drawPanel.repaint();

                }
            }
        }

    }
    @Override

/**
 * Este metodo es el encargado del drag para la plantilla
 *
 * */
    public void mouseDragged(MouseEvent e) {
        int newX = getX()  + (e.getX() -startDragX);
        int newY = getY() + (e.getY() -startDragY);
        setLocation(newX, newY);
        inDrag = true;
        Main.drawPanel.repaint();
        Main.frame.repaint();
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {

    }






}
