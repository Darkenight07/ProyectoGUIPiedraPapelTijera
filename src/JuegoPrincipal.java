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
        // Elementos importantes
        JFrame frame = new JFrame("Juego");
        JTextField cajaTexto = new JTextField();
        JButton boton = new JButton("Enviar");
        JLabel textoPrincipal = new JLabel("Juego Piedra, papel y tijera");

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
        JLabel textoResultado = new JLabel();
        textoResultado.setBounds(160, 150, 100, 100);
        frame.add(textoResultado);

        // Caja de texto
        cajaTexto.setBounds(120, 250, 130, 20);
        frame.add(cajaTexto);

        // Boton
        boton.setBounds(150, 300, 80, 30);
        frame.add(boton);

        // Boton de como se juega
        JButton botonComoSeJuega = new JButton("¿Como se juega?");
        botonComoSeJuega.setBounds(10, 15, 120, 30);
        botonComoSeJuega.setSize(137,30);
        frame.add(botonComoSeJuega);

        // Accion del boton
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionElegidaUsuario = cajaTexto.getText().toLowerCase();

                if (opcionElegidaUsuario.equals("piedra") || opcionElegidaUsuario.equals("papel") || opcionElegidaUsuario.equals("tijera")) {
                    if (opcionElegidaUsuario.equals(anterior)) {
                        JOptionPane.showMessageDialog(frame, "Has repetido la misma opcion en la anterior ronda, " + "antes elegiste " + anterior);
                    } else {
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

                        if (rondas == 5) {
                            System.out.println("Fin del juego, han pasado 5 rondas");

                            if (puntosUsuario > puntosComputadora) {
                                JOptionPane.showMessageDialog(frame, "El usuario gano " + "con " + puntosUsuario + " puntos");
                            } else if (puntosComputadora > puntosUsuario) {
                                JOptionPane.showMessageDialog(frame, "La computadora gano " + "con " + puntosComputadora + " puntos");
                            } else if (puntosUsuario == puntosComputadora) {
                                JOptionPane.showMessageDialog(frame, "Empate " + "con " + puntosUsuario + " puntos el usuario y " + puntosComputadora + " puntos la computadora");
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
                            anterior = opcionElegidaUsuario; // Actualiza el valor de anterior
                        }
                    }
                } else {
                    System.out.println("No has introducido ningun valor o no es valido");
                }
            }
        });

        // Accion del boton de como se juega
        botonComoSeJuega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Para jugar debes introducir en la caja de texto: piedra, papel o tijera y dar en el boton de enviar");
            }
        });

        frame.setVisible(true);

    }
}
