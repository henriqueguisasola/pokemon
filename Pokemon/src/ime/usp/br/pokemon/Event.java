package ime.usp.br.pokemon;

import java.util.Random;


public class Event {
	private int prioridade;
	private Pokemon origem;
	private Pokemon alvo;
	private Treinador treinador;
	private Treinador treinadorAlvo;
	public boolean alvoVivo;
	
	
	public Event(int n, Pokemon a, Pokemon b, Treinador c, Treinador d){
		prioridade = n;
		origem = a;
		alvo = b;
		treinador = c;
		treinadorAlvo = d;
		alvoVivo = true;
	}
	
	public void action(){
		if(prioridade == 0){
			//Fugiu da batalha
			System.out.println(origem.getNome() + " got away safely!");
			treinador.correu();
			System.out.println("\n---------------------------\n");		
		}
		
		if(prioridade == 1){
			//Troca pokemon
			System.out.println(treinador.getNome()+" which pokemon you want to put in the battle?");
			treinador.imprimeVivos();
			String s = Leitura.leString();
			Pokemon pokeAtual;
			for(int i = 0; i < 6; i++){
				pokeAtual = treinador.getPokemon(i);
				System.out.println(pokeAtual.getNome());
				if(pokeAtual.getNome().equals(s)){
					treinador.pokemonAtual = pokeAtual;
				}
			}			
			System.out.println(s);
			System.out.println(treinador.pokemonAtual.getNome());
			System.out.println("\n---------------------------\n");
		}
		
		if(prioridade == 2){
			//Usa poção
			System.out.println("Which item do you want to use? Potion(P) or SuperPotion(S)?");
			String s = Leitura.leString();
			if (s.equals("P")){
				origem.recuperaHP(60);
			}
			if (s.equals("S")){
				origem.recuperaHP(100);
			}
			System.out.println("\n---------------------------\n");
			System.out.println(origem.getHP());
		}
		
		if(prioridade == 3){
			//Ataca pokemon
			if(!treinador.getTipo()){
				System.out.println(treinador.getNome()+" - Which skill should "+origem.getNome()+" use?");
				(treinador.pokemonAtual).imprimeHabil();
				int s = Leitura.leNumero();
				Habilidade habilAtual;
				habilAtual = origem.getHabilidade(s-1);
				alvo.tomouHabilidade(habilAtual.getDano());
				System.out.println(origem.getNome()+" used "+habilAtual.getNome()+".");
				if(alvo.getHP() == 0){
					System.out.println("Foe's "+alvo.getNome()+" fainted.");
					treinadorAlvo.removePokemon(alvo);
					if(treinadorAlvo.getNum() > 0){
						if(!treinadorAlvo.getTipo()){
							System.out.println("---------------------------");
							System.out.println(treinadorAlvo.getNome()+", which pokemon do you want to put in the battle?");
							treinadorAlvo.imprimeVivos();
							String d = Leitura.leString();
							Pokemon pokeAtual;
							int j = 5;
							while(j >= 0 || alvoVivo){
								pokeAtual = treinadorAlvo.getPokemon(j);
								if(pokeAtual.getNome().equals(d)){
									treinadorAlvo.pokemonAtual = pokeAtual;
									alvoVivo = false;							
								}
								j--;
							}
						}
					}
					else{
						if(!treinadorAlvo.getTipo()){
							System.out.println(treinadorAlvo.getNome()+" is out of pokemons!");
						}
						alvoVivo = false;
					}
				}
				System.out.println("\n---------------------------\n");
			}
			
			if(treinador.getTipo()){
				Random rnd = new Random();
				int a = rnd.nextInt(4);
				Habilidade habilAtual;
				habilAtual = origem.getHabilidade(a);
				alvo.tomouHabilidade(habilAtual.getDano());
				System.out.println("Wild "+origem.getNome()+" used "+habilAtual.getNome()+".");
				if(alvo.getHP() == 0){
					System.out.println(alvo.getNome()+" fainted.");
					treinadorAlvo.removePokemon(alvo);
					if(treinadorAlvo.getNum() > 0){
						System.out.println("---------------------------");
						System.out.println(treinadorAlvo.getNome()+", which pokemon do you want to put in the battle?");
						treinadorAlvo.imprimeVivos();
						String d = Leitura.leString();
						Pokemon pokeAtual;
						int j = 5;
						while(j >= 0 || alvoVivo){
							pokeAtual = treinadorAlvo.getPokemon(j);
							if(pokeAtual.getNome().equals(d)){
								treinadorAlvo.pokemonAtual = pokeAtual;
								alvoVivo = false;							
							}
							j--;
						}

					}
					else{
						if(!treinadorAlvo.getTipo()){
							System.out.println(treinadorAlvo.getNome()+" is out of pokemons!");
						}
						alvoVivo = false;
					}
				}
				System.out.println("\n---------------------------\n");
			}
		}
		
	}

}
