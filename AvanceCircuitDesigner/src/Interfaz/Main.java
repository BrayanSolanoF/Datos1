package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * Esta clase funciona como ventana principal de la aplicacion.
 * En ella se:
 * Define lo relacionado con interfaz de usuario
 * Establece botones en la paleta como imagenes
 *
 * */

public class Main   {

    /**
     *Los siguientes "fields" son usados para dar un # de ID a los objetos
     *
     * */
    static Lista<Componente> componentes = new Lista<Componente>(); //Lista de todos los componentes en la aplicacion
    static Lista<Conexion> lineas= new Lista<Conexion>(); //Lista de todas las conexiones entre las compuertas en la aplicacion
    public static int IDComponente = 0;
    public static int IDConector = 0;
    public static int IDConexion = 0;
    static String modo = "";
    static boolean mostrarEntradas = true, mostrarSalidas = true;
    static Salida SalidaSelecionada= null;

    //Titulo Ventana
    static JFrame frame = new JFrame("Circuit Designer");
    //Pantilla o "Canvas"
    static Plantilla drawPanel = new Plantilla();
    //Construtor
    Main(){

        //Cuando se cierre la ventana nuestro programa debe acabar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Hace visible la ventana
        frame.setVisible(true);

        drawPanel.setLayout(null);
        frame.add(drawPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel buttonspanel = new JPanel();
        //Split donde se encuentras los botones
        splitPane.setTopComponent(buttonspanel);
        frame.add(splitPane, BorderLayout.PAGE_START);

        //Botones como Jbuttons patra implementarlos a splitPane
        JButton andbutton = new JButton();
        //Se busca funcion para utilizar los Jbuttons con imagenes de cada componente
        try {
            Image img = ImageIO.read(getClass().getResource("./images/and.png"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/or.png"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/not.png"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/nand.png"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/nor.png"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/xor.png"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/xnor.png"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton newConnectionButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/Thread.png"));
            newConnectionButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton startButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/start.png"));
            startButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton endButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/end.png"));
            endButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton simulateButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/simulate.png"));
            simulateButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton eraseButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./images/erase.png"));
            eraseButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        
        //Agregar botones a la paleta
        buttonspanel.add(andbutton);
        buttonspanel.add(orbutton);
        buttonspanel.add(notbutton);
        buttonspanel.add(nandbutton);
        buttonspanel.add(norbutton);
        buttonspanel.add(xnorbutton);
        buttonspanel.add(xorbutton);
        buttonspanel.add(newConnectionButton);
        buttonspanel.add(startButton);
        buttonspanel.add(endButton);
        buttonspanel.add(simulateButton);
        buttonspanel.add(eraseButton);

        //Hasta este punto llegan el formato de las cosas del GUI
        //Acontinuacion vienen los eventos de los botones
        /**
         * actionPerformed es el unico metodo del paquete java.awt.event y es invocado al momento de hacer click en algun componente
         * */

        andbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeAnd();
            }
        });



        orbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeOr();
            }
        });

        notbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeNot();
            }
        });

        nandbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                makeNand();
            }
        });

        norbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                makeNor();
            }
        });

        xorbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                makeXor();
            }
        });

        xnorbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                makeXnor();
            }
        });

        newConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeConnection();
            }
        });


        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                makeStart();
            }
        });

        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                makeEnd();
            }
        });
        simulateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                simulate();
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                makeErase();
            }
        });


        frame.setVisible(true);
    }

    /**
     * Funciones para cada boton de acuerdo a cada modo
     *
     * */
    void makeAnd() {

        modo = "addingAnd";
    }

    void makeOr() {

        modo = "addingOr";
    }

    void makeNot() {

        modo = "addingNot";
    }

    void makeNand(){

        modo = "addingNand";
    }

    void makeNor(){
        modo = "addingNor";
    }

    void makeXor(){

        modo = "addingXor";
    }

    void makeXnor(){
        modo = "addingXnor";
    }

    void makeConnection() {

        modo = "choosingOutput";
        mostrarEntradas = false;
        mostrarSalidas= true;
        drawPanel.repaint();
    }

    void makeStart() {

        modo = "addingStart";
    }

    void makeEnd() {

        modo = "addingEnd";
    }

    void makeErase() {

        modo = "erase";

    }
    /**
     *  funcion para simular dentro del canvas
     * */
    int simulate() {
        int toBeReturned = -1; // valor de error, se retorna solo en caso de que no funcione la funcion

        int keepGoing = 0;

        while (keepGoing < 200) { //ciclo para asegurar que se alcanzo el final del circuito
            keepGoing++;
            int endsReached = 0;

            for (Componente gate : componentes) {
                boolean act = true;
              Lista<Boolean> inputValues = new Lista<Boolean>();
                for (Entrada entrada : gate.entradas) {
                    if (!(entrada.hasValue)) {
                        act = false; 
                    }
                    else {
                        inputValues.add(entrada.value);
                    }
                }
                if (act) {  //Asumiendo que la compuerta tiene valores en sus entradas
                    if (gate.type.equals("User")) { 
                        
                        int nextOne=0;
                        for (Salida out : gate.salidas) {
                            System.out.println("nextone is " + nextOne + "input value: " + inputValues + " value is " + (gate.userOperation(inputValues)));
                            out.value = gate.userOperation(inputValues).get(nextOne);
                            nextOne ++;
                        }
                    }
                    else { 
                        for (Salida out : gate.salidas){ // Transfiere valores desde las salidas hasta las entradas que estan conectadas
                            out.value = gate.operation(inputValues);
                        }
                    }
                    for (Salida out : gate.salidas) { 
                        for (Entrada input : out.inputsReceivingThis) {


                            input.value = out.value;
                            input.hasValue = true;
                        }
                    }
                    if (gate.type.equals("End")) {
                        boolean reached = false;
                        String result;
                        if (gate.entradas.get(0).value == false) {
                            result = Integer.toString(0);
                            reached = true;
                        }
                        else if (gate.entradas.get(0).value == true) {
                            result = Integer.toString(1);
                            reached = true;
                        }
                        else { 
                            result = "";
                        }

                        if (reached) { 
                            gate.setText(result);
                            endsReached +=1;
                        }

                        Lista<Componente> endPoints = new Lista<Componente>();
                        for (Component componente : componentes) {
                            if (componente.equals("End")) {
                                endPoints.add((Componente) componente);
                            }
                        }
                        if (endsReached >= endPoints.size()) { // Si todos los modos se alcanzaron con exito, entonces el circuito se completa
                            toBeReturned = 0; // retorna valor de exito

                        }

                    }
                }
                else {

                }


            }

        }
        return toBeReturned;




    }





    
    /**
     * Este metodo inicia la aplicacion.
     * @param args - argumentos a ejecutar de la pantalla principal
     *
     * */
    public static void main(String[] args){

        new Main();
    }
}


