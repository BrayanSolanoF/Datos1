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

public class Main {

    /**
     * Los siguientes "fields" son usados para dar un # de ID a los objetos
     */
    static Lista<Component> components = new Lista<Component>(); //Lista de todos los componentes en la aplicacion
    static Lista<Connection> lines = new Lista<Connection>(); //Lista de todas las conexiones entre las compuertas en la aplicacion
    public static int currentComponentID = 0;
    public static int currentConnectorID = 0;
    public static int currentConnectionID = 0;
    static String mode = "";
    static boolean showInputs = true, showOutputs = true;
    static Output selectedOutput = null;

    //Titulo Ventana
    static JFrame frame = new JFrame("Circuit Designer");
    //Pantilla o "Canvas"
    static Plantilla drawPanel = new Plantilla();

    //Construtor
    Main() {

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
        frame.add(splitPane, BorderLayout.PAGE_END);

        //Botones como Jbuttons patra implementarlos a splitPane
        JButton andbutton = new JButton();
        //Se busca funcion para utilizar los Jbuttons con imagenes de cada componente
        try {
            Image img = ImageIO.read(getClass().getResource("./and.png"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println();
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./or.png"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./not.png"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nand.png"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nor.png"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xor.png"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xnor.png"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton newConnectionButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./Thread.png"));
            newConnectionButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton startButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./start.png"));
            startButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton endButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./end.png"));
            endButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton simulateButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./simulate.png"));
            simulateButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton eraseButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./erase.png"));
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

        nandbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                makeNand();
            }
        });

        norbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                makeNor();
            }
        });

        xorbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                makeXor();
            }
        });

        xnorbutton.addActionListener(new ActionListener() {

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
     */
    private void makeAnd() {

        mode = "addingAnd";
    }

    void makeOr() {

        mode = "addingOr";
    }

    void makeNot() {

        mode = "addingNot";
    }

    void makeNand() {

        mode = "addingNand";
    }

    void makeNor() {
        mode = "addingNor";
    }

    void makeXor() {

        mode = "addingXor";
    }

    void makeXnor() {
        mode = "addingXnor";
    }

    void makeConnection() {

        mode = "choosingOutput";
        showInputs = false;
        showOutputs = true;
        drawPanel.repaint();
    }

    void makeStart() {

        mode = "addingStart";
    }

    void makeEnd() {

        mode = "addingEnd";
    }

    void makeErase() {

        mode = "erase";

    }

    /**
     * funcion para simular dentro del canvas
     */
    int simulate() {
        int toBeReturned = -1; // valor de error, se retorna solo en caso de que no funcione la funcion

        int keepGoing = 0;

        while (keepGoing < 200) { //ciclo para asegurar que se alcanzo el final del circuito
            keepGoing++;
            int endsReached = 0;

            for (Component gate : components) {
                boolean act = true;
                Lista<Boolean> inputValues = new Lista<Boolean>();
                for (Input input : gate.inputs) {
                    if (!(input.hasValue)) {
                        act = false;
                    } else {
                        inputValues.add(input.value);
                    }
                }
                if (act) {  //Asumiendo que la compuerta tiene valores en sus entradas
                    if (gate.type.equals("User")) {

                        int nextOne = 0;
                        for (Output out : gate.outputs) {
                            System.out.println("nextone is " + nextOne + "input value: " + inputValues + " value is " + (gate.userOperation(inputValues)));
                            out.value = gate.userOperation(inputValues).get(nextOne);
                            nextOne++;
                        }
                    } else {
                        for (Output out : gate.outputs) { // Transfiere valores desde las salidas hasta las entradas que estan conectadas
                            out.value = gate.operation(inputValues);
                        }
                    }
                    for (Output out : gate.outputs) {
                        for (Input input : out.inputsReceivingThis) {


                            input.value = out.value;
                            input.hasValue = true;
                        }
                    }
                    if (gate.type.equals("End")) {
                        boolean reached = false;
                        String result;
                        if (!gate.inputs.get(0).value) {
                            result = Integer.toString(0);
                            reached = true;
                        } else if (gate.inputs.get(0).value) {
                            result = Integer.toString(1);
                            reached = true;
                        } else {
                            result = "";
                        }

                        if (reached) {
                            gate.setText(result);
                            endsReached += 1;
                        }

                        Lista<Component> endPoints = new Lista<Component>();
                        for (Component component : components) {
                            if (component.equals("End")) {
                                endPoints.add((Component) component);
                            }
                        }
                        if (endsReached >= endPoints.size()) { // Si todos los modos se alcanzaron con exito, entonces el circuito se completa
                            toBeReturned = 0; // retorna valor de exito

                        }

                    }
                } else {

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


