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
