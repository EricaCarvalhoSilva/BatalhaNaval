public class Navio {

    private String nome;
    private int tamanho;
    private int vidas;
    private Navio proximo;

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.vidas = tamanho;
        this.proximo = null;
    }

    public void receberDano() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public boolean afundou() {
        return vidas <= 0;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getVidas() {
        return vidas;
    }

    public Navio getProximo() {
        return proximo;
    }

    public void setProximo(Navio proximo) {
        this.proximo = proximo;
    }
}
