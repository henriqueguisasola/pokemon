package ime.usp.br.pokemon;

public class Pokemon {
	private int hp;
	private int i = 0;
	private String nome;
	private Habilidade[] habilidades = new Habilidade[4];
	public Pokemon(String n, int vida){
		nome = n;
		hp = vida;
	}
	public void setHabil(Habilidade a){
		habilidades[i] = a;
		i++;
	}
	public String getNome(){
		return nome;
	}
}
