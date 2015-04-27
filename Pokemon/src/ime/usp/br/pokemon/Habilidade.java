package ime.usp.br.pokemon;

public class Habilidade {
	private int dano;
	private String nome;
	public Habilidade(String n, int d){
		nome = n;
		dano = d;
	}
	public String getNome(){
		return nome;
	}
}
