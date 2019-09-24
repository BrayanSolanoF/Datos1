package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Componente extends JLabel implements MouseListener, MouseMotionListener {

    int numberConnected = 0;
    int id;
    public String type;

    public void toggle() {

    }
    public boolean operation(ArrayList<Boolean> args) { //overwritten by subclasses
        return false;
    }
    public ArrayList<Boolean> userOperation(ArrayList<Boolean> args) { //overwritten by subclasses
        return (new ArrayList<Boolean>());
    }
    int value = 0;
    ArrayList<Entrada> inputs = new ArrayList<Entrada>();
    ArrayList<Entrada> toggles = new ArrayList<Entrada>();
    ArrayList<Salida> outputs = new ArrayList<Salida>();
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
        outputs.add(o);
    }
    public void addInput(Entrada i) {
        inputs.add(i);
    }

    public void addtoToggles(Entrada i) {
        toggles.add(i);
    }

    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.mostrarEntradas) {
            for (Entrada in : inputs) {
                in.paintConnector(g2d);
            }
        }

        else {
            for (Entrada tog : toggles) {
                tog.paintConector(g2d);
            }
        }
        if (Main.mostrarSalidas) {
            for (Salida out : outputs) {
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

            for (Entrada input : this.inputs) {

                for (Conexion connection : input.conexiones) {

                    Main.drawPanel.remove(connection);
                    Main.lineas.remove(connection);

                    connection.salida.conexiones.remove(connection);




                }
                input.conexiones.remove(input.conexiones);
            }
            for (Salida output : this.outputs) {
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
        for (Entrada in : inputs) {
            if (in.componente.type.equals("Start") && in.contains(e.getPoint())){
                System.out.println("testtoggle");
                in.componente.toggle();

            }
        }
        if (Main.modo.equals("choosingInput")) {

            for (Entrada in : inputs) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lineas.add(new Conexion(Main.IDConexion, Main.SalidaSelecionada, in));

                    Main.drawPanel.repaint();
                    Main.modo = "";
                    Main.mostrarSalidas = true;

                }
            }
        }
        if (Main.modo.equals("choosingOutput")) {
            for (Salida out : outputs) {
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
