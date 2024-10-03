# Calculadora en NetBeans

Esta es una aplicación de calculadora sencilla desarrollada en Java utilizando el entorno de desarrollo NetBeans. Permite realizar operaciones matemáticas básicas como suma, resta, multiplicación y división de manera intuitiva y fácil de usar.

## Características
- Realiza operaciones matemáticas básicas (suma, resta, multiplicación, división).
- Interfaz gráfica amigable y fácil de navegar.
- Manejo de errores para evitar divisiones por cero y entradas no válidas.

## Tecnologías Utilizadas
- Java
- Java Swing para la interfaz gráfica
- NetBeans IDE como entorno de desarrollo

## Instalación
1. Clona este repositorio.
2. Abre el proyecto en NetBeans.
3. Ejecuta el archivo `Calculadora.java` para iniciar la aplicación.

## Uso
Simplemente ingresa los números y selecciona la operación deseada. La calculadora mostrará el resultado en la interfaz.

## Contribución
Si deseas contribuir, por favor crea un fork del repositorio y envía un pull request con tus mejoras.




package Operaciones;

public class Operaciones {
   //Entrada:Dos enteros a y b.
//Salida: La suma de a y b.
//Es una funcion que Devuelve el resultado de sumar los dos números
    public int sumar(int a , int b){
        return a + b;
    }
    //Entrada:Dos enteros a y b.
//Salida: La resta de a y b.
//Es una funcion que Devuelve el resultado la resta de los dos números
    public int restar(int a , int b){
        return a - b;
    }
    //Entrada:Dos enteros a y b.
//Salida: La multiplicasion de a y b.
//Es una funcion que Devuelve el resultado de la multiplicasion de los dos números
    public int multiplicar(int a , int b){
        return a * b;
    }
    //Entrada:Dos enteros a y b.
//Salida: La division de a y b.
//Es una funcion que devuelves el divisor pero antes comprueba si b es 0 ya que el 0 no es tomado encuenta en matematicas si no b no es 0 entonces saca el reultado.
    public int dividir(int a , int b){
        if (b == 0) {
            throw new IllegalArgumentException("División por cero no es permitida.");
        }
        return (int) a / b;
    }
    // esta funcion hace que ve sea entero y que b tome con desimales:
    public double porcentaje(int b){
        b=b/100;
        return b;
    }
    
}




//organiza el codigo
package calculadora1;

import interfaz.Loggin;
import interfaz.ventana;
import java.io.IOException;

public class Calculadora1 {
    private String usuario;  
// Variable para almacenar el usuario

    public Calculadora1(String user) {
        this.usuario = user;  
// Guarda el usuario que ha iniciado sesión
        try {
            new ventana(usuario); 
// Abre la ventana de la calculadora
        } catch (IOException e) {
            e.printStackTrace(); 
// Manejo de excepciones
        }
    }
//Ejecucuion del programa
    public static void main(String[] args) {
        launchApp();
    }
// encargado de mostrar la ventana de inicio de sesion.
    public static void launchApp() {
        Loggin login = new Loggin();
        login.setVisible(true);
    }
}





package interfaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//constructor
public class Archivos  {
    //Atributos de la clase
    private String nombre;
    private File archivo;

    public Archivos(String nombre)  {
        this.nombre=nombre;      
    }
    // metodo para crear archivos en alguna ruta especificada
    public void  create( String ruta) throws IOException  {
        this.archivo = new File(ruta);
        this.archivo.createNewFile();        
    }
 
    public String getNombre(){
    return this.nombre;
    }
    
    // Registra linias en un archivo
    public  boolean registrar(String linea){
        try {
            if(archivo.exists()){
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return  true;
            }
        } catch (IOException ex) {
            System.out.println("error de archivo: "+ex);
               
        }
        return false;
    }
    
    // Limpia el archivo 
    public boolean limpiarArchivo(){
        try {
            String directorio = archivo.getParent();
            archivo.delete();
            new FileWriter(directorio+"/datos.txt",true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Métodos para Obtener y Establecer Atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public File getArchivo() {
        return archivo;
    }
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
}



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
//constructor
public class Loggin implements ActionListener {
    //atributos de cada clase
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
     //inicializacion de los componentes
    private void initComponents() {
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //posición y estilo de los componentes
        iniciarSesion.setBounds(150, 20, 150, 30);
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
        //etiquetas y campos
        usuarioLabel.setBounds(50, 70, 100, 30);
        usuarioField.setBounds(150, 70, 200, 30);

        passwordLabel.setBounds(50, 120, 100, 30);
        passwordField.setBounds(150, 120, 200, 30);

        registrarseButton.setBounds(50, 180, 120, 30);
        accederButton.setBounds(200, 180, 120, 30);
        cancelarButton.setBounds(125, 220, 120, 30);
        // Asignar acciones a los botones
        registrarseButton.addActionListener(this);
        accederButton.addActionListener(this);
        cancelarButton.addActionListener(e -> frame.dispose()); 
        // Agregar componentes al marco
        frame.add(iniciarSesion);
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(registrarseButton);
        frame.add(accederButton);
        frame.add(cancelarButton);
        
        frame.setVisible(true);
    }
    // Carga de archivos (como nombres,apellidos)
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
    //Manejo de acciones como(las funcionavilidades de cada boton y mensajes de cada funcion o actividad realizada)
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
            new Register();
        }
    }
  // metodo para cargar las listas mientras enta en ejecucion.
    public void refreshUsers() {
        loadUsers();
    }
   // controlar la visividad del marco.
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}




package interfaz;

import calculadora1.Calculadora1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register implements ActionListener {
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JFrame frame;
  // constructor
    public Register() {
        frame = new JFrame("Registrar Usuario");
        usuarioField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Guardar");
        JButton cancelButton = new JButton("Cancelar");

        // Configurar la interfaz de usuario
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Etiquetas
        JLabel usuarioLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        JLabel confirmPasswordLabel = new JLabel("Confirme Contraseña:");

        // Establecer límites para los componentes
        usuarioLabel.setBounds(30, 20, 100, 30);
        usuarioField.setBounds(150, 20, 120, 30);
        passwordLabel.setBounds(30, 60, 100, 30);
        passwordField.setBounds(150, 60, 120, 30);
        confirmPasswordLabel.setBounds(30, 100, 150, 30);
        confirmPasswordField.setBounds(150, 100, 120, 30);
        registerButton.setBounds(30, 150, 120, 30);
        cancelButton.setBounds(160, 150, 120, 30);

        // Agregar componentes al marco
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(cancelButton);

        registerButton.addActionListener(this);
        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //manejo de accciones para dar la funcionabilidad de cada boton de y registro como mensaje del error que sale guando ingres datos 
    public void actionPerformed(ActionEvent e) {
        String usuario = usuarioField.getText().trim();
        String contraseña = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        // Validar que las contraseñas coincidan
        if (!contraseña.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden. Inténtalo de nuevo.");
            return;
        }

        // Guardar el nuevo usuario
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\users.txt", true))) {
            escritor.write(usuario + "," + contraseña);
            escritor.newLine();
            escritor.flush();
            JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
            frame.dispose(); // Cerrar el marco de registro
            Calculadora1.launchApp(); // Reiniciar la aplicación
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error al registrar el usuario.");
            ex.printStackTrace();
        }
    }
}





package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
//constructor
public class botonCircular extends JButton {

    public botonCircular(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
//funcionabilidades externos para darle forma a tus venatanas como(darle color,figura.estilo...ect
    // darle forma a tus botones y cada cuadro de cad numero o letras.
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY); 
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }

    @Override
    public boolean contains(int x, int y) {
        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }
}




