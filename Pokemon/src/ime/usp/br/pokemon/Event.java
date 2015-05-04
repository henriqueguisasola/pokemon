package ime.usp.br.pokemon;


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
			System.out.println("O Pokemon " + origem.getNome() + " fugiu da batalha.");
			treinador.pokemonAtual = null;
					
		}
		
		if(prioridade == 1){
			//Troca pokemon
			System.out.println(treinador.getNome()+" qual pokemon você deseja colocar em batalha?");
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
		}
		
		if(prioridade == 2){
			//Usa poção
			System.out.println("Qual item você deseja usar Potion(P) ou SuperPotion(S)");
			String s = Leitura.leString();
			if (s == "P"){
				origem.recuperaHP(60);
			}
			if (s == "S"){
				origem.recuperaHP(100);
			}
		}
		
		if(prioridade == 3){
			//Ataca pokemon
			System.out.println(treinador.getNome()+" - Qual habilidade o "+origem.getNome()+" deve usar?");
			(treinador.pokemonAtual).imprimeHabil();
			int s = Leitura.leNumero();
			Habilidade habilAtual;
			habilAtual = origem.getHabilidade(s-1);
			alvo.tomouHabilidade(habilAtual.getDano());
			System.out.println(alvo.getNome()+" tomou "+habilAtual.getDano()+" de dano.");
			if(alvo.getHP() == 0){
				System.out.println(alvo.getNome()+" morreu.");
				treinadorAlvo.removePokemon(alvo);
				if(treinadorAlvo.getNum() > 0){
					System.out.println(treinadorAlvo.getNome()+" qual pokemon você deseja colocar em batalha?");
					treinadorAlvo.imprimeVivos();
					String d = Leitura.leString();
					Pokemon pokeAtual;
					int j = 6;
					while(j > 0 || alvoVivo){
						pokeAtual = treinadorAlvo.getPokemon(j);
						if(pokeAtual.getNome().equals(d)){
							treinadorAlvo.pokemonAtual = pokeAtual;
							alvoVivo = false;							
						}
						j++;
					}
				}
				else{
					System.out.println("O "+treinadorAlvo.getNome()+" esta sem pokemon!");
					alvoVivo = false;
				}
			}
		}
		
	}

}
