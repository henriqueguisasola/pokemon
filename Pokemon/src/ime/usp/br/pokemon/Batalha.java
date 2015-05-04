package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Batalha extends EventSet {

	public static void main(String[] args) throws FileNotFoundException {
		Treinador trainer1 = new Treinador("Trainer1");
		Treinador trainer2 = new Treinador("Trainer2");
		String nome;
		int hp;
		Mapa m =  new Mapa();
		m.geraMapa();
		m.setTreinadorMapa(trainer1);
		m.imprimeMapa();
		trainer1.andarTreinadorHoriz();
		m.setTreinadorMapa(trainer1);
		m.imprimeMapa();
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
		while (trainer1.getNum() > 0 && trainer2.getNum() > 0) {
			// EventSet batalha = new EventSet();
			System.out.println("O que o trainer 1 deseja fazer?");
			System.out.println("0 - Fugir da Batalha");
			System.out.println("1 - Trocar Pokemon");
			System.out.println("2 - Usar poção");
			System.out.println("3 - Atacar");
			int k = Leitura.leNumero();

			System.out.println("O que o trainer 2 deseja fazer?");
			System.out.println("0 - Fugir da Batalha");
			System.out.println("1 - Trocar Pokemon");
			System.out.println("2 - Usar poção");
			System.out.println("3 - Atacar");
			int l = Leitura.leNumero();
			boolean vivo = true;
			if (k <= l) {
				Event evento1 = new Event(k, trainer1.pokemonAtual,	trainer2.pokemonAtual, trainer1, trainer2);
				evento1.action();
				vivo = evento1.alvoVivo;
			} else {
				Event evento2 = new Event(l, trainer2.pokemonAtual,	trainer1.pokemonAtual, trainer2, trainer1);
				evento2.action();
			}
			if(vivo){
				if (k <= l && trainer1.pokemonAtual != null) {
					Event evento2 = new Event(l, trainer2.pokemonAtual,	trainer1.pokemonAtual, trainer2, trainer1);
					evento2.action();
				} else {
					if (trainer2.pokemonAtual != null){
						Event evento1 = new Event(k, trainer1.pokemonAtual,	trainer2.pokemonAtual, trainer1, trainer2);
						evento1.action();
					}
				}
			}
		}
		System.out.println("A batalha acabou!");
		Leitura.close();
	}
}
