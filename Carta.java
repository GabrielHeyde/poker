
//Gabriel Heyde Pintos e Jardel Nikolas Mathias Ferreira
public class Carta
{
    private String nome, naipe;
    
    public Carta(String nome, String naipe){
        this.nome = nome;
        this.naipe = naipe;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNaipe(String naipe){
        this.naipe = naipe;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getNaipe(){
        return naipe;
    }
}