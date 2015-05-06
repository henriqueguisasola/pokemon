package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Aventura {
	static private Pokemon[] listaPokemons = new Pokemon[255];
	static private boolean automatico = true;
	static private int numPokemons=0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String nome;
		int hp;
		int dano;
		Scanner scanner = new Scanner(new FileReader("arquivo.txt")).useDelimiter("\\||\\n");
		int k = 0;
		while((nome = scanner.next()).equals("Fim") == false){
			hp = scanner.nextInt();
			Pokemon pokemon = new Pokemon(nome, hp);
			for(int j = 0; j < 4 ; j++){
				nome = scanner.next();
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
			}
			listaPokemons[k] = pokemon;
			numPokemons++;
			k++;
		}
		scanner.close();


		System.out.println("Welcome to the Pokemon World!");
		System.out.println("What is your name pokemon trainer?");
		String nome1 = Leitura.leString();
		Treinador trainer1 = new Treinador(nome1, false);
		System.out.println("Now, I need you to choose 6 pokemons that will follow you in your journey.");
		Aventura.escolhaPokemons(trainer1);
		System.out.println("\n---------------------------\n");
		System.out.println("What would you like to do? Play the Singleplayer mode(S) or play with your friend in the Multiplayer mode(M)?");
		String d = Leitura.leString();
		if(d.equals("S")){
			//PArte do mapa
			System.out.println("\n---------------------------\n");
			Mapa m = new Mapa();
			m.geraMapa();
			m.atualizarTreinadorMapa(trainer1);
			m.imprimeMapa();
			
			while(trainer1.getAltura() != 9 && trainer1.getLargura() != 19){
				System.out.println("\n---------------------------\n");
				System.out.println("Which way would you like to go? (up, down, right, left)");
				String andar = Leitura.leString();
				switch(andar){
					case("up"):
						if((trainer1.getAltura()-1) >= 0){
							trainer1.andarCima();
							m.atualizarTreinadorMapa(trainer1);
							m.imprimeMapa();
							if(m.temPokemonNoMato(trainer1)){
								System.out.println("You found a wild pokemon! Press ENTER to start the battle!");
								Treinador trainer2 = new Treinador("Wild", true);
								Random rnd = new Random();
								int n = rnd.nextInt(11);
								Pokemon pokemon3 = new Pokemon(listaPokemons[n].getNome(), listaPokemons[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaPokemons[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha.batalhar(trainer1, trainer2);
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
					
						break;
					case("down"):
						if((trainer1.getAltura()+1) <= 9){
							trainer1.andarBaixo();
							m.atualizarTreinadorMapa(trainer1);
							m.imprimeMapa();
							if(m.temPokemonNoMato(trainer1)){
								System.out.println("You found a wild pokemon! Press ENTER to start the battle!");
								Treinador trainer2 = new Treinador("Wild", true);
								Random rnd = new Random();
								int n = rnd.nextInt(11);
								Pokemon pokemon3 = new Pokemon(listaPokemons[n].getNome(), listaPokemons[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaPokemons[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha.batalhar(trainer1, trainer2);
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
					
						break;
					case("right"):
						if((trainer1.getAltura()+1) <= 19){
							trainer1.andarDireita();
							m.atualizarTreinadorMapa(trainer1);
							m.imprimeMapa();
							if(m.temPokemonNoMato(trainer1)){
								System.out.println("You found a wild pokemon! Press ENTER to start the battle!");
								Treinador trainer2 = new Treinador("Wild", true);
								Random rnd = new Random();
								int n = rnd.nextInt(11);
								Pokemon pokemon3 = new Pokemon(listaPokemons[n].getNome(), listaPokemons[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaPokemons[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha.batalhar(trainer1, trainer2);
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
						break;
					case("left"):
						if((trainer1.getAltura()-1) >= 0){
							trainer1.andarEsquerda();
							m.atualizarTreinadorMapa(trainer1);
							m.imprimeMapa();
							if(m.temPokemonNoMato(trainer1)){
								System.out.println("You found a wild pokemon! Get ready to battle!");
								Treinador trainer2 = new Treinador("Wild", true);
								Random rnd = new Random();
								int n = rnd.nextInt(11);
								Pokemon pokemon3 = new Pokemon(listaPokemons[n].getNome(), listaPokemons[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaPokemons[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha.batalhar(trainer1, trainer2);
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
					
						break;
					default:
						System.out.println("Sorry, I don't understand you, please type again.");
						break;
				}
			}
		}
		if(d.equals("M")){
			automatico = false;
			System.out.println("You chose the Multiplayer mode, but I still don't know your friend's name, can you tell me?");
			String nome2 = Leitura.leString();
			Treinador trainer2 = new Treinador(nome2, false);
			System.out.println("Now, "+nome2+" need to choose his pokemons.");
			Aventura.escolhaPokemons(trainer2);
			
			Batalha.batalhar(trainer1, trainer2);
			}
		Leitura.close();
	}
	
	public static void imprimeLista(){
		System.out.println("\nList of available pokemon:");
		for(int i = 0; i < numPokemons; i = i + 4){
			System.out.println(listaPokemons[i].getNome()+"    "+listaPokemons[i+1].getNome()+"    "+listaPokemons[i+2].getNome()+"    "+
					listaPokemons[i+3].getNome());
		}
	}
	
	public static void escolhaPokemons(Treinador trainer){
		System.out.println("Please, write the name of each pokemon that you want, one at a time");
		Aventura.imprimeLista();
		boolean mudou = false;
		for(int j = 0; j < 6; j++){
			String s = Leitura.leString();
			for(int i = 0; i < numPokemons; i++){
				if((listaPokemons[i].getNome()).equals(s)){
					Pokemon pokemon2 = new Pokemon(listaPokemons[i].getNome(), listaPokemons[i].getHPmax());
					for(int k = 0; k < 4; k++){
						pokemon2.setHabil(listaPokemons[i].getHabilidade(k));
					}
					trainer.setPokemons(pokemon2);
					mudou = true;
				}
			}
			if(!mudou){
				System.out.println("You have entered the wrong name! Please type again.");
				j--;
			}
			mudou = false;
		}
		trainer.pokemonAtual = trainer.getPokemon(0);
	}

}


