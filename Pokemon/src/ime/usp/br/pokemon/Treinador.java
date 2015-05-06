package ime.usp.br.pokemon;

public class Treinador {
	private Pokemon[] pokemons = new Pokemon[6];
	private int i = 0;
	private String nome;
	public Pokemon pokemonAtual;
	private static int altura;
	private static int largura;
	private static int alturaAnterior;
	private static int larguraAnterior;
	private boolean automatico;
	private boolean correu = false;
	
	public Treinador(String n, boolean c){
		nome = n;
		automatico = c;
		altura = 0;
		largura = 0;
		alturaAnterior = altura;
		larguraAnterior = largura;
	}
	public void setPokemons(Pokemon a){
		pokemons[i] = a;
		i++;
	}
	public void removePokemon(Pokemon a){
		if(!automatico){
			for(int i = 0; i < 6;i++){
				if(pokemons[i].getNome().equals(a.getNome())){
					Pokemon pokemon = new Pokemon("Morto", 0);
					pokemons[i] = pokemon;
				}
			}
		}
		else{
			Pokemon pokemon = new Pokemon("Morto", 0);
			pokemons[0] = pokemon;
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
	public int getAlturaAnterior(){
		return alturaAnterior;
	}
	public int getLarguraAnterior(){
		return larguraAnterior;
	}
	public void andarCima(){
		alturaAnterior = altura;
		altura -= 1;
	}
	public void andarBaixo(){
		alturaAnterior = altura;
		altura += 1;
	}
	public void andarDireita(){
		larguraAnterior = largura;
		largura += 1;
	}
	public void andarEsquerda(){
		larguraAnterior = largura;
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
	
	public boolean getTipo(){
		return automatico;
	}
	
	public boolean getCorreu(){
		return correu;
	}
	
	public void correu(){
		correu = true;
	}
}
