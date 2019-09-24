package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

abstract class Componente extends JLabel implements MouseListener, MouseMotionListener {

    int numberConnected = 0;
    int id;
    String type;

    public void toggle() {

    }
    public boolean operation(ArrayList<Boolean> args) { //overwritten by subclasses
        return false;
    }
    public ArrayList<Boolean> userOperation(ArrayList<Boolean> args) { //overwritten by subclasses
        return (new ArrayList<Boolean>());
    }
    int value = 0;
    ArrayList<Input> inputs = new ArrayList<Input>();
    ArrayList<Input> toggles = new ArrayList<Input>();
    ArrayList<Output> outputs = new ArrayList<Output>();
    public Componente(int ID, String text, int x, int y) {

        super(text);
        id = ID;
        Main.IDComponente++;

        Main.components.add(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        Main.drawPanel.add(this);
    }

    public void addOutput(Output o) {
        outputs.add(o);
    }
    public void addInput(Input i) {
        inputs.add(i);
    }

    public void addtoToggles(Input i) {
        toggles.add(i);
    }

    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.showInputs) {
            for (Input in : inputs) {
                in.paintConnector(g2d);
            }
        }

        else {
            for (Input tog : toggles) {
                tog.paintConnector(g2d);
            }
        }
        if (Main.showOutputs) {
            for (Output out : outputs) {
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

        System.out.println(Main.mode);
        if (Main.mode.equals("erase")) {


            Main.drawPanel.remove(this);
            Main.components.remove(this);

            for (Input input : this.inputs) {

                for (Connection connection : input.connections) {

                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.output.connections.remove(connection);




                }
                input.connections.remove(input.connections);
            }
            for (Output output : this.outputs) {
                for (Connection connection : output.connections) {
                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.input.connections.remove(connection);
                }
                output.connections.remove(output.connections);
            }

            Main.drawPanel.repaint();
            Main.mode = "";

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
        for (Input in : inputs) {
            if (in.component.type.equals("Start") && in.contains(e.getPoint())){
                System.out.println("testtoggle");
                in.component.toggle();

            }
        }
        if (Main.mode.equals("choosingInput")) {

            for (Input in : inputs) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lines.add(new Connection(Main.currentConnectionID, Main.selectedOutput, in));

                    Main.drawPanel.repaint();
                    Main.mode = "";
                    Main.showOutputs = true;

                }
            }
        }
        if (Main.mode.equals("choosingOutput")) {
            for (Output out : outputs) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.selectedOutput = out;
                    Main.showOutputs = false;
                    Main.mode = "choosingInput";
                    Main.showInputs = true;

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
