package Parciales.Grafos.Parcial29062024Tema1;

public class Usuario {
    private String nombre;
    private int distancia;

    public Usuario(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", distancia=" + distancia +
                '}';
    }
}
