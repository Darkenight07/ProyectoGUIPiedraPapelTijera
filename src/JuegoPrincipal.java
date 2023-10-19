import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JuegoPrincipal {
    private static int rondas = 0;
    private static int puntosUsuario = 0;
    private static int puntosComputadora = 0;
    private static String anterior = null;

    public static void main(String[] args) {
        // Elementos importantes de la ventana
        JFrame frame = new JFrame("Juego Piedra, papel y tijera");
        JTextField cajaTexto = new JTextField();

        // Textos
        JLabel textoPrincipal = new JLabel("Juego Piedra, papel y tijera");
        JLabel textoResultado = new JLabel();
        JLabel textoPuntosUsuario = new JLabel("Puntos usuario: " + puntosUsuario);
        JLabel textoPuntosComputadora = new JLabel("Puntos computadora: " + puntosComputadora);

        // Botones
        JButton botonEnviar = new JButton("Enviar");
        JButton botonComoSeJuega = new JButton("¿Como se juega?");
        JButton botonReiniciar = new JButton("Reiniciar");

        // Ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setResizable(false);

        // Texto principal
        textoPrincipal.setBounds(75, 100, 100, 100);
        textoPrincipal.setSize(500, 100);
        textoPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(textoPrincipal);

        // Texto de resultado del ganador
        textoResultado.setBounds(160, 150, 100, 100);
        frame.add(textoResultado);

        // Caja de texto
        cajaTexto.setBounds(120, 250, 130, 20);
        frame.add(cajaTexto);

        // Boton
        botonEnviar.setBounds(150, 300, 80, 30);
        frame.add(botonEnviar);

        // Boton de como se juega
        botonComoSeJuega.setBounds(10, 15, 120, 30);
        botonComoSeJuega.setSize(137,30);
        frame.add(botonComoSeJuega);

        // Texto contador puntos usuario
        textoPuntosUsuario.setBounds(10, 50, 100, 100);
        frame.add(textoPuntosUsuario);

        // Texto contador puntos computadora
        textoPuntosComputadora.setBounds(10, 70, 135, 100);
        frame.add(textoPuntosComputadora);

        // Boton para reiniciar juego
        botonReiniciar.setBounds(287, 15, 90, 30);
        frame.add(botonReiniciar);

        // Accion del boton
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionElegidaUsuario = cajaTexto.getText().toLowerCase();

                if (opcionElegidaUsuario.equals("piedra") || opcionElegidaUsuario.equals("papel") || opcionElegidaUsuario.equals("tijera")) {
                    Random random = new Random();
                    int opcionElegidaComputadora = random.nextInt(3);
                    String opcionComputadora = null;

                    if (opcionElegidaComputadora == 0 ) {
                        opcionComputadora = "piedra";
                    } else if (opcionElegidaComputadora == 1) {
                        opcionComputadora = "papel";
                    } else if (opcionElegidaComputadora == 2) {
                        opcionComputadora = "tijera";
                    }

                    if (rondas == 5 ) {
                        System.out.println("Fin del juego, han pasado 5 rondas");
                        if (puntosUsuario >= 2 && puntosComputadora < puntosUsuario) {
                            JOptionPane.showMessageDialog(frame, "El usuario gano " + "con " + puntosUsuario + " puntos");
                        } else if (puntosUsuario <= 1 && puntosComputadora < puntosUsuario) {
                            JOptionPane.showMessageDialog(frame, "El usuario ganó " + "con " + puntosUsuario + " punto");
                        } else if (puntosComputadora >= 2 && puntosUsuario < puntosComputadora) {
                            JOptionPane.showMessageDialog(frame, "La computadora gano " + "con " + puntosComputadora + " puntos");
                        } else if (puntosComputadora <= 1 && puntosUsuario < puntosComputadora) {
                            JOptionPane.showMessageDialog(frame, "La computadora ganó " + "con " + puntosComputadora + " punto");
                        } else if (puntosUsuario == puntosComputadora) {
                            if (puntosUsuario >= 2 && puntosComputadora >= 2) {
                                JOptionPane.showMessageDialog(frame, "Empate " + "con " + puntosUsuario + " puntos el usuario y " + puntosComputadora + " puntos la computadora");
                            } else if (puntosUsuario < 2 && puntosComputadora < 2) {
                                JOptionPane.showMessageDialog(frame, "Empate " + "con " + puntosUsuario + " punto el usuario y " + puntosComputadora + " punto la computadora");
                            }
                        }
                    } else {
                        System.out.println("Siguiente ronda");

                        if (opcionElegidaUsuario.equals(opcionComputadora) ) {
                            System.out.println("Empate");
                            textoResultado.setText("Empate");
                        } else if (opcionElegidaUsuario.equals("papel") && opcionComputadora.equals("piedra") ) {
                            System.out.println("Ganaste");
                            textoResultado.setText("Ganaste");
                            puntosUsuario = puntosUsuario + 1;
                        } else if (opcionElegidaUsuario.equals("piedra") && opcionComputadora.equals("tijera") ) {
                            System.out.println("Ganaste");
                            textoResultado.setText("Ganaste");
                            puntosUsuario = puntosUsuario + 1;
                        } else if (opcionElegidaUsuario.equals("tijera") && opcionComputadora.equals("papel") ) {
                            System.out.println("Ganaste");
                            textoResultado.setText("Ganaste");
                            puntosUsuario = puntosUsuario + 1;
                        } else {
                            System.out.println("Perdiste");
                            textoResultado.setText("Perdiste");
                            puntosComputadora = puntosComputadora + 1;
                        }
                        rondas++;
                    }
                } else {
                    System.out.println("No has introducido ningun valor o no es valido");
                }
                textoPuntosUsuario.setText("Puntos usuario: " + puntosUsuario);
                textoPuntosComputadora.setText("Puntos computadora: " + puntosComputadora);
            }
        });
        // Accion del boton de como se juega
        botonComoSeJuega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Para jugar debes introducir en la caja de texto: piedra, papel o tijera y dar en el boton de enviar");
            }
        });

        // Cuando se aprieta el boton de "Reiniciar" se reinician los puntos a 0
        botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rondas = 0;
                puntosUsuario = 0;
                puntosComputadora = 0;
                textoPuntosUsuario.setText("Puntos usuario: " + puntosUsuario);
                textoPuntosComputadora.setText("Puntos computadora: " + puntosComputadora);
                System.out.println("Se reiniciaron los puntos a 0");
            }
        });
        frame.setVisible(true);
    }
}