package app;

import modelo.*;

public class AppRoteiro {
	public static void main(String [] args) {
		Instituicao UERJ = new Instituicao("UERJ");
		UERJ.criarAluno("Gabriel Henrique", "cpfVálido");
		UERJ.criarReprovavel("LP2", "código", 2, 10);
		
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("código"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		
		UERJ.getAluno("cpfVálido").desmatricular(UERJ.getDisciplina("código"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);
		
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("código"));
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);
		UERJ.getDisciplina("código").encerrar(UERJ.getAluno("cpfVálido"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		
		UERJ.getReprovavel("código").cadastrarAvaliacao(UERJ.getAluno("cpfVálido"), 10);
		UERJ.getDisciplina("código").encerrar(UERJ.getAluno("cpfVálido"));
		UERJ.getAluno("cpfVálido").listarMatriculas();
		UERJ.getDisciplina("código").listarAlunos();
		
		
		UERJ.criarEletiva("Plantacao de Bananeira", "PTB10", 10);
		UERJ.getAluno("cpfVálido").matricular(UERJ.getDisciplina("PTB10"));
		UERJ.getDisciplina("PTB10").cancelarDisciplina();
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
