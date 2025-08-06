package Geometrica;

public class Triangulo {
    private float base;
    private float altura;
    private float resultado;

    public void AreaT(float base, float altura) {
        this.base = base;
        this.altura = altura;
        this.resultado = (base * altura) / 2;
    }

    public float getResultado() {
        return resultado;
    }
}
