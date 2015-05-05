package ime.usp.br.pokemon;



public class Batalha{

	public static void batalhar(Treinador trainer1, Treinador trainer2){
		System.out.println("\n---------------------------");
		System.out.println("Pokemon battle!");
		if(!trainer2.getTipo()){
			System.out.println(trainer1.getNome()+" vs "+trainer2.getNome()); 
			System.out.println("---------------------------\n");
		}
		if(trainer2.getTipo()){
			System.out.println(trainer1.getNome()+" vs Wild Pokemon"); 
			System.out.println("---------------------------\n");
		}
		while (trainer1.getNum() > 0 && trainer2.getNum() > 0 && !trainer1.getCorreu() && !trainer2.getCorreu()) {
			if(!trainer2.getTipo()){
				System.out.println(trainer1.getNome()+"'s "+trainer1.pokemonAtual.getNome()+"("+trainer1.pokemonAtual.getHP()+"/"+trainer1.pokemonAtual.getHPmax()+") vs "+
						trainer2.getNome()+"'s "+trainer2.pokemonAtual.getNome()+"("+trainer2.pokemonAtual.getHP()+"/"+trainer2.pokemonAtual.getHPmax()+")");
			}
			if(trainer2.getTipo()){
				System.out.println(trainer1.getNome()+"'s "+trainer1.pokemonAtual.getNome()+"("+trainer1.pokemonAtual.getHP()+"/"+trainer1.pokemonAtual.getHPmax()+") vs "+
						trainer2.getNome()+" "+trainer2.pokemonAtual.getNome()+"("+trainer2.pokemonAtual.getHP()+"/"+trainer2.pokemonAtual.getHPmax()+")");
			}
			System.out.println(trainer1.getNome()+" - What will "+trainer1.pokemonAtual.getNome()+" do?");
			System.out.println("0 - Run");
			System.out.println("1 - Switch Pokemon");
			System.out.println("2 - Use Potion");
			System.out.println("3 - Fight");
			int k = Leitura.leNumero();
			
			if(!trainer2.getTipo()){
				//batalha entre 2 players
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
				if(vivo && !trainer1.getCorreu()){
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
			else{
				//batalha automatica
				boolean vivo = true;
				System.out.println("\n---------------------------\n");
				if (k <= 3) {
					Event evento1 = new Event(k, trainer1.pokemonAtual,	trainer2.pokemonAtual, trainer1, trainer2);
					evento1.action();
					vivo = evento1.alvoVivo;
				} else {
					Event evento2 = new Event(3, trainer2.pokemonAtual,	trainer1.pokemonAtual, trainer2, trainer1);
					evento2.action();
				}
				if(vivo && !trainer1.getCorreu()){
					if (k <= 3 && trainer1.pokemonAtual != null) {
						Event evento2 = new Event(3, trainer2.pokemonAtual,	trainer1.pokemonAtual, trainer2, trainer1);
						evento2.action();
					} else {
						if (trainer2.pokemonAtual != null){
							Event evento1 = new Event(k, trainer1.pokemonAtual,	trainer2.pokemonAtual, trainer1, trainer2);
							evento1.action();
						}
					}
				}
			}
		}
		System.out.println("The battle is over!");
		Leitura.close();
	}
}
