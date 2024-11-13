package TP5.Ejercicio5;

public class Persona {
    private String nombre;
    private boolean jubilado;

    public Persona(String nombre, boolean jubilado){
        this.nombre = nombre;
        this.jubilado = jubilado;
    }

    public boolean getJubilado(){
        return this.jubilado;
    }

    public String getNombre(){
        return this.nombre;
    }
}
