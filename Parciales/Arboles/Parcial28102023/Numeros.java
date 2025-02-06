package Parciales.Arboles.Parcial28102023;

public class Numeros {
    private int numeroSuma;
    private int numeroResta;

    public Numeros(int numeroSuma, int numeroResta) {
        this.numeroSuma = numeroSuma;
        this.numeroResta = numeroResta;
    }

    public int getNumeroSuma() {
        return numeroSuma;
    }

    public int getNumeroResta() {
        return numeroResta;
    }

    public void setNumeroSuma(int numeroNuevo) {
        this.numeroSuma = numeroNuevo;
    }

    public void setNumeroResta(int numeroNuevo) {
        this.numeroResta = numeroNuevo;
    }


    public String toString() {
        return "Numero suma: " + numeroSuma + ", Numero resta: " + numeroResta;
    }
}
