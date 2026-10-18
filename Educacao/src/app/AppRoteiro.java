package app;

import modelo.*;

public class AppRoteiro {
	public static void main(String [] args) {
		Instituicao UERJ = new Instituicao("UERJ");
		UERJ.criarAluno("Gabriel Henrique", "cpfVálido");
		UERJ.criarReprovavel("LP2", "código", 2, 10);
		
		System.out.println("Matriculando Aluno");
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("código"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		System.out.println("---------------------");
		
		System.out.println("Desmatriculando Aluno");
		UERJ.getAluno("cpfVálido").desmatricular(UERJ.getDisciplina("código"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		System.out.println("---------------------");
		
		System.out.println("Testando sistema de avaliação");
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);		// invalido pq aluno n esta matriculado
		
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("código"));
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);		// valido
		UERJ.getDisciplina("código").encerrar(UERJ.getAluno("cpfVálido"));						// invalido pq aluno n concluiu os requisitos minimos
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);		// valido
		UERJ.getDisciplina("código").encerrar(UERJ.getAluno("cpfVálido"));						// valido
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		System.out.println("---------------------");
		
		
		System.out.println("Testando exclusão de disciplinas");
		UERJ.criarEletiva("Plantacao de Bananeira", "PTB10", 1);
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("PTB10"));
		UERJ.criarMonitor("Julio", "2020");
		UERJ.getAluno("2020").matricular(UERJ.getDisciplina("PTB10"));
		UERJ.getMonitor("2020").cadastrarDisciplina(UERJ.getDisciplina("PTB10"));
		UERJ.criarTurma("Turma 2", UERJ.getDisciplina("PTB10"));
		UERJ.excluirDisciplina(UERJ.getDisciplina("PTB10"));
		UERJ.exibirTodasDisciplinas();
		UERJ.exibirTurmas();
		System.out.println(UERJ.getMonitor("2020").leciona(null));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		System.out.println("---------------------");
		
		
		
		UERJ.criarEletiva("Plantacao de Bananeira", "PTB10", 1);
		UERJ.criarTurma("Turma 4", UERJ.getDisciplina("código"));
		UERJ.criarTurma("Turma 2", UERJ.getDisciplina("PTB10"));
		UERJ.criarProfessor("Sérgio Mauro", "cadastro", UERJ.getDisciplina("código"));
		UERJ.getMonitor("2020").cadastrarDisciplina(UERJ.getDisciplina("PTB10"));
		System.out.println(UERJ.getMonitor("2020").leciona(UERJ.getDisciplina("PTB10")));
		UERJ.exibirTodasDisciplinas();
		UERJ.exibirTurmas();
		
		UERJ.getAluno("2020").matricular(UERJ.getDisciplina("código"));
		
		UERJ.getTurma("Turma 4").cadastrarAluno(UERJ.getAluno("2020"));
		UERJ.getTurma("Turma 4").listarAlunos();
		UERJ.getTurma("Turma 4").aula(UERJ.getProfessor("cadastro"));
		UERJ.getTurma("Turma 4").listarAlunos();
		
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("PTB10"));
		
		UERJ.getTurma("Turma 2").cadastrarAluno(UERJ.getAluno("cpfVálido"));
		UERJ.getTurma("Turma 2").listarAlunos();
		UERJ.getTurma("Turma 2").aula(UERJ.getMonitor("2020"));
		UERJ.getTurma("Turma 2").listarAlunos();
		
		UERJ.getDisciplina("PTB10").encerrar(UERJ.getAluno("cpfVálido"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
	}
	
	public static void oldMain(String [] args) {
		Instituicao UERJ = new Instituicao("UERJ");
		System.out.println(UERJ);
		UERJ.criarAluno("Gabriel Henrique", "209naoemeucpf-82");
		UERJ.exibirAlunos();
		UERJ.exibirReprovaveis();
		Aluno eu = UERJ.getAluno(1);
		eu.ordenarMatriculas();
		
		UERJ.criarReprovavel("LP2", "202020", 2, 10);
		UERJ.exibirReprovaveis();
		UERJ.criarReprovavel("LP1", "202020", 0, 0);
		UERJ.criarReprovavel("AED2", "666666", 3, 12);
		UERJ.criarReprovavel("Cálculo 3" , "número :-)", 4, 5);
		
		UERJ.exibirReprovaveis();
		
		eu.matricular(UERJ.getReprovavel(1));
		eu.matricular(UERJ.getReprovavel(2));
		eu.matricular(UERJ.getReprovavel(3));
		
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		eu.desmatricular(UERJ.getReprovavel(2));
		eu.listarMatriculas();
		eu.matricular(UERJ.getReprovavel(2));
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		
		UERJ.getReprovavel(2).adicionarPresencas(eu, 20);
		UERJ.getReprovavel(2).cadastrarAvaliacao(eu, 6);
		UERJ.getReprovavel(2).cadastrarAvaliacao(eu, 6);
		UERJ.getReprovavel(2).cadastrarAvaliacao(eu, 5);
		UERJ.getReprovavel(2).cadastrarAvaliacao(eu, 6);
		UERJ.getReprovavel(2).encerrar(eu);
		
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		
		eu.desmatricular(3);
		eu.desmatricular(1);
		eu.listarMatriculas();
	}
}
