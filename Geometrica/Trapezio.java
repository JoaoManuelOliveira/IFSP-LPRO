package Geometrica;

public class Trapezio {
    private float baseMaior;
    private float baseMenor;
    private float altura;
    private float resultado;

    public void AreaTra(float baseMaior, float baseMenor, float altura) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.resultado = ((baseMaior + baseMenor) * altura) / 2;
    }

    public float getResultado() {
        return resultado;
    }
}
