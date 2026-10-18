package util;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Instituicao;
import modelo.Lecionador;
import modelo.Reprovavel;
import modelo.Turma;

import java.util.Scanner;

public class Menu {
	private static Scanner input;
	private static Instituicao instituicao;
	
	public static String receberTextoNaoVazio(Scanner input, String prompt) {
		String texto = null;
		System.out.println(prompt);
		while (texto == null || texto.isBlank()) {
			texto = input.nextLine();
		}
		return texto;
	}
	
	
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
		for (int i = 0; i < 0; i++) desenharLinha(30, "|", " ");
		textoCentralizado(30, titulo, " ");
		for (int i = 0; i < 0; i++) desenharLinha(30, "|", " ");
		desenharLinha(30, "+", "-");
	}


	
	public static boolean setInput(Scanner input) {
		if (Menu.input == null && input != null) {
			Menu.input = input;
			return true;
		}
		return false;
	}
	public static boolean setInstituicao(Instituicao instituicao) {
		if (Menu.instituicao == null && instituicao != null) {
			Menu.instituicao = instituicao;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	public static void menuPrincipal() {
		boolean voltar = false;
		while (!voltar) {
			titulo(instituicao.toString());
			System.out.println();
			switch(opcoesPrincipais()) {
			case 1:
				menuAlunos();
				break;
			case 2:
				menuLecionadores();
				break;
			case 3:
				menuDisciplinas();
				break;
			case 4:
				menuTurmas();
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesPrincipais() {
		System.out.println("1. Alunos");
		System.out.println("2. Lecionadores");
		System.out.println("3. Disciplinas");
		System.out.println("4. Turmas");
		System.out.println("0. Sair");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 4) return opcao;
		return -1;
	}


	public static void menuAlunos() {
		String nome;
		String cpf;
		Disciplina disciplina;
		Aluno aluno;
		boolean voltar = false;
		while (!voltar) {
			titulo("Alunos");
			System.out.println();
			switch(opcoesAlunos()) {
			case 1:
				instituicao.exibirAlunos();
				System.out.println("Insira algo para continuar...");
				input.next();
				break;
			case 2:
				nome = receberTextoNaoVazio(input, "Digite o nome do Aluno:");
				cpf = receberTextoNaoVazio(input, "Digite o cpf do Aluno:");
				instituicao.criarAluno(nome, cpf);
				break;
			case 3:
				if (instituicao.haDisciplinas()) {
					nome = receberTextoNaoVazio(input, "Digite o nome do Monitor:");
					cpf = receberTextoNaoVazio(input, "Digite o cpf do Monitor:");
					instituicao.criarMonitor(nome, cpf);
				}
				else {
					System.out.println("Favor, criar alguma Disciplina!");
				}
				break;
			case 4:
				aluno = escolherAluno();
				if (aluno != null) {
					aluno.listarMatriculas();
					System.out.println("Insira algo para continuar...");
					input.next();
				}
				break;
			case 5:
				if (instituicao.haDisciplinas()) {
					aluno = escolherAluno();
					if (aluno != null) {
						disciplina = escolherDisciplina();
						if (disciplina != null) {
							aluno.matricular(disciplina);
						}
					}
				}
				else {
					System.out.println("Favor, criar alguma Disciplina!");
				}
				break;
			case 6:
				aluno = escolherAluno();
				if (aluno != null) {
					aluno.desmatricular(escolherMatriculaAluno(aluno));
				}
				break;
			case 7:
				aluno = escolherAluno();
				if (aluno != null) {
					instituicao.excluirAluno(aluno);
				}
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesAlunos() {
		System.out.println("1. Listar Alunos");
		System.out.println("2. Criar Aluno");
		System.out.println("3. Criar Monitor");
		System.out.println("4. Listar Matrículas");
		System.out.println("5. Matricular");
		System.out.println("6. Desmatricular");
		System.out.println("7. Excluir Aluno");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 7) return opcao;
		return -1;
	}

	
	public static void menuLecionadores() {
		String nome;
		String cpf;
		String cadastro;
		Disciplina disciplina;
		Lecionador lecionador;
		boolean voltar = false;
		while (!voltar) {
			titulo("Lecionadores");
			System.out.println();
			switch(opcoesLecionadores()) {
			case 1:
				instituicao.exibirLecionadores();
				System.out.println("Insira algo para continuar...");
				input.next();
				break;
			case 2:
				if (instituicao.haDisciplinas()) {
					nome = receberTextoNaoVazio(input, "Digite o nome do Professor:");
					cadastro = receberTextoNaoVazio(input, "Digite o cadastro do Professor:");
					disciplina = escolherDisciplina();
					instituicao.criarProfessor(nome, cadastro, disciplina);
				}
				else {
					System.out.println("Favor, criar alguma Disciplina!");
				}
				break;
			case 3:
				if (instituicao.haDisciplinas()) {
					nome = receberTextoNaoVazio(input, "Digite o nome do Monitor:");
					cpf = receberTextoNaoVazio(input, "Digite o cpf do Monitor:");
					instituicao.criarMonitor(nome, cpf);
				}
				else {
					System.out.println("Favor, criar alguma Disciplina!");
				}
				break;
			case 4:
				if (instituicao.haDisciplinas()) {
					lecionador = escolherLecionador();
					if (lecionador != null) {
						disciplina = escolherDisciplina();
						lecionador.cadastrarDisciplina(disciplina);
					}
				}
				else {
					System.out.println("Favor, criar alguma Disciplina!");
				}
				break;
			case 5:
				lecionador = escolherLecionador();
				if (lecionador != null) {
					instituicao.excluirLecionador(lecionador);
				}
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesLecionadores() {
		System.out.println("1. Listar Lecionadores");
		System.out.println("2. Criar Professor");
		System.out.println("3. Criar Monitor");
		System.out.println("4. Cadastrar Disciplina");
		System.out.println("5. Excluir Lecionador");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 5) return opcao;
		return -1;
	}
	
	
	public static void menuDisciplinas() {
		boolean voltar = false;
		while (!voltar) {
			titulo("Disciplinas");
			System.out.println();
			switch(opcoesDisciplinas()) {
			case 1:
				menuReprovaveis();
				break;
			case 2:
				menuEletivas();
				break;
			case 3:
				menuTodasDisciplinas();
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesDisciplinas() {
		System.out.println("1. Reprováveis");
		System.out.println("2. Eletivas");
		System.out.println("3. Todas");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 3) return opcao;
		return -1;
	}
	
	
	public static void menuTurmas() {
		String identificador;
		Disciplina disciplina;
		Aluno aluno;
		Turma turma;
		boolean voltar = false;
		while (!voltar) {
			titulo("Turmas");
			System.out.println();
			switch(opcoesTurmas()) {
			case 1:
				instituicao.exibirTurmas();
				System.out.println("Insira algo para continuar...");
				input.next();
				break;
			case 2:
				if (instituicao.haDisciplinas()) {
					identificador = receberTextoNaoVazio(input, "Digite o Identificador da Turma:");
					disciplina = escolherDisciplina();
					instituicao.criarTurma(identificador, disciplina);
				}
				break;
			case 3:
				turma = escolherTurma();
				if (turma != null) {
					instituicao.excluirTurma(turma);
				}
				break;
			case 4:
				turma = escolherTurma();
				if (turma != null) {
					turma.listarAlunos();
					System.out.println("Insira algo para continuar...");
					input.next();
				}
				break;
			case 5:
				aluno = escolherAluno();
				if (aluno != null) {
					turma = escolherTurma();
					if (turma != null) turma.cadastrarAluno(aluno);
					else System.out.println("Crie uma turma!");
				}
				else {
					System.out.println("Crie um aluno!");
				}
				break;
			case 6:
				turma = escolherTurma();
				if (turma != null) {
					turma.removerAluno(escolherAlunoTurma(turma));
				}
				break;
			case 7:
				turma = escolherTurma();
				if (turma != null) {
					Lecionador lecionador = escolherLecionador();
					turma.aula(lecionador);
				}
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesTurmas() {
		System.out.println("1. Listar Turmas");
		System.out.println("2. Criar Turma");
		System.out.println("3. Excluir Turma");
		System.out.println("4. Listar Alunos");
		System.out.println("5. Adicionar Aluno");
		System.out.println("6. Remover Aluno");
		System.out.println("7. Realizar Aula");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 7) return opcao;
		return -1;
	}
	
	
	
	public static void menuReprovaveis() {
		String nome;
		String codigo;
		int avaliacoes;
		int faltas;
		Reprovavel reprovavel;
		float nota;
		
		boolean voltar = false;
		while (!voltar) {
			titulo("Reprovaveis");
			System.out.println();
			switch(opcoesReprovaveis()) {
			case 1:
				instituicao.exibirReprovaveis();
				System.out.println("Insira algo para continuar...");
				input.next();
				break;
			case 2:
				nome = receberTextoNaoVazio(input, "Digite o nome da Disciplina Reporvável:");
				codigo = receberTextoNaoVazio(input, "Digite o código da Disciplina Reprovável:");
				System.out.println("Insira a quantidade de avaliações:");
				avaliacoes = input.nextInt();
				System.out.println("Insira a quantidade máxima de faltas:");
				faltas = input.nextInt();
				instituicao.criarReprovavel(nome, codigo, avaliacoes, faltas);
				break;
			case 3:
				reprovavel = escolherReprovavel();
				if (reprovavel != null) {
					int indiceMatricula = escolherMatriculaDisciplina(reprovavel);
					System.out.println("Digite a nota do aluno:");
					nota = input.nextFloat();
					reprovavel.cadastrarAvaliacao(indiceMatricula, nota);
				}
				break;
			case 4:
				reprovavel = escolherReprovavel();
				if (reprovavel != null) {
					int indiceMatricula = escolherMatriculaDisciplina(reprovavel);
					System.out.println("Digite quantas faltas deseja cadastrar:");
					faltas = input.nextInt();
					reprovavel.adicionarFaltas(indiceMatricula, faltas);
				}
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesReprovaveis() {
		System.out.println("1. Listar Reprováveis");
		System.out.println("2. Criar Reprovável");
		System.out.println("3. Realizar Avaliação");
		System.out.println("4. Registrar Falta");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 4) return opcao;
		return -1;
	}
	
	
	
	
	public static void menuEletivas() {
		String nome;
		String codigo;
		int presenca;
		boolean voltar = false;
		while (!voltar) {
			titulo("Eletivas");
			System.out.println();
			switch(opcoesEletivas()) {
			case 1:
				instituicao.exibirEletivas();
				System.out.println("Insira algo para continuar...");
				input.next(); 
				break;
			case 2:
				nome = receberTextoNaoVazio(input, "Digite o nome da Disciplina Reporvável:");
				codigo = receberTextoNaoVazio(input, "Digite o código da Disciplina Reprovável:");
				System.out.println("Insira a quantidade mínima de aulas:");
				presenca = input.nextInt();
				instituicao.criarEletiva(nome, codigo, presenca);
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesEletivas() {
		System.out.println("1. Listar Eletivas");
		System.out.println("2. Criar Eletivas");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 2) return opcao;
		return -1;
	}
	
	private static void menuTodasDisciplinas() {
		Disciplina disciplina;
		boolean voltar = false;
		while (!voltar) {
			titulo("Todas Disciplinas");
			System.out.println();
			switch(opcoesTodasDisciplinas()) {
			case 1:
				instituicao.exibirTodasDisciplinas();
				System.out.println("Insira algo para continuar...");
				input.next(); 
				break;
			case 2:
				disciplina = escolherDisciplina();
				if (disciplina != null) {
					int index = escolherMatriculaDisciplina(disciplina);
					disciplina.encerrar(index);
				}
				break;
			case 3:
				disciplina = escolherDisciplina();
				if (disciplina != null) {
					instituicao.excluirDisciplina(disciplina);
				}
				break;
			case 0:
				voltar = true;
				break;
			}
		}
	}
	private static int opcoesTodasDisciplinas() {
		System.out.println("1. Listar Todas Disciplinas");
		System.out.println("2. Concluir Matrícula");
		System.out.println("3. Excluir Disciplina");
		System.out.println("0. Voltar");
		
		System.out.println("Escolha opção:");
		int opcao = input.nextInt();
		
		if (0 <= opcao && opcao <= 3) return opcao;
		return -1;
	}
	
	private static Reprovavel escolherReprovavel() {
		instituicao.exibirReprovaveis();
		System.out.println("Escolha uma Disciplina Reprovável:");
		int index = input.nextInt();
		return instituicao.getReprovavel(index);
	}
	
	private static Disciplina escolherDisciplina() {
		instituicao.exibirTodasDisciplinas();
		System.out.println("Escolha uma Disciplina:");
		int index = input.nextInt();
		return instituicao.getDisciplina(index);
	}
	
	private static int escolherMatriculaDisciplina(Disciplina disciplina) {
		disciplina.listarAlunos();
		System.out.println("Escolha uma Matrícula:");
		int index = input.nextInt();
		return index;
	}

	private static Aluno escolherAluno() {
		instituicao.exibirAlunos();
		System.out.println("Escolha um Aluno:");
		int index = input.nextInt();
		return instituicao.getAluno(index);
	}

	private static int escolherMatriculaAluno(Aluno aluno) {
		aluno.listarMatriculas();
		System.out.println("Escolha uma Matricula:");
		int index = input.nextInt();
		return index;
	}
	
	private static Lecionador escolherLecionador() {
		instituicao.exibirLecionadores();
		System.out.println("Escolha um Lecionador:");
		int index = input.nextInt();
		return instituicao.getLecionador(index);
	}
	
	private static int escolherAlunoTurma(Turma turma) {
		turma.listarAlunos();
		System.out.println("Escolha um aluno:");
		return input.nextInt();
	}

	private static Turma escolherTurma() {
		instituicao.exibirTurmas();
		System.out.println("Escolha uma Turma:");
		int index = input.nextInt();
		return instituicao.getTurma(index);
	}
}
