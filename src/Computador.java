import java.util.Random;

public class Computador extends Jogador {

    private Random random;

    public Computador(String nome) {

        super(nome);

        random = new Random();
    }

    public void posicionarNavios() {

        Navio[] frota = {

                new Navio("Porta-Avioes", 5),
                new Navio("Encouracado", 4),
                new Navio("Destroyer", 3),
                new Navio("Submarino", 2)
        };

        for (Navio navio : frota) {

            boolean colocado = false;

            while (!colocado) {

                int linha =
                        random.nextInt(10);

                int coluna =
                        random.nextInt(10);

                char direcao =
                        random.nextBoolean()
                                ? 'H'
                                : 'V';

                colocado =
                        tabuleiro.posicionarNavio(
                                navio,
                                linha,
                                coluna,
                                direcao);

                if (colocado) {

                    navios.adicionar(navio);
                }
            }
        }

        System.out.println(
                "Computador posicionou os navios.");
    }

    public Jogada atirar(
            Tabuleiro tabuleiroInimigo) {

        int linha;
        int coluna;

        do {

            linha = random.nextInt(10);
            coluna = random.nextInt(10);

        } while (

                tabuleiroInimigo
                        .getMatriz()[linha][coluna]
                        == 'X'

                        ||

                        tabuleiroInimigo
                                .getMatriz()[linha][coluna]
                                == 'O'
        );

        boolean acertou =
                tabuleiroInimigo.registrarTiro(
                        linha,
                        coluna);

        if (acertou) {

            pontuacao.adicionarAcerto();
        }
        else {

            pontuacao.adicionarErro();
        }

        System.out.println(
                "Computador atacou: "
                        + linha
                        + ", "
                        + coluna);

        return new Jogada(
                linha,
                coluna,
                acertou);
    }
}
