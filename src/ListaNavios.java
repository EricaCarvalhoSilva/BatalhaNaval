public class ListaNavios {

    private Navio inicio;

    public ListaNavios() {
        inicio = null;
    }

    public void adicionar(Navio navio) {

        if (inicio == null) {
            inicio = navio;
            return;
        }

        Navio aux = inicio;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }

        aux.setProximo(navio);
    }

    public boolean remover(String nome) {

        if (inicio == null)
            return false;

        if (inicio.getNome().equalsIgnoreCase(nome)) {
            inicio = inicio.getProximo();
            return true;
        }

        Navio atual = inicio;
        Navio anterior = null;

        while (atual != null) {

            if (atual.getNome().equalsIgnoreCase(nome)) {
                anterior.setProximo(atual.getProximo());
                return true;
            }

            anterior = atual;
            atual = atual.getProximo();
        }

        return false;
    }

    public Navio buscar(String nome) {

        Navio aux = inicio;

        while (aux != null) {

            if (aux.getNome().equalsIgnoreCase(nome))
                return aux;

            aux = aux.getProximo();
        }

        return null;
    }

    public boolean todosAfundados() {

        Navio aux = inicio;

        while (aux != null) {

            if (!aux.afundou())
                return false;

            aux = aux.getProximo();
        }

        return true;
    }

    public int quantidadeNavios() {

        int cont = 0;

        Navio aux = inicio;

        while (aux != null) {
            cont++;
            aux = aux.getProximo();
        }

        return cont;
    }

    public void exibirNavios() {

        Navio aux = inicio;

        while (aux != null) {

            System.out.println(
                    aux.getNome() +
                            " | Tamanho: " + aux.getTamanho() +
                            " | Vidas: " + aux.getVidas()
            );

            aux = aux.getProximo();
        }
    }
}
