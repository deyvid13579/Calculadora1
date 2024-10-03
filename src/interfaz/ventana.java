
package interfaz;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
//importaciones
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
// constructor de la clase ventana.
public class ventana implements ActionListener{
    //atributos de la clase 
    private String usuario;
    private ArrayList<String> operaciones;
    
    private int indiceSeleccionado= -1;
    JFrame frame = new JFrame();
    JTextField entrada = new JTextField();
    Archivos documento = new Archivos("C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\actividades.txt");
    
//Definicion de los botones
    JButton igual = new JButton("=");
    JButton sumar = new botonCircular("+"); 
    JButton restar = new botonCircular("-"); 
    JButton multiplicar = new botonCircular("x"); 
    JButton dividir = new botonCircular("/");
    JButton porcentaje = new JButton("%");
    JButton punto = new JButton(".");
    JButton num0 = new JButton("0");
    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton eliminarTodo = new JButton("AC");
    JButton eliminar = new JButton("C");
    
    JButton mostrarOperacionesButton = new JButton("Resultados");
    
    public ventana(String usuario) throws IOException{
        this.usuario = usuario; // Almacena el nombre del usuario.
        this.operaciones = new ArrayList<>(); // Inicializa la lista
        iniciar(usuario); // Método que inicia la interfaz gráfica
        cargarOperacionesDesdeArchivo();
    }
//metodo de la configuracion de la interfaz grafica como (darle color,marco,botones).
    private void iniciar(String usuario) throws IOException {
        // Crear archivo de datos
        this.documento.create("C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\data.txt");
        //this.documento.create("..\\data\\data.txt");
        
        //Configuración del JFrame
        frame.setSize(310, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("TECH GO - Usuario: \\" + usuario);
        frame.getContentPane().setBackground(new Color(0, 38, 77));
        frame.setVisible(true);
        
        Color buttonBackgroundDark = new Color(64, 72, 87);
        Color buttonBackgroundRed = new Color(235, 73, 86);
        Color buttonTextWhite = Color.WHITE;
        Color buttontexoper = new Color(51, 153, 102);
        Color buttonOperationColor = new Color(0, 0, 102);
        mostrarOperacionesButton.addActionListener(e -> mostrarOperaciones());
        mostrarOperacionesButton.setBounds(125, 100, 150, 25);
        frame.add(mostrarOperacionesButton);

        eliminarTodo.setText("AC");
        eliminar.setText("C");
        
        sumar.setSize(50,50);
        restar.setSize(50,50);
        multiplicar.setSize(50,50);
        dividir.setSize(50,50);
        porcentaje.setSize(50,50);
        punto.setSize(50,50);
        igual.setSize(50,115);
        num0.setSize(50,50);
        num1.setSize(50,50);
        num2.setSize(50,50);
        num3.setSize(50,50);
        num4.setSize(50,50);
        num5.setSize(50,50);
        num6.setSize(50,50);
        num7.setSize(50,50);
        num8.setSize(50,50);
        num9.setSize(50,50);
        
        sumar.setBackground(buttonOperationColor);
        restar.setBackground(buttonOperationColor);
        multiplicar.setBackground(buttonOperationColor);
        dividir.setBackground(buttonOperationColor);
        igual.setBackground(buttonBackgroundRed);

        sumar.setForeground(buttontexoper);
        restar.setForeground(buttontexoper);
        multiplicar.setForeground(buttontexoper);
        dividir.setForeground(buttontexoper);
        igual.setForeground(buttonTextWhite);
        
        entrada.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton[] botones={ sumar,restar,multiplicar,dividir,porcentaje,punto,
            igual,num0,num1,num2,num3,num4,num5,num6,num7,num8,num9};
        Font fuente = new Font("Arial",Font.PLAIN, 18);
        for(JButton boton : botones){
            boton.setFont(fuente);
        }
        
        sumar.setLocation(155, 135);
        restar.setLocation(220,135);
        multiplicar.setLocation(220, 200);
        dividir.setLocation(220, 265);
        porcentaje.setLocation(155,395);
        punto.setLocation(90,395);
        igual.setLocation(220, 330);
        num0.setLocation(25,395);
        num1.setLocation(25,330);
        num2.setLocation(90,330);
        num3.setLocation(155,330);
        num4.setLocation(25,265);
        num5.setLocation(90,265);
        num6.setLocation(155,265);
        num7.setLocation(25,200);
        num8.setLocation(90,200);
        num9.setLocation(155,200);
        
        
        //Añadiendo botones al JFrame
        frame.add(sumar);
        frame.add(restar);
        frame.add(multiplicar);
        frame.add(dividir);
        frame.add(porcentaje);
        frame.add(punto);
        frame.add(igual);
        frame.add(num0);
        frame.add(num1);
        frame.add(num2);
        frame.add(num3);
        frame.add(num4);
        frame.add(num5);
        frame.add(num6);
        frame.add(num7);
        frame.add(num8);
        frame.add(num9);
        
        entrada.setSize(248,60);
        entrada.setLocation(25, 25);
        frame.add(entrada);
     
        eliminarTodo.setSize(50,50);
        eliminarTodo.setLocation(25,135);
        frame.add(eliminarTodo);
        eliminar.setSize(50,50);
        eliminar.setLocation(90,135);
        frame.add(eliminar);
        
        eliminarTodo.addActionListener(this);
        eliminar.addActionListener(this);
        sumar.addActionListener(this);
        restar.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);
        porcentaje.addActionListener(this);
        punto.addActionListener(this);
        igual.addActionListener(this);
        num0.addActionListener(this);
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);

        
    }
     // manejo de eventos esto se encarga de darle clip a cierto boton y asi imgresar a darle esa funcion donde necesite ingresar.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sumar) {
            this.entrada.setText(this.entrada.getText()+"+");
        }
        if (e.getSource() == this.restar) {
            this.entrada.setText(this.entrada.getText()+"-");
        }
        if (e.getSource() == this.multiplicar) {
            this.entrada.setText(this.entrada.getText()+"*");
        }
        if (e.getSource() == this.dividir) {
            this.entrada.setText(this.entrada.getText()+"/");
        }
        if (e.getSource() == this.porcentaje) {
            this.entrada.setText(this.entrada.getText()+"%");
        }
        if (e.getSource() == this.punto) {
            this.entrada.setText(this.entrada.getText()+".");
        }
        if (e.getSource() == this.num0) {
        this.entrada.setText(this.entrada.getText() + "0");
        } 
        if (e.getSource() == this.num1) {
            this.entrada.setText(this.entrada.getText() + "1");
        } 
        if (e.getSource() == this.num2) {
            this.entrada.setText(this.entrada.getText() + "2");
        } 
        if (e.getSource() == this.num3) {
            this.entrada.setText(this.entrada.getText() + "3");
        } 
        if (e.getSource() == this.num4) {
            this.entrada.setText(this.entrada.getText() + "4");
        } 
        if (e.getSource() == this.num5) {
            this.entrada.setText(this.entrada.getText() + "5");
        } 
        if (e.getSource() == this.num6) {
            this.entrada.setText(this.entrada.getText() + "6");
        } 
        if (e.getSource() == this.num7) {
            this.entrada.setText(this.entrada.getText() + "7");
        } 
        if (e.getSource() == this.num8) {
            this.entrada.setText(this.entrada.getText() + "8");
        } 
        if (e.getSource() == this.num9) {
            this.entrada.setText(this.entrada.getText() + "9");
        }
        if (e.getSource() == this.igual) {
            this.calcular(); // Llama al método para calcular el resultado 

        }
        if (e.getSource() == this.eliminarTodo) {
            this.entrada.setText("");
        }
        if (e.getSource() == this.eliminar) {
            String currentText = this.entrada.getText();
            if(currentText.length()>0){
                this.entrada.setText(currentText.substring(0,currentText.length
                ()-1));
            }  
        }
       
     }

   //se encarga de leer las operaciones y de esa manera guardar en una lista
    private void cargarOperacionesDesdeArchivo() {
    String rutaArchivo = "C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";
    operaciones.clear(); // Limpiar la lista antes de cargar
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            operaciones.add(linea); // Añadir cada línea a la lista de operaciones
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error al cargar las operaciones.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   //se encarga de leer y asi guardar el archivo actual en una lista 
private void guardarOperacionesEnArchivo() {
    String rutaArchivo = "C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
        for (String operacion : operaciones) {
            writer.write(operacion);
            writer.newLine();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    //es una amnera donde puedes modificar una lista.
    public void modificarOperacion(int indice, String nuevaOperacion) {
    if (indice >= 0 && indice < operaciones.size()) {
        operaciones.set(indice, nuevaOperacion); // Modifica la operación
        // También puedes guardar la operación en el historial si es necesario
        registrarActividad(nuevaOperacion); // Cambia el segundo parámetro según sea necesario
    } else {
        JOptionPane.showMessageDialog(frame, "Índice fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    //esto se encarga de mostrar toda las actividades de cada usuario y permite modificar crear nuevo actividad,eliminar 
private void mostrarOperaciones() {
    JList<String> listaOperaciones = new JList<>(operaciones.toArray(new String[0]));
    listaOperaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(listaOperaciones);

    JButton modificarButton = new JButton("Modificar");
    modificarButton.addActionListener(e -> {
        int indiceSeleccionado = listaOperaciones.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            String operacionSeleccionada = operaciones.get(indiceSeleccionado);
            entrada.setText(operacionSeleccionada.split("=")[0].trim());
            JOptionPane.showMessageDialog(frame, "Realize nueva operación o modifique", "Modificar Operación", JOptionPane.INFORMATION_MESSAGE);
            this.indiceSeleccionado = indiceSeleccionado;
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, selecciona una operación para modificar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    });

   // Botón "Nuevo"
    JButton nuevoButton = new JButton("Nuevo");
    nuevoButton.addActionListener(e -> {
    // Ruta para el nuevo archivo, incluyendo la fecha y hora
    String nuevoArchivo = "C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\" + usuario + "_nueva_actividad_" + System.currentTimeMillis() + ".txt";
    
    // Crear el nuevo archivo
    try {
        File nuevoFile = new File(nuevoArchivo);
        nuevoFile.createNewFile();
        
        // Guardar las operaciones actuales en el nuevo archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevoFile))) {
            for (String operacion : operaciones) {
                writer.write(operacion);
                writer.newLine();
            }
        }

        // Limpiar el archivo actual
        String rutaArchivoActual = "C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";
        new BufferedWriter(new FileWriter(rutaArchivoActual)).close(); // Esto vacía el archivo

        // Mensaje de éxito
        JOptionPane.showMessageDialog(frame, "Nuevo archivo creado: " + nuevoArchivo , "Archivo Creado", JOptionPane.INFORMATION_MESSAGE);
        
        // Opcional: actualizar la lista de operaciones
        cargarOperacionesDesdeArchivo(); // Para recargar la lista actualizada
        listaOperaciones.setListData(operaciones.toArray(new String[0])); // Actualizar la lista

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "Error al crear el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
});

    // Botón "Eliminar"
    JButton eliminarButton = new JButton("Eliminar");
    eliminarButton.addActionListener(e -> {
        int indiceSeleccionado = listaOperaciones.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            operaciones.remove(indiceSeleccionado);
            
            guardarOperacionesEnArchivo(); // Guardar cambios en el archivo
            listaOperaciones.setListData(operaciones.toArray(new String[0])); // Actualizar la lista
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, selecciona una operación para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    });

    // Botón "Actualizar"
    JButton actualizarButton = new JButton("Actualizar");
    actualizarButton.addActionListener(e -> {
        cargarOperacionesDesdeArchivo(); // Cargar operaciones desde el archivo
        listaOperaciones.setListData(operaciones.toArray(new String[0])); // Actualizar la lista
       
    });

    // Crear un panel para mostrar la lista y los botones
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(scrollPane, BorderLayout.CENTER);

    // Crear un panel para los botones
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(modificarButton);
    buttonPanel.add(nuevoButton);
    buttonPanel.add(eliminarButton);
    buttonPanel.add(actualizarButton); // Agregar botón de actualizar

    panel.add(buttonPanel, BorderLayout.SOUTH);

    // Mostrar en un JDialog
    JDialog dialog = new JDialog(frame, "Operaciones Realizadas", Dialog.ModalityType.MODELESS);
    dialog.setContentPane(panel);
    dialog.setSize(400, 300);
    int x = frame.getX() + frame.getWidth(); // X de la ventana principal + ancho de la ventana
    int y = frame.getY(); // Y de la ventana principal
    dialog.setLocation(x, y);
    dialog.setVisible(true);
}
//METODO PARA CALCULAR: esta exprecion toma la expresión ingresada, la evalúa usando exp4j y actualiza la lista de operaciones.
 public void calcular() {
    String expresion = this.entrada.getText();
    Expression e = new ExpressionBuilder(expresion).build();

    // Evaluar la expresión
    double resultado;
    try {
        resultado = e.evaluate();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(frame, "Error en la expresión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar si hay una operación seleccionada para modificar
    if (this.indiceSeleccionado >= 0) {
        // Modificar la operación existente
        if (indiceSeleccionado < operaciones.size()) {
            String operacionModificada = expresion + " = " + resultado;
            operaciones.set(indiceSeleccionado, operacionModificada);
            JOptionPane.showMessageDialog(frame, "Operación modificada: " + operacionModificada, "Operación Modificada", JOptionPane.INFORMATION_MESSAGE);
            registrarActividad(operacionModificada); // Guardar la operación modificada
            this.indiceSeleccionado = -1; // Resetear el índice
        }
    } else {
        // Registrar la nueva operación
        String operacionNueva = expresion + " = " + resultado;
        operaciones.add(operacionNueva);
        registrarActividad(operacionNueva); // Guardar la nueva operación
    }

    // Mostrar el resultado en el campo de entrada
    this.entrada.setText(resultado + "");

    // Guardar todas las operaciones en el archivo
    guardarOperacionesEnArchivo();
}

//REGISTRO DE ACTIVIDADES": Guarda un registro de cada operación realizada junto con el nombre del usuario creado.
private void registrarActividad(String registro) {
    String user = this.usuario; // Usa el nombre del usuario

    // Define la ruta del archivo usando el nombre del usuario
    String rutaArchivo = "C:\\Users\\MSI CYBORG\\Downloads\\Calculadora4\\Calculadora1\\src\\data\\" + user + "_actividades.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        writer.write("Usuario: " + user + " realizó la operación: " + registro);
        writer.newLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
  } 
}