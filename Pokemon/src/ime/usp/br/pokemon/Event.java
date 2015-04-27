package ime.usp.br.pokemon;

public class Event {
	private int prioridade;
	private Pokemon origem;
	private Pokemon alvo;
	private Treinador treinador;
	
	
	public Event(int n, Pokemon a, Pokemon b){
		prioridade = n;
		origem = a;
		alvo = b;
	}
	
	public void action(){
		if(prioridade == 0){
			//Fugiu da batalha
			System.out.println("O Pokemon " + origem.getNome() + " fugiu da batalha.");
			treinador.pokemonAtual = NULL;
			
			
		}
		
		if(prioridade == 1){
			//Troca pokemon
					
			
		}
	}

}
