public class Tabuleiro {

    private char[][] matriz;
    private Navio[][] mapaNavios;
    private int tamanho;

    public Tabuleiro() {

        tamanho = 10;

        matriz = new char[tamanho][tamanho];
        mapaNavios = new Navio[tamanho][tamanho];

        inicializar();
    }

    public void inicializar() {

        for (int i = 0; i < tamanho; i++) {

            for (int j = 0; j < tamanho; j++) {

                matriz[i][j] = '~';
                mapaNavios[i][j] = null;
            }
        }
    }

    public void exibir() {

        System.out.println();

        System.out.print("   ");

        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < tamanho; i++) {

            System.out.printf("%2d ", i);

            for (int j = 0; j < tamanho; j++) {

                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }

    public boolean verificarPosicao(
            int linha,
            int coluna,
            int tamanhoNavio,
            char direcao) {

        if (linha < 0 || linha >= tamanho)
            return false;

        if (coluna < 0 || coluna >= tamanho)
            return false;

        if (direcao == 'H') {

            if (coluna + tamanhoNavio > tamanho)
                return false;

            for (int i = 0; i < tamanhoNavio; i++) {

                if (matriz[linha][coluna + i] != '~')
                    return false;
            }
        }

        else if (direcao == 'V') {

            if (linha + tamanhoNavio > tamanho)
                return false;

            for (int i = 0; i < tamanhoNavio; i++) {

                if (matriz[linha + i][coluna] != '~')
                    return false;
            }
        }

        else {

            return false;
        }

        return true;
    }

    public boolean posicionarNavio(
            Navio navio,
            int linha,
            int coluna,
            char direcao) {

        if (!verificarPosicao(
                linha,
                coluna,
                navio.getTamanho(),
                direcao)) {

            return false;
        }

        if (direcao == 'H') {

            for (int i = 0; i < navio.getTamanho(); i++) {

                matriz[linha][coluna + i] = 'N';

                mapaNavios[linha][coluna + i] = navio;
            }
        }

        else {

            for (int i = 0; i < navio.getTamanho(); i++) {

                matriz[linha + i][coluna] = 'N';

                mapaNavios[linha + i][coluna] = navio;
            }
        }

        return true;
    }

    public boolean registrarTiro(
            int linha,
            int coluna) {

        if (linha < 0 || linha >= tamanho)
            return false;

        if (coluna < 0 || coluna >= tamanho)
            return false;

        if (matriz[linha][coluna] == 'N') {

            matriz[linha][coluna] = 'X';

            Navio navioAtingido =
                    mapaNavios[linha][coluna];

            if (navioAtingido != null) {

                navioAtingido.receberDano();

                if (navioAtingido.afundou()) {

                    System.out.println(
                            "\n*** NAVIO "
                                    + navioAtingido.getNome()
                                    + " AFUNDOU! ***");
                }
            }

            return true;
        }

        if (matriz[linha][coluna] == '~') {

            matriz[linha][coluna] = 'O';

            return false;
        }

        return false;
    }

    public boolean todosNaviosAfundados() {

        for (int i = 0; i < tamanho; i++) {

            for (int j = 0; j < tamanho; j++) {

                Navio navio = mapaNavios[i][j];

                if (navio != null && !navio.afundou()) {

                    return false;
                }
            }
        }

        return true;
    }

    public int getTamanho() {
        return tamanho;
    }

    public char[][] getMatriz() {
        return matriz;
    }
}