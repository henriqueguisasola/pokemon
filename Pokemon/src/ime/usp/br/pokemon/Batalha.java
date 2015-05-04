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
		m.setTreinadorMapa(0,0);
		m.imprimeMapa();
		trainer1.andarTreinadorHoriz();
		m.setTreinadorMapa(0,1);
		m.imprimeMapa();
		int dano;
		Scanner scanner = new Scanner(new FileReader("arquivo.txt"))
				.useDelimiter("\\||\\n");
		while (scanner.hasNext()) {
			nome = scanner.next();
			hp = scanner.nextInt();
			System.out.println(nome);
			System.out.println(hp);
			Pokemon pokemon = new Pokemon(nome, hp);
			for(int j = 0; j < 4 ; j++){
				nome = scanner.next();
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
				System.out.println(pokemon.getHabilidade(0).getNome());
			}

		}
		scanner.close();
		trainer1.pokemonAtual = trainer1.getPokemon(0);

		Scanner scanner1 = new Scanner(new FileReader("arquivo2.txt"))
		.useDelimiter("\\||\\n");
		while (scanner1.hasNext()) {
			nome = scanner1.next();
			hp = scanner1.nextInt();
			System.out.println(nome);
			System.out.println(hp);
			Pokemon pokemon = new Pokemon(nome, hp);
			for(int j = 0; j < 4 ; j++){
				nome = scanner1.next();
				dano = scanner1.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
				System.out.println(pokemon.getHabilidade(0).getNome());
			}
		}
		scanner1.close();
		trainer2.pokemonAtual = trainer2.getPokemon(0);
		while (trainer1.getNum() > 0 && trainer2.getNum() > 0) {
			Scanner scanner2 = new Scanner(System.in);
			// EventSet batalha = new EventSet();
			System.out.println("O que o trainer 1 deseja fazer?");
			System.out.println("0 - Fugir da Batalha");
			System.out.println("1 - Trocar Pokemon");
			System.out.println("2 - Usar poção");
			System.out.println("3 - Atacar");
			int k = scanner2.nextInt();

			System.out.println("O que o trainer 2 deseja fazer?");
			System.out.println("0 - Fugir da Batalha");
			System.out.println("1 - Trocar Pokemon");
			System.out.println("2 - Usar poção");
			System.out.println("3 - Atacar");
			int l = scanner2.nextInt();
			Event evento1 = new Event(k, trainer1.pokemonAtual,
					trainer2.pokemonAtual, trainer1, trainer2);
			Event evento2 = new Event(l, trainer2.pokemonAtual,
					trainer1.pokemonAtual, trainer2, trainer1);

			if (k <= l) {
				evento1.action();
			} else {
				evento2.action();
			}
			scanner2.close();
		}
	}
}
