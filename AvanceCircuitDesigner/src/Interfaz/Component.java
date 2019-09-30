package Interfaz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;


/**
 * Esta clase es la clase padre para todos los componentes
 *Maneja tanto eventos como metodos que se heredan a las compuertas, el metodo de simulacion, entradas y salidas.
 * */
//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

public class Component extends JLabel implements MouseListener, MouseMotionListener {
    /**
     * Necesarios para que funcione la aplicacion
     * */

    int numberConnected = 0;// Inicia sin nada conectado
    int id;//Parte de un IDfeature
    String type;//Se establece de forma diferente dependiendo de la subclase
    /**
     * Este metodo sobreescribe solo el punto de inicio
     *
     * */

    public void toggle() {
    }

    public boolean operation(Lista<Boolean> args) {//overwritten by subclasses
        return false;
    }

    public Lista<Boolean> userOperation(Lista<Boolean> args) {
        return (new Lista<Boolean>());
    }

    int value = 0; //Da el valor default a la compuerta, (Es por esto que entrada tiene un cero default)
    Lista<Input> inputs = new Lista<Input>(); //Lista de los componentes entradas
    Lista<Input> toggles = new Lista<Input>(); //Lista de los componentes para pasar
    //las entradas (Pasar de 0 a 1 ya que default de entrada es 0)
    Lista<Output> outputs = new Lista<Output>();//Lista de las salidas

    public Component(int ID, String text, int x, int y) {

        super(text);//Se extiende JLabel esto hace el JLabel con el texto dado
        id = ID;
        Main.currentComponentID++;

        Main.componentes.add(this);// Agrega los componentes a la lista principal
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
    public void paintComponent(Graphics g) {//este metodo es para repain en mi panel
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (Main.mostrarInputs) { // Las entradas solo se muestran cuando son apropiadas
            for (Input in : inputs) {
                in.paintConnector(g2d);
            }
        } else {
            for (Input tog : toggles) {
                tog.paintConnector(g2d);
            }
        }
        if (Main.mostrarOutputs) {
            for (Output out : outputs) {//Salidas solo se muestran cuando son apropiadas
                if (out.isAvailable()) {
                    out.paintConnector(g2d);
                }
            }
        }
    }


    int startDragX, startDragY;//Usado para el click and drag
    boolean inDrag = false;//Se establece verdadero cuando se llama el click and drag
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
    public void mousePressed(MouseEvent e) { //Evento que me permite clickear para hacer el click-and-drag (ref.)

        System.out.println(Main.modo);
        if (Main.modo.equals("erase")) {//Cuando esta en modo erase y se hace click sobre un componente deberia borrarse

            Main.drawPanel.remove(this);
            Main.componentes.remove(this);//El siguiente for remueve todas las conexiones asociadas con las entradas

            for (Input input : this.inputs) {
                for (Connection connection : input.connections) {

                    Main.drawPanel.remove(connection);
                    Main.lineas.remove(connection);

                    connection.output.connections.remove(connection);
                }
                input.connections.remove(input.connections);
            }

            for (Output output : this.outputs) {
                for (Connection connection : output.connections) {
                    Main.drawPanel.remove(connection);
                    Main.lineas.remove(connection);

                    connection.input.connections.remove(connection);
                }
                output.connections.remove(output.connections);
            }

            Main.drawPanel.repaint();
            Main.modo = "";//Si se necesita borrar de nuevo hay que hacer click en borrar de nuevo
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
    public void mouseClicked(MouseEvent e) { //Con este evento doy manejo a mis listas con respecto a lo que clickeo

        for (Input in : inputs) {
            if (in.component.type.equals("Start") && in.contains(e.getPoint())) {
                System.out.println("testtoggle");
                in.component.toggle();
            }
        }
        if (Main.modo.equals("choosingInput")) {// Cuando se este en Main.modo elegir entrada, se elige la entrada y luego se dibuja la linea
            // Cuando se esta en este modo tambien se epuede elegir una salida para la linea (SalidaSeleccionada)
            for (Input in : inputs) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lineas.add(new Connection(Main.currentConnectionID, Main.selectedOutput, in));//La aplicacion sabe donde dibujar la conexion desde que se selecciono la entrada
                    Main.drawPanel.repaint();
                    Main.modo = "";
                    Main.mostrarOutputs = true;
                }
            }
        }

        if (Main.modo.equals("choosingOutput")) {// Cuando se este en Main.modo elegir entrada, se elige la entrada y luego pasa a Main.modo elegir salida
            for (Output out : outputs) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.selectedOutput = out;
                    Main.mostrarOutputs = false;
                    Main.modo = "choosingInput";//Despues de elegir la salida se elige la entrada
                    Main.mostrarInputs = true;
                    Main.drawPanel.repaint();
                }
            }
        }
    }
    /**
     * Este metodo es el encargado del drag para la plantilla
     *
     * */

    @Override

    public void mouseDragged (MouseEvent e){
        int newX = getX() + (e.getX() - startDragX); // mueve el componente a su nueva localizacion
        int newY = getY() + (e.getY() - startDragY); // mueve el componente a su nueva localizacion
        setLocation(newX, newY);
        inDrag = true;
        Main.drawPanel.repaint();
        Main.frame.repaint();
    }
    @Override
    public void mouseMoved (MouseEvent arg0){
        //MetodoSin uso pero necesario

    }
}
