package Geometrica;

public class Retangulo {
    private float base;
    private float altura;
    private float resultado;

    public void AreaR(float base, float altura) {
        this.base = base;
        this.altura = altura;
        this.resultado = base * altura;
    }

    public float getResultado() {
        return resultado;
    }
}