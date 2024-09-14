package TP1.ejercicio2;
import java.util.Scanner;
public class ejercicio2 {
    private static int[] numeros;

    public static int contar42(){
        Scanner input = new Scanner(System.in);
        int cantidad = 1;
        while (input.nextInt() != 15){
            cantidad++;
        }
        return cantidad++;
    }

    public static void armarArreglo(int n){
        numeros = new int[n];
        //int aux = n;
        for (int i = 0; i < n; i++){
            numeros[i] = n * (i + 1);
        }
    }
    public static void imprimirArreglo(){
        for (int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }

    public static void main(String[] args) {
        //System.out.println(contar42());
        armarArreglo(5);
        imprimirArreglo();
    }
}
