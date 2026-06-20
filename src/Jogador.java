public class Jogador {

    protected String nome;
    protected Tabuleiro tabuleiro;
    protected ListaNavios navios;
    protected Pontuacao pontuacao;

    public Jogador(String nome) {

        this.nome = nome;

        tabuleiro = new Tabuleiro();
        navios = new ListaNavios();
        pontuacao = new Pontuacao();
    }

    public void posicionarNavios(
            Navio navio,
            int linha,
            int coluna,
            char direcao) {

        boolean sucesso =
                tabuleiro.posicionarNavio(
                        navio,
                        linha,
                        coluna,
                        direcao);

        if (sucesso) {

            navios.adicionar(navio);

            System.out.println(
                    "Navio posicionado com sucesso!");
        }
        else {

            System.out.println(
                    "Posicao invalida!");
        }
    }

    public Jogada atirar(
            Tabuleiro tabuleiroInimigo,
            int linha,
            int coluna) {

        boolean acertou =
                tabuleiroInimigo.registrarTiro(
                        linha,
                        coluna);

        if (acertou) {

            pontuacao.adicionarAcerto();

            System.out.println("ACERTOU!");
        }
        else {

            pontuacao.adicionarErro();

            System.out.println("ERROU!");
        }

        return new Jogada(
                linha,
                coluna,
                acertou);
    }

    public String getNome() {
        return nome;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public ListaNavios getNavios() {
        return navios;
    }
}