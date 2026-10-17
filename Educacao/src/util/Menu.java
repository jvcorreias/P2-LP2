package util;

import modelo.Instituicao;

public class Menu {
	private static void desenharLinha(int tamanho, String extremo, String interno) {
		if (tamanho >= 2) {
			System.out.print(extremo);
			for (int i = 0; i < tamanho-2; i++) {
				System.out.print(interno);
			}
			System.out.print(extremo);
		}
		else {
			for (int i = 0; i < tamanho; i++) {
				System.out.print(extremo);
			}
		}
		System.out.println();
	}
	private static void textoCentralizado(int tamanho, String texto, String padding) {
		if (texto == null || tamanho < texto.length());
		int paddingTot = (tamanho - texto.length()) / padding.length();
		int paddingE = paddingTot / 2;
		int paddingD = paddingTot - paddingE;
		for (int i = 0; i < paddingE; i++) System.out.print(padding);
		System.out.print(texto);
		for (int i = 0; i < paddingD; i++) System.out.print(padding);
		System.out.println();
	}
	private static void titulo(String titulo) {
		desenharLinha(30, "+", "-");
		for (int i = 0; i < 1; i++) desenharLinha(30, "|", " ");
		textoCentralizado(30, titulo, " ");
		for (int i = 0; i < 1; i++) desenharLinha(30, "|", " ");
		desenharLinha(30, "+", "-");
	}
	public static void menuPrincipal(Instituicao instituicao) {
		titulo(instituicao.toString());
		System.out.println();
		opcoesPrincipais();
		System.out.println();
		System.out.println("Escolha opção:");
	}
	
	
	private static void opcoesPrincipais() {
		System.out.println("1. Alunos");
		System.out.println("2. Lecionadores");
		System.out.println("3. Disciplinas");
		System.out.println("4. Turmas");
	}
}
