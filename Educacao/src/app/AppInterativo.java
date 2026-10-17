package app;

import java.util.Scanner;
import modelo.*;
import util.*;

public class AppInterativo {
	private static Instituicao instituicao;
	
	private static String receberTextoNaoVazio(Scanner input, String prompt) {
		String texto = null;
		while (texto == null || texto.isBlank()) {
			System.out.println(prompt);
			texto = input.nextLine();
		}
		return texto;
	}
	
	public static void main(String [] args) {
		Scanner teclado = new Scanner(System.in);
		
		//String nomeInstituição = receberTextoNaoVazio(teclado, "Insira o nome da Instituição: ");
		//Instituicao inst1 = new Instituicao(nomeInstituição);
		instituicao = new Instituicao("UERJ");
		//System.out.println(inst1);
		
		int menuAtual = 0;
		
		while(true) {
			Menu.menuPrincipal();
			int opcao = teclado.nextInt();
			switch opcao()
		}
		
		teclado.close();
	}
	
	public static void menuPorEstado(int indiceMenu) {
		switch(indiceMenu) {
		case 0:
			Menu.menuPrincipal(instituicao);
			break;
		}
	}
}
