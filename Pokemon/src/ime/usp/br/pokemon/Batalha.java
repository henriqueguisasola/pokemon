package ime.usp.br.pokemon;



public class Batalha{

	public void batalhar(Treinador trainer1, Treinador trainer2, boolean automatico){
		System.out.println("\n---------------------------");
		System.out.println("Welcome to the pokemon battle!");
		System.out.println("Trainer 1 vs Trainer 2"); //Colocar depois em função de quem é a batalha
		System.out.println("---------------------------\n");

		while (trainer1.getNum() > 0 && trainer2.getNum() > 0 && trainer1.pokemonAtual != null && trainer2.pokemonAtual != null) {
			System.out.println(trainer1.getNome()+"'s "+trainer1.pokemonAtual.getNome()+"("+trainer1.pokemonAtual.getHP()+"/"+trainer1.pokemonAtual.getHPmax()+") vs "+
					trainer2.getNome()+"'s "+trainer2.pokemonAtual.getNome()+"("+trainer2.pokemonAtual.getHP()+"/"+trainer2.pokemonAtual.getHPmax()+")");
			System.out.println(trainer1.getNome()+" - What will "+trainer1.pokemonAtual.getNome()+" do?");
			System.out.println("0 - Run");
			System.out.println("1 - Switch Pokemon");
			System.out.println("2 - Use Potion");
			System.out.println("3 - Fight");
			int k = Leitura.leNumero();
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
			if(vivo){
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
		System.out.println("The battle is over!");
		Leitura.close();
	}
}
