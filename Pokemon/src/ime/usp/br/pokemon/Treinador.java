package ime.usp.br.pokemon;

public class Treinador {
	private Pokemon[] pokemons = new Pokemon[6];
	private int i = 0;
	private String nome;
	public Treinador(String n){
		nome = n;
	}
	public void setPokemons(Pokemon a){
		pokemons[i] = a;
		i++;
	}
}
