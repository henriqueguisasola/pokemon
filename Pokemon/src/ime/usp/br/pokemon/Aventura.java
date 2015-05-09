package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Aventura {
	static private Pokemon[] listaPokemons = new Pokemon[50];
	static private Pokemon[] listaWild = new Pokemon[25];
	static private int numPokemons=0;
	
	public static void main(String[] args) throws FileNotFoundException {
		//Leitura do Arquivo e construção do vetores de pokemons
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
		int z = 0;
		String wild;
		while((wild = scanner.next()).equals("Fim") == false){
			hp = scanner.nextInt();
			Pokemon pokemon = new Pokemon(wild, hp);
			for(int m = 0; m < 4 ; m++){
				wild = scanner.next();
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(wild, dano);
				pokemon.setHabil(habilidade);
			}
			listaWild[z] = pokemon;
			z++;
		}
		scanner.close();

		//Construção do treinador principal
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
			//Modo Single Player
			System.out.println("\n---------------------------\n");
			System.out.println("Professor Oak needs your help! It looks that a legendary pokemon is causing some problems nearby the Viridian Forest! " +
					"You should check it, maybe you can find him.(The entrance to the cave is marked with a 'C' in your map)");
			//Geração do mapa
			Mapa m = new Mapa();
			m.geraMapa();
			m.atualizarTreinadorMapa(trainer1);
			m.imprimeMapa();
			
			while((trainer1.getAltura() != 9 || trainer1.getLargura() != 19) && trainer1.getNum() > 0){
				//Ações do Treinador
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
								int n = rnd.nextInt(19);
								Pokemon pokemon3 = new Pokemon(listaWild[n].getNome(), listaWild[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaWild[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha battle = new Batalha();
								battle.batalhar(trainer1, trainer2);
								m.imprimeMapa();
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
								int n = rnd.nextInt(19);
								Pokemon pokemon3 = new Pokemon(listaWild[n].getNome(), listaWild[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaWild[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha battle = new Batalha();
								battle.batalhar(trainer1, trainer2);
								m.imprimeMapa();
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
					
						break;
					case("right"):
						if((trainer1.getLargura()+1) <= 19){
							trainer1.andarDireita();
							m.atualizarTreinadorMapa(trainer1);
							m.imprimeMapa();
							if(m.temPokemonNoMato(trainer1)){
								System.out.println("You found a wild pokemon! Press ENTER to start the battle!");
								Treinador trainer2 = new Treinador("Wild", true);
								Random rnd = new Random();
								int n = rnd.nextInt(19);
								Pokemon pokemon3 = new Pokemon(listaWild[n].getNome(), listaWild[n].getHPmax());
								for(int l = 0; l < 4; l++){
									pokemon3.setHabil(listaWild[n].getHabilidade(l));
								}
								trainer2.setPokemons(pokemon3);
								trainer2.pokemonAtual = trainer2.getPokemon(0);
								Leitura.leString();
								Batalha battle = new Batalha();
								battle.batalhar(trainer1, trainer2);
								m.imprimeMapa();
							}
						}
						else{
							System.out.println("This is not a valid position! Please type again.");
						}
						break;
					case("left"):
						if((trainer1.getLargura()-1) >= 0){
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
								Batalha battle = new Batalha();
								battle.batalhar(trainer1, trainer2);
								m.imprimeMapa();
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
			//Treinador sem pokemons
			if(trainer1.getNum() == 0){
				System.out.println("You lose!");
				System.out.println("--- THE END ---");
			}
			//Batalha final
			if(trainer1.getAltura() == 9 && trainer1.getLargura() == 19){
				System.out.println("You found him! It's the legendary pokemon! Press ENTER to start the battle!");
				Treinador trainer2 = new Treinador("Wild", true);
				Pokemon pokemon3 = new Pokemon("Mewtwo", 300);
				Habilidade habil1 = new Habilidade("Psychic", 90);
				pokemon3.setHabil(habil1);
				Habilidade habil2 = new Habilidade("Dream Eater", 100);
				pokemon3.setHabil(habil2);
				Habilidade habil3 = new Habilidade("Focus Blast", 110);
				pokemon3.setHabil(habil3);
				Habilidade habil4 = new Habilidade("Psystrike", 120);
				pokemon3.setHabil(habil4);
				trainer2.setPokemons(pokemon3);
				trainer2.pokemonAtual = trainer2.getPokemon(0);
				Leitura.leString();
				Batalha battle = new Batalha();
				battle.batalhar(trainer1, trainer2);
				if(trainer2.getNum() == 0){
					System.out.println("Congratulations, you have defeated Mewtwo!");
					System.out.println("--- THE END ---");
				}
				else{
					if(trainer1.getNum() == 0){
						System.out.println("You lose!");
						System.out.println("--- THE END ---");
					}
					else{
						System.out.println("Running away? What a shame!");
						System.out.println("--- THE END ---");
					}
				}
			}
		}
		if(d.equals("M")){
			//Modo Multiplayer
			System.out.println("You chose the Multiplayer mode, but I still don't know your friend's name, can you tell me?");
			String nome2 = Leitura.leString();
			Treinador trainer2 = new Treinador(nome2, false);
			System.out.println("Now, "+nome2+" need to choose his pokemons.");
			Aventura.escolhaPokemons(trainer2);
			
			Batalha battle = new Batalha();
			battle.batalhar(trainer1, trainer2);
			}
		Leitura.close();
	}
	
	public static void imprimeLista(){
		System.out.println("\nList of available pokemon:");
		for(int i = 0; i < numPokemons; i = i + 8){
			System.out.println(listaPokemons[i].getNome()+"    "+listaPokemons[i+1].getNome()+"    "+listaPokemons[i+2].getNome()+"    "+
					listaPokemons[i+3].getNome()+"    "+listaPokemons[i+4].getNome()+"    "+listaPokemons[i+5].getNome()+"    "+listaPokemons[i+6].getNome()+"    "+
					listaPokemons[i+7].getNome());
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


