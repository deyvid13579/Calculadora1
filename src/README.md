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

## Código de Ejemplo

Aquí tienes un ejemplo del código de la calculadora:




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
