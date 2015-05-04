package ime.usp.br.pokemon;

public class Mapa {
	private static int m[][] = new int[10][10];
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
		for (int i =0 ; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if (m[i][j] != 2)
					System.out.print(m[i][j] +" ");
				else
					System.out.print("T ");
			}
			System.out.println("");
		}
	}
	public void AtualizarTreinadorMapa(Treinador t){
		m[t.getAltura()][t.getLargura()] = 2;
	}
}
