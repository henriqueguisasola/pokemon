package ime.usp.br.pokemon;

import java.util.Scanner;

public class Batalha extends EventSet{

	public static void main(String[] args) {
		Treinador trainer1 = new Treinador("Trainer1");
		Treinador trainer2 = new Treinador("Trainer2");
		String nome;
		int hp;
		int dano;
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 6; i++){
			System.out.println("Digite o nome do "+i+"º pokemon");
			nome = scanner.nextLine();
			System.out.println("Digite o hp do "+i+"º pokemon");
			hp = scanner.nextInt();
			Pokemon pokemon = new Pokemon(nome, hp);
			scanner.nextLine();
			for(int j = 0; j < 4; j++){
				//Scanner scanner = new Scanner(System.in);
				System.out.println("Digite o nome da "+j+"ª habilidade");
				nome = scanner.nextLine();
				System.out.println("Digite o dano da "+j+"ª habilidade");
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
				scanner.nextLine();
			}
			trainer1.setPokemons(pokemon);
		}
		trainer1.pokemonAtual = trainer1.getPokemon(0);
		
		for(int i = 0; i < 6; i++){
			System.out.println("Digite o nome do "+i+"º pokemon");
			nome = scanner.nextLine();
			System.out.println("Digite o hp do "+i+"º pokemon");
			hp = scanner.nextInt();
			Pokemon pokemon = new Pokemon(nome, hp);
			scanner.nextLine();
			for(int j = 0; j < 4; j++){
				System.out.println("Digite o nome da "+j+"ª habilidade");
				nome = scanner.nextLine();
				System.out.println("Digite o dano da "+j+"ª habilidade");
				dano = scanner.nextInt();
				Habilidade habilidade = new Habilidade(nome, dano);
				pokemon.setHabil(habilidade);
				scanner.nextLine();
			}
			trainer2.setPokemons(pokemon);
		}
		trainer2.pokemonAtual = trainer2.getPokemon(0);

		//EventSet batalha = new EventSet();
		System.out.println("O que o trainer 1 deseja fazer?");
		System.out.println("0 - Fugir da Batalha");
		System.out.println("1 - Trocar Pokemon");
		System.out.println("2 - Usar poção");
		System.out.println("3 - Atacar");
		int k = scanner.nextInt();
			
		System.out.println("O que o trainer 2 deseja fazer?");
		System.out.println("0 - Fugir da Batalha");
		System.out.println("1 - Trocar Pokemon");
		System.out.println("2 - Usar poção");
		System.out.println("3 - Atacar");
		int l = scanner.nextInt();
		Event evento1 = new Event(k, trainer1.pokemonAtual, trainer2.pokemonAtual, trainer1, trainer2);
		Event evento2 = new Event(l, trainer2.pokemonAtual, trainer1.pokemonAtual, trainer2, trainer1);		
		
		if(k <= l){
			evento1.action();
		}
		else{
			evento2.action();		
		}
		scanner.close();	
	}

}
