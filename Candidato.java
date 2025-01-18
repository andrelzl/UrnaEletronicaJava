public class Candidato {
    private String _nome;
    private int _numero;
    private int _votos;

    //construtor
    public Candidato(String nome, int numero){
        this._nome = nome;
        this._numero = numero;
    }

    public String getNome(){
       return _nome;
    }

    public int getNumero(){
        return _numero;
    }

    public int getVotos(){
        return _votos;
    }

    public void incrementarVotos(){
        _votos ++;
    }   
}
