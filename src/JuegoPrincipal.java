import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
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

                System.out.println(opcionComputadora + " " + opcionElegidaUsuario);

                if (opcionElegidaUsuario.equals(opcionComputadora) ) {
                    System.out.println("Empate");
                } else if (opcionElegidaUsuario == "papel" || opcionComputadora == "piedra" ) {
                    System.out.println("Ganaste");
                } else if (opcionElegidaUsuario == "piedra" || opcionComputadora == "tijera") {
                    System.out.println("Ganaste");
                } else if (opcionElegidaUsuario == "tijera" || opcionComputadora == "papel" ) {
                    System.out.println("Ganaste");
                } else {
                    System.out.println("Perdiste");
                }

            }
        });

        frame.setVisible(true);
    }
}