package ime.usp.br.pokemon;

public class Aventura {


	public static void main(String[] args) {
		boolean automatico = true;
		System.out.println("Welcome to the Pokemon World!");
		System.out.println("What is your name pokemon trainer?");
		String nome = Leitura.leString();
		Treinador trainer1 = new Treinador(nome);
		System.out.println("Now, I need you to choose 6 pokemons that will follow you in your journey.");
		
		//implementar escolha de pokemons
		
		
		System.out.println("What would you like to do? Play the Singleplayer mode(S) or play with your friend in the Multiplayer mode(M)?");
		String d = Leitura.leString();
		if(d == "S"){
			//PArte do mapa
			
			//if(achou mato)
			//		gera treinador com 1 pokemon aleatorio
			//		batalha(trainer1, trainer2, automatico)
		}
		if(d == "M"){
			automatico = false;
			System.out.println("You chose the Multiplayer mode, but I still don't know your friend's name, can you tell me?");
			String nome2 = Leitura.leString();
			Treinador trainer2 = new Treinador(nome2);
			System.out.println("Now, "+nome2+" need to choose his pokemons.");
			
			// implementar escolha de pokemons
			
			
			//batalha(trainer1, trainer2, automatico)
		}
		
	}

}
