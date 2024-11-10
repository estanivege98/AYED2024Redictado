package tp3.ejercicio4;

public class AreaEmpresa {
    private String nombreArea;
    private int tardanza;

    public AreaEmpresa(String nombreArea, int tardanza) {
        this.nombreArea = nombreArea;
        this.tardanza = tardanza;
    }

    public String getNombreArea() {
        return this.nombreArea;
    }

    public int getTardanza(){
        return this.tardanza;
    }
}
