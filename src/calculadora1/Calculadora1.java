
package calculadora1;

import interfaz.Loggin;
import interfaz.ventana;
import java.io.IOException;

public class Calculadora1 {
    private String usuario;  // Variable para almacenar el usuario

    public Calculadora1(String user) {
        this.usuario = user;  // Guarda el usuario que ha iniciado sesión
        try {
            new ventana(usuario); // Abre la ventana de la calculadora
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public static void main(String[] args) {
        launchApp();
    }

    public static void launchApp() {
        Loggin login = new Loggin();
        login.setVisible(true);
    }
}