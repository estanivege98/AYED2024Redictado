package TP1.ejercicio1;

public class ejercicio1 {

    public static void printFor(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
            a++;
        }
    }

    public static void printWhile(int a, int b) {
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }

    public static void printNoIterative(int a, int b) {
        if (a <= b) {
            System.out.println(a);
            printNoIterative(a + 1, b);
        }
    }

    public static void main(String[] args) {
        printFor(1, 10);
        printWhile(1, 10);
        printNoIterative(1, 10);
    }
}
