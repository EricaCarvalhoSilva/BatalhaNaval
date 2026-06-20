public class Jogada {

    private int linha;
    private int coluna;
    private boolean acertou;

    public Jogada(int linha, int coluna, boolean acertou) {

        this.linha = linha;
        this.coluna = coluna;
        this.acertou = acertou;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean acertou() {
        return acertou;
    }

    @Override
    public String toString() {

        return "Linha: " + linha +
                " Coluna: " + coluna +
                " Resultado: " +
                (acertou ? "ACERTOU" : "ERROU");
    }
}
