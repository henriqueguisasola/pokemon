package ime.usp.br.pokemon;

import java.util.Scanner;

public class Event {
	private int prioridade;
	private Pokemon origem;
	private Pokemon alvo;
	private Treinador treinador;
	private Treinador treinadorAlvo;
	
	
	public Event(int n, Pokemon a, Pokemon b, Treinador c, Treinador d){
		prioridade = n;
		origem = a;
		alvo = b;
		treinador = c;
		treinadorAlvo = d;
	}
	
	public void action(){
		if(prioridade == 0){
			//Fugiu da batalha
			System.out.println("O Pokemon " + origem.getNome() + " fugiu da batalha.");
			treinador.pokemonAtual = null;
					
		}
		
		if(prioridade == 1){
			//Troca pokemon
			System.out.println("Qual pokemon você deseja colocar em batalha?");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			Pokemon pokeAtual;
			for(int i = 0; i < 6; i++){
				pokeAtual = treinadorAlvo.getPokemon(i);
				if(pokeAtual.getNome().equals(s)){
					treinador.pokemonAtual = pokeAtual;
				}
			}			
		}
		
		if(prioridade == 2){
			//Usa poção
			System.out.println("Qual item você deseja usar Potion(P) ou SuperPotion(S)");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			if (s == "P"){
				origem.recuperaHP(60);
			}
			if (s == "S"){
				origem.recuperaHP(100);
			}
		}
		
		if(prioridade == 3){
			//Ataca pokemon
			System.out.println("Qual habilidade o pokemon deve usar?");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			Habilidade habilAtual;
			for(int i = 0; i < 4; i++){
				habilAtual = origem.getHabilidade(i);
				if(habilAtual.getNome().equals(s)){
					alvo.tomouHabilidade(habilAtual.getDano());
				}
				if(alvo.getHP() == 0){
					treinadorAlvo.removePokemon(alvo);
					System.out.println("Qual pokemon você deseja colocar em batalha?");
					Scanner scanner2 = new Scanner(System.in);
					String d = scanner.nextLine();
					Pokemon pokeAtual;
					for(int j = 0; j < 6; j++){
						pokeAtual = treinadorAlvo.getPokemon(i);
						if(pokeAtual.getNome().equals(s)){
							treinador.pokemonAtual = pokeAtual;
						}
					}
				}
			}
		}
		
	}

}
