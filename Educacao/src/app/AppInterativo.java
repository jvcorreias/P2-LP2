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
		
		String nomeInstituição = receberTextoNaoVazio(teclado, "Insira o nome da Instituição: ");
		Instituicao inst = new Instituicao(nomeInstituição);
		instituicao = new Instituicao("UERJ");
		System.out.println(inst);
		
		
		
		int opcao = 1;
		while(opcao!=0) {
			Menu.menuPrincipal(instituicao);
			
			//Não ficar com enter a mais
			opcao = Integer.parseInt(teclado.nextLine());
			OpcoesPrincipais [] valores = OpcoesPrincipais.values();
			
			
			if(opcao == 0) {
				System.out.println("Encerrando sistema...");
				break;	
			}
			
		if(opcao>0 && opcao<=valores.length) {
			
			OpcoesPrincipais opcaoPrincipal = valores[opcao-1];
			int opcaoInt = 1;
			switch (opcaoPrincipal){
				case ALUNOS:
					//Alunos			
					while(opcaoInt!=0) {
						System.out.println("1- Listar alunos");
						System.out.println("2- Cadastrar aluno");
						System.out.println("3- Matricular em disciplina");
						System.out.println("4- Desmatricular de disciplina");
						System.out.println("5- Listar matriculas");
						System.out.println("0- Retornar");
					opcaoInt = Integer.parseInt(teclado.nextLine());
					switch(opcaoInt) {
					case 1:{
						inst.exibirAlunos();
						break;
					}
					case 2:{
						String nomeA = receberTextoNaoVazio(teclado, "Digite o nome do aluno: ");
						String cpfA = receberTextoNaoVazio(teclado, "Digite o CPF do aluno: ");
						inst.criarAluno(nomeA, cpfA);
						System.out.println("\n");
						break;
					}
					case 3:{
						System.out.println("Digite o indice do aluno que quer inscrever: ");
						int idA = Integer.parseInt(teclado.nextLine());
						Aluno A = inst.getAluno(idA);
						System.out.println("\t" + idA + "." + inst.getAluno(idA) + ": selecionado");
						System.out.println("1- Inscrever em reprovavel\n"
								+ 		   "2- Inscrever em eletiva");
						int eleRep = Integer.parseInt(teclado.nextLine());
						if(eleRep == 1) {
							System.out.println("Digite o indice da disciplina reprovavel");
							int idR = Integer.parseInt(teclado.nextLine());
							if(inst.getDisciplina(idR)!=null) {
								A.matricular(inst.getDisciplina(idR));
								System.out.println("Matriculado com sucesso!");
							}else {
								System.out.println("Erro ao realizar matricula");
							}
						}else if(eleRep == 2) {
							System.out.println("Digite o indice da disciplina eletiva");
							int idE = Integer.parseInt(teclado.nextLine());
							System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");

							if(inst.getEletiva(idE)!=null) {
								A.matricular(inst.getEletiva(idE));
								System.out.println("Matriculado com sucesso!");
							}else {
								System.out.println("Erro ao realizar matricula");

							}
						}
						break;
					}
						
					case 4:{
						System.out.println("Digite o indice do aluno que quer inscrever: ");
						int idA = Integer.parseInt(teclado.nextLine());
						Aluno A = inst.getAluno(idA);
						System.out.println("\t" + idA + "." + inst.getAluno(idA) + ": selecionado");
						System.out.println("1- Remover matricula em reprovavel\n"
								+ 		   "2- Remover matricula em eletiva");
						int opcaoD = Integer.parseInt(teclado.nextLine());
						if(opcaoD == 1) {
							System.out.println("Digite o indice da disciplina reprovavel");
							int idR = Integer.parseInt(teclado.nextLine());
							System.out.println("\t" + idR + "." + inst.getDisciplina(idR) + ": selecionado");
							A.desmatricular(idR);
						}else if(opcaoD == 2) {
							System.out.println("Digite o indice da disciplina eletiva");
							int idE = Integer.parseInt(teclado.nextLine());
							System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");
							A.desmatricular(idE);
						}
						break;
					}
					case 5:{
						System.out.println("Digite o indice do aluno que quer inscrever: ");
						int idA = Integer.parseInt(teclado.nextLine());
						Aluno A = inst.getAluno(idA);
						System.out.println("\t" + idA + "." + inst.getAluno(idA) + ": selecionado");
						A.ordenarMatriculas();
						A.listarMatriculas();
						break;
					}
					case 0:
						System.out.println("Retornando...");
						opcaoInt=0;
						break;
					}
					
					}
					break;
				case LECIONADORES:
					//Lecionadores
					while(opcaoInt!=0) {
					System.out.println("1- Listar lecionadores");
					System.out.println("2- Criar lecionador");
					System.out.println("3- Cadastrar disciplina");
					System.out.println("4- Lecionar");
					System.out.println("0- Retornar");

					
					switch (opcaoInt) {
					
					case 1:{
						inst.exibirLecionadores();
						break;
					}
					
					case 2:{
						//Nome cadastro disciplina
						System.out.println("1- Criar professor"
								+ 	       "2- Criar monitor");
						int profMon = Integer.parseInt(teclado.nextLine());
						if(profMon == 1) {
							String nomeP = receberTextoNaoVazio(teclado, "Digite o nome do professor: ");
							String cadastro = receberTextoNaoVazio(teclado, "Digite o cadastro do professor: ");
							int idD = Integer.parseInt(teclado.nextLine());
							
							System.out.println("1- Lecionar disciplina reprovavel\n"
									+ 		   "2- Lecionar disciplina eletiva");
							int opcaoD = Integer.parseInt(teclado.nextLine());
							if(opcaoD == 1) {
								System.out.println("Digite o indice da disciplina reprovavel");
								int idR = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idR + "." + inst.getDisciplina(idR) + ": selecionado");
								inst.criarProfessor(nomeP, cadastro, inst.getDisciplina(idR));
							}else if(opcaoD == 2) {
								System.out.println("Digite o indice da disciplina eletiva");
								int idE = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");
								inst.criarProfessor(nomeP, cadastro, inst.getEletiva(idE));
							}
						}else if(profMon == 2) {
							String nomeM = receberTextoNaoVazio(teclado, "Digite o nome do monitor: ");
							String cpf = receberTextoNaoVazio(teclado, "Digite o CPF do monitor: ");

							System.out.println("1- Lecionar disciplina reprovavel\n"
									+ 		   "2- Lecionar disciplina eletiva");
							int opcaoD = Integer.parseInt(teclado.nextLine());
							if(opcaoD == 1) {
								System.out.println("Digite o indice da disciplina reprovavel");
								int idR = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idR + "." + inst.getDisciplina(idR) + ": selecionado");
								inst.criarMonitor(nomeM, cpf, inst.getDisciplina(idR));
							}else if(opcaoD == 2) {
								System.out.println("Digite o indice da disciplina eletiva");
								int idE = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");
								inst.criarProfessor(nomeM, cpf, inst.getEletiva(idE));
							}
						}
						break;
						}
						
					case 3:{
						System.out.println("1- Adicionar disciplina para professor"
								+ 	       "2- Alterar disciplina de monitor");
						int profMon = Integer.parseInt(teclado.nextLine());
						if(profMon == 1) {
							System.out.println("Digite o índice de lecionador do professor");

							int idP = Integer.parseInt(teclado.nextLine());
							System.out.println("\t" + idP + "." + inst.getLecionador(idP) + ": selecionado");
							Professor p = (Professor) inst.getLecionador(idP);
							System.out.println("1- Lecionar disciplina reprovavel\n"
									+ 		   "2- Lecionar disciplina eletiva");
							int opcaoD = Integer.parseInt(teclado.nextLine());
							if(opcaoD == 1) {
								System.out.println("Digite o indice da disciplina reprovavel");
								int idR = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idR + "." + inst.getDisciplina(idR) + ": selecionado");
								p.cadastrarDisciplina(inst.getDisciplina(idR));
							}else if(opcaoD == 2) {
								System.out.println("Digite o indice da disciplina eletiva");
								int idE = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");
								p.cadastrarDisciplina(inst.getDisciplina(idE));
							}
							
						}else if(profMon == 2) {
							int idM = Integer.parseInt(teclado.nextLine());
							
							System.out.println("\t" + idM + "." + inst.getLecionador(idM) + ": selecionado");
							Monitor m = (Monitor) inst.getLecionador(idM);
							System.out.println("1- Lecionar disciplina reprovavel\n"
									+ 		   "2- Lecionar disciplina eletiva");
							int opcaoD = Integer.parseInt(teclado.nextLine());
							if(opcaoD == 1) {
								System.out.println("Digite o indice da disciplina reprovavel");
								int idR = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idR + "." + inst.getDisciplina(idR) + ": selecionado");
								m.cadastrarDisciplina(inst.getDisciplina(idR));
							}else if(opcaoD == 2) {
								System.out.println("Digite o indice da disciplina eletiva");
								int idE = Integer.parseInt(teclado.nextLine());
								System.out.println("\t" + idE + "." + inst.getEletiva(idE) + ": selecionado");
								m.cadastrarDisciplina(inst.getDisciplina(idE));
							}
						
						}
						break;
					}
					
					case 4: {
						//Lecionar
						System.out.println("1- Lecionar disciplina de professor"
								+ 	       "2- Lecionar disciplina de monitor");
						int profMon = Integer.parseInt(teclado.nextLine());
						if(profMon == 1) {
							System.out.println("Digite o índice de lecionador do professor");

							int idP = Integer.parseInt(teclado.nextLine());
							System.out.println("\t" + idP + "." + inst.getLecionador(idP) + ": selecionado");
							Professor p = (Professor) inst.getLecionador(idP);
							
						}
						
						
						
					}
					
					}
					
					}
					break;
				case DISCIPLINAS:
					//Disciplinas
					while(opcaoInt!=0) {
					System.out.println("1- Listar todas as disciplinas");
					System.out.println("2- Criar disciplina reprovavel");
					System.out.println("3- Criar disciplina eletiva");
					System.out.println("4- Listar reprovaveis");
					System.out.println("5- Listar eletivas");
					//Encerrar
					//checar estado (Reprovavel)
					//obter media
					//adicionar faltas/
					//cadastrar avaliação
					//Listar alunos
					//Adicionar/Remover Matricula
					//
					System.out.println("0- Retornar");

					switch(opcaoInt) {
					case 1:{
						inst.exibirDisciplinas();
						break;
					}
					case 2:{
						//String nome, String codigo, int totalAvaliacoes, int limiteFaltas)
						String nomeR = receberTextoNaoVazio(teclado, "Digite o nome da disciplina: ");
						String codigoR = receberTextoNaoVazio(teclado, "Digite o codigo da disciplina: ");
						int totAvaR = Integer.parseInt(teclado.nextLine());
						int limFal = Integer.parseInt(teclado.nextLine());
						inst.criarDisciplina(nomeR, codigoR, totAvaR, limFal);
						break;
					}
					
					case 3:{
						//(String nome, String codigo, int minimoAulas)
						String nomeE = receberTextoNaoVazio(teclado, "Digite o nome da disciplina: ");
						String codigoE = receberTextoNaoVazio(teclado, "Digite o codigo da disciplina: ");
						int minAulas = Integer.parseInt(teclado.nextLine());
						inst.criarEletiva(nomeInstituição, codigoE, minAulas);
						break;
					}
					case 4:{
						inst.exibirDisciplinas();
						break;
					}
					case 5:{
						inst.exibirEletiva();
						break;
					}
					
					case 0:{
						System.out.println("Retornando...");
						opcaoInt=0;
						break;
					}
					
					}
					}
					break;
				case TURMAS:
					//Turmas
					System.out.println("1- Listar turmas");
					System.out.println("2- Criar turma");
					break;
					
					
			}
			
		}
		}
		
	}
	
	public static void menuPorEstado(int indiceMenu) {
		switch(indiceMenu) {
		case 0:
			Menu.menuPrincipal(instituicao);
			break;
		}
	}
}
