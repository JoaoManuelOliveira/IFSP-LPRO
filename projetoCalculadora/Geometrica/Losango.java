package Geometrica;

public class Losango {
    private float diagonalM;
    private float diagonalm;
    private float resultado;

    public void AreaL(float diagonalM, float diagonalm) {
        this.diagonalM = diagonalM;
        this.diagonalm = diagonalm;
        this.resultado = (diagonalM * diagonalm) /2;
    }

    public float getResultado() {
        return resultado;
    }
}
