package Geometrica;

public class Quadrado {
    private float lado;
    private float resultado;

    public void AreaQ(float lado) {
        this.lado = lado;
        this.resultado = lado * lado;
    }

    public float getResultado() {
        return resultado;
    }
}