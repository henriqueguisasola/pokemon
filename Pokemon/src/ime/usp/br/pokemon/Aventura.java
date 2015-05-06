package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Aventura {


	public static void main(String[] args) throws FileNotFoundException {
		boolean automatico = true;
		System.out.println("Welcome to the Pokemon World!");
		System.out.println("What is your name pokemon trainer?");
		String nome1 = Leitura.leString();
		Treinador trainer1 = new Treinador(nome1, false);
		System.out.println("Now, I need you to choose 6 pokemons that will follow you in your journey.");
		
		//implementar escolha de pokemons-------------------------------------------
		
		String nome;
		int hp;
		int dano;
		Scanner scanner = new Scanner(new FileReader("arquivo.txt")).useDelimiter("\\||\\n");
		for(int i = 0; i < 6; i++) {
			nome = scanner.next();
			hp = scanner.nextInt();
			Pokemon pokemon = new Pokemon(nome, hp);
			for(int j = 0; j < 4 ; j++){
				nome = scanner.next();
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
			}
			trainer1.setPokemons(pokemon);
		}

		scanner.close();
		trainer1.pokemonAtual = trainer1.getPokemon(0);

		
		//--------------------------------------------------------------------------------
		
		System.out.println("What would you like to do? Play the Singleplayer mode(S) or play with your friend in the Multiplayer mode(M)?");
		String d = Leitura.leString();
		if(d.equals("S")){
			//PArte do mapa
			
			//Testestinhos show
			Mapa m =  new Mapa();
			m.geraMapa();
			m.atualizarTreinadorMapa(trainer1);
			m.imprimeMapa();
			trainer1.andarDireita();
			m.atualizarTreinadorMapa(trainer1);
			m.temPokemonNoMato(trainer1);
			m.imprimeMapa();
			trainer1.andarDireita();
			m.atualizarTreinadorMapa(trainer1);
			m.temPokemonNoMato(trainer1);
			m.imprimeMapa();
			trainer1.andarBaixo();
			m.atualizarTreinadorMapa(trainer1);
			m.temPokemonNoMato(trainer1);
			m.imprimeMapa();
			trainer1.andarBaixo();
			m.atualizarTreinadorMapa(trainer1);
			m.temPokemonNoMato(trainer1);
			m.imprimeMapa();
			if(m.temPokemonNoMato(trainer1)){			
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
			
			
			// implementar escolha de pokemons-------------------------------------------
			
			Scanner scanner1 = new Scanner(new FileReader("arquivo2.txt")).useDelimiter("\\||\\n");
			for(int i = 0; i < 6; i++) {
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
			
			//--------------------------------------------------------------------------------
			
			Batalha.batalhar(trainer1, trainer2);
		}
	}
	}
}


