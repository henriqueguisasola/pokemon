package ime.usp.br.pokemon;

public class Mapa {
	private static int m[][] = new int[10][10];
	private static int posicaoAnterior;
	public Mapa(){
		
	}
	public void geraMapa(){
		for (int i =0 ; i < 10; i++){
			for(int j = 0; j < 10; j++){
				m[i][j] = (int)Math.round(Math.random());
			}
		}
	}
	public void imprimeMapa(){
		System.out.println("Mapa do Pokemon");
		for (int i =0 ; i < 10; i++){
			System.out.print("+---+---+---+---+---+---+---+---+---+---+");
			System.out.println("");
			for(int j = 0; j < 10; j++){
				if (m[i][j] == 1){
					System.out.print("| # ");
				}
				if(m[i][j] == 0){
					System.out.print("|   ");
				}
				if(m[i][j] == 2){
					System.out.print("| T ");
				}	
			}
			System.out.print("|");
			System.out.println("");
		}
		System.out.print("+---+---+---+---+---+---+---+---+---+---+");
		System.out.println("");
		System.out.println("");
	}
	public void atualizarTreinadorMapa(Treinador t){ 
		m[t.getAltura()][t.getLargura()] = 2;
	}
	public boolean temPokemon(Treinador t){
		if (m[t.getAltura()][t.getLargura()] == 1){
			if(Math.random() >= 0.4){
				//Chance de ter um pokemon
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}
