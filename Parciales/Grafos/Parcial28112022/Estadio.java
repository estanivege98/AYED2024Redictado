package Parciales.Grafos.Parcial28112022;

public class Estadio {
    private String nombre;
    private String nombreCiudad;

    public Estadio(String nombre, String nombreCiudad) {
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "nombre='" + nombre + '\'' +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                '}';
    }
}
