package ime.usp.br.pokemon;

public class Treinador {
	private Pokemon[] pokemons = new Pokemon[6];
	private int i = 0;
	private String nome;
	public Pokemon pokemonAtual;
	public Treinador(String n){
		nome = n;
	}
	public void setPokemons(Pokemon a){
		pokemons[i] = a;
		i++;
	}
	public void removePokemon(Pokemon a){
		for(int i = 0; i < 6;i++){
			if(pokemons[i].getNome().equals(a.getNome())){
				pokemons[i] = null;
			}
		}
	}
	public Pokemon getPokemon(int i){
		return pokemons[i];
	}
}
