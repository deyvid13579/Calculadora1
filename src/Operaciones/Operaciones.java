
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
