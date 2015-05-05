package ime.usp.br.pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Batalha{

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the Pokemon World!");
		System.out.println("First trainer, what is your name?");
		String h = Leitura.leString();
		Treinador trainer1 = new Treinador(h);
		System.out.println("Second trainer, what is your name?");
		String m = Leitura.leString();
		Treinador trainer2 = new Treinador(m);
		String nome;
		int hp;
		/*Mapa m =  new Mapa();
		m.geraMapa();
		m.setTreinadorMapa(trainer1);
		m.imprimeMapa();
		trainer1.andarTreinadorHoriz();
		m.setTreinadorMapa(trainer1);
		m.imprimeMapa();*/
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
		
		System.out.println("\n---------------------------");
		System.out.println("Welcome to the pokemon battle!");
		System.out.println("Trainer 1 vs Trainer 2"); //Colocar depois em função de quem é a batalha
		System.out.println("---------------------------\n");

		while (trainer1.getNum() > 0 && trainer2.getNum() > 0 && trainer1.pokemonAtual != null && trainer2.pokemonAtual != null) {
			System.out.println(trainer1.getNome()+"'s "+trainer1.pokemonAtual.getNome()+"("+trainer1.pokemonAtual.getHP()+"/"+trainer1.pokemonAtual.getHPmax()+") vs "+
					trainer2.getNome()+"'s "+trainer2.pokemonAtual.getNome()+"("+trainer2.pokemonAtual.getHP()+"/"+trainer2.pokemonAtual.getHPmax()+")");
			System.out.println(trainer1.getNome()+" - What will "+trainer1.pokemonAtual.getNome()+" do?");
			System.out.println("0 - Run");
			System.out.println("1 - Switch Pokemon");
			System.out.println("2 - Use Potion");
			System.out.println("3 - Fight");
			int k = Leitura.leNumero();
			System.out.println("\n---------------------------\n");
			System.out.println(trainer2.getNome()+" - What will "+trainer2.pokemonAtual.getNome()+" do?");
			System.out.println("0 - Run");
			System.out.println("1 - Switch Pokemon");
			System.out.println("2 - Use Potion");
			System.out.println("3 - Fight");
			int l = Leitura.leNumero();
			boolean vivo = true;
			System.out.println("\n---------------------------\n");
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
		System.out.println("The battle is over!");
		Leitura.close();
	}
}
