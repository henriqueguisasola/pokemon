package ime.usp.br.pokemon;

public class Treinador {
	private Pokemon[] pokemons = new Pokemon[6];
	private int i = 0;
	private String nome;
	public Pokemon pokemonAtual;
	int altura;
	int largura;
	public Treinador(String n){
		nome = n;
		altura = 0;
		largura = 0;
	}
	public void setPokemons(Pokemon a){
		pokemons[i] = a;
		i++;
	}
	public void removePokemon(Pokemon a){
		for(int i = 0; i < 6;i++){
			if(pokemons[i].getNome().equals(a.getNome())){
				Pokemon pokemon = new Pokemon("Morto", 0);
				pokemons[i] = pokemon;
			}
		}
		this.i--;
	}
	public Pokemon getPokemon(int i){
		return pokemons[i];
	}
	public int getNum(){
		return i;
	}
	public int getAltura(){
		return altura;
	}
	public int getLargura(){
		return largura;
	}
	public void andarCima(){
		altura += 1;
	}
	public void andarBaixo(){
		altura -= 1;
	}
	public void andarDireita(){
		largura += 1;
	}
	public void andarEsquerda(){
		largura -= 1;
	}
	
	public String getNome(){
		return nome;
	}
	public void imprimeVivos(){
		for(int j = 0; j < 6; j++){
			if(pokemons[j].getNome() != "Morto"){
				System.out.println(pokemons[j].getNome());
			}
		}
	}
}
