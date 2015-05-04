package ime.usp.br.pokemon;

import java.util.Scanner;

public class Leitura {
	
	private static Scanner scanner = new Scanner(System.in);

	public static String leString(){
		String s = scanner.nextLine();
		return s;
	}
	
	public static int leNumero(){
		int n = scanner.nextInt();
		scanner.nextLine();
		return n;
	}
	
	public static void close(){
		scanner.close();
	}
}
