public class NoJogada {

    private Jogada jogada;
    private NoJogada proximo;

    public NoJogada(Jogada jogada) {
        this.jogada = jogada;
        this.proximo = null;
    }

    public Jogada getJogada() {
        return jogada;
    }

    public NoJogada getProximo() {
        return proximo;
    }

    public void setProximo(NoJogada proximo) {
        this.proximo = proximo;
    }
}
