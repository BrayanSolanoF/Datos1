package Interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

/**
 * Esta clase es la clase padre para todos los componentes
 *Maneja tanto eventos como metodos que se heredan a las compuertas, el metodo de simulacion, entradas y salidas.
 * */

public class Component extends JLabel implements MouseListener, MouseMotionListener {
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
    int value = 0;//Da el valor default a la compuerta, (Es por esto que entrada tiene un cero default)
    Lista<Input> inputs = new Lista<Input>();//Lista de los componentes entradas
    Lista<Input> toggles = new Lista<Input>();//Lista de los componentes para pasar las entradas (Pasar de 0 a 1 ya que default de entrada es 0)
    Lista<Output> outputs = new Lista<Output>();//Lista de las salidas
    public Component(int ID, String text, int x, int y) {

        super(text);//Se extiende JLabel esto hace el JLabel con el texto dado
        id = ID;
        Main.currentComponentID++;

        Main.components.add(this);// Agrega los componentes a la lista principal
        addMouseListener(this);//Permite los mouse events en los componentes
        addMouseMotionListener(this);
        Main.drawPanel.add(this);//Hace que el componente aparezca en la plantilla
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
    /**
     * Este metodo muestra o desplega el componente
     * Esto se llama en drawPanel.repaint()
     * */
    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.showInputs) { // Las entradas solo se muestran cuando son apropiadas
            for (Input in : inputs) {
                in.paintConnector(g2d);
            }
        }

        else {
            for (Input tog : toggles) {
                tog.paintConector(g2d);
            }
        }
        if (Main.showOutputs) {
            for (Output out : outputs) { //Salidas solo se muestran cuando son apropiadas
                if (out.isAvailable()) {
                    out.paintConnector(g2d);
                }

            }
        }
    }

    int startDragX, startDragY; //Usado para el click and drag
    boolean inDrag = false; //Se establece verdadero cuando se llama el click and drag
    /**
     * Este metodo no hace nada literal pero es necesario para Java ya que podria hacer algo
     * */
    @Override
    public void mouseEntered(MouseEvent e) {


    }
    /**
     * Este metodo no hace nada literal pero es necesario para Java ya que podria hacer algo
     * */
    @Override
    public void mouseExited(MouseEvent e) {

    }
    /**
     * Este metodo es el click de click and drag
     * */
    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(Main.mode);
        if (Main.mode.equals("erase")) { //Cuando esta en modo erase y se hace click sobre un componente deberia borrarse


            Main.drawPanel.remove(this);
            Main.components.remove(this);
            //El siguiente for remueve todas las conexiones asociadas con las entradas
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
            Main.mode = ""; //Si se necesita borrar de nuevo hay que hacer click en borrar de nuevo

        }
        startDragX = e.getX();// Localizacion del mouse en todoo momento que este clickeado
        startDragY = e.getY();// Localizacion del mouse en todoo momento que este clickeado

    }
    /**
     * Este metodo es para cuando se libera el mouse de click and drag
     * */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (inDrag) {
            inDrag = false;
        }
    }
    /**
     * Este metodo es para cuando se hace click en un punto de inicio de la entrada (tipo switch) esto pasa al valor inicial
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Input in : inputs) {
            if (in.component.type.equals("Start") && in.contains(e.getPoint())){
                System.out.println("testtoggle");
                in.component.toggle();

            }
        }
        if (Main.mode.equals("choosingInput")) { // Cuando se este en Main.modo elegir entrada, se elige la entrada y luego se dibuja la linea
                                                 // Cuando se esta en este modo tambien se epuede elegir una salida para la linea (SalidaSeleccionada)
            for (Input in : inputs) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lines.add(new Connection(Main.currentConnectionID, Main.selectedOutput, in));

                    Main.drawPanel.repaint();
                    Main.mode = "";
                    Main.showOutputs = true;

                }
            }
        }
        if (Main.mode.equals("choosingOutput")) { // Cuando se este en Main.modo elegir entrada, se elige la entrada y luego pasa a Main.modo elegir salida
            for (Output out : outputs) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.selectedOutput = out; //La aplicacion sabe donde dibujar la conexion desde que se selecciono la entrada
                    Main.showOutputs = false;
                    Main.mode = "choosingInput"; //Despues de elegir la salida se elige la entrada
                    Main.showInputs = true;

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
        int newX = getX()  + (e.getX() -startDragX); // mueve el componente a su nueva localizacion
        int newY = getY() + (e.getY() -startDragY); // mueve el componente a su nueva localizacion
        setLocation(newX, newY);
        inDrag = true;
        Main.drawPanel.repaint();
        Main.frame.repaint();
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {
        //MetodoSin uso pero necesario
    }






}
