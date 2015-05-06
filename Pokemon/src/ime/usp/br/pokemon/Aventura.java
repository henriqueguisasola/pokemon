package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		System.out.println("What would you like to do? Play the Singleplayer mode(S) or play with your friend in the Multiplayer mode(M)?");
		String d = Leitura.leString();
		if(d.equals("S")){
			//PArte do mapa
			
			
			/*Mapa m =  new Mapa();
			m.geraMapa();
			m.setTreinadorMapa(trainer1);
			m.imprimeMapa();
			trainer1.andarTreinadorHoriz();
			m.setTreinadorMapa(trainer1);
			m.imprimeMapa();*/
			
			
			//if(achou mato)
			//		treinador trainer2 = new trainer2(???, true)
			//		batalha(trainer1, trainer2, automatico)
			
			//-------------TESTE--------------
			Treinador trainer2 = new Treinador("Wild", true);
			Scanner scanner1 = new Scanner(new FileReader("arquivo3.txt")).useDelimiter("\\||\\n");
			for(int i = 0; i < 1; i++) {
				nome = scanner1.next();
				hp = scanner1.nextInt();
				Pokemon pokemon = new Pokemon(nome, hp);
				for(int j = 0; j < 4 ; j++){
					nome = scanner1.next();
					dano = scanner1.nextInt();
					Habilidade habilidade = new Habilidade(nome, dano);
					pokemon.setHabil(habilidade);
				}
				trainer2.setPokemons(pokemon);
			}
			scanner1.close();
			trainer2.pokemonAtual = trainer2.getPokemon(0);
			
			Batalha.batalhar(trainer1, trainer2);
			//--------------------------------------------
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
		System.out.println("List of available pokemon:");
		for(int i = 0; i < numPokemons; i++){
			System.out.println(listaPokemons[i].getNome());
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
					Pokemon pokemon2 = listaPokemons[i];
					trainer.setPokemons(pokemon2);
					//CLONAR OBJETOS!!!!
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
