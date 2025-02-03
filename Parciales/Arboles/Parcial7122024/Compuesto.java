package Parciales.Arboles.Parcial7122024;

public class Compuesto {
    private String nombre;
    private int vueltas;

    public Compuesto(String nombre, int vueltas) {
        this.nombre = nombre;
        this.vueltas = vueltas;
    }
    public Compuesto() {
        this.nombre = "";
        this.vueltas = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public int getVueltas() {
        return vueltas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double tipoNeumatico(){
        if(nombre.equals("Hard")){
            return 0.7;
        }
        else if(nombre.equals("Med")){
            return 0.4;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "Compuesto{" +
                "nombre='" + nombre + '\'' +
                ", vueltas=" + vueltas +
                '}';
    }
}