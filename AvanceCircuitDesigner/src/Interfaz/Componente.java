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
    int value = 0;//Da el valor default a la compuerta, (Es por esto que entrada tiene un cero default)
    Lista<Entrada> entradas = new Lista<Entrada>();//Lista de los componentes entradas
    Lista<Entrada> toggles = new Lista<Entrada>();//Lista de los componentes para pasar las entradas (Pasar de 0 a 1 ya que default de entrada es 0)
    Lista<Salida> salidas = new Lista<Salida>();//Lista de las salidas
    public Componente(int ID, String text, int x, int y) {

        super(text);//Se extiende JLabel esto hace el JLabel con el texto dado
        id = ID;
        Main.IDComponente++;

        Main.componentes.add(this);// Agrega los componentes a la lista principal
        addMouseListener(this);//Permite los mouse events en los componentes
        addMouseMotionListener(this);
        Main.drawPanel.add(this);//Hace que el componente aparezca en la plantilla
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
    /**
     * Este metodo muestra o desplega el componente
     * Esto se llama en drawPanel.repaint()
     * */
    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.mostrarEntradas) { // Las entradas solo se muestran cuando son apropiadas
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
            for (Salida out : salidas) { //Salidas solo se muestran cuando son apropiadas
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
     * Este es el click de click and drag
     * */
    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(Main.modo);
        if (Main.modo.equals("erase")) { //Cuando esta en modo erase y se hace click sobre un componente deberia borrarse


            Main.drawPanel.remove(this);
            Main.componentes.remove(this);
            //El siguiente for remueve todas las conexiones asociadas con las entradas
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
            Main.modo = ""; //Si se necesita borrar de nuevo hay que hacer click en borrar de nuevo

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
        for (Entrada in : entradas) {
            if (in.componente.type.equals("Start") && in.contains(e.getPoint())){
                System.out.println("testtoggle");
                in.componente.toggle();

            }
        }
        if (Main.modo.equals("choosingInput")) { // Cuando se este en Main.modo elegir entrada, se elige la entrada y luego se dibuja la linea
                                                 // Cuando se esta en este modo tambien se epuede elegir una salida para la linea (SalidaSeleccionada)
            for (Entrada in : entradas) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lineas.add(new Conexion(Main.IDConexion, Main.SalidaSelecionada, in));

                    Main.drawPanel.repaint();
                    Main.modo = "";
                    Main.mostrarSalidas = true;

                }
            }
        }
        if (Main.modo.equals("choosingOutput")) { // Cuando se este en Main.modo elegir entrada, se elige la entrada y luego pasa a Main.modo elegir salida
            for (Salida out : salidas) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.SalidaSelecionada = out; //La aplicacion sabe donde dibujar la conexion desde que se selecciono la entrada
                    Main.mostrarSalidas = false;
                    Main.modo = "choosingInput"; //Despues de elegir la salida se elige la entrada
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
        int newX = getX()  + (e.getX() -startDragX); // mueve el componente a su nueva localizacion
        int newY = getY() + (e.getY() -startDragY); // mueve el componente a su nueva localizacion
        setLocation(newX, newY);
        inDrag = true;
        Main.drawPanel.repaint();
        Main.frame.repaint();
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {
        // Metodo sin uso pero necesario
    }






}
