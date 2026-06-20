public class Pontuacao {

    private int pontos;
    private int tiros;
    private int acertos;

    public Pontuacao() {
        pontos = 0;
        tiros = 0;
        acertos = 0;
    }

    public void adicionarAcerto() {
        acertos++;
        tiros++;
        pontos += 10;
    }

    public void adicionarErro() {
        tiros++;
    }

    public double calcularPrecisao() {

        if (tiros == 0)
            return 0;

        return ((double) acertos / tiros) * 100;
    }

    public int getPontos() {
        return pontos;
    }

    public int getTiros() {
        return tiros;
    }

    public int getAcertos() {
        return acertos;
    }
}
