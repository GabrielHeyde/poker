

public class Jogador
{
    private String nome, status;
    private int fichas;
    private Carta[] c = new Carta[5];
    private boolean participaDaRodada;
    private int pontosNaRodada;
    private boolean allIn;
    private int valorAI;

    public Jogador(String nome, String status){
        this.nome = nome;
        this.fichas = 200;
        this.status = status;
        this.participaDaRodada = true;
        this.pontosNaRodada = 0;
        this.allIn = false;
        this.valorAI = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public Carta[] getC() {
        return c;
    }

    public void setC(Carta[] c) {
        this.c = c;
    }

    public boolean getParticipaDaRodada() {
        return participaDaRodada;
    }

    public void setParticipaDaRodada(boolean participaDaRodada) {
        this.participaDaRodada = participaDaRodada;
    }

    public int getPontosNaRodada() {
        return pontosNaRodada;
    }

    public void setPontosNaRodada(int pontosNaRodada) {
        this.pontosNaRodada = pontosNaRodada;
    }

    public boolean getAllIn() {
        return allIn;
    }

    public void setAllIn(boolean allIn) {
        this.allIn = allIn;
    }

    public int getValorAI() {
        return valorAI;
    }

    public void setValorAI(int valorAI) {
        this.valorAI = valorAI;
    }
}