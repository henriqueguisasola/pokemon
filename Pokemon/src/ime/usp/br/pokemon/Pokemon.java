package ime.usp.br.pokemon;

public class Pokemon {
	private int hp;
	private int hpMax;
	private int i = 0;
	private Pokemon pokemonAtual; 
	private String nome;
	private Habilidade[] habilidades = new Habilidade[4];
	public Pokemon(String n, int vida){
		nome = n;
		hpMax = vida;
		hp = hpMax;
	}
	public void setHabil(Habilidade a){
		habilidades[i] = a;
		i++;
	}
	public String getNome(){
		return nome;
	}
	public void recuperaHP(int x){
		if(hp + x > hpMax){
			hp = hpMax;
		}
		else{
			hp += x;
		}
	}
	public Habilidade getHabilidade(int i){
		return habilidades[i];
	}
	
}
