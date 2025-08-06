package Calculo;

public class Potenciacao {
    private float resultado;

    public void Potencia(float base, float expoente) {
        resultado = (float) Math.pow(base, expoente); // Calcula a potência
    }

    public float getResultado() {
        return resultado;
    }
}
