package ime.usp.br.pokemon;

public class Mapa {
	private static int m[][] = new int[10][20];
	public int posicaoAnterior = m[0][0];
	public Mapa(){
	}
	public void geraMapa(){
		m[0][0] = 0;
		for (int i =0 ; i < 10; i++){
			for(int j = 1; j < 20; j++){
				m[i][j] = (int)Math.round(Math.random());
			}
		}
		m[9][19] = 3;
	}
	public void imprimeMapa(){
		System.out.println("Pokemon Map");
		for (int i =0 ; i < 10; i++){
			System.out.print("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
			System.out.println("");
			for(int j = 0; j < 20; j++){
				if (m[i][j] == 1){
					System.out.print("| # ");
				}
				if(m[i][j] == 0){
					System.out.print("|   ");
				}
				if(m[i][j] == 2){
					System.out.print("| T ");
				}
				if(m[i][j] == 3){
					System.out.print("| C ");
				}
			}
			System.out.print("|");
			System.out.println("");
		}
		System.out.print("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
		System.out.println("");
		System.out.println("");
	}
	public void atualizarTreinadorMapa(Treinador t){ 
		if((t.getAlturaAnterior() != t.getAltura()) || (t.getLarguraAnterior() != t.getLargura())){
			System.out.println("("+(t.getAlturaAnterior() + 1)+","+(t.getLarguraAnterior()+ 1)+")" +" -----> "+"(" +(t.getAltura()+ 1)+","+(t.getLargura()+ 1)+")" );
			m[t.getAlturaAnterior()][t.getLarguraAnterior()] = posicaoAnterior;
			if(m[t.getAltura()][t.getLargura()] == 1){
				System.out.println("Current Position: Grass");
			}
			else{
				System.out.println("Current Position: Ground");
			}
		}
		posicaoAnterior = m[t.getAltura()][t.getLargura()];
		m[t.getAltura()][t.getLargura()] = 2;
	}
	public boolean temPokemonNoMato(Treinador t){
		if (posicaoAnterior == 1){
			if(Math.random() >= 0.5){
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
