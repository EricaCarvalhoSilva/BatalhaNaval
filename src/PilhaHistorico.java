public class PilhaHistorico {

    private NoJogada topo;

    public PilhaHistorico() {
        topo = null;
    }

    public void push(Jogada jogada) {

        NoJogada novo = new NoJogada(jogada);

        novo.setProximo(topo);

        topo = novo;
    }

    public Jogada pop() {

        if (estaVazia())
            return null;

        Jogada removida = topo.getJogada();

        topo = topo.getProximo();

        return removida;
    }

    public Jogada peek() {

        if (estaVazia())
            return null;

        return topo.getJogada();
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void exibirHistorico() {

        NoJogada atual = topo;

        System.out.println("\n===== HISTÓRICO =====");

        while (atual != null) {

            System.out.println(atual.getJogada());

            atual = atual.getProximo();
        }
    }
}
