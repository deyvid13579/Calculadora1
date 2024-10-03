package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loggin implements ActionListener {
    
    JFrame frame = new JFrame("Iniciar Sesión");
    JLabel iniciarSesion = new JLabel("INICIAR SESION");
    JLabel usuarioLabel = new JLabel("Usuario: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usuarioField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton registrarseButton = new JButton("Registrarse");
    JButton accederButton = new JButton("Acceder");
    JButton cancelarButton = new JButton("Cancelar"); // Nuevo botón

    HashMap<String, String> usersDB = new HashMap<>();

    public Loggin() {
        loadUsers();
        initComponents(); 
    }

    private void initComponents() {
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarSesion.setBounds(150, 20, 150, 30);
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
        
        usuarioLabel.setBounds(50, 70, 100, 30);
        usuarioField.setBounds(150, 70, 200, 30);

        passwordLabel.setBounds(50, 120, 100, 30);
        passwordField.setBounds(150, 120, 200, 30);

        registrarseButton.setBounds(50, 180, 120, 30);
        accederButton.setBounds(200, 180, 120, 30);
        cancelarButton.setBounds(125, 220, 120, 30); // Posicionar el botón Cancelar
        
        registrarseButton.addActionListener(this);
        accederButton.addActionListener(this);
        cancelarButton.addActionListener(e -> frame.dispose()); // Acción para el botón Cancelar
        
        frame.add(iniciarSesion);
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(registrarseButton);
        frame.add(accederButton);
        frame.add(cancelarButton); // Agregar el botón Cancelar
        
        frame.setVisible(true);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\users.txt"))) {
            String line;
            usersDB.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    usersDB.put(parts[0], parts[1]);
                }  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accederButton) {
            String user = usuarioField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (!usersDB.containsKey(user)) {
                JOptionPane.showMessageDialog(frame, "El usuario no existe.");
            } else if (!usersDB.get(user).equals(pass)) {
                JOptionPane.showMessageDialog(frame, "Error en la contraseña del usuario.");
            } else {
                JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso");
                frame.dispose();
                try {
                    new ventana(user);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == registrarseButton) {
            frame.dispose();
            new Register(); // Pasar la instancia de Loggin a Register
        }
    }

    public void refreshUsers() {
        loadUsers(); // Recargar usuarios desde el archivo
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
