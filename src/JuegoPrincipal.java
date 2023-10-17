import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JuegoPrincipal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego");
        JTextField cajaTexto = new JTextField();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setResizable(false);

        // Texto principal
        JLabel textoPrincipal = new JLabel("Juego Piedra, papel y tijera");
        textoPrincipal.setBounds(75, 100, 100, 100);
        textoPrincipal.setSize(500, 100);
        textoPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(textoPrincipal);

        // Caja de texto
        cajaTexto.setBounds(120, 250, 130, 20);
        frame.add(cajaTexto);

        // Boton
        JButton boton = new JButton("Ingresar");
        boton.setBounds(120, 280, 130, 20);
        frame.add(boton);

        // Evento del boton
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String opcionElegidaUsuario = cajaTexto.getText();
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

                int rondas = 0;
                int puntosUsuario = 0;
                int puntosComputadora = 0;

                if (rondas == 5) {
                    System.out.println("Fin del juego, han pasado 5 rondas");

                    if (puntosUsuario > puntosComputadora) {
                        System.out.println("El usuario gano");
                    } else if (puntosComputadora > puntosComputadora) {
                        System.out.println("La computadora gano");
                    } else if (puntosUsuario == puntosComputadora) {
                        System.out.println("Empate");
                    }


                } else if (rondas < 5) {
                    System.out.println("Siguiente ronda");

                    System.out.println(opcionElegidaUsuario + " " + opcionComputadora);

                    if (opcionElegidaUsuario.equals(opcionComputadora) ) {
                        System.out.println("Empate");
                    } else if (opcionElegidaUsuario.equals("papel") && opcionComputadora.equals("piedra") ) {
                        System.out.println("Ganaste");
                        puntosUsuario = puntosUsuario + 1;
                    } else if (opcionElegidaUsuario.equals("piedra") && opcionComputadora.equals("tijera") ) {
                        System.out.println("Ganaste");
                        puntosUsuario = puntosUsuario + 1;
                    } else if (opcionElegidaUsuario.equals("tijera") && opcionComputadora.equals("papel") ) {
                        System.out.println("Ganaste");
                        puntosUsuario = puntosUsuario + 1;
                    } else {
                        System.out.println("Perdiste");
                        puntosComputadora = puntosComputadora + 1;
                    }

                }
                rondas = rondas + 1;

            }
        });

        frame.setVisible(true);
    }
}