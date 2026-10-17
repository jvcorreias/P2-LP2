package app;

import java.util.Scanner;
import modelo.*;
import util.*;

public class AppInterativo {
	public static void main(String [] args) {
		Scanner teclado = new Scanner(System.in);
		Menu.setInput(teclado);
		
		Menu.setInstituicao(new Instituicao(Menu.receberTextoNaoVazio(teclado, "Insira o nome da Instituição: ")));
		Menu.menuPrincipal();
		
		teclado.close();
	}
	
}
