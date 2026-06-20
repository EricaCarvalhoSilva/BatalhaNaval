import java.util.Scanner;

public class Jogo {

    private Jogador jogador1;
    private Jogador jogador2;

    private boolean contraComputador;

    private int turno;

    private PilhaHistorico historico;

    private Scanner scanner;

    public Jogo() {

        historico = new PilhaHistorico();

        scanner = new Scanner(System.in);

        turno = 0;
    }

    public void iniciar() {

        escolherModo();

        posicionarNavios();

        executarPartida();

        encerrarPartida();
    }

    private void escolherModo() {

        System.out.println("===== BATALHA NAVAL =====");

        System.out.println("1 - Jogador x Jogador");
        System.out.println("2 - Jogador x Computador");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome Jogador 1: ");
        String nome1 = scanner.nextLine();

        jogador1 = new Jogador(nome1);

        if (opcao == 2) {

            contraComputador = true;

            jogador2 = new Computador("Computador");
        }
        else {

            contraComputador = false;

            System.out.print("Nome Jogador 2: ");
            String nome2 = scanner.nextLine();

            jogador2 = new Jogador(nome2);
        }
    }

    private void posicionarNavios() {

        posicionarNaviosJogador(jogador1);

        if (contraComputador) {

            ((Computador) jogador2).posicionarNavios();
        }
        else {

            posicionarNaviosJogador(jogador2);
        }
    }

    private void posicionarNaviosJogador(Jogador jogador) {

        System.out.println("\nPosicionando navios de " + jogador.getNome());

        Navio[] frota = {

                new Navio("Porta-Avioes", 5),
                new Navio("Encouracado", 4),
                new Navio("Destroyer", 3),
                new Navio("Submarino", 2)
        };

        for (Navio navio : frota) {

            boolean colocado = false;

            while (!colocado) {

                jogador.getTabuleiro().exibir();

                System.out.println(
                        "\nNavio: "
                                + navio.getNome()
                                + " ("
                                + navio.getTamanho()
                                + ")");

                System.out.print("Linha: ");
                int linha = scanner.nextInt();

                System.out.print("Coluna: ");
                int coluna = scanner.nextInt();

                System.out.print("Direcao (H/V): ");
                char direcao =
                        scanner.next().toUpperCase().charAt(0);

                colocado =
                        jogador.getTabuleiro()
                                .posicionarNavio(
                                        navio,
                                        linha,
                                        coluna,
                                        direcao);

                if (colocado) {

                    jogador.getNavios()
                            .adicionar(navio);
                }
                else {

                    System.out.println(
                            "Posicao invalida!");
                }
            }
        }
    }

    private void executarPartida() {

        while (true) {

            Jogador atacante;
            Jogador defensor;

            if (turno == 0) {

                atacante = jogador1;
                defensor = jogador2;
            }
            else {

                atacante = jogador2;
                defensor = jogador1;
            }

            System.out.println(
                    "\n===== TURNO DE "
                            + atacante.getNome()
                            + " =====");

            Jogada jogada;

            if (atacante instanceof Computador) {

                jogada =
                        ((Computador) atacante)
                                .atirar(
                                        defensor.getTabuleiro());
            }
            else {

                System.out.print("Linha: ");
                int linha = scanner.nextInt();

                System.out.print("Coluna: ");
                int coluna = scanner.nextInt();

                jogada =
                        atacante.atirar(
                                defensor.getTabuleiro(),
                                linha,
                                coluna);
            }

            historico.push(jogada);

            if (defensor
                    .getTabuleiro()
                    .todosNaviosAfundados()) {

                System.out.println(
                        "\nVENCEDOR: "
                                + atacante.getNome());

                break;
            }

            trocarTurno();
        }
    }

    private void trocarTurno() {

        turno = 1 - turno;
    }

    private void encerrarPartida() {

        System.out.println("\n===== FIM DE JOGO =====");

        System.out.println(
                "\nPontuacao "
                        + jogador1.getNome());

        System.out.println(
                "Pontos: "
                        + jogador1.getPontuacao()
                        .getPontos());

        System.out.printf(
                "Precisao: %.2f%%\n",
                jogador1.getPontuacao()
                        .calcularPrecisao());

        System.out.println(
                "\nPontuacao "
                        + jogador2.getNome());

        System.out.println(
                "Pontos: "
                        + jogador2.getPontuacao()
                        .getPontos());

        System.out.printf(
                "Precisao: %.2f%%\n",
                jogador2.getPontuacao()
                        .calcularPrecisao());

        historico.exibirHistorico();
    }
}
